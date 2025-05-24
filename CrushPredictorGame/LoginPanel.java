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
        setLayout(new GridLayout(6, 1, 10, 10));

        JLabel prompt = new JLabel("Enter Secret Code", SwingConstants.CENTER);
        inputField = new JTextField();
        JButton submit = new JButton("Enter");
        messageLabel = new JLabel("", SwingConstants.CENTER);
        attemptLabel = new JLabel("", SwingConstants.CENTER);
        
        // Create hint label that's always visible
        hintLabel = new JLabel("Note : It rhymes with LUSH!!!", SwingConstants.CENTER);
        hintLabel.setForeground(Color.GRAY);

        // Submit action
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();

                if (input.equalsIgnoreCase("CRUSH")) {
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

        // Add components
        add(prompt);
        add(hintLabel);
        add(inputField);
        add(submit);
        add(messageLabel);
        add(attemptLabel);
    }
}