/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybutton;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author hugo
 */
public class MyButton1 extends JButton {

    private Color firstcol;
    private Color sndcol;
    private String firsttext;
    private String sndtext;

    public MyButton1(Color col1, Color col2, String text1, String text2) {
        setText(text1);
        setBackground(col1);
        firstcol = col1;
        sndcol = col2;
        firsttext = text1;
        sndtext = text2;


    }

    public MyButton1() {
        this(Color.GREEN, Color.RED, "ON", "OFF");
    }

    public void toggleState() {
        if (getBackground() == firstcol) {
            setBackground(sndcol);
            setText(sndtext);
        } else {
            setBackground(firstcol);
            setText(firsttext);
        }
    }

}