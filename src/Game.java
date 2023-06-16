import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) throws IOException {

        int number = 17;
        int guess = 0;
        int tries = 1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Guess a number between 1 and 50: ");
            guess = Integer.parseInt(reader.readLine());

            while (guess != number && tries < 3) {
                if (guess > number) {
                    System.out.println("Too high, please try again!");
                } else {
                    System.out.println("Too low, please try again!");
                }
                tries++;
                System.out.print("Guess a number between 1 and 50: ");
                guess = Integer.parseInt(reader.readLine());
            }

            if (guess == number) {
                System.out.println("Congratulations!");
            } else {
                System.out.println("");
                System.out.println("Sorry, you have used up all of your tries. The number was " + number + ".");
            }
        } catch (IOException e) {
            System.out.println("Invalid Input. Please input a number!");
        }
    }
}