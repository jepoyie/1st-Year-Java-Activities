import java.util.Scanner;
import java.util.Arrays;

public class Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter name " + (i+1) + ": ");
            names[i] = scanner.nextLine();
        }

        boolean exit = false;
        String[] newNames;

        while (!exit) {

            System.out.println("\nChoose an option:");
            System.out.println("A. Descending order");
            System.out.println("B. Ascending order");
            System.out.println("C. Insert name");
            System.out.println("D. Search name");
            System.out.println("E. Exit");
            System.out.println("F. Remove name");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            System.out.println("");

            switch (choice.toUpperCase()) {
                case "A":
                    Arrays.sort(names, (a, b) -> b.compareTo(a));
                    System.out.println("Names in descending order: " + Arrays.toString(names));
                    break;
                case "B":
                    Arrays.sort(names);
                    System.out.println("Names in ascending order: " + Arrays.toString(names));
                    break;
                case "C":
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    newNames = new String[names.length+1];
                    System.arraycopy(names, 0, newNames, 0, names.length);
                    newNames[names.length] = newName;
                    names = newNames;
                    System.out.println("New name added. Names: " + Arrays.toString(names));
                    break;
                case "D":
                    Arrays.sort(names);
                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();
                    int index = Arrays.binarySearch(names, searchName);
                    if (index >= 0) {
                        System.out.println(searchName + " found at index " + index);
                    } else {
                        System.out.println(searchName + " not found.");
                    }
                    break;
                case "E":
                    exit = true;
                    break;
                case "F": //Ask the user to enter the name to be removed
                    System.out.print("Enter the name to remove: ");
                    String removeName = scanner.nextLine();
                    int removeIndex = -1; //Initialize a variable to store the index of the name to be removed as -1 (not found)

                    for (int i = 0; i < names.length; i++) {
                        if (names[i].equals(removeName)) {
                            removeIndex = i;
                            break;
                        }
                    }

                    if (removeIndex >= 0) {
                        newNames = new String[names.length - 1];
                        System.arraycopy(names, 0, newNames, 0, removeIndex);
                        System.arraycopy(names, removeIndex+1, newNames, removeIndex, names.length-removeIndex-1);
                        names = newNames;
                        System.out.println(removeName + " removed. Names: " + Arrays.toString(names));
                    } else {
                        System.out.println(removeName + " not found.");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            if (!exit) {
                System.out.print("Do you want to continue? (Y/N) ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("N")) {
                    exit = true;
                }
            }
        }
    }
}