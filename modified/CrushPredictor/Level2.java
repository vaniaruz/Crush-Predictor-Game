import java.awt.*;
import javax.swing.*;

public class Level2 extends JPanel {
    private final CardLayout layout;
    private final JFrame frame;
    private final JPanel panelContainer;
    private JLabel questionLabel;
    private JButton yesButton;
    private JButton noButton;
    private int currentQuestion = 0;

    private static final String[] mainQuestions = {
        "Are you close with your crush?",
        "Any interactions with your crush?",
        "Do you think your crush knows you exist?",
        "Ever imagined being in a relationship with them?",
        "Do you genuinely like your crush?"
    };

    public Level2(CardLayout layout, JFrame frame, JPanel panelContainer) {
        this.layout = layout;
        this.frame = frame;
        this.panelContainer = panelContainer;
        questionLabel = new JLabel(mainQuestions[currentQuestion]);
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F0F8FF")); // Light blue background

        // Yes Button
        yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Sans Serif", Font.BOLD, 18));
        yesButton.setBackground(Color.decode("#FF6F61")); // Coral background
        yesButton.setForeground(Color.BLACK);
        yesButton.setFocusPainted(false);
        yesButton.setOpaque(true);
        yesButton.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));

        // No Button
        noButton = new JButton("No");
        noButton.setFont(new Font("Sans Serif", Font.BOLD, 18));
        noButton.setBackground(Color.decode("#FF6F61")); // Coral background
        noButton.setForeground(Color.BLACK);
        noButton.setFocusPainted(false);
        noButton.setOpaque(true);
        noButton.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));

        yesButton.addActionListener(e -> handleAnswer(true));
        noButton.addActionListener(e -> handleAnswer(false));

        // Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // Question Panel
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionLabel.setFont(new Font("Sans Serif", Font.BOLD, 16)); // Reduced font size from 20 to 16
        questionLabel.setForeground(Color.decode("#FF6F61")); // Coral text
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionPanel.add(questionLabel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // Horizontal gap of 10 pixels
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Add top padding
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        // Add panels to contentPanel
        contentPanel.add(questionPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(contentPanel);
    }

    private void handleAnswer(boolean isYes) {
        currentQuestion++;
        if (currentQuestion >= mainQuestions.length) {
            layout.show(panelContainer, "Level3");
        } else {
            updateQuestion();
        }
    }

    public void reset() {
        currentQuestion = 0;
        questionLabel.setText(mainQuestions[currentQuestion]);
        yesButton.setEnabled(true);
        noButton.setEnabled(true);
    }

    private void updateQuestion() {
        questionLabel.setText(mainQuestions[currentQuestion]);
    }
}