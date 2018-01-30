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
   
    public ViewPane() {
        setPreferredSize(new Dimension(800, 600));
        previousURL = new Stack<URL>();
        forwardURL = new Stack<URL>();
        historyURL = new Stack<URL>();
        
        try {
            homeURL= new URL("https://www.kth.se/utbildning/civilingenjor/teknisk-fysik/studenter-berattar/patrik-teknisk-fysik-300-hp-1.766608");
        } catch (MalformedURLException ex) {
            System.err.println("Attempted to read a bad URL: " + currentURL);
        }
        setEditable(false);
        addHyperlinkListener(this);
        navigate(homeURL);
       
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            previousURL.push(currentURL);
            forwardURL.clear();
            navigate(e.getURL());
        }
    }
    /**
    * Navigerar till en ny sida.
    */
    public void navigate(URL inURL){
        
        editHistory();  
        currentURL=inURL;
        try {
            setPage(currentURL);
        } catch (IOException ex) {
            System.err.println("Attempted to read a bad URL: " + currentURL);
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
