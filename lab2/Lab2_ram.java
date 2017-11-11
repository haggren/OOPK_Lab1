/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

/**
 *
 * @author hugo
 */
public class Lab2_ram implements ActionListener{
    public static void main(String[] args){
        JFrame Frame = new JFrame("Lab2-test");
        MyButton Knapp = new MyButton();
        Knapp.setPreferredSize(new Dimension(300, 200));
        Frame.add(Knapp);
        Frame.pack();
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Knapp.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
             Knapp.toggleState();
        }
    });
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
  
}
