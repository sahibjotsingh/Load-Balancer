package Servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server4
{
    private static ServerSocket serversocket;
    
    public static void main(String[] args) throws IOException 
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        serversocket=new ServerSocket(126);
        while(true)
        {
            int number;
            Socket socket=serversocket.accept();
            Scanner sc=new Scanner(socket.getInputStream());
            number=sc.nextInt();
            Task task = new Task(socket, number);
            executor.execute(task);
            //temp=number*2;
            //PrintStream p=new PrintStream(s.getOutputStream());
            //p.println(temp);
            //s.close();
            if(number==0) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        serversocket.close();
    }
    
}
