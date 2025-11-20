package is;

import java.util.Scanner;

public class RoleBasedAccessDemo {
    static ArrayList<String> users = new ArrayList<>();
    static ArrayList<String> studentRecords = new ArrayList<>();
    static ArrayList<String> grades = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Preloaded demo data
        studentRecords.add("Student: John | Class: 12 | Attendance: 90%");
        studentRecords.add("Student: James | Class: 11 | Attendance: 94%");

        grades.add("John: A");
        grades.add("James: A+");

        System.out.print("Enter your role (Admin / Teacher / Student): ");
        String role = sc.nextLine();

        System.out.println("\n--- Menu ---");

        if (role.equalsIgnoreCase("Admin")) {
            System.out.println("1. Add User");
            System.out.println("2. View Student Records");
            System.out.println("3. Check Grades");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username to add: ");
                    String newUser = sc.nextLine();
                    users.add(newUser);
                    System.out.println("User added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Student Records ---");
                    for (String record : studentRecords)
                        System.out.println(record);
                    break;

                case 3:
                    System.out.println("\n--- Grades ---");
                    for (String g : grades)
                        System.out.println(g);
                    break;

                default:
                    System.out.println("Exiting...");
            }
        }

        else if (role.equalsIgnoreCase("Teacher")) {
            System.out.println("1. View Student Records");
            System.out.println("2. Check Grades");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Student Records ---");
                    for (String record : studentRecords)
                        System.out.println(record);
                    break;

                case 2:
                    System.out.println("\n--- Grades ---");
                    for (String g : grades)
                        System.out.println(g);
                    break;

                default:
                    System.out.println("Exiting...");
            }
        }

        else if (role.equalsIgnoreCase("Student")) {
            System.out.println("1. Check Grades");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Grades ---");
                    for (String g : grades)
                        System.out.println(g);
                    break;

                default:
                    System.out.println("Exiting...");
            }
        }

        else {
            System.out.println("Unknown role! Access Denied.");
        }

        sc.close();
    }
}
