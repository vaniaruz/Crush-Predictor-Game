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
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        nameLabel.setForeground(Color.decode("#FF6F61"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        nameField = new JTextField(20);
        nameField.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        nameField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6F61"), 2));
        gbc.gridx = 1;
        add(nameField, gbc);

        JLabel crushLabel = new JLabel("Enter Crush's Name:");
        crushLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        crushLabel.setForeground(Color.decode("#FF6F61"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(crushLabel, gbc);

        crushField = new JTextField(20);
        crushField.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        crushField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6F61"), 2));
        gbc.gridx = 1;
        add(crushField, gbc);

        JButton nextBtn = new JButton("Next");
        nextBtn.setFont(new Font("Sans Serif", Font.BOLD, 18));
        nextBtn.setBackground(Color.decode("#FF6F61"));
        nextBtn.setForeground(Color.WHITE);
        nextBtn.setFocusPainted(false);
        nextBtn.setOpaque(true);
        nextBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(nextBtn, gbc);

        messageLabel = new JLabel();
        messageLabel.setForeground(Color.RED);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVisible(false);
        gbc.gridy = 3;
        add(messageLabel, gbc);

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