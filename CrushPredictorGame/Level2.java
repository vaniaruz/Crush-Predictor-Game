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
        "Have you ever imagined being in a relationship with your crush?",
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

        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        
        yesButton.addActionListener(e -> handleAnswer(true));
        noButton.addActionListener(e -> handleAnswer(false));

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel questionPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        questionPanel.add(questionLabel, BorderLayout.CENTER);
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

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
    }

    private void updateQuestion() {
        questionLabel.setText(mainQuestions[currentQuestion]);
    }
}
