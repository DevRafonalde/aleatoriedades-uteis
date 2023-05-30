package projeto.de.testes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.batik.swing.JSVGCanvas;

/**
 *
 * @author rafael.albuquerque
 */
public class ProjetoDeTestes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a new JFrame.
        JFrame f = new JFrame("Svg");
        ProjetoDeTestes app = new ProjetoDeTestes(f);

        // Add components to the frame.
        f.getContentPane().add(app.createComponents());

        // Display the frame.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    // The frame.
    protected JFrame frame;

    // The SVG canvas.
    protected JSVGCanvas svgCanvas = new JSVGCanvas();

    public ProjetoDeTestes(JFrame f) {
        frame = f;
    }

    public JComponent createComponents() {
        // Create a panel and add the button, status label and the SVG canvas.
        final JPanel panel = new JPanel(new BorderLayout());

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panel.add("North", p);
        panel.add("Center", svgCanvas);


        File svg = new File("C:\\Users\\rafael.albuquerque\\Downloads\\users-gear-solid.svg");
        svgCanvas.setURI(svg.toURI().toString());

        return panel;
    }

}
