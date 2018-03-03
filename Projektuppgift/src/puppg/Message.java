/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

import java.awt.Color;

/**
 *
 * @author Hugo
 */
public class Message {
    
    private String userName;
    private Color textColor;
    private String xmlMessage;
    
    public Message(String msg, String name,Color inCol){
        userName = name;
        textColor = inCol;
        
        xmlMessage = "<message sender=\"" + userName + "\">" +"<text color=\""
                    +textColor.getRGB()+"\">"+msg + "</text></message>";
        
    }
    public Message(String xmlArg){
        
    }
    
    public String getName(){
        return userName;
        
    }
    public Color getColor(){
        return textColor;
    }
}
