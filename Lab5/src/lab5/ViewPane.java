/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author hugo
 */
public class ViewPane extends JEditorPane implements HyperlinkListener {
    
    
    public URL currentURL;
    private URL homeURL;
    public Stack<URL> previousURL;
    public Stack<URL> forwardURL;
    public Stack<URL> historyURL;
    private MainFrame main;
    
   
    public ViewPane(MainFrame frame) {
        setPreferredSize(new Dimension(800, 600));
        previousURL = new Stack<URL>();
        forwardURL = new Stack<URL>();
        historyURL = new Stack<URL>();
        main = frame; 
        
        setEditable(false);
        addHyperlinkListener(this);
        
        
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            previousURL.push(currentURL);
            forwardURL.clear();
            navigate(e.getURL());
        }
    }
    public void goToHomepage(){
        try {
            homeURL= new URL("https://www.kth.se/");
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null,
                "The URL you entered seems to be wonky.");
        }
        navigate(homeURL);
    }
    /**
    * Navigerar till en ny sida.
    */  
    public void navigate(URL inURL){
        
        editHistory();  
        main.updateAllButtons();
        main.setURL(inURL.toString());
        currentURL=inURL;
        try {
            setPage(currentURL);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                "The URL you entered seems to be wonky.");
        }
    }
    
    public void goBack(){
        if(!previousURL.empty()){      
            forwardURL.push(currentURL);
            navigate(previousURL.pop());
            
        }
    }
    
    public void goForward(){
        if(!forwardURL.empty()){      
            previousURL.push(currentURL);
            navigate(forwardURL.pop());
        }  
    }
    
    public void editHistory(){
        if (currentURL != null) {
            if (!historyURL.contains(currentURL)) {
                historyURL.push(currentURL);
            } else {
                historyURL.remove(currentURL);
            }
        }
    }
    

}
