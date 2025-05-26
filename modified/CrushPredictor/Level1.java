import java.awt.*;
import javax.swing.*;

public class Level1 extends JPanel {
    private final JTextField nameField;
    private final JTextField crushField;
    private JLabel messageLabel;

    public Level1(CardLayout layout, JFrame frame, JPanel panelContainer) {
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#F0F8FF"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Ensure fields expand horizontally
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components

        // Name Label
        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        nameLabel.setForeground(Color.decode("#FF6F61"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        // Name Field (Increased size)
        nameField = new JTextField(30); // Increased column width from 20 to 30
        nameField.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        nameField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6F61"), 2));
        gbc.gridx = 1;
        gbc.weightx = 1.0; // Allow the field to expand horizontally
        add(nameField, gbc);

        // Crush Label
        JLabel crushLabel = new JLabel("Enter Crush's Name:");
        crushLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        crushLabel.setForeground(Color.decode("#FF6F61"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(crushLabel, gbc);

        // Crush Field (Increased size)
        crushField = new JTextField(30); // Increased column width from 20 to 30
        crushField.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        crushField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6F61"), 2));
        gbc.gridx = 1;
        gbc.weightx = 1.0; // Allow the field to expand horizontally
        add(crushField, gbc);

        // Next Button
        JButton nextBtn = new JButton("Continue");
        nextBtn.setFont(new Font("Sans Serif", Font.BOLD, 18));
        nextBtn.setBackground(Color.decode("#FF6F61"));
        nextBtn.setForeground(Color.BLACK);
        nextBtn.setFocusPainted(false);
        nextBtn.setOpaque(true);
        nextBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span across two columns
        gbc.weightx = 0.0; // Reset weight for button
        add(nextBtn, gbc);

        // Message Label
        messageLabel = new JLabel();
        messageLabel.setForeground(Color.RED);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVisible(false);
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across two columns
        add(messageLabel, gbc);

        // Action Listener for Next Button
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
    }

    public void reset() {
        nameField.setText("");
        crushField.setText("");
    }
}