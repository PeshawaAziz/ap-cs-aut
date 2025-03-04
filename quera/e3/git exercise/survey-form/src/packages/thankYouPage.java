package packages;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class thankYouPage {

    public void create(JFrame frame) {

        // Create and configure the panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 600, 800);
        panel.setBackground(Color.YELLOW);

        // Create thank you label
        JLabel thankYouLabel = new JLabel("Thanks for your participation!");
        thankYouLabel.setFont(font);
        thankYouLabel.setBounds(10, 10, 200, 20);
        thankYouLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add components to the panel
        panel.add(thankYouLabel, BorderLayout.NORTH);

        // Add panel to the frame
        frame.add(panel);

    }

}
