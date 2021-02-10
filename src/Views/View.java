package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public View(JPanel contnet) {
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contnet);
        setVisible(true);
    }
}
