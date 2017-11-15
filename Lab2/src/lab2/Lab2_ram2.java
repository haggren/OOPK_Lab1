/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import mybutton.MyButton;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author hugo
 */
public class Lab2_ram2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab2-test");
        MyButton knapp = new MyButton();
        knapp.setPreferredSize(new Dimension(300, 200));
        frame.add(knapp);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

}
