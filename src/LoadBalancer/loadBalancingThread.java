package LoadBalancer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class loadBalancingThread extends Thread
{
    public int iterator=-1;
    String IPAddress[] = {"127.0.0.1", "127.0.0.1", "127.0.0.1", "127.0.0.1", "127.0.0.1"};
    int ports[]={123, 124, 125, 126, 127};
    private BlockingQueue<Integer> queue =new LinkedBlockingQueue<Integer>();
    private BlockingQueue<Socket> queue2 =new LinkedBlockingQueue<Socket>();
    
    public void accept(int data, Socket m) 
    {
        queue.add(data);
        queue2.add(m);
    }
   
   @Override
   public void run() 
   {
        while (true)
            try 
            {
                RoundRobin(queue.take(), queue2.take());
            }
            catch (InterruptedException e) {
            } catch (IOException ex) {
                Logger.getLogger(loadBalancingThread.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
   
   private void RoundRobin(final int data, final Socket si) throws IOException
   {
            iterator=((iterator+1)%5);
            
            PrintStream p1=new PrintStream(si.getOutputStream());
            p1.println(IPAddress[iterator]);
            
            PrintStream p2=new PrintStream(si.getOutputStream());
            p2.println(ports[iterator]);
   }
}