import javax.swing.JOptionPane;

public class Menu {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to Hidalgo's Karenderya");

        double total = 0.0;

        while (true) {
            String menu = "A. Food\nB. Drinks\nC. Exit\n\nPlease choose: ";
            char input = JOptionPane.showInputDialog(menu).charAt(0);

            if (input == 'A' || input == 'a') {
                String foods = "1. Adobo w/ rice - Php 75\n2. Siomai w/ rice - Php 65\n3. Sinigang w/ rice - Php 70\n\nPlease choose: ";
                char choice = JOptionPane.showInputDialog(foods).charAt(0);

                if (choice == '1') {
                    JOptionPane.showMessageDialog(null, "You choose Adobo w/ rice which cost Php 75");
                    total += 75;
                } else if (choice == '2') {
                    JOptionPane.showMessageDialog(null, "You choose Siomai w/ rice which cost Php 65");
                    total += 65;
                } else if (choice == '3') {
                    JOptionPane.showMessageDialog(null, "You choose Sinigang w/ rice which cost Php 70");
                    total += 70;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Please input a number!");
                }

                int select = JOptionPane.showConfirmDialog(null, "Do you want to purchase another order?", "Choose Again", JOptionPane.YES_NO_OPTION);
                if (select == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "The total amount of your order is Php " + total + ".");

                    double cash = Double.parseDouble(JOptionPane.showInputDialog("Please input the amount of your cash: "));

                    while (cash < total) {
                        JOptionPane.showMessageDialog(null, "Insufficient cash!\n\nThe total amount of your order is Php " + total + ".");
                        cash = Double.parseDouble(JOptionPane.showInputDialog("Please input the amount of your cash: "));
                    }

                    double change = cash - total;
                    JOptionPane.showMessageDialog(null, "Thank you for your payment!\n\nYour change is Php " + change + ".");
                    System.exit(0);
                }
                } else if (input == 'B' || input == 'b') {
                    String drinks = "1. Coffee - Php 25\n2. Mountain Dew - Php 25\n3. Bottled Water - Php 20\n\nPlease choose: ";
                    char choice = JOptionPane.showInputDialog(drinks).charAt(0);

                    if (choice == '1') {
                        JOptionPane.showMessageDialog(null, "You choose Coffee which cost Php 25");
                        total += 25;
                    } else if (choice == '2') {
                        JOptionPane.showMessageDialog(null, "You choose Mountain Dew which cost Php 25");
                        total += 25;
                    } else if (choice == '3') {
                        JOptionPane.showMessageDialog(null, "You choose Bottled Water which cost Php 20");
                        total += 20;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Input. Please input a number!");
                    }

                int select = JOptionPane.showConfirmDialog(null, "Do you want to purchase another order?", "Choose Again", JOptionPane.YES_NO_OPTION);
                if (select == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "The total amount of your order is Php " + total + ".");

                    double cash = Double.parseDouble(JOptionPane.showInputDialog("Please input the amount of your cash: "));

                    while (cash < total) {
                        JOptionPane.showMessageDialog(null, "Insufficient cash!\n\nThe total amount of your order is Php " + total + ".");
                        cash = Double.parseDouble(JOptionPane.showInputDialog("Please input the amount of your cash: "));
                    }

                    double change = cash - total;
                    JOptionPane.showMessageDialog(null, "Thank you for your payment!\n\nYour change is Php " + change + ".");
                    System.exit(0);
                }

            } else if (input == 'C' || input == 'c') {
                JOptionPane.showMessageDialog(null, "Thank you, come again next time!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Input. Please input a correct letter!");
            }
        }
    }
}