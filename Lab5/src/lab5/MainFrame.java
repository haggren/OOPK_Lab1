
package lab5;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author hugo
 */
public class MainFrame extends JFrame{
    
    private URLField urlField;
    private ViewPane viewPane;
    private JScrollPane scrollPane;
    private JPanel container;
    private JButton closeButton;
    
    public MainFrame(){
        
        container = new JPanel();
        container.setPreferredSize(new Dimension(1200,900));
        viewPane = new ViewPane();
        scrollPane = createScrollPane(viewPane);
        urlField = new URLField(viewPane);
        closeButton = new CloseButton(this);
        
        handleLayout();
        add(container);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /*
    Skapar ett fönster som har scrollbar och lägger argumentet i den.
    */
    private JScrollPane createScrollPane(JEditorPane argPane){
        JScrollPane scroller = new JScrollPane(argPane);
        scroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(800, 600));
        scroller.setMinimumSize(new Dimension(800, 600));
        return scroller;
    }
    
    /*
    En riktig shitfest, denna metod sätter in allt i container och ser till att det ser snyggt ut
    mha GridBagLayout vilket påstås vara den värsta swing klassen av dem alla.
    */
    private void handleLayout() {
        
        JLabel label = new JLabel("WebbläsarN");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD,30));
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        
        container.add(label,gbc);
        gbc.gridy++;
                
        container.add(urlField, gbc);
        gbc.gridy++;
        
        container.add(scrollPane, gbc);
        gbc.gridy++;
        
        container.add(closeButton, gbc);
        gbc.gridy++;
        
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 2;
    }
    
    public static void main(String[] args){
        new MainFrame();
    }
    
}
