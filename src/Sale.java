import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Sale {
    public static void main(String[] args) throws  IOException{

        double price1 = 0;
        double discount1 = 0;
        double price2 = 0;
        double discount2 = 0;
        int quantity1 = 0;
        int quantity2 = 0;
        int cash = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Welcome to Hidalgo's Sales System");
        System.out.println("\n");

        System.out.print("Enter the name of the first item: ");
        String firstItem = reader.readLine();

        try {
            System.out.print("Enter the price of " + firstItem + ": ");
            price1 = Double.parseDouble(reader.readLine());

            System.out.print("Enter the quantity of " + firstItem + ": ");
            quantity1 = Integer.parseInt(reader.readLine());

            System.out.print("Enter the discount of " + firstItem + ": ");
            discount1 = Double.parseDouble(reader.readLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid price entered for " + firstItem + ". Please enter a valid number.");
            System.exit(0);
        }

        System.out.println("");

        System.out.print("Enter the name of the second item: ");
        String secondItem = reader.readLine();

        try {
            System.out.print("Enter the price of " + secondItem + ": ");
            price2 = Double.parseDouble(reader.readLine());

            System.out.print("Enter the quantity of " + secondItem + ": ");
            quantity2 = Integer.parseInt(reader.readLine());

            System.out.print("Enter the discount of " + secondItem + ": ");
            discount2 = Double.parseDouble(reader.readLine());

            System.out.print("Enter your cash: ");
            cash = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid price entered for " + secondItem + ". Please enter a valid number.");
            System.exit(0);
        }

        System.out.println("");

        int sum = quantity1 + quantity2;
        double totalPrice1 = (price1 * quantity1) - (discount1/100 * price1 * quantity1);
        double totalPrice2 = (price2 * quantity2) - (discount2/100 * price2 * quantity2);
        double total = totalPrice1 + totalPrice2;

        double change = cash - total;

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("The items are " + firstItem + " and " + secondItem + ".");
        System.out.println("The total quantity of items in the inventory is: " + sum);
        System.out.println("The total price of " + firstItem + " is Php " + df.format(totalPrice1));
        System.out.println("The total price of " + secondItem + " is Php " + df.format(totalPrice2));
        System.out.println("Your change is Php " + df.format(cash - total));
    }

}