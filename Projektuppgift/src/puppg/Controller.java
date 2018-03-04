/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author hugo
 */
public class Controller implements ActionListener{
    

    private Model myModel;
    private View myView;
    private String userName = "Anon";
    private Color textColor = Color.BLACK;
    
    public Controller(Model m, View v){
        myModel = m;
        myView = v;
        myView.sendField.addActionListener(this);
        myView.nameField.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = ((JTextField)e.getSource()).getText();
            }
            
        });
        myView.colorField.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String colHex = ((JTextField)e.getSource()).getText();
                textColor = Color.decode(colHex);
            }
            
        });
        Thread thr = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                   
                    System.out.println("true shit");
                    try{
                        System.out.println("try it bro");
                        receiveMessage();
                        System.out.println("1");
                        //receiveMessage();
                        System.out.println("2");
                    }
                    catch(Exception AAA){
                        System.out.println("börja om hela koden hugo " + AAA);
                    }
                }
            }
            
        });
        thr.start();
    }

    public void sendMessage(String s){
        Message m = new Message(s,userName,textColor);
        myModel.sendMessage(m.getXMLText());
        myView.showMessage(m);
    }
    
    public void receiveMessage(){
        System.out.println("3. attempted to receive");
        Message m = new Message(myModel.receiveMessage());
        System.out.println("received: " + m.getText());
        myView.showMessage(m);
       
    }
    
    public void updateChat(){
        
    }
    public String encrypt(){
        return "crypto boii";
    }
    public String decrypt(){
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendMessage(((JTextField)e.getSource()).getText());
        ((JTextField)e.getSource()).setText("");
        
    }
}
