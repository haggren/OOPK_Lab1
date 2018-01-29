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
public class Lab2_ram3 extends JApplet {
    //Called when this applet is loaded into the browser.
    @Override
    public void init() {
        MyButton knapp = new MyButton();
        knapp.setPreferredSize(new Dimension(300, 200));
        add(knapp);
        setVisible(true);

    }


}
