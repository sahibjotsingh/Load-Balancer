package Client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
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
    InetAddress o;
    Socket s1, s2;
    Scanner sc1, sc2;
    PrintStream p1, p2;
    String address, text;
    int num, ans;
            
    public Client()
    {
        panel.setLayout(null);
        frame.setSize(550, 180);
        setup();
        frame.setVisible(true);
    }
    
    public void setup()
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
                    text = clientInput.getText();
                    num = Integer.parseInt(text);
                    
                    s1 = new Socket("127.0.0.1", 555);
                    sc1 = new Scanner(s1.getInputStream());
                    p1 = new PrintStream(s1.getOutputStream());
                    p1.println(num);
                    address = sc1.next();
                    sc1 = new Scanner(s1.getInputStream());
                    int port = sc1.nextInt();
                    
                    o = InetAddress.getByName(address);
                    s2 = new Socket(o, port);
                    sc2 = new Scanner(s2.getInputStream());
                    p2 = new PrintStream(s2.getOutputStream());
                    p2.println(num);
                    ans = sc2.nextInt();
                    clientOutput.setText(Integer.toString(ans));
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
