package is;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class AESDemo {
    public static void main(String[] args) throws Exception {

        // Generate AES key (128-bit)
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        String plaintext = "INFORMATION SECURITY";

        // Create AES cipher object
        Cipher cipher = Cipher.getInstance("AES");

        // ------------------ ENCRYPTION ------------------
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        // ------------------ DECRYPTION ------------------
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);

        System.out.println("Original Text   : " + plaintext);
        System.out.println("Encrypted Text  : " + encryptedText);
        System.out.println("Decrypted Text  : " + decryptedText);
    }
}
