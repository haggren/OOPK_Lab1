/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import mybutton.MyButton1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author hugo
 */
public class Lab2C2 implements ActionListener {
    
    private JFrame frame;
    private Color[] colors = {Color.RED,Color.BLUE, Color.GRAY,Color.GREEN,Color.PINK,Color.ORANGE,Color.YELLOW};
    private String[] texts = {"Stockholm", "Göteborg","Malmö","Lund","Linköping","Umeå","Gävle","Uppsala","Södertälje"};
    private MyButton1[] buttons;
    private int numButtons;
    
    public Lab2C2(String[] args){
        frame = new JFrame();
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout);
        if(args.length>1){ // Checks if multiple arguments have been sent
            throw new IllegalArgumentException("Multiple arguments!");
        }
        
        try{ // tries to convert the string to an integer
            numButtons = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            /* should an exception occur this is 
            thrown
            */
            throw new IllegalArgumentException("Argument not an integer!");    
        }
        
        createButtons();
       
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void createButtons(){
        buttons = new MyButton1[numButtons];
        for (int i = 0; i < numButtons; i++){
            buttons[i] = new MyButton1(colors[(int)(Math.random()*(colors.length-1))],
                                      colors[(int)(Math.random()*(colors.length-1))],
                                      texts[(int)(Math.random()*(texts.length-1))],
                                      texts[(int)(Math.random()*(texts.length-1))]);
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
            
        }
        
    }
    
    public static void main(String[] args){
        new Lab2C2(args);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numButtons; i++){
            if (!e.getSource().equals(buttons[i])){
                buttons[i].toggleState();
            }
        }

    }
  
}
