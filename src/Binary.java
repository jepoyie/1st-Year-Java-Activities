import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentID = {2010011, 2200455, 2015927, 2010428, 2200320};
        String[] studentNames = { "Janpol", "Ashley", "Owen", "Franz", "John Leonard"};
        String[] location = {"Sagay City", "Bago City", "Municipality of Hinigaran", "Bacolod City",  "Cadiz City"};

        System.out.print("Enter a student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter search method (L or B):  ");
        char method = scanner.next().charAt(0);

        switch (method) {
            case 'L':
            case 'l':
                boolean found = false;
                for (int i = 0; i < studentID.length; i++) {
                    if (studentID[i] == id) {
                        System.out.println("Linear search: " + studentNames[i] + location[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Linear search: Student not found.");
                }
                break;

            case 'B':
            case 'b':
                int low = 0;
                int high = studentID.length - 1;
                found = false;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (studentID[mid] == id) {
                        System.out.println("Binary search: " + studentNames[mid] + " " + location[mid]);
                        found = true;
                        break;
                    } else if (id < studentID[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                if (!found) {
                    System.out.println("Binary search: Student not found.");
                }
                break;

            default:
                System.out.println("Invalid search method.");
                break;
        }
    }
}