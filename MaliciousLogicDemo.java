package is;

import java.time.LocalDate;
import java.util.Scanner;

public class MaliciousLogicDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Normal Program: Calculator ===");
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println("Sum = " + sum);

        // ----- Hidden Malicious Logic (Simulation) -----
        LocalDate today = LocalDate.now();

        // Logic bomb triggers on a specific date (example)
        LocalDate triggerDate = LocalDate.of(2025, 1, 1);

        if (today.equals(triggerDate)) {
            System.out.println("\n⚠ ALERT: Hidden Logic Triggered!");
            System.out.println("This simulates a logic bomb that activates on a specific date.");
        }

        // Or trigger based on special user input (safe simulation)
        if (a == 99 && b == 99) {
            System.out.println("\n⚠ ALERT: Suspicious input detected!");
            System.out.println("Hidden malicious logic activated intentionally for demonstration.");
        }

        sc.close();
    }
}
