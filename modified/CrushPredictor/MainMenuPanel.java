import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;

    public MainMenuPanel(CardLayout layout, JFrame frame, JPanel panelContainer, Level1 level1, Level2 level2, Level3 level3) {
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F0F8FF")); 

        // Title JLabel
        JLabel title = new JLabel("Crush Predictor Game");
        title.setFont(new Font("Sans Serif", Font.BOLD, 36));
        title.setForeground(Color.decode("#FF6F61"));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(50, 0, 20, 0));

        // Start Button
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        startButton.setBackground(Color.decode("#FF6F61")); 
        startButton.setForeground(Color.WHITE); 
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startButton.setBorderPainted(false);
        startButton.setOpaque(true);
        startButton.setPreferredSize(new Dimension(200, 50));

        // Button Hover Effect
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButton.setBackground(Color.decode("#FF4F3D")); 
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButton.setBackground(Color.decode("#FF6F61")); 
            }
        });

        // Add action listener to start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(panelContainer, "Level1");
            }
        });

        // Adding components
        add(title, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }
}