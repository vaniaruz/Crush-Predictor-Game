import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Level1 extends JPanel {
    private final JTextField nameField;
    private final JTextField crushField;
    private JLabel messageLabel; // Changed to non-final since we initialize it later

    public Level1 (CardLayout layout, JFrame frame, JPanel panelContainer) {
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameField = new JTextField(20);
        JLabel crushLabel = new JLabel("Enter Crush's Name:");
        crushField = new JTextField(20);

        JButton nextBtn = new JButton("Next");
        // Initialize message label
        messageLabel = new JLabel();
        messageLabel.setForeground(Color.RED);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVisible(false);

        nextBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String crush = crushField.getText().trim();

            if (name.isEmpty() || crush.isEmpty()) {
                messageLabel.setText("⚠️ Please enter both names");
                messageLabel.setVisible(true);
            } else {
                messageLabel.setVisible(false);
                layout.show(panelContainer, "Level2");
            }
        });

        add(nameLabel);
        add(nameField);
        add(crushLabel);
        add(crushField);
        add(nextBtn);
        add(messageLabel);
    }

    public void reset() {
        nameField.setText("");
        crushField.setText("");
    }
}