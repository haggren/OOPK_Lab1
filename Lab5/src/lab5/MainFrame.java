
package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;



/**
 *
 * @author hugo
 */
public class MainFrame extends JFrame implements HyperlinkListener{
    
    private URLField urlField;
    private ViewPane viewPane;
    private JTextPane historyPane;
    private JScrollPane scrollPane;
    private JPanel container;
    private JPanel navBarPanel;
    private JButton closeButton;
    private NavButton back;
    private NavButton forward;
    private NavButton history;
    
    
    public MainFrame(){
        super("Webbrowser");
        container = new JPanel();
        container.setPreferredSize(new Dimension(1200,900));
        viewPane = new ViewPane();
        scrollPane = createScrollPane(viewPane);
        urlField = new URLField(viewPane);
        closeButton = new CloseButton(this);
        createHistoryPane();
        
         
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
        
        JLabel label = new JLabel("Webbrowser");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD,30));
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        
        container.add(label,gbc);
        gbc.gridy++;
        
        container.add(createNavBar(), gbc);
        gbc.gridy++;
        
        container.add(urlField, gbc);
        gbc.gridy++;
        
        container.add(scrollPane, gbc);
        gbc.gridx++;
        container.add(historyPane, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        container.add(closeButton, gbc);
        gbc.gridy++;
        
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 2;
    }
    
    /*
    Skapar navigeringsraden
    */
    private JPanel createNavBar(){
        

        navBarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        back = new NavButton("BACK");
        history = new NavButton("HISTORY");
        forward = new NavButton("FORWARD");
        navBarPanel.add(back);
        navBarPanel.add(history);
        navBarPanel.add(forward);

        return navBarPanel;
    }
    
    private void createHistoryPane(){
        historyPane = new JTextPane();
        historyPane.setVisible(false);
        historyPane.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        historyPane.setEditable(false);
        historyPane.setPreferredSize(new Dimension(250,600));
        historyPane.addHyperlinkListener(this);
    }
    
    public void displayHistoryPane(){
        if (!historyPane.isVisible()){
            historyPane.setVisible(true);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < viewPane.historyURL.size() ; i++){
                
                sb.append(("<a href=" + viewPane.historyURL.get(i).toString() +
                            ">" + viewPane.historyURL.get(i).toString() + "</a>" + " <br>"));
                
                System.out.println(viewPane.historyURL.get(i).toString());
            }
            historyPane.setText(sb.toString());
        }else{
            historyPane.setVisible(false);
        }
            
    }
        
    public static void main(String[] args){
        new MainFrame();
    }


    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        viewPane.hyperlinkUpdate(e);
    }
    
public class NavButton extends JButton implements ActionListener {
    
    
    public NavButton(String text){
        
        setBackground(Color.lightGray);
        setText(text);
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (getText().equals("BACK")){
            viewPane.goBack();
        }
        if (getText().equals("FORWARD")){
            viewPane.goForward();
        }
        if (getText().equals("HISTORY")){
            displayHistoryPane();
        }
    }
    
}

    
    
}
