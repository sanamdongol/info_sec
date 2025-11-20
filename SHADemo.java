package is;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHADemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a message to hash using SHA-256: ");
        String input = sc.nextLine();

        try {
            // Create SHA MessageDigest instance (SHA-256)
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Compute hash
            byte[] hashBytes = md.digest(input.getBytes());

            // Convert bytes to hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            System.out.println("SHA-256 Hash: " + hexString);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algorithm not found!");
        }

        sc.close();
    }
}
