/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author hugo
 */
public class BackButton extends JButton implements ActionListener {
    
    private ViewPane viewPane;
    
    public BackButton(ViewPane v){
        super("BACK");
        setBackground(Color.lightGray);
        addActionListener(this);
        viewPane = v;
    }
    public void updateButton() {
        if (viewPane.previousURL.isEmpty()) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        viewPane.goBack();
    }
    
}
