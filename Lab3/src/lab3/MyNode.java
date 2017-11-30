/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;


import javax.swing.tree.*;


/**
 *
 * @author hugo
 */
public class MyNode extends DefaultMutableTreeNode{
    
    private String text;
    private String level;
    
    public MyNode(String nodeName, String textIn, String levelIn){
        super(nodeName);
        text = textIn;
        level = levelIn;
    }
    
    public String getText(){
        return text;
    }
}
