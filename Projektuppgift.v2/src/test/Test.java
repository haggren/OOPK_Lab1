/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
/**
 *
 * @author hugo
 */
public class Test extends JFrame{    
    
    private JTextPane receivePane;
    private JScrollPane scroller;
    // Model myModel;
    private StyledDocument doc;
    private SimpleAttributeSet keyWord;
    
    public static void main(String[] args){
//        JFrame frame = new JFrame();
//        String[] s = {"Server","Client"};
//        JOptionPane p = new JOptionPane("Server or Client?");
//        
//        p.setOptions(s);
//        frame.add(p);
//        frame.pack();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


//        String[] s = {"Server","Client"};
//        int userType = JOptionPane.showOptionDialog(null,"Server or Client?","Pick one.",JOptionPane.DEFAULT_OPTION,
//                                        JOptionPane.QUESTION_MESSAGE,null,s,s[0]);
//        System.out.println(userType);
            
//            JFrame f = new JFrame();
//            
//            JLabel l = new JLabel("hejhejhej");
//            f.add(l);
//            f.pack();
//            f.setVisible(true);
//            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Test();
    }
    
    public Test(){
        
 
        
        receivePane = new JTextPane();
        receivePane.setPreferredSize(new Dimension(800,400));
        receivePane.setEditable(false);
        receivePane.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        receivePane.setLayout(new GridBagLayout());
        doc = receivePane.getStyledDocument();
        
        keyWord = new SimpleAttributeSet();
        StyleConstants.setForeground(keyWord, Color.RED);
        StyleConstants.setBackground(keyWord, Color.YELLOW);
        StyleConstants.setBold(keyWord, true);
        

        scroller = new JScrollPane();
        scroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(800, 400));
        scroller.setMinimumSize(new Dimension(800, 400));
        
        
        scroller.add(receivePane);
        add(scroller);
        Thread thr = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    showMessage();
                }
            }
        });
        thr.start();
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    public void showMessage(){
        
        try {
            doc.insertString(0, "Start of text\n", null);
            doc.insertString(doc.getLength(), "test\n", keyWord);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

 
        
    }
