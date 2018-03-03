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

    
    public Controller(Model m, View v){
        myModel = m;
        myView = v;
        myView.sendField.addActionListener(this);
        
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
        myModel.sendMessage(s);
        myView.showMessage(s);
    }
    
    public void receiveMessage(){
        System.out.println("3. attempted to receive");
        String s = myModel.receiveMessage();
        if (s != null){
            myView.showMessage(s);
        }
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
