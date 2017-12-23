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
        loadBalancingThread lbt = new loadBalancingThread();
        lbt.start();
        serversocket=new ServerSocket(555);
        
        while(true)
        {
            JTextField text;
            Socket socket = serversocket.accept();
            Scanner sc = new Scanner(socket.getInputStream());
            int number = sc.nextInt();
            if(number == 0) break;
            lbt.accept(socket);
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        serversocket.close();
    }
}
