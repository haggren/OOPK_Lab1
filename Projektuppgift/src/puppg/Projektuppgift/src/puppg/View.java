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
    JTextField nameField;
    JTextField colorField;
    private JScrollPane scroller;
    //private Controller myController;
    private Model myModel;
    
    
    public View(Model m){
        
        setPreferredSize(new Dimension(800,500));
        setVisible(true);
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        
        myModel = m;
        
        receivePane = new ReceivePane();
       
        nameField = new JTextField("Name",15);
        
        colorField = new JTextField("Color",15);
        
        
        sendField = new JTextField();
        sendField.setPreferredSize(new Dimension(800,50));

        scroller = new JScrollPane(receivePane);
        scroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(800, 400));
        scroller.setMinimumSize(new Dimension(800, 400));
        
        add(nameField,gbc);
        gbc.gridy++;
        add(colorField,gbc);
        gbc.gridy++;
        
        add(scroller,gbc);
        gbc.gridy++;
        add(sendField,gbc);
        
        
    }
    
    public void showMessage(Message m){
        
        StyledDocument doc = receivePane.getStyledDocument();

        Style style = receivePane.addStyle("Style", null);
        StyleConstants.setForeground(style, m.getColor());
        
        try { doc.insertString(doc.getLength(), m.getName() + ": "+ m.getText() +"\n",style);}
        catch (BadLocationException e){}
        
        
    }

 
}
