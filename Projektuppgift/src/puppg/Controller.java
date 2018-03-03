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
                    receiveMessage();
                }
            }
            
        });
        
    }

    public void sendMessage(String s){
        myModel.sendMessage(s);
        myView.showMessage(s);
    }
    
    public void receiveMessage(){
        String s = myModel.receiveMessage();
        myView.showMessage(s);
                
    }
    
    public void updateChat(){
        
    }
    public String encrypt(){
        return "";
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
