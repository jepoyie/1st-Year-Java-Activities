import javax.swing.JOptionPane;

public class Quiz {
    public static void main(String[] args) {
        int score = 0;

        String[] options1 = {"Blue", "Orange"};
        int answer1 = JOptionPane.showOptionDialog(null, "What is the color of the sky?", "Question 1",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
        if (answer1 == 0) {
            score++;
        }

        String[] options2 = {"White", "Orange"};
        int answer2 = JOptionPane.showOptionDialog(null, "What is the color of the sun?", "Question 2",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        if (answer2 == 1) {
            score++;
        }

        String[] options3 = {"Fruit", "Vegetable"};
        int answer3 = JOptionPane.showOptionDialog(null, "What is tomato?", "Question 3",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]);
        if (answer3 == 0) {
            score++;
        }

        String[] options4 = {"Color", "Fruit"};
        int answer4 = JOptionPane.showOptionDialog(null, " What is an orange?", "Question 4",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options4, options4[0]);
        if (answer4 == 1) {
            score++;
        }

        String[] options5 = {"Odd", "Even"};
        int answer5 = JOptionPane.showOptionDialog(null, "Is number 0 an even or odd?", "Question 5",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options5, options5[0]);
        if (answer5 == 1) {
            score++;
        }

        JOptionPane.showMessageDialog(null, "Congratulations! You scored " + score + "/5.", "Quiz Results", JOptionPane.INFORMATION_MESSAGE);
    }
}