import javax.swing.JOptionPane;

public class LoginSignupSystem {
    public static void main(String[] args) {

        int option = JOptionPane.showOptionDialog(null, "Please choose an option:", "Login or Signup", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] { "Login", "Sign up" }, "Login");
        if (option == 0) {
            String username = JOptionPane.showInputDialog(null, "Enter your username:");
            String password = JOptionPane.showInputDialog(null, "Enter your password:");

            String user = "user";
            String pass = "pass";

           if (username.equals("user") && password.equals("pass")) {
               JOptionPane.showMessageDialog(null, "You are logging in as " + username + ".");
           } else{
               JOptionPane.showMessageDialog(null, "Incorrect username or password. Please try again");
           }
        } else if (option == 1) {
            String firstName = JOptionPane.showInputDialog(null, "Enter your first name:");
            String lastName = JOptionPane.showInputDialog(null, "Enter your last name:");
            String username = JOptionPane.showInputDialog(null, "Enter a username:");
            String password = JOptionPane.showInputDialog(null, "Enter a password:");
            String email = JOptionPane.showInputDialog(null, "Enter your email address:");
            JOptionPane.showMessageDialog(null, "You are signing up with the following details:\nName: " + firstName + " " + lastName + "\nUsername: " + username + "\nEmail: " + email);
        }
    }
}