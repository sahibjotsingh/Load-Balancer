package LoadBalancer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextField;

public class loadBalancer 
{
    private static ServerSocket serversocket;
    public static void main(String[] args) throws IOException 
    {
        loadBalancingThread o=new loadBalancingThread();
        o.start();
        serversocket=new ServerSocket(555);
        
        while(true)
        {
            JTextField text;
            Socket socket=serversocket.accept();
            int number=0;
            o.accept(number, socket);
            if(number==0) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        serversocket.close();
    }
}
