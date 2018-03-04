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
    private String text;
    
    public Message(String msg, String name,Color inCol){
        userName = name;
        textColor = inCol;
        text = msg;
        xmlMessage = "<message sender=\"" + userName + "\">" +"<text color=\""
                    +textColor.getRGB()+"\">"+msg + "</text></message>";
        
    }
    public Message(String xmlArg){
        
    }
    public String getText(){
        return text;
    }
    public String getName(){
        return userName;
        
    }
    public Color getColor(){
        return textColor;
    }
    public void xmlConvert(String s){
        
        s = s.replace("<", "");
        s = s.replace(">", "");
        s = s.replace("sender=", "");
        s = s.replace("color=", "");
        s = s.replace("message", "");
        s = s.replace("text", "");
        s = s.replace("/", "");
        s = s.replace("\"", "");

    }
}
