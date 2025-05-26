import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Level3 extends JPanel {
    private final String[] outcomes = {
        "YOU TWO ARE MADE FOR EACH OTHER!!!",
        "Talk to them…RIGHT NOW",
        "It's a match <3",
        "They want you so bad fr",
        "It's not a match :(",
        "They see you as a friend",
        "One-sided, stay strong.",
        "They liked you.....last semester",
        "Besties forever, das it",
        "Play Take a Chance by Niki"
    };

    private final JTextArea resultArea;
    private Timer shuffleTimer;
    private final CardLayout layout;
    private final JPanel panelContainer;

    public Level3(CardLayout layout, JFrame frame, JPanel panelContainer) {
        this.layout = layout;
        this.panelContainer = panelContainer;
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F0F8FF"));

        // Result Area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        resultArea.setForeground(Color.decode("#FF6F61"));
        resultArea.setBackground(Color.WHITE);
        resultArea.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6F61"), 2));

        // Generate Button
        JButton generateBtn = new JButton("Generate");
        generateBtn.setFont(new Font("Sans Serif", Font.BOLD, 18));
        generateBtn.setBackground(Color.decode("#FF6F61"));
        generateBtn.setForeground(Color.BLACK);
        generateBtn.setFocusPainted(false);
        generateBtn.setOpaque(true);
        generateBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));
        generateBtn.addActionListener((ActionEvent e) -> {
            // Stop any ongoing shuffle
            if (shuffleTimer != null && shuffleTimer.isRunning()) {
                shuffleTimer.stop();
            }

            // Start the shuffle animation
            shuffleTimer = new Timer(100, new ActionListener() {
                private int count = 0;
                private Random random = new Random();

                @Override
                public void actionPerformed(ActionEvent e) {
                    // Display a random outcome
                    resultArea.setText(outcomes[random.nextInt(outcomes.length)]);

                    // Stop after 10 ticks (adjust as needed)
                    if (++count >= 10) {
                        shuffleTimer.stop();

                        // Set the final outcome
                        String finalResult = outcomes[random.nextInt(outcomes.length)];
                        resultArea.setText(finalResult);
                    }
                }
            });
            shuffleTimer.start();
        });

        // Restart Button
        JButton restartBtn = new JButton("Restart");
        restartBtn.setFont(new Font("Sans Serif", Font.BOLD, 18));
        restartBtn.setBackground(Color.decode("#FF6F61"));
        restartBtn.setForeground(Color.BLACK);
        restartBtn.setFocusPainted(false);
        restartBtn.setOpaque(true);
        restartBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));
        restartBtn.addActionListener(e -> {
            // Reset the result area
            resultArea.setText("");
            
            // Stop any ongoing shuffle
            if (shuffleTimer != null && shuffleTimer.isRunning()) {
                shuffleTimer.stop();
            }
            
            // Reset Level1
            Level1 level1 = (Level1) panelContainer.getComponent(2); // Level1 is at index 2 in the panel container
            level1.reset();
            
            // Reset Level2
            Level2 level2 = (Level2) panelContainer.getComponent(3); // Level2 is at index 3 in the panel container
            level2.reset();
            
            // Reset Level3
            Level3 level3 = (Level3) panelContainer.getComponent(4); // Level3 is at index 4 in the panel container
            level3.reset();
            
            // Show Level1 again
            layout.show(panelContainer, "Level1");
        });

        // Button Panel
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Horizontal gap of 20 pixels
        btnPanel.setBackground(Color.decode("#F0F8FF"));
        btnPanel.add(generateBtn);
        btnPanel.add(restartBtn);

        // Add padding to the button panel
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Top, Left, Bottom, Right

        // Add components to the main panel
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public void reset() {
        resultArea.setText("");
    }
}