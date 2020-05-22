package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Coady Duffney
 */
public class PrefsDialog extends JDialog {

    private JButton okButton;
    private JButton cancelButton;
    private JSpinner portSpinner;
    private SpinnerNumberModel spinnerModel;

    public PrefsDialog(JFrame parentFrame) {
        super(parentFrame, "Preferences", false);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("Port: "), gc);

        gc.gridx++;
        add(portSpinner, gc);

        // -- NEXT ROW
        gc.gridy++;
        gc.gridx = 0;
        add(okButton,gc);

        gc.gridx = 1;
        add(cancelButton, gc);

        okButton.addActionListener((e) -> {
            Integer value = (Integer) portSpinner.getValue();
            System.out.println("value=" + value);
            dispose();
        });

        cancelButton.addActionListener((e) -> {
            dispose();
        });

        setSize(400, 300);
        setLocationRelativeTo(parentFrame);
    }
    
}
