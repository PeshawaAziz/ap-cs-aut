import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {

    static String[] foodItems = { "ساندویچ", "برگر" };
    static double[] foodCosts = { 190.0, 167.0 }; // Prices now end with 7
    static int[] foodCounts = { 0, 0, 0 };

    static String[] drinkItems = { "لیموناد", "فانتا", "آب" };
    static double[] drinkCosts = { 24.0, 38.0, 19.0 }; // Prices now end with 4
    static int[] drinkCounts = { 0, 0, 0 };

    static String[] dessertItems = { "کیک" };
    static double[] dessertCosts = { 33.0, 46.0 }; // Prices now end with 6
    static int[] dessertCounts = { 0, 0 };

    private static void launchUI() {
        JFrame mainFrame = new JFrame("Cafe Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(420, 420);
        mainFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(4, 1, 0, 25));
        JButton btnFoods = new JButton("غذاها");
        JButton btnDrinks = new JButton("نوشیدنی‌ها");
        JButton btnDesserts = new JButton("دسرها");

        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.add(btnFoods);
        mainPanel.add(btnDrinks);
        mainPanel.add(btnDesserts);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

        btnFoods.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCategory(0);
            }
        });
        btnDrinks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCategory(1);
            }
        });
        btnDesserts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCategory(2);
            }
        });
    }

    private static void displayCategory(int catIdx) {
        String frameLabel = "";
        String[] names = {};
        double[] costs = {};
        int[] counts = {};
        switch (catIdx) {
            case 0:
                frameLabel = "غذاها";
                names = foodItems;
                costs = foodCosts;
                counts = foodCounts;
                break;
            case 1:
                frameLabel = "نوشیدنی‌ها";
                names = drinkItems;
                costs = drinkCosts;
                counts = drinkCounts;
                break;
            case 2:
                frameLabel = "دسرها";
                names = dessertItems;
                costs = dessertCosts;
                counts = dessertCounts;
                break;
            default:
                return;
        }
        final int[] finalCounts = counts;
        JFrame catFrame = new JFrame(frameLabel);
        JPanel catPanel = new JPanel();
        catPanel.setLayout(new BoxLayout(catPanel, BoxLayout.Y_AXIS));
        catPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < names.length; i++) {
            JPanel itemRow = new JPanel(new GridLayout(1, 4, 20, 0));
            JLabel lblName = new JLabel(names[i]);
            JLabel lblPrice = new JLabel(costs[i] + " $");
            ImageIcon itmIcon = new ImageIcon("../assets/" + names[i].toLowerCase() + ".jpg");
            Image scImg = itmIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel lblImg = new JLabel(new ImageIcon(scImg));
            JLabel lblCount = new JLabel("تعداد: " + finalCounts[i]);
            JPanel ctrlPanel = new JPanel(new GridLayout(1, 2, 10, 0));
            ctrlPanel.add(lblCount);
            JButton btnInc = new JButton("+");
            ctrlPanel.add(btnInc);
            itemRow.add(lblName);
            itemRow.add(lblPrice);
            itemRow.add(lblImg);
            itemRow.add(ctrlPanel);
            catPanel.add(itemRow);
            catPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            final int idx = i;
            btnInc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    finalCounts[idx]++;
                    lblCount.setText("تعداد: " + finalCounts[idx]);
                }
            });
        }
        JScrollPane scrollCat = new JScrollPane(catPanel);
        catFrame.add(scrollCat, BorderLayout.CENTER);
        catFrame.setSize(520, 650);
        catFrame.setLocationRelativeTo(null);
        catFrame.setVisible(true);
    }

    private static void displayCart() {
        JFrame cartWin = new JFrame("سبد خرید");
        JPanel cartDiv = new JPanel();
        cartDiv.setLayout(new BoxLayout(cartDiv, BoxLayout.Y_AXIS));
        cartDiv.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel headerRow = new JPanel(new GridLayout(1, 4, 20, 0));
        headerRow.add(new JLabel("نام"));
        headerRow.add(new JLabel("قیمت"));
        headerRow.add(new JLabel("تعداد"));
        headerRow.add(new JLabel("مجموع"));
        cartDiv.add(headerRow);

        boolean cartEmpty = true;
        double totalSum = 0;

        for (int j = 0; j < foodItems.length; j++) {
            if (foodCounts[j] > 0) {
                cartEmpty = false;
                JPanel row = new JPanel(new GridLayout(1, 4, 20, 0));
                row.setBorder(new EmptyBorder(20, 20, 20, 20));
                row.add(new JLabel(foodItems[j]));
                row.add(new JLabel(foodCosts[j] + " $"));
                row.add(new JLabel(String.valueOf(foodCounts[j])));
                double sub = foodCosts[j] * foodCounts[j];
                row.add(new JLabel(sub + " $"));
                cartDiv.add(row);
                cartDiv.add(Box.createRigidArea(new Dimension(0, 5)));
                totalSum += sub;
            }
        }

        for (int j = 0; j < drinkItems.length; j++) {
            if (drinkCounts[j] > 0) {
                cartEmpty = false;
                JPanel row = new JPanel(new GridLayout(1, 4, 20, 0));
                row.setBorder(new EmptyBorder(20, 20, 20, 20));
                row.add(new JLabel(drinkItems[j]));
                row.add(new JLabel(drinkCosts[j] + " $"));
                row.add(new JLabel(String.valueOf(drinkCounts[j])));
                double sub = drinkCosts[j] * drinkCounts[j];
                row.add(new JLabel(sub + " $"));
                cartDiv.add(row);
                cartDiv.add(Box.createRigidArea(new Dimension(0, 5)));
                totalSum += sub;
            }
        }

        for (int j = 0; j < dessertItems.length; j++) {
            if (dessertCounts[j] > 0) {
                cartEmpty = false;
                JPanel row = new JPanel(new GridLayout(1, 4, 20, 0));
                row.setBorder(new EmptyBorder(20, 20, 20, 20));
                row.add(new JLabel(dessertItems[j]));
                row.add(new JLabel(dessertCosts[j] + " $"));
                row.add(new JLabel(String.valueOf(dessertCounts[j])));
                double sub = dessertCosts[j] * dessertCounts[j];
                row.add(new JLabel(sub + " $"));
                cartDiv.add(row);
                cartDiv.add(Box.createRigidArea(new Dimension(0, 5)));
                totalSum += sub;
            }
        }

        JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        JLabel sumLabel = new JLabel("مجموع کل: " + totalSum + " $");
        JButton btnPay = new JButton("پرداخت");

        if (cartEmpty) {
            JPanel emptyMsg = new JPanel(new FlowLayout(FlowLayout.CENTER));
            emptyMsg.add(
                    new JLabel("سبد خرید خالی است"));
            cartDiv.add(emptyMsg);
        } else {
            btnPay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < foodCounts.length; i++)
                        foodCounts[i] = 0;
                    for (int i = 0; i < drinkCounts.length; i++)
                        drinkCounts[i] = 0;
                    for (int i = 0; i < dessertCounts.length; i++)
                        dessertCounts[i] = 0;
                    cartDiv.removeAll();
                    cartDiv.add(headerRow);
                    JPanel emptyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    emptyPanel.add(new JLabel(
                            "سبد خرید خالی است"));
                    cartDiv.add(emptyPanel);
                    cartDiv.revalidate();
                    cartDiv.repaint();
                }
            });
            summaryPanel.add(sumLabel);
            summaryPanel.add(btnPay);
            cartDiv.add(summaryPanel);
        }

        JScrollPane scrollCart = new JScrollPane(cartDiv);
        cartWin.add(scrollCart, BorderLayout.CENTER);
        cartWin.setSize(520, 650);
        cartWin.setLocationRelativeTo(null);
        cartWin.setVisible(true);
    }

    public static void main(String[] args) {
        launchUI();
    }
}