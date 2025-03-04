import java.util.HashMap;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
    private static final Color FG_COLOR = new Color(220, 220, 220);
    private static final Color DARK_BG_COLOR = new Color(10, 10, 10);
    private static final Color NORMAL_BG_COLOR = new Color(20, 20, 20);
    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 20);
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 20);
    private static final DecimalFormat df = new DecimalFormat("#.##");

    enum Category {
        FOOD, DRINK, DESSERT
    }

    private static class MenuItem {
        public String name;
        public double price;
        public int inCart;

        public MenuItem(String name, double price) {
            this.inCart = 0;
            this.name = name;
            this.price = price;
        }
    }

    private static MenuItem[][] menuItems = {
            {
                    new MenuItem("Pizza", 199.9),
                    new MenuItem("Pasta", 189.9),
                    new MenuItem("Kabab", 219.9),
                    new MenuItem("Burger", 99.9)
            },
            {
                    new MenuItem("Coca-Cola", 29.9),
                    new MenuItem("Fanta", 29.9),
                    new MenuItem("Tea", 5.9),
                    new MenuItem("Milk", 9.9),
                    new MenuItem("Water", 1.99)
            },
            {
                    new MenuItem("Chocolate Cake", 39.9),
                    new MenuItem("Apple Pie", 49.9),
            }
    };

    private static HashMap<String, Integer> cart = new HashMap<>();;

    public static void main(String[] args) {
        UIManager.put("Label.font", LABEL_FONT);
        UIManager.put("Button.font", BUTTON_FONT);

        initialize();
    }

    private static ImageIcon scaleIcon(String path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);

        return imageIcon;
    }

    private static void initialize() {
        JFrame frame = new JFrame("Cafe Menu");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 0, 30));
        ImageIcon foodIcon = scaleIcon("../assets/icons/food.png", 30, 30);
        JButton foodsBtn = new JButton("FOODS", foodIcon);
        ImageIcon drinkIcon = scaleIcon("../assets/icons/drink.png", 30, 30);
        JButton drinksBtn = new JButton("DRINKS", drinkIcon);
        ImageIcon dessertIcon = scaleIcon("../assets/icons/dessert.png", 30, 30);
        JButton dessertsBtn = new JButton("DESSERTS", dessertIcon);
        ImageIcon cartIcon = scaleIcon("../assets/icons/cart.png", 30, 30);
        JButton shoppingCartBtn = new JButton("SHOPPING CART", cartIcon);

        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        panel.add(foodsBtn);
        panel.add(drinksBtn);
        panel.add(dessertsBtn);
        panel.add(shoppingCartBtn);
        frame.add(panel);
        frame.setVisible(true);

        foodsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openItemsMenu(Category.FOOD);
            }
        });

        drinksBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openItemsMenu(Category.DRINK);
            }
        });

        dessertsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openItemsMenu(Category.DESSERT);
            }
        });

        shoppingCartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openShoppingCart();
            }
        });
    }

    private static void openItemsMenu(Category category) {
        JFrame itemsFrame = new JFrame();
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        String frameTitle = "";

        switch (category) {
            case FOOD:
                frameTitle = "FOODS";
                break;
            case DRINK:
                frameTitle = "DRINKS";
                break;
            case DESSERT:
                frameTitle = "DESSERTS";
                break;

            default:
                break;
        }

        JPanel header = new JPanel(new GridLayout(1, 4, 20, 0));
        JLabel nameHeader = new JLabel("Name");
        JLabel priceHeader = new JLabel("Price");
        JLabel imageHeader = new JLabel("Image");
        JLabel cartHeader = new JLabel("Cart");
        JSeparator separator = new JSeparator();

        header.add(nameHeader);
        header.add(priceHeader);
        header.add(imageHeader);
        header.add(cartHeader);

        nameHeader.setForeground(FG_COLOR);
        priceHeader.setForeground(FG_COLOR);
        imageHeader.setForeground(FG_COLOR);
        cartHeader.setForeground(FG_COLOR);
        itemsPanel.setBackground(DARK_BG_COLOR);
        header.setBackground(new Color(40, 40, 40));
        header.setBorder(new EmptyBorder(50, 50, 50, 50));
        header.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        itemsPanel.add(separator);
        itemsPanel.add(header);

        for (int i = 0; i < menuItems[category.ordinal()].length; i++) {
            MenuItem item = menuItems[category.ordinal()][i];

            JPanel itemBox = new JPanel(new GridLayout(1, 4, 20, 0));
            JLabel itemName = new JLabel(item.name);
            JLabel itemPrice = new JLabel(df.format(item.price) + " $");
            ImageIcon imageIcon = new ImageIcon("../assets/" + item.name.toLowerCase() + ".jpg");
            Image scaledImage = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            JLabel cartCount = new JLabel("In Cart: " + item.inCart);
            JPanel cartManagementPanel = new JPanel(new GridLayout(2, 1, 10, 0));
            JPanel cartCountPanel = new JPanel();
            JPanel cartBtnPanel = new JPanel();
            JButton addBtn = new JButton("+");
            JButton removeBtn = new JButton("-");

            itemName.setForeground(FG_COLOR);
            itemPrice.setForeground(FG_COLOR);

            addBtn.setBackground(Color.YELLOW);
            addBtn.setForeground(Color.BLACK);

            if (item.inCart > 0) {
                removeBtn.setEnabled(true);
            } else {
                removeBtn.setEnabled(false);
            }

            addBtn.setFont(new Font("Arial", Font.BOLD, 40));
            removeBtn.setFont(new Font("Arial", Font.BOLD, 40));
            cartCount.setForeground(FG_COLOR);
            cartManagementPanel.setBackground(NORMAL_BG_COLOR);
            cartCountPanel.setBackground(NORMAL_BG_COLOR);
            cartBtnPanel.setBackground(NORMAL_BG_COLOR);

            itemBox.setBackground(NORMAL_BG_COLOR);
            itemBox.setBorder(new EmptyBorder(0, 50, 0, 50));
            itemBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

            itemBox.add(itemName);
            itemBox.add(itemPrice);
            itemBox.add(imageLabel);
            cartCountPanel.add(cartCount);
            cartBtnPanel.add(addBtn);
            cartBtnPanel.add(removeBtn);
            cartManagementPanel.add(cartCountPanel);
            cartManagementPanel.add(cartBtnPanel);
            itemBox.add(cartManagementPanel);
            itemsPanel.add(itemBox);
            itemsPanel.add(Box.createRigidArea(new Dimension(0, 5)));

            addBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    item.inCart++;
                    cartCount.setText("In Cart: " + item.inCart);
                    if (item.inCart > 0) {
                        removeBtn.setEnabled(true);
                    } else {
                        removeBtn.setEnabled(false);
                    }
                }
            });

            removeBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (item.inCart > 0) {
                        item.inCart--;
                        cartCount.setText("In Cart: " + item.inCart);
                    }

                    if (item.inCart > 0) {
                        removeBtn.setEnabled(true);
                    } else {
                        removeBtn.setEnabled(false);
                    }
                }
            });
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        itemsFrame.add(scrollPane, BorderLayout.CENTER);
        itemsFrame.setTitle(frameTitle);
        itemsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        itemsFrame.setSize(800, 1200);
        itemsFrame.setLocationRelativeTo(null);
        itemsFrame.setVisible(true);
    }

    private static void openShoppingCart() {
        JFrame cartFrame = new JFrame();
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
        JPanel header = new JPanel(new GridLayout(1, 4, 20, 0));
        JLabel nameHeader = new JLabel("Name");
        JLabel priceHeader = new JLabel("Price");
        JLabel countHeader = new JLabel("Count");
        JLabel totalPriceHeader = new JLabel("Total");
        JSeparator separator = new JSeparator();

        nameHeader.setForeground(FG_COLOR);
        priceHeader.setForeground(FG_COLOR);
        countHeader.setForeground(FG_COLOR);
        totalPriceHeader.setForeground(FG_COLOR);
        cartPanel.setBackground(DARK_BG_COLOR);
        header.setBackground(new Color(40, 40, 40));
        header.setBorder(new EmptyBorder(50, 50, 50, 50));
        header.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        header.add(nameHeader);
        header.add(priceHeader);
        header.add(countHeader);
        header.add(totalPriceHeader);
        cartPanel.add(separator);
        cartPanel.add(header);

        boolean isEmpty = true;
        double priceSum = 0;
        for (MenuItem[] row : menuItems) {
            for (MenuItem item : row) {
                if (item.inCart != 0) {
                    isEmpty = false;
                    JPanel itemBox = new JPanel(new GridLayout(1, 4, 20, 0));
                    JLabel itemName = new JLabel(item.name);
                    JLabel itemPrice = new JLabel(df.format(item.price) + " $");
                    JLabel itemCount = new JLabel(item.inCart + "");
                    JLabel itemTotalPrice = new JLabel(df.format(item.price * item.inCart) + " $");

                    itemName.setForeground(FG_COLOR);
                    itemPrice.setForeground(FG_COLOR);
                    itemCount.setForeground(FG_COLOR);
                    itemTotalPrice.setForeground(FG_COLOR);
                    itemBox.setBackground(NORMAL_BG_COLOR);
                    itemBox.setBorder(new EmptyBorder(50, 50, 50, 50));
                    itemBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

                    itemBox.add(itemName);
                    itemBox.add(itemPrice);
                    itemBox.add(itemCount);
                    itemBox.add(itemTotalPrice);
                    cartPanel.add(itemBox);
                    cartPanel.add(Box.createRigidArea(new Dimension(0, 5)));

                    priceSum += item.price * item.inCart;
                }
            }
        }

        JPanel emptyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel emptyAlert = new JLabel("<html>The shopping cart is empty.<br /> Add items to view them here.</html>");

        emptyAlert.setForeground(Color.YELLOW);
        emptyAlert.setFont(new Font("Arial", Font.PLAIN, 30));
        emptyPanel.setBackground(DARK_BG_COLOR);
        emptyPanel.setBorder(new EmptyBorder(300, 0, 0, 0));

        JPanel payPanel = new JPanel(new FlowLayout(1, 50, 0));
        JLabel priceSumLabel = new JLabel();
        JButton payButton = new JButton("Pay");

        priceSumLabel.setText("Total Sum: " + df.format(priceSum) + "$");
        priceSumLabel.setForeground(Color.GREEN);
        priceSumLabel.setFont(new Font("Arial", Font.BOLD, 30));
        payButton.setBackground(Color.LIGHT_GRAY);
        payButton.setFont(new Font("Arial", Font.BOLD, 30));
        payPanel.setBackground(DARK_BG_COLOR);
        payPanel.setBorder(new EmptyBorder(30, 0, 30, 0));

        if (isEmpty) {
            emptyPanel.add(emptyAlert);
            cartPanel.add(emptyPanel);
        } else {

            payButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (MenuItem[] row : menuItems) {
                        for (MenuItem item : row) {
                            item.inCart = 0;
                        }
                    }

                    cartPanel.removeAll();
                    cartPanel.repaint();
                    cartPanel.revalidate();
                    cartPanel.add(header);
                    cartPanel.add(emptyPanel);
                }
            });

            payPanel.add(priceSumLabel);
            payPanel.add(payButton);
            cartPanel.add(payPanel);
        }

        JScrollPane scrollPane = new JScrollPane(cartPanel);
        cartFrame.add(scrollPane, BorderLayout.CENTER);
        cartFrame.setTitle("Shopping Cart");
        cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cartFrame.setSize(800, 1200);
        cartFrame.setLocationRelativeTo(null);
        cartFrame.setVisible(true);
    }
}