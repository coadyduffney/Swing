package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Coady Duffney
 */
public class PrefsDialog extends JDialog {

    private JButton okButton;
    private JButton cancelButton;
    private JSpinner portSpinner;
    private SpinnerNumberModel spinnerModel;
    private JTextField userField;
    private JPasswordField passField;

    private PrefsListener prefsListener;

    public PrefsDialog(JFrame parentFrame) {
        super(parentFrame, "Preferences", false);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);

        userField = new JTextField(10);
        passField = new JPasswordField(10);
        passField.setEchoChar('*');

        layoutControls();

        okButton.addActionListener((e) -> {
            Integer portValue = (Integer) portSpinner.getValue();

            String user = userField.getText();

            char[] password = passField.getPassword();
            String passwordString = new String(password);

            if (prefsListener != null) {
                prefsListener.preferencesSet(user, passwordString, portValue);
            }

            dispose();
        });

        cancelButton.addActionListener((e) -> {
            dispose();
        });

        setSize(340, 250);
        setLocationRelativeTo(parentFrame);
    }

    private void layoutControls() {

        JPanel controlsPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        Border spaceBorder = BorderFactory.createEmptyBorder(8,8,8,8);
        Border titleBorder = BorderFactory.createTitledBorder("Database Preferences");

        controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        controlsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        // -- FIRST ROW -- //
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;


        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("User: "), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(userField, gc);

        // -- NEXT ROW -- //
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("Password: "), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(passField, gc);

        // -- NEXT ROW -- //
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("Port: "), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(portSpinner, gc);

        // -- BUTTONS PANEL -- //
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        Dimension btnSize = cancelButton.getPreferredSize();
        okButton.setPreferredSize(btnSize);

        buttonsPanel.add(okButton, gc);
        buttonsPanel.add(cancelButton, gc);

        // Add sub panels to dialog
        setLayout(new BorderLayout());
        add(controlsPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void setDefaults(String user, String password, int port) {
        userField.setText(user);
        passField.setText(password);
        portSpinner.setValue(port);
    }

    public void setPrefsListener(PrefsListener prefsListener) {
        this.prefsListener = prefsListener;
    }

}
