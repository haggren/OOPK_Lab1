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
public class Lab2C_ram {
    
    private static JFrame frame;
    
    public static void main(String[] args){
        for (int i = 0; i < Integer.parseInt(args[0]); i++){
            MyButton x = new MyButton();
            frame.add(x);
            
        }
            
            
    }
}
