package view;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Coady Duffney
 */
public class PrefsDialog extends JDialog {

    public PrefsDialog(JFrame parentFrame) {
        super(parentFrame, "Preferences", false);
        
        setSize(400, 300);
    }
    
}
