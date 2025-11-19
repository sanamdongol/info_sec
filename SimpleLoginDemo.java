package is;

import java.util.Scanner;

public class SimpleLoginDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Registration
        System.out.println("=== Registration ===");
        System.out.print("Enter username: ");
        String registeredUsername = sc.nextLine();

        System.out.print("Enter password: ");
        String registeredPassword = sc.nextLine();

        System.out.println("\nRegistration successful!");
        System.out.println("----------------------");

        // Login
        System.out.println("=== Login ===");
        System.out.print("Enter username: ");
        String loginUsername = sc.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();

        // Verify credentials
        if (registeredUsername.equals(loginUsername) && registeredPassword.equals(loginPassword)) {
            System.out.println("Login Successful! Welcome " + loginUsername);
        } else {
            System.out.println("Login Failed! Invalid username or password.");
        }

        sc.close();
    }
}
