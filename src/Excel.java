import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Excel {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter some text (type 'quit' to stop): ");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("quit")) {
                break;
            }
            list.add(line);
        }

        File file = new File("output.xls");
        try {
            FileWriter writer = new FileWriter(file);
            for (String str : list) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Choose an Operation:\n1. Delete element\n2. Update element");
        System.out.print("Enter your choice: ");
        int operation = scanner.nextInt();
        scanner.nextLine();

        switch (operation) {
            case 1:
                System.out.print("Enter the element to delete: ");
                String deleteElement = scanner.nextLine();
                if (list.contains(deleteElement)) {
                    list.remove(deleteElement);
                    System.out.println("Element deleted.");
                    updateExcelFile(file, list);
                } else {
                    System.out.println("Element not found!");
                }
                break;
            case 2:
                System.out.print("Enter the element to update: ");
                String oldElement = scanner.nextLine();
                if (list.contains(oldElement)) {
                    System.out.print("Enter the new element: ");
                    String newElement = scanner.nextLine();
                    list.set(list.indexOf(oldElement), newElement);
                    System.out.println("Element updated.");
                    updateExcelFile(file, list);
                } else {
                    System.out.println("Element not found!");
                }
                break;
            default:
                System.out.println("Invalid operation!");
        }

        System.out.println("Updated List:");
        for (String element : list) {
            System.out.println(element);
        }

        scanner.close();
    }

    public static void updateExcelFile(File file, ArrayList<String> list) {
        try {
            FileWriter writer = new FileWriter(file);
            for (String str : list) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}