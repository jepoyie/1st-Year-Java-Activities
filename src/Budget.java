import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Budget {

    public static void main(String[] args) throws IOException {

        int income;
        int housing;
        int electricity;
        int water;
        int food;
        int miscellaneous;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("---------------------------------------------");
        System.out.println("-             BUDGETING SYSTEM              -");
        System.out.println("---------------------------------------------");
        try {
            System.out.print("Enter your monthly income: ");
            income = Integer.parseInt(reader.readLine());
            BigDecimal incomes = new BigDecimal(income);

            System.out.print("Enter your housing expenses: ");
            housing = Integer.parseInt(reader.readLine());
            BigDecimal housings = new BigDecimal(housing);

            System.out.print("Enter your electricity bill per month: ");
            electricity = Integer.parseInt(reader.readLine());
            BigDecimal electricities = new BigDecimal(electricity);

            System.out.print("Enter your water bill per month: ");
            water = Integer.parseInt(reader.readLine());
            BigDecimal waters = new BigDecimal(water);

            System.out.print("Enter your food expenses per month: ");
            food = Integer.parseInt(reader.readLine());
            BigDecimal foods = new BigDecimal(food);

            System.out.print("Enter your miscellaneous expenses: ");
            miscellaneous = Integer.parseInt(reader.readLine());
            BigDecimal others = new BigDecimal(miscellaneous);

            BigDecimal total = electricities.add (waters)
                                            .add (housings)
                                            .add (foods)
                                            .add (others);

            BigDecimal remaining = incomes.subtract(total);

            System.out.println("");
            System.out.println("Your monthly income is: " + income);
            System.out.println("Your total expense is: " + total);
            System.out.println("Your remaining income is: " + remaining);

        }catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please input a number!");
        }
    }
}
