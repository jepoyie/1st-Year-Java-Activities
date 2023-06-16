import java.util.Arrays;
import java.util.Scanner;

public class LinearBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentID = {2200455, 2200320, 2010011, 2015927, 2010428};
        String[] names = {"Janpol", "Ashley", "John Leonard", "Franz", "Owen"};
        String[] personality = {"mysterious", "lovable", "wise", "caring", "honest"};

        boolean continueSearching = true;

        while (continueSearching) {
            System.out.print("Enter a student ID: ");
            int id = 0;
            try {
                id = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
                return;
            }

            System.out.print("Enter search method (L for Linear, B for Binary): ");
            char method = ' ';
            try {
                method = scanner.next().charAt(0);
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
                return;
            }

            switch (method) {
                case 'L':
                case 'l':
                    boolean found = false;
                    for (int i = 0; i < studentID.length; i++) {
                        if (studentID[i] == id) {
                            System.out.println("Linear search: Found student " + names[i] + ", who is " + personality[i] + ".");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Linear search: Student with ID " + id + " not found.");
                    }
                    break;

                case 'B':
                case 'b':
                    int[] sortedIDs = Arrays.copyOf(studentID, studentID.length);
                    Arrays.sort(sortedIDs);
                    int low = 0;
                    int high = sortedIDs.length - 1;
                    found = false;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (sortedIDs[mid] == id) {
                            int index = -1;
                            for (int i = 0; i < studentID.length; i++) {
                                if (studentID[i] == sortedIDs[mid]) {
                                    index = i;
                                    break;
                                }
                            }
                            System.out.println("Binary search: Found student " + names[index] + ", who is " + personality[index] + ".");
                            found = true;
                            break;
                        } else if (id < sortedIDs[mid]) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    if (!found) {
                        System.out.println("Binary search: Student with ID " + id + " not found.");
                    }
                    break;
            }

            System.out.print("Do you want to continue? (Y/N): ");
            char choice = scanner.next().charAt(0);
            if (choice == 'N' || choice == 'n') {
                continueSearching = false;
            }
        }
    }
}
