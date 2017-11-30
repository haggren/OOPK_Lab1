/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author hugo
 */
public class LifeTree {

    private static ArrayList info = new ArrayList();

    public static void main(String[] args) {
        scanFile();
        
        String s = "<Biosfär namn=\"Liv\">";
        System.out.println(s.indexOf("namn=") + " namn index");
        System.out.println(s.indexOf("<") + " < index");
        System.out.println(s.substring(s.indexOf("namn=") + 5, s.indexOf(">")));
        System.out.println(s.substring(s.indexOf("<")+1, s.indexOf(" ")));

    }

    private static void scanFile() {

        Scanner sc;

        try {
            sc = new Scanner(new File("Liv.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.toString());
            return;
        }
        sc.useDelimiter("\n");
         while (sc.hasNext()) {
              String s = sc.next();
              System.out.println(s);
         }
         
         System.out.println(sc.toString());
//        for (int i = 0; i < 2; i++){
//            sc.nextLine();
//            
//        }
//        String s = sc.nextLine();
//        System.out.println(s);
    }

    public static MyNode readNode(int linenum) {
        Scanner sc = null;
        Scanner sc2 = null;
        MyNode retNode;
        String s;
        String name = "";
        String level = "";
        String text;

        try {
            sc = new Scanner(new File("Liv.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.toString());
        }

        for (int i = 0; i < linenum - 1; i++) {
            sc.nextLine();
        }
        s = sc.nextLine();
        text = s.substring(s.indexOf(">"));
        sc2 = new Scanner(s);

        String s2 = sc2.next();
        if (s2.contains("namn="));
        {
            name = s2.substring(s2.indexOf("namn=") + 5, s2.indexOf(">"));
        }
        if (s2.startsWith("<"));
        {
            level = s2.substring(s2.indexOf("<"), s2.indexOf(" "));
        }

        sc2.close();
        retNode = new MyNode(name, text, level);

        if (s.startsWith("<"));
        {
            retNode.add(readNode(linenum++));

        }
        if (s.startsWith("</"));
        {
            sc.close();
            return retNode;

        }
        

    }

}
