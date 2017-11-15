/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import mybutton.MyButton1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author hugo
 */
public class Lab2_ram implements ActionListener {

    private MyButton1 knapp;

    //KONSTRUKTOR
    public Lab2_ram() {
        JFrame frame = new JFrame("Lab2-test");
        knapp = new MyButton1();
        knapp.setPreferredSize(new Dimension(300, 200));
        frame.add(knapp);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        knapp.addActionListener(this);


    }

    public static void main(String[] args) {
        new Lab2_ram();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        knapp.toggleState();
    }

}
