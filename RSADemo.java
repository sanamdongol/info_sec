package is;

import java.util.Scanner;

public class RSADemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Input message
        System.out.print("Enter a number to encrypt: ");
        int msg = sc.nextInt();

        // Step 2: Choose two prime numbers
        int p = 3;
        int q = 11;

        // Step 3: Compute n = p*q
        int n = p * q;

        // Step 4: Compute phi = (p-1)*(q-1)
        int phi = (p - 1) * (q - 1);

        // Step 5: Choose e such that 1 < e < phi and gcd(e, phi) = 1
        int e = 7; // Common small choice

        // Step 6: Compute d such that (d*e) % phi = 1  (mod inverse)
        int d = 3; // precomputed for e=7 and phi=20

        // Step 7: Encryption: c = (msg^e) % n
        int encrypted = 1;
        for (int i = 0; i < e; i++) {
            encrypted = (encrypted * msg) % n;
        }

        // Step 8: Decryption: m = (c^d) % n
        int decrypted = 1;
        for (int i = 0; i < d; i++) {
            decrypted = (decrypted * encrypted) % n;
        }

        System.out.println("\n--- RSA Details ---");
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("n = " + n);
        System.out.println("phi = " + phi);
        System.out.println("Public Key (e, n) = (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n) = (" + d + ", " + n + ")");

        System.out.println("\nEncrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);

        sc.close();
    }
}
