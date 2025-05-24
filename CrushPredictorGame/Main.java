import java.awt.CardLayout;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Create and configure frame
            JFrame frame = new JFrame("Russian Roulette: Crush Edition");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            // Create layout and container
            CardLayout layout = new CardLayout();
            JPanel panelContainer = new JPanel(layout);

            // Create panels
            Level1 level1 = new Level1(layout, frame, panelContainer);
            Level2 level2 = new Level2(layout, frame, panelContainer);
            Level3 level3 = new Level3(layout, frame, panelContainer);
            LoginPanel loginPanel = new LoginPanel(layout, frame, panelContainer);
            MainMenuPanel menuPanel = new MainMenuPanel(layout, frame, panelContainer, level1, level2, level3);

            // Add panels to container
            panelContainer.add(loginPanel, "Login");
            panelContainer.add(menuPanel, "Menu");
            panelContainer.add(level1, "Level1");
            panelContainer.add(level2, "Level2");
            panelContainer.add(level3, "Level3");

            // Check if user has logged in before
            java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(Main.class);
            boolean hasLoggedInBefore = prefs.getBoolean("hasLoggedInBefore", false);
            
         // Show login panel only if it's the first time
             if (!hasLoggedInBefore) {
                 layout.show(panelContainer, "Login");
             } else {
                layout.show(panelContainer, "Menu");
             }
            
         // Add container to frame
            frame.add(panelContainer);
            frame.setVisible(true);
            
            // Show appropriate panel
            String initialPanel = hasLoggedInBefore ? "Menu" : "Login";
            layout.show(panelContainer, initialPanel);
            // Add panels to the container
            panelContainer.add(loginPanel, "Login");
            panelContainer.add(menuPanel, "Menu");
            panelContainer.add(level1, "Level1");
            panelContainer.add(level2, "Level2");
            panelContainer.add(level3, "Level3");

            // Set initial panel and add to frame
            layout.show(panelContainer, "Login");

            // Add container to frame and make visible
            frame.add(panelContainer);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error starting the game: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}