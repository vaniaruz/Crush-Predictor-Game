import java.awt.*;
import java.awt.event.ActionEvent;
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

    public Level3(CardLayout layout, JFrame frame, JPanel panelContainer) {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F0F8FF"));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        resultArea.setForeground(Color.decode("#FF6F61"));
        resultArea.setBackground(Color.WHITE);
        resultArea.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6F61"), 2));

        JButton generateBtn = new JButton("Generate");
        generateBtn.setFont(new Font("Sans Serif", Font.BOLD, 18));
        generateBtn.setBackground(Color.decode("#FF6F61"));
        generateBtn.setForeground(Color.WHITE);
        generateBtn.setFocusPainted(false);
        generateBtn.setOpaque(true);
        generateBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));
        generateBtn.addActionListener((ActionEvent e) -> {
            String result = outcomes[new Random().nextInt(outcomes.length)];
            resultArea.setText(result);
        });

        JButton restartBtn = new JButton("Restart");
        restartBtn.setFont(new Font("Sans Serif", Font.BOLD, 18));
        restartBtn.setBackground(Color.decode("#FF6F61"));
        restartBtn.setForeground(Color.WHITE);
        restartBtn.setFocusPainted(false);
        restartBtn.setOpaque(true);
        restartBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4F3D"), 2));
        restartBtn.addActionListener(e -> layout.show(panelContainer, "Menu"));

        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.setBackground(Color.decode("#F0F8FF"));
        btnPanel.add(generateBtn);
        btnPanel.add(restartBtn);

        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public void reset() {
        resultArea.setText("");
    }
}