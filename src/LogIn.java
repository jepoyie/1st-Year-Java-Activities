import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LogIn {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to Hidalgo's Login System");

        String username = "user";
        String password = "pass";
        int attempt = 0;

        do {
            String user = JOptionPane.showInputDialog("Enter username: ");

            JPasswordField passField = new JPasswordField();
            passField.setEchoChar('*');
            Object[] passwordFields = {"Enter password: ", passField};
            JOptionPane.showConfirmDialog(null, passwordFields, "Password", JOptionPane.OK_CANCEL_OPTION);

            String pass = new String(passField.getPassword());

            if (user.equals(username) && pass.equals(password)){
                JOptionPane.showMessageDialog(null, "ACCESS GRANTED");
                break;
            }else {
                JOptionPane.showMessageDialog(null, "ACCESS DENIED");
                attempt++;

                if (attempt >= 3) {
                    JOptionPane.showMessageDialog(null, "You've used up all of your attempts. Please try again later.");
                    System.exit(0);
                }
            }

            String ans;

            do {
                ans = JOptionPane.showInputDialog("Do you want to continue (Y/N)? ");
                ans = ans.toUpperCase();
                if (!ans.equals("Y") && !ans.equals("N")) {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Please enter Y or N.");
                }
            } while (!ans.equals("Y") && !ans.equals("N"));

            if (ans.equals("N")) {
                break;
            }
        } while (true);
    }
}