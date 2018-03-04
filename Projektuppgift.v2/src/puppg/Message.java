/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

import java.awt.Color;
import static java.awt.Color.*;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Hugo
 */
public class Message {
    
    private String userName;
    private Color textColor;
    private String xmlMessage;
    private String text;
    private boolean isDisconnect;
    
    public Message(String msg, String name,Color inCol){
        userName = name;
        textColor = inCol;
        text = msg;
        
        int r = textColor.getRed();
        int g = textColor.getGreen();
        int b = textColor.getBlue();
        String hex = String.format("#%02X%02X%02X", r, g, b);
        xmlMessage = "<message sender=\"" + userName + "\">" +"<text color=\""
                    +hex+"\">"+msg + "</text></message>";
        
    }
    
    
    
        public Message(String name, String text){
        userName = name;
        textColor = Color.BLACK;
        text = text;
        
        int r = textColor.getRed();
        int g = textColor.getGreen();
        int b = textColor.getBlue();
        String hex = String.format("#%02X%02X%02X", r, g, b);
        xmlMessage = "<message sender=\"" + userName + "\">" +"<text color=\""
                    +hex+"\">"+text + "</text></message>";
        
    }
    
 
    public  void setDisconnect(){
        isDisconnect = true;
        
    }
    
    public boolean getDisconnect(){
        return isDisconnect;
    }
            
    public Message(String xmlArg){
        //System.out.println("New message being made");
        //System.out.println("raw message text: "+ xmlArg);
        String[] msg = null;
        try {
            msg = xmlParse(xmlArg);
        } catch (Exception ex) {
            System.out.println("Couldn't create message");
        }
        
        userName = msg[2];
        //System.out.println("username: " + userName);
        textColor = Color.decode(msg[1]);
        text = msg[0];

        
    }
    public String getXMLText(){
        return xmlMessage;
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
    public String[] xmlConvert(String s){
        
        String[] output;
                
        s = s.replace("<", "");
        s = s.replace(">", " ");
        s = s.replace("sender=", "");
        s = s.replace("color=", "");
        s = s.replace("message", "");
        s = s.replace("text", "");
        s = s.replace("/", "");
        s = s.replace("\"", "");
        s = s.substring(1);
        System.out.println(s);
        output = s.split(" ",3);
        
        return output;
    }

    
    public String[] xmlParse(String xml) throws Exception{
        
        
        
        DocumentBuilder db = DocumentBuilderFactory.newInstance().
                newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        Document doc = db.parse(is);
        //System.out.println("sout doc : " +doc);
        NodeList nodes = doc.getElementsByTagName("message");
        //System.out.println("sout nodes : " + nodes);
        Element mess = (Element) nodes.item(0);
        /*
        girls_laughing.jpg
        */
        String name = mess.getAttribute("sender");
        Node textnode = mess.getFirstChild();
        Element textel = (Element) textnode;
        String textattr = textel.getAttribute("color");
        
        String[] result = new String[3];

        result[0] = textnode.getTextContent();
        result[1] = textattr;
        result[2] = name;
        //System.out.println("server just loaded a textattr: "+ textattr); 
        return result;
}
    
}
