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
 * Uso da biblioteca Apache Batik para usar SVG em Java
 */
public class ProjetoDeTestes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("Svg");
        ProjetoDeTestes app = new ProjetoDeTestes(f);

        f.getContentPane().add(app.createComponents());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    protected JFrame frame;

    protected JSVGCanvas svgCanvas = new JSVGCanvas();

    public ProjetoDeTestes(JFrame f) {
        frame = f;
    }

    public JComponent createComponents() {
        final JPanel panel = new JPanel(new BorderLayout());

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panel.add("North", p);
        panel.add("Center", svgCanvas);


        File svg = new File("C:\\Users\\rafael.albuquerque\\Downloads\\users-gear-solid.svg");
        svgCanvas.setURI(svg.toURI().toString());

        return panel;
    }

}
