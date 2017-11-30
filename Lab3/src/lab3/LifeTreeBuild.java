
package lab3;

import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;        
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Scanner;

public class LifeTreeBuild extends JFrame implements ActionListener {

   public LifeTreeBuild() {
      
      Container c = getContentPane();
      //*** Build the tree and a mouse listener to handle clicks
      
      root = readNode();
      
      treeModel = new DefaultTreeModel( root );
      tree = new JTree( treeModel );
      MouseListener ml = 
        new MouseAdapter() {
          public void mouseClicked( MouseEvent e ) {
            if ( box.isSelected() )
              showDetails( tree.getPathForLocation( e.getX(), 
                                                    e.getY() ) );
          }
        };
      tree.addMouseListener( ml );
      //*** build the tree by adding the nodes
      
      //*** panel the JFrame to hold controls and the tree
      controls = new JPanel();
      box = new JCheckBox( showString );
      init(); //** set colors, fonts, etc. and add buttons
      c.add( controls, BorderLayout.NORTH );
      c.add( tree, BorderLayout.CENTER );   
      setVisible( true ); //** display the framed window
   } 

   public void actionPerformed( ActionEvent e ) {
      String cmd = e.getActionCommand();
      if ( cmd.equals( closeString ) )
        dispose();
   }

   private void init() {
      tree.setFont( new Font( "Dialog", Font.BOLD, 12 ) );
      controls.add( box );
      addButton( closeString );
      controls.setBackground( Color.lightGray );
      controls.setLayout( new FlowLayout() );    
      setSize( 400, 400 );
   }

   private void addButton( String n ) {
      JButton b = new JButton( n );
      b.setFont( new Font( "Dialog", Font.BOLD, 12 ) );
      b.addActionListener( this );
      controls.add( b );
   }


   private void showDetails( TreePath p ) {
      if ( p == null )
        return;
      MyNode currNode = (MyNode)p.getLastPathComponent();
      JOptionPane.showMessageDialog( this, currNode.getText() );
   }

  

    public static void main(String[] args) {
        if (args.length > 0) {
            katalog = args[0];
        }
        new LifeTreeBuild();
    }
    public static MyNode readNode() {

        Scanner xmlScan = scanFile();
        xmlScan.nextLine(); //Skippar första xml-raden
        String nextLine = "";
        String currLine = xmlScan.nextLine();
        String[] attributes = makeAttributes(currLine);
        String endTag = "/" + attributes[0];

        MyNode retNode = createNode(attributes);

        nextLine = xmlScan.nextLine();
        while (!cleanLine(nextLine).split(" ")[0].equals(endTag)) {
            readNode(retNode, nextLine, xmlScan);
            nextLine = xmlScan.nextLine();
        }
        xmlScan.close();
        return retNode;

    }
    public static MyNode readNode(MyNode parent, String inLine, Scanner inScan) {

        Scanner xmlScan = inScan;
        String nextLine = ""; //Temporär sträng

        String[] attributes = makeAttributes(inLine);

        String endTag = "/" + attributes[0];

        MyNode retNode = createNode(attributes);
        parent.add(retNode);
        nextLine = xmlScan.nextLine();
        while (!cleanLine(nextLine).split(" ")[0].equals(endTag)) {
            readNode(retNode, nextLine, xmlScan);
            nextLine = xmlScan.nextLine();
        }

        return retNode;

    }
    
    private static String[] makeAttributes(String inLine){
        
        String line = cleanLine(inLine);
        String name = getName(inLine);
        
        String[] output = {line.split(" ",2)[0],line.split(" ",2)[1], getName(inLine)};
                
        return output;
        
        
    }
    
    private static MyNode createNode(String[] inputs) {

        String name;
        String level;
        String text;

        System.out.println(Arrays.toString(inputs));
        name = inputs[2];
        level = inputs[0];
        text = inputs[1];

        return new MyNode(name, text, level);



    }

    
 public static String getName(String argLine){
       int citIndex = argLine.indexOf("\"");
       if(citIndex!=-1){
         String name = argLine.substring(citIndex+1, 
                  argLine.indexOf("\"",citIndex+1));
         System.out.println(name);
         return name;}
       String empty = "";
       return empty;
       
   }
    private static String cleanLine(String line) {
        String outLine = line;
        outLine = outLine.replace("<", "");
        outLine = outLine.replace(">", "");
        outLine = outLine.replace("namn=", "");
        outLine = outLine.replace("\"","");
        
        String name = getName(line);
        if(!name.equals("")){
            outLine.replace(name, "");
        }
        
        return outLine;
    }
    
    private static Scanner scanFile() {
        Scanner sc;
        try {
            sc = new Scanner(new File("Liv.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
        return sc;
    }

      

   private JCheckBox box;
   private JTree tree;
   private DefaultMutableTreeNode root;
   private DefaultTreeModel treeModel;
   private JPanel controls;
   private static String katalog="Liv";
   private static final String closeString = " Close ";
   private static final String showString = " Show Details ";
}
