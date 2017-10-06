package Client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame
{
    public int X=500, Y=90;
    public JTextField  displayMessage;
    public JLabel      clientLabel;
    public JButton     sendButton;
    public JTextField  clientInput;
    public JTextField  clientOutput;
    JFrame frame = new JFrame("Client Menu");
    JPanel panel = (JPanel) frame.getContentPane();
    public Client()
    {
        panel.setLayout(null);
        frame.setSize(550, 180);
        setup1();
        frame.setVisible(true);
    }
    
    public void setup1()
    {
        clientLabel = new JLabel("Client1");
        clientLabel.setFont(new Font("Tahoma", 0, 12));
        panel.add(clientLabel);
        clientLabel.setBounds(47, 52, 37, 15);
        
        clientInput = new JTextField();
        clientInput.setFont(new Font("Tahoma", 0, 12));
        panel.add(clientInput);
        clientInput.setBounds(100, 50, 125, 20);
        
        displayMessage = new JTextField();
        displayMessage.setEditable(false);
        displayMessage.setFont(new Font("Tahoma", 0, 12));
        panel.add(displayMessage);
        displayMessage.setBounds(100, 83, 350, 20);
        
        clientOutput=new JTextField();
        clientOutput.setEditable(false);
        clientOutput.setFont(new Font("Tahoma", 0, 12));
        panel.add(clientOutput);
        clientOutput.setBounds(350, 50, 125, 20);
        
        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    displayMessage.setText("Your request is being processed");
                    Socket s;
                    Scanner sc=new Scanner(System.in);
                    s = new Socket("127.0.0.1", 555);
                    Scanner sc1=new Scanner(s.getInputStream());
                    String text=clientInput.getText();
                    int num=Integer.parseInt(text);
                    PrintStream p=new PrintStream(s.getOutputStream());
                    p.println(num);
                    int temp=sc1.nextInt();
                    clientOutput.setText(Integer.toString(temp));
                    displayMessage.setText("");
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        panel.add(sendButton);
        sendButton.setFont(new Font("Tahoma", 0, 12));
        sendButton.setBounds(250, 50, 70, 20);
    }
    
    public static void main(String[] args)
    {
        Client o=new Client();
    }
}
