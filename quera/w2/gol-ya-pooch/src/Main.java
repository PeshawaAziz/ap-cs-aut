import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GolYaPooch");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(1, 100, 200));
        panel.setBackground(Color.BLACK);

        JButton leftBtn = createButton("Left", "../assets/left.png", panel);
        JButton rightBtn = createButton("Right", "../assets/right.png", panel);

        rightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(panel);
            }
        });

        leftBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(panel);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void handleButtonClick(JPanel panel) {
        Random rand = new Random();
        String[] option = { "AGAIN" };
        boolean is_winner = rand.nextInt(2) == 1 ? true : false;
        panel.setBackground(is_winner ? Color.GREEN : Color.RED);

        ImageIcon icon = new ImageIcon(is_winner ? "../assets/gol.png" : "../assets/pooch.png");
        Image scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel messageLabel = new JLabel(is_winner ? "YOU WON!" : "YOU LOST!");

        JOptionPane.showOptionDialog(panel, messageLabel, "", JOptionPane.YES_OPTION,
                JOptionPane.INFORMATION_MESSAGE, new ImageIcon(scaledIcon), option, null);

        panel.setBackground(Color.BLACK);
    }

    private static JButton createButton(String text, String path, JPanel panel) {
        Icon icon = new ImageIcon(path);
        JButton btn = new JButton("", icon);
        btn.setBackground(Color.BLACK);
        panel.add(btn);
        return btn;
    }
}
