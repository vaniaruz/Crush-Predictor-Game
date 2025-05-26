import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel {
    private final JTextField inputField;
    private final JLabel messageLabel;
    private final JLabel attemptLabel;
    private final JLabel hintLabel;
    private int attemptsLeft = 3;
    private final CardLayout layout;
    private final JPanel panelContainer;

    public LoginPanel(CardLayout layout, JFrame frame, JPanel panelContainer) {
        this.layout = layout;
        this.panelContainer = panelContainer;
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#F0F8FF"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 15, 15, 15); // Increased padding

        // Title prompt
        JLabel prompt = new JLabel("Enter Secret Code", SwingConstants.CENTER);
        prompt.setFont(new Font("Sans Serif", Font.BOLD, 24));
        prompt.setForeground(Color.decode("#FF6F61")); // Coral color
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        add(prompt, gbc);

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        inputField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6F61"), 2));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(inputField, gbc);

        // Submit button
        JButton submit = new JButton("Enter");
        submit.setFont(new Font("Sans Serif", Font.BOLD, 20));
        submit.setBackground(Color.decode("#FF6F61"));
        submit.setForeground(Color.BLACK);
        submit.setFocusPainted(false);
        submit.setOpaque(true);
        submit.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));
        submit.setPreferredSize(new Dimension(100, 40));
        gbc.gridx = 1;
        add(submit, gbc);

        // Hint Label
        hintLabel = new JLabel("Note: It rhymes with LUSH!!!", SwingConstants.CENTER);
        hintLabel.setForeground(Color.GRAY);
        hintLabel.setFont(new Font("Sans Serif", Font.ITALIC, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 10, 10);
        add(hintLabel, gbc);

        // Message Panel for stacked labels
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.setBackground(Color.decode("#F0F8FF"));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 10, 10);

        // Message Label
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messagePanel.add(messageLabel);

        // Attempt Label
        attemptLabel = new JLabel("", SwingConstants.CENTER);
        attemptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messagePanel.add(attemptLabel);

        add(messagePanel, gbc);

        // Submit action listener
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();

                if (input.equalsIgnoreCase("CRUSH")) {
                    // Save login state
                    java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(Main.class);
                    prefs.putBoolean("hasLoggedInBefore", true);

                    // Show menu panel
                    layout.show(panelContainer, "Menu");
                } else {
                    attemptsLeft--;
                    messageLabel.setText("Incorrect code!");
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setVisible(true);
                    attemptLabel.setForeground(Color.RED);
                    attemptLabel.setText("Attempts Left: " + attemptsLeft);
                    attemptLabel.setVisible(true);

                    if (attemptsLeft == 0) {
                        submit.setEnabled(false);
                        messageLabel.setText("Too many attempts....");
                        attemptLabel.setText("");

                        // Start countdown
                        new Thread(() -> {
                            for (int i = 30; i > 0; i--) {
                                int secondsLeft = i;
                                SwingUtilities.invokeLater(() -> {
                                    attemptLabel.setText("Try again in " + secondsLeft + "s");
                                    attemptLabel.setVisible(true);
                                });

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }

                            // After 30s, reset UI
                            SwingUtilities.invokeLater(() -> {
                                attemptsLeft = 3;
                                attemptLabel.setVisible(false);
                                messageLabel.setText("");
                                inputField.setText("");
                                submit.setEnabled(true);
                            });
                        }).start();
                    }
                }
            }
        });
    }
}