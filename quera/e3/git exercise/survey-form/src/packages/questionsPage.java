package packages;

import java.awt.Color;
import javax.swing.*;

public class questionsPage {

    public void create(JFrame frame) {
        // Create and configure the panel
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 1200);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.YELLOW);

        // Question 1
        JLabel question1 = new JLabel("How attractive do you find the software's UI?");
        question1.setFont(font);
        question1.setBounds(10, 10, 300, 20);

        JRadioButton radio1_1 = new JRadioButton("1");
        radio1_1.setFont(font);
        radio1_1.setBounds(10, 40, 100, 20);
        JRadioButton radio1_2 = new JRadioButton("2");
        radio1_2.setFont(font);
        radio1_2.setBounds(80, 40, 100, 20);
        JRadioButton radio1_3 = new JRadioButton("3");
        radio1_3.setFont(font);
        radio1_3.setBounds(150, 40, 100, 20);
        JRadioButton radio1_4 = new JRadioButton("4");
        radio1_4.setFont(font);
        radio1_4.setBounds(220, 40, 100, 20);
        JRadioButton radio1_5 = new JRadioButton("5");
        radio1_5.setFont(font);
        radio1_5.setBounds(290, 40, 100, 20);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(radio1_1);
        group1.add(radio1_2);
        group1.add(radio1_3);
        group1.add(radio1_4);
        group1.add(radio1_5);

        // Question 2
        JLabel question2 = new JLabel("Is it easy for you to access the various features of the software?");
        question2.setFont(font);
        question2.setBounds(10, 90, 300, 20);
      
        JRadioButton radio2_1 = new JRadioButton("1");
        radio2_1.setFont(font);
        radio2_1.setBounds(10, 120, 100, 20);
        JRadioButton radio2_2 = new JRadioButton("2");
        radio2_2.setFont(font);
        radio2_2.setBounds(80, 120, 100, 20);
        JRadioButton radio2_3 = new JRadioButton("3");
        radio2_3.setFont(font);
        radio2_3.setBounds(150, 120, 100, 20);
        JRadioButton radio2_4 = new JRadioButton("4");
        radio2_4.setFont(font);
        radio2_4.setBounds(220, 120, 100, 20);
        JRadioButton radio2_5 = new JRadioButton("5");
        radio2_5.setFont(font);
        radio2_5.setBounds(290, 120, 100, 20);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(radio2_1);
        group2.add(radio2_2);
        group2.add(radio2_3);
        group2.add(radio2_4);
        group2.add(radio2_5);

        // Question 3
        JLabel question3 = new JLabel("How simple and user-friendly is the software page design?");
        question3.setFont(font);
        question3.setBounds(10, 170, 300, 20);

        JRadioButton radio3_1 = new JRadioButton("1");
        radio3_1.setFont(font);
        radio3_1.setBounds(10, 200, 100, 20);
        JRadioButton radio3_2 = new JRadioButton("2");
        radio3_2.setFont(font);
        radio3_2.setBounds(80, 200, 100, 20);
        JRadioButton radio3_3 = new JRadioButton("3");
        radio3_3.setFont(font);
        radio3_3.setBounds(150, 200, 100, 20);
        JRadioButton radio3_4 = new JRadioButton("4");
        radio3_4.setFont(font);
        radio3_4.setBounds(220, 200, 100, 20);
        JRadioButton radio3_5 = new JRadioButton("5");
        radio3_5.setFont(font);
        radio3_5.setBounds(290, 200, 100, 20);

        ButtonGroup group3 = new ButtonGroup();
        group3.add(radio3_1);
        group3.add(radio3_2);
        group3.add(radio3_3);
        group3.add(radio3_4);
        group3.add(radio3_5);

        // Question 4
        JLabel question4 = new JLabel("Are the colors and fonts used in the software appropriate?");
        question4.setFont(font);
        question4.setBounds(10, 250, 350, 20);

        JRadioButton radio4_1 = new JRadioButton("1");
        radio4_1.setFont(font);
        radio4_1.setBounds(10, 280, 100, 20);
        JRadioButton radio4_2 = new JRadioButton("2");
        radio4_2.setFont(font);
        radio4_2.setBounds(80, 280, 100, 20);
        JRadioButton radio4_3 = new JRadioButton("3");
        radio4_3.setFont(font);
        radio4_3.setBounds(150, 280, 100, 20);
        JRadioButton radio4_4 = new JRadioButton("4");
        radio4_4.setFont(font);
        radio4_4.setBounds(220, 280, 100, 20);
        JRadioButton radio4_5 = new JRadioButton("5");
        radio4_5.setFont(font);
        radio4_5.setBounds(290, 280, 100, 20);

        ButtonGroup group4 = new ButtonGroup();
        group4.add(radio4_1);
        group4.add(radio4_2);
        group4.add(radio4_3);
        group4.add(radio4_4);
        group4.add(radio4_5);

        // Next button to go to Page3
        JButton nextButton = new JButton("next page");
        nextButton.setFont(font);
        nextButton.setBounds(10, 320, 100, 20);
        nextButton.addActionListener(e -> {
            frame.remove(panel);
            frame.revalidate();
            frame.repaint();

            thankYouPage thankYouPage = new thankYouPage();
            thankYouPage.create(frame);

            frame.revalidate();
            frame.repaint();
        });

        // Add components to the panel
        panel.add(question1);
        panel.add(radio1_1);
        panel.add(radio1_2);
        panel.add(radio1_3);
        panel.add(radio1_4);
        panel.add(radio1_5);

        panel.add(question2);
        panel.add(radio2_1);
        panel.add(radio2_2);
        panel.add(radio2_3);
        panel.add(radio2_4);
        panel.add(radio2_5);

        panel.add(question3);
        panel.add(radio3_1);
        panel.add(radio3_2);
        panel.add(radio3_3);
        panel.add(radio3_4);
        panel.add(radio3_5);

        panel.add(question4);
        panel.add(radio4_1);
        panel.add(radio4_2);
        panel.add(radio4_3);
        panel.add(radio4_4);
        panel.add(radio4_5);

        panel.add(nextButton);

        // Add panel to the frame
        frame.add(panel);
    }
}
