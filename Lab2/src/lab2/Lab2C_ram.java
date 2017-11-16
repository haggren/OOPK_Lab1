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
        
        int numButtons;
        if(args.length>1){
            throw new IllegalArgumentException("Multiple arguments!");
        }
        
        try{
            numButtons = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Argument not an integer!");    
        }
        
        
        for (int i = 0; i < numButtons; i++){
            MyButton x = new MyButton();
            frame.add(x);
            
        }
            
            
    }
}
