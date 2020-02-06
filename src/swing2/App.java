package swing2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Coady Duffney
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new MainFrame();
        });
    }
}
