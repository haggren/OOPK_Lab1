package puppg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hugo
 */
public class View extends JPanel{
    
    private JTextPane receivePane;
    JTextField sendField;
    private JScrollPane scroller;
    //private Controller myController;
    private Model myModel;
    
    
    public View(Model m){
        
        setPreferredSize(new Dimension(800,500));
        setVisible(true);
        
        myModel = m;
        
        receivePane = new ReceivePane();
       
        sendField = new JTextField();
        sendField.setPreferredSize(new Dimension(800,100));

        scroller = new JScrollPane(receivePane);
        scroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(800, 400));
        scroller.setMinimumSize(new Dimension(800, 400));
        
        
        add(scroller);
        add(sendField);
        
        
    }
    
    public void showMessage(String s){
        
        StyledDocument doc = receivePane.getStyledDocument();

        Style style = receivePane.addStyle("I'm a Style", null);

        try { doc.insertString(doc.getLength(), ": "+ s +"\n",style);}
        catch (BadLocationException e){}
        
        
    }

 
}
