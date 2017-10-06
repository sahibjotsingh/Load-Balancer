package LoadBalancer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JTextField;

public class loadBalancer 
{
    private static ServerSocket serversocket;
    public static void main(String[] args) throws IOException 
    {
        loadBalancingThread o=new loadBalancingThread();
        o.start();
        //ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        serversocket=new ServerSocket(555);
        
        while(true)
        {
            JTextField text;
            Socket socket=serversocket.accept();
            Scanner sc=new Scanner(socket.getInputStream());
            int number=sc.nextInt();
            o.accept(number, socket);
            //int temp=number*2;
            //PrintStream p=new PrintStream(socket.getOutputStream());
            //p.println(temp);
            //s.close();
            if(number==0) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        serversocket.close();
    }
}
