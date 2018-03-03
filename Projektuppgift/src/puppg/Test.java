/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;
import javax.swing.*;
/**
 *
 * @author hugo
 */
public class Test {
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
            
            JFrame f = new JFrame();
            
            JLabel l = new JLabel("hejhejhej");
            f.add(l);
            f.pack();
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
