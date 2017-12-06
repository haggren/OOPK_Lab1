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
public class CloseButton extends JButton implements ActionListener {
    
    private JFrame frame;

    public CloseButton(JFrame frameIn) {
        frame = frameIn;
        setText("Close this MESS");
        setBackground(Color.lightGray);
        addActionListener(this);
        setPreferredSize(new Dimension(200,50));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
    }

}