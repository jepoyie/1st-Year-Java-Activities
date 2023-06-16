import javax.swing.JOptionPane;

public class Guess {

    public static void main(String[] args) {

        int number = 17;
        int guess = 0;
        int tries = 1;

        try {
            guess = Integer.parseInt(JOptionPane.showInputDialog("Guess a number between 1 and 50:"));

            while (guess != number && tries < 3) {
                if (guess > number) {
                    JOptionPane.showMessageDialog(null, "Too high, please try again!");
                } else {
                    JOptionPane.showMessageDialog(null, "Too low, please try again!");
                }
                tries++;
                guess = Integer.parseInt(JOptionPane.showInputDialog("Guess a number between 1 and 50:"));
            }

            if (guess == number) {
                JOptionPane.showMessageDialog(null, "Congratulations!");
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, you have used up all of your tries. The number was " + number + ".");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input, please enter a number between 1 and 50.");
        }
    }
}