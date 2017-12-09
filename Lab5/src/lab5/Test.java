/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

/**
 *
 * @author hugo
 */
public class Test implements HyperlinkListener {
    
    public static void main(String[] args){
        
        new Test();
    }
    public Test(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextPane historyPane = new JTextPane();
        
        
        historyPane.setContentType("text/html");
        historyPane.setEditable(false);
        historyPane.setPreferredSize(new Dimension(250,600));
        historyPane.addHyperlinkListener(this);
        historyPane.setText("hej <br> hej <br> hej");
        
        
//        JLabel label = new JLabel("Hej <br>");
//        label.setAlignmentY(0.85f);
//        historyPane.insertComponent(label);
//        historyPane.insertComponent(new JLabel("Hej <br>"));
//        historyPane.insertComponent(new JLabel("Hej <br>"));
//        historyPane.insertComponent(new JLabel("Hej <br>"));
     
        
        
     
        
        frame.add(historyPane);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())) {
                            System.out.println(e.getURL());
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                desktop.browse(e.getURL().toURI());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
        }
}
