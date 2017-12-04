/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.awt.Color;
import javax.swing.*;



/**
 *
 * @author hugo
 */
public class MyFrame extends JFrame {

    private View myView;
    private Model myModel;
    private Controller myController;
    private JPanel container;
    
    
    public MyFrame() {
        container = new JPanel();
        myModel = new Model(10000);
        myView = new View(myModel);
        myController = new Controller(myModel, myView);
        
       
        container.add(myView);
        container.add(myController);
        add(container);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.green);
    }
    public static void main(String[] args){
        new MyFrame();
    }
}
