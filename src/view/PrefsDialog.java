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
    private JTextField userField;
    private JPasswordField passField;


    public PrefsDialog(JFrame parentFrame) {
        super(parentFrame, "Preferences", false);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);

        userField = new JTextField(10);
        passField = new JPasswordField(10);
        passField.setEchoChar('*');

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        // -- FIRST ROW
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("User: "), gc);

        gc.gridx++;
        add(userField, gc);

        // -- NEXT ROW
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("Password: "), gc);

        gc.gridx++;
        add(passField, gc);

        // -- NEXT ROW
        gc.gridy++;

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
            Integer portValue = (Integer) portSpinner.getValue();
            String user = userField.getText();
            char[] password = passField.getPassword();

            System.out.println(user + new String(password));

            dispose();
        });

        cancelButton.addActionListener((e) -> {
            dispose();
        });

        setSize(400, 300);
        setLocationRelativeTo(parentFrame);
    }
    
}
