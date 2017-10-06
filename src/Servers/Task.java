
package Servers;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class Task implements Runnable 
{
    final Socket s;
    final int number;
 
    public Task(Socket s, int number) 
    {
        this.s=s;
        this.number=number;
    }
    
    @Override
    public void run() 
    {
        try
        {
            PrintStream p=new PrintStream(s.getOutputStream());
            p.println(number*number);
            TimeUnit.SECONDS.sleep(10);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
