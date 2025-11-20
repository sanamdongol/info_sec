package is;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RailFenceCipher {
    public static String encrypt(String text, int key) {
        if (key == 1) return text;

        StringBuilder[] rail = new StringBuilder[key];
        for (int i = 0; i < key; i++) rail[i] = new StringBuilder();

        int row = 0;
        boolean down = true;

        for (char c : text.toCharArray()) {
            rail[row].append(c);

            if (row == 0) down = true;
            else if (row == key - 1) down = false;

            row += (down ? 1 : -1);
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rail) result.append(sb);

        return result.toString();
    }

    public static String decrypt(String cipher, int key) {
        if (key == 1) return cipher;

        boolean[][] mark = new boolean[key][cipher.length()];

        int row = 0;
        boolean down = true;
        for (int i = 0; i < cipher.length(); i++) {
            mark[row][i] = true;

            if (row == 0) down = true;
            else if (row == key - 1) down = false;

            row += (down ? 1 : -1);
        }

        char[][] rail = new char[key][cipher.length()];
        int index = 0;

        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipher.length(); j++) {
                if (mark[i][j]) {
                    rail[i][j] = cipher.charAt(index++);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        row = 0;
        down = true;

        for (int i = 0; i < cipher.length(); i++) {
            result.append(rail[row][i]);

            if (row == 0) down = true;
            else if (row == key - 1) down = false;

            row += (down ? 1 : -1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String message = "INFORMATIONSECURITY";
        int key = 3;

        String encrypted = encrypt(message, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
