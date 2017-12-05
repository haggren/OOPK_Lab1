
package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author hugo
 */
public class View extends JPanel {

    private Model myModel;
    private static final int X_SIZE = 800;
    private static final int Y_SIZE = 600;

    public View(Model modelArg) {
        myModel = modelArg;
        setPreferredSize(new Dimension(X_SIZE, Y_SIZE));
        this.setOpaque(true);

        setVisible(true);
        repaint();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        double[] positions = myModel.getTotalPosition();
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, X_SIZE, Y_SIZE);

        for (int i = 0; i < positions.length; i = i + 2) {
            double x = positions[i] * X_SIZE;
            double y = positions[i + 1] * Y_SIZE;
            
            g2.setPaint(Color.BLACK);
            g2.fill(new Ellipse2D.Double(x, y, 6, 6));
            //System.out.println(x + "," + y);
        }
        Toolkit.getDefaultToolkit().sync();
        g2.setPaint(Color.RED);
        g2.fill(new Ellipse2D.Double(0, 0, 6, 6));
        
    }

}
    

