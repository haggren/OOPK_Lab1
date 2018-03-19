/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author hugo
 */
public class HistoryButton extends JButton implements ActionListener{
    
    private ViewPane viewPane;
    private HistoryPane historyPane;
    
    public HistoryButton(ViewPane v, HistoryPane h){
        super("HISTORY");
        setBackground(Color.lightGray);
        addActionListener(this);
        setEnabled(false);
        viewPane = v;
        historyPane = h;
    }
public void updateButton(){
    if (viewPane.historyURL.isEmpty()){
        setEnabled(false);
    } else{
        setEnabled(true);
    }
}
    @Override
    public void actionPerformed(ActionEvent e) {
        historyPane.displayHistoryPane();
    }
    
}
