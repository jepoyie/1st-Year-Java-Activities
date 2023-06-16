import java.util.Scanner;

public class Search {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"John", "Mary", "David", "Sarah", "Michael"};
        String[] descriptions = {"Wise", "Cute", "Honest", "Beautiful", "Faithful"};

        while (true) {
            System.out.print("Enter a name to search for, or type 'list' to display the list of names, or 'quit' to exit: ");
            String searchName = scanner.nextLine();

            if (searchName.equalsIgnoreCase("quit")) {
                break;
            } else if (searchName.equalsIgnoreCase("list")) {
                System.out.println("List of names:");
                for (int i = 0; i < names.length; i++) {
                    System.out.println(names[i] + " (" + descriptions[i] + ")");
                }
            } else {
                int index = -1;
                for (int i = 0; i < names.length; i++){
                    if (names[i].equalsIgnoreCase(searchName)){
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println(searchName + " is not found in the array!");
                    System.out.print("Do you want to add it to the array? (y/n): ");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        System.out.print("Enter a one-word description for " + searchName + ": ");
                        String description = scanner.nextLine();
                        String[] newNames = new String[names.length + 1];
                        String[] newDescriptions = new String[descriptions.length + 1];
                        for (int i = 0; i < names.length; i++) {
                            newNames[i] = names[i];
                            newDescriptions[i] = descriptions[i];
                        }
                        newNames[newNames.length - 1] = searchName;
                        newDescriptions[newDescriptions.length - 1] = description;
                        names = newNames;
                        descriptions = newDescriptions;
                        System.out.println(searchName + " has been added to the array with description: " + description);
                    }
                } else {
                    System.out.println(names[index] + " is found at the index number: " + index + ". Description: " + descriptions[index]);
                }
            }
        }
        scanner.close();
    }
}