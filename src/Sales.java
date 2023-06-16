import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Sales {
    public static void main(String[] args) {

        double price1 = 0;
        double price2 = 0;
        double discount1 = 0;
        double discount2 = 0;
        int quantity1 = 0;
        int quantity2 = 0;
        int cash = 0;
        int sum = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Hidalgo's Sales System");

        String firstItem = JOptionPane.showInputDialog("Enter the name of the first item: ");
        try {
            price1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of " + firstItem + "."));
            quantity1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity of " + firstItem + "."));
            discount1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the discount of " + firstItem + "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price entered for " + firstItem + ". Please enter a valid number.");
            JOptionPane.showMessageDialog(null, "Invalid quantity entered for " + firstItem + ". Please enter a valid number.");
            JOptionPane.showMessageDialog(null, "Invalid discount entered for " + firstItem + ". Please enter a valid number.");
            System.exit(0);
        }

        String secondItem = JOptionPane.showInputDialog("Enter the name of the second item: ");
        try {
            price2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of " + secondItem + "."));
            quantity2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity of " + secondItem + "."));
            discount2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the discount of " + secondItem + "."));
            cash = Integer.parseInt(JOptionPane.showInputDialog("Enter your cash: "));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid price entered for " + secondItem + ". Please enter a valid number.");
            System.exit(0);
        }

        sum = quantity1 + quantity2;
        double totalPrice1 = (price1 * quantity1) - (discount1/100 * price1 * quantity1);
        double totalPrice2 = (price2 * quantity2) - (discount2/100 * price2 * quantity2);
        double total = totalPrice1 + totalPrice2;

        double change = cash - total;

        DecimalFormat df = new DecimalFormat("0.00");

        JOptionPane.showMessageDialog(null, "The items are " + firstItem+ " and "+ secondItem + ".");
        JOptionPane.showMessageDialog(null, "The total quantity of items in the inventory is: " + sum);
        JOptionPane.showMessageDialog(null, "The total price of " + firstItem + " is Php " + df.format(totalPrice1));
        JOptionPane.showMessageDialog(null, "The total price of " + secondItem + " is Php " + df.format(totalPrice2));
        JOptionPane.showMessageDialog(null, "The total price of all items is Php " + df.format(totalPrice1 + totalPrice2));
        JOptionPane.showMessageDialog(null, "Your cash is Php " + cash + ".");
        JOptionPane.showMessageDialog(null, "Your change is Php " + df.format(cash - total));
    }

}