import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Loan {
    public static void main(String[] args) throws  IOException{

        double loan;
        double interest;
        int months;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("---------------------------------------------");
        System.out.println("-           LOAN PAYMENT SYSTEM             -");
        System.out.println("---------------------------------------------");

        try {
            System.out.print("Enter loan amount: ");
            loan = Double.parseDouble(reader.readLine());

            System.out.print("Enter interest rate per month: ");
            interest = Double.parseDouble(reader.readLine());

            System.out.print("Enter loan period in months: ");
            months = Integer.parseInt(reader.readLine());
            System.out.println("");

            double monthlyInterest = interest / 100; //interest rate per month calculating by dividing interest rate by 12
            int payment = months; //no. of payment = sa number of months sa gienter ka user
            double monthlyPayment = loan * monthlyInterest / (1 - 1 / Math.pow(1 + monthlyInterest, payment)); //1 - 1 / Math.pow(1 + monthlyInterest, payment) gina calculate na di ang each payment nga makadto sa pagbayad ka interest, ga reciprocate sa each payment na makadto sa pagbayad ka utang

            System.out.println("Your monthly payment is Php " + monthlyPayment);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please input a number!");
            System.exit(0);
        }
    }
}