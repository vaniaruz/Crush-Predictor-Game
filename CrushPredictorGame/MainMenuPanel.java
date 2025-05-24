import java.awt.*;
import javax.swing.*;

public class MainMenuPanel extends JPanel {
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;

    public MainMenuPanel(CardLayout layout, JFrame frame, JPanel panelContainer, Level1 level1, Level2 level2, Level3 level3) {
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Crush Predictor Game");
        JButton startButton = new JButton("Start");
        
        startButton.addActionListener(e -> layout.show(panelContainer, "Level1"));

        add(title, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }
}