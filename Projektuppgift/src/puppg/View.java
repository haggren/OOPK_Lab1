package puppg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private JScrollPane scroller;
    private Model myModel;
    private StyledDocument doc;
    private SimpleAttributeSet keyWord;
    
    
    public View(Model m){
        
        setPreferredSize(new Dimension(800,600));
        setVisible(true);
        
        myModel = m;
        
        receivePane = new JTextPane();
        receivePane.setPreferredSize(new Dimension(800,400));
       
       
        

        scroller = new JScrollPane(receivePane);
        scroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(800, 400));
        scroller.setMinimumSize(new Dimension(800, 400));
        

        add(scroller);
        
        showMessage();
        
        
    }
    public void showMessage(){
//        try {
//            receivePane.read(new InputStreamReader(
//                    getClass().getResourceAsStream("/log.xml")),
//                    null);
//        } catch (Exception ex) {
//           
//        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                while (true) {
                    receivePane.setText(myModel.receiveMessage());
                }
            }
        });
        
    }

 
}
