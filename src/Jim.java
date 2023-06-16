import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Jim {

    public static void main(String[] args) throws IOException {

        boolean continueLoop;
        String name;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print("Enter your name: ");
            name = reader.readLine();

            for (int i = 0; i < 100; i++) {
                System.out.print(" " + name);
            }
            System.out.println("\n");
            System.out.print("Do you want to continue? ");
            String input = reader.readLine();
            continueLoop = input.equalsIgnoreCase("y");
        }while (continueLoop);

    }
}