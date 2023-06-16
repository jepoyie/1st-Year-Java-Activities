import java.util.Scanner;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = new String[3];
        String lastRemovedName = null;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            if (Arrays.asList(names).contains(name)) {
                System.out.println("Name already exists. Please enter a different name.");
                i--;
            } else {
                names[i] = name;
            }
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
            System.out.println("G. Restore name");

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
                    if (Arrays.asList(names).contains(newName)) { //Check if the name already exists
                        System.out.println("Name already exists. Please enter a different name.");
                    } else {
                        newNames = new String[names.length + 1];
                        System.arraycopy(names, 0, newNames, 0, names.length);
                        newNames[names.length] = newName;
                        names = newNames;
                        System.out.println("New name has been added. Names: " + Arrays.toString(names));
                    }
                    break;
                case "D":
                    Arrays.sort(names);
                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();
                    int index = Arrays.binarySearch(names, searchName);
                    if (index >= 0) {
                        System.out.println(searchName + " found at index " + index);
                    } else {
                        System.out.println(searchName + " has been not found.");
                    }
                    break;
                case "E":
                    exit = true;
                    break;
                case "F":
                    System.out.print("Enter the name to remove: ");
                    String removeName = scanner.nextLine();
                    int removeIndex = -1;

                    for (int i = 0; i < names.length; i++) {
                        if (names[i].equals(removeName)) {
                            removeIndex = i;
                            break;
                        }
                    }

                    if (removeIndex >= 0) {
                        lastRemovedName = names[removeIndex];
                        newNames = new String[names.length - 1];
                        System.arraycopy(names, 0, newNames, 0, removeIndex);
                        System.arraycopy(names, removeIndex + 1, newNames, removeIndex, names.length - removeIndex - 1);
                        names = newNames;
                        System.out.println(removeName + " has been removed. Names: " + Arrays.toString(names));
                    } else {
                        System.out.println(removeName + " has been not found.");
                    }
                    break;
                case "G":
                    if (lastRemovedName == null) {
                        System.out.println("No names to restore.");
                    } else {
                        System.out.println("Last removed name: " + lastRemovedName);
                        System.out.print("Do you want to restore this name? (Y/N): ");
                        String restoreChoice = scanner.nextLine();
                        if (restoreChoice.toUpperCase().equals("Y")) {
                            if (Arrays.asList(names).contains(lastRemovedName)) {
                                System.out.println("Name already exists. Please enter a different name.");
                            } else {
                                newNames = new String[names.length + 1];
                                System.arraycopy(names, 0, newNames, 0, names.length);
                                newNames[names.length] = lastRemovedName;
                                names = newNames;
                                lastRemovedName = null;
                                System.out.println("Name restored. Names: " + Arrays.toString(names));
                            }
                        }
                    }
                    break;
                    default:
                    System.out.println("Invalid Input");
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