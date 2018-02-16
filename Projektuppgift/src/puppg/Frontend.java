/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author hugo
 */
public class Frontend {

    private View myView;
    private Model myModel;
    private Controller myController;
    private int userType;
    private JFrame chatFrame;
    private JFrame connectFrame;
    private JTextField portField;
    private JTextField addressField;
    private String serverAddress;
    private int port;

    public Frontend() {
        showOptionPane();
        showConnectFrame(userType);
        
    }

    public static void main(String[] args) {
        new Frontend();
    }

    public void showOptionPane() {

        String[] s = {"Server", "Client"};
        userType = JOptionPane.showOptionDialog(null, "Server or Client?", "Pick one.", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, s, s[0]);

    }

    public void showConnectFrame(int a) {

        connectFrame = new JFrame();
        JLabel label;

        JButton go = new JButton("GO");

        connectFrame.setPreferredSize(new Dimension(400, 200));
        connectFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);

        if (a == 0) {
//            try {
//                serverAddress = getLocalHostLANAddress();  
//            } catch (UnknownHostException ex) {
//                System.out.println("Failure with IP address");
//            }
            //serverAddress = getIP();
            serverAddress = "130.229.133.11";
            label = new JLabel("Server");
            label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            JLabel ip = new JLabel("Your IP-address is: ");
            JLabel yourIP = new JLabel(serverAddress);
            JLabel p = new JLabel("Choose port: ");
            portField = new JTextField(15);

            go.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    port = Integer.parseInt(portField.getText());
                    connectFrame.dispose();
                    showChatFrame();
                }
            });

            connectFrame.add(label, gbc);
            gbc.gridy++;
            connectFrame.add(ip, gbc);
            gbc.gridx++;
            connectFrame.add(yourIP, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            connectFrame.add(p, gbc);
            gbc.gridx++;
            connectFrame.add(portField, gbc);

        }
        if (a == 1) {
            label = new JLabel("Client");
            label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

            JLabel k = new JLabel("Server address: ");
            addressField = new JTextField(15);
            JLabel p = new JLabel("Port: ");
            portField = new JTextField(15);

            go.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    port = Integer.parseInt(portField.getText());
                    serverAddress = addressField.getText();
                    connectFrame.dispose();
                    showChatFrame();

                }
            });

            connectFrame.add(label, gbc);
            gbc.gridy++;
            connectFrame.add(k, gbc);
            gbc.gridx++;
            connectFrame.add(addressField, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            connectFrame.add(p, gbc);
            gbc.gridx++;
            connectFrame.add(portField, gbc);

        }
        gbc.gridy++;
        connectFrame.add(go, gbc);

        connectFrame.pack();
        connectFrame.setVisible(true);
        connectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void showChatFrame() {

        

        chatFrame = new JFrame("Chat with your friends!");
        chatFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        chatFrame.setVisible(true);
        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        myModel = new Model(serverAddress, port, userType);
        myController = new Controller(myModel);
        Thread thr = new Thread(new Runnable(){
            public void run(){
                myView = new View(myModel);
                chatFrame.add(myView, gbc);
            }
        });
        thr.start();
        gbc.gridy++;
        chatFrame.add(myController, gbc);
        chatFrame.pack();
        
        
    }
    private String getIP(){
        URL url = null;
        BufferedReader in = null;
        String ipAddress = "";
        try {
            url = new URL("http://bot.whatismyipaddress.com");
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            ipAddress = in.readLine().trim();
            /* IF not connected to internet, then
             * the above code will return one empty
             * String, we can check it's length and
             * if length is not greater than zero, 
             * then we can go for LAN IP or Local IP
             * or PRIVATE IP
             */
            if (!(ipAddress.length() > 0)) {
                try {
                    InetAddress ip = InetAddress.getLocalHost();
                    System.out.println((ip.getHostAddress()));
                    ipAddress = (ip.getHostAddress());
                } catch(Exception exp) {
                    ipAddress = "ERROR";
                }
            }
        } catch (Exception ex) {
            // This try will give the Private IP of the Host.
            try {
                InetAddress ip = InetAddress.getLocalHost();
                System.out.println((ip.getHostAddress()).trim());
                ipAddress = (ip.getHostAddress()).trim();
            } catch(Exception exp) {
                ipAddress = "ERROR";
            }
            //ex.printStackTrace();
        }
        
        System.out.println(ipAddress);
        return ipAddress;
    }   

}
