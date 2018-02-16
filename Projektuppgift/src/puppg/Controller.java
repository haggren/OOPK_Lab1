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
public class Controller extends JPanel implements ActionListener{
    
    private JTextField sendField;
    private Model myModel;
    
    
    public Controller(Model m){
        setPreferredSize(new Dimension(800,100));
        myModel = m;
        sendField = new JTextField();
        sendField.setPreferredSize(new Dimension(800,100));
        add(sendField);
        sendField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = sendField.getText();
        myModel.sendMessage(s);
        sendField.setText("");
    }
   
}
