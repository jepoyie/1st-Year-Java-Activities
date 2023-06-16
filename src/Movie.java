import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Movie {
    public static void main (String[] args) throws IOException {

        String movie;
        double percent;
        double ticket;
        double tickets;
        double adult;
        double child;
        double sold;
        double gross;
        double amount;
        double net;
        double percentage;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("---------------------------------------------");
        System.out.println("-           MOVIE TICKETING SYSTEM          -");
        System.out.println("---------------------------------------------");

        System.out.print("Enter Movie Name: ");
         movie = reader.readLine();
        try {
            System.out.print("Enter Child Price: ");
            child = Double.parseDouble(reader.readLine());
            System.out.print("Enter Adult Price: ");
            adult = Double.parseDouble(reader.readLine());
            System.out.print("Enter the number of child tickets sold: ");
            ticket = Double.parseDouble(reader.readLine());
            System.out.print("Enter the number of adult tickets sold: ");
            tickets = Double.parseDouble(reader.readLine());


            sold = ticket + tickets;
            System.out.println("");
            System.out.print("Number of tickets sold: " + sold);

            gross = (tickets * adult) + (ticket * child);
            System.out.println("");
            System.out.print("Gross Amount is: " + gross);
            System.out.println("");
            System.out.print("Enter the percentage of amount donated: "); //input a decimal number
            percent = Double.parseDouble(reader.readLine());

            percentage = percent / gross;
            System.out.println("Percentage of the gross amount is: " + percentage);

            amount = gross * (percentage / 100);
            net = gross - amount;

            System.out.println("Amount Donated: " + amount);
            System.out.println("Net Sale: " + net);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please input a number!");
            System.exit(0);
        }
    }
}