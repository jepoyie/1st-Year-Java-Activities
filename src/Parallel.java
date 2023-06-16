import java.util.Scanner;

public class Parallel {
    private String[] names;
    private int[] ages;
    private String[] courses;

    public Parallel(String[] names, int[] ages, String[] courses) {
        this.names = names;
        this.ages = ages;
        this.courses = courses;
    }

    public void displayRecords() {
        System.out.println("NAME\tAGE\tCOURSE");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s\t%d\t%s\n", names[i], ages[i], courses[i]);
        }
    }

    public int searchRecord(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] names = {"Ash", "Franz", "John Leonard", "Janpol", "Owen"};
        int[] ages = {19, 18, 20, 17, 21};
        String[] courses = {"Data Science", "Game Developer", "Software Engineering", "Data Analysis", "Web Developer"};

        Parallel system = new Parallel(names, ages, courses);

        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.print("Enter name to search: ");
            String name = scanner.nextLine();
            int index = system.searchRecord(name);
            if (index == -1) {
                System.out.println("Sorry, the name you searched is not in the records.");
            } else {
                System.out.printf("Record found at index %d: %s, %d, %s\n", index, names[index], ages[index], courses[index]);
            }

            System.out.print("Do you want to continue searching (Y/N)? ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Thank you for using the system!");
    }
}