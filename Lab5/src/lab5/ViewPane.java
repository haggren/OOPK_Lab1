/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

import java.io.*;

/**
 *
 * @author hugo
 */
public class ViewPane extends JEditorPane implements HyperlinkListener {

    public ViewPane() {
        setPreferredSize(new Dimension(800, 600));
        setEditorKit(createEditorKitForContentType("text/html"));
        setEditable(false);
        addHyperlinkListener(this);
        try {
            setPage("https://www.kth.se/");

        } catch (IOException ex) {
            System.err.println("Attempted to read a bad URL");
        }
       
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                setPage(e.getURL());
            } catch (IOException ex) {
                System.err.println("Attempted to read a bad URL: " + e.getURL());
            }
        }
    }
    

}
