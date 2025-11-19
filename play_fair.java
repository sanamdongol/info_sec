package is;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class PlayFairCipher {
    private static char[][] generateKeyMatrix(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : key.toCharArray()) set.add(c);

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J') continue;
            set.add(c);
        }

        Iterator<Character> it = set.iterator();
        char[][] matrix = new char[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                matrix[i][j] = it.next();

        return matrix;
    }

    private static int[] findPosition(char[][] matrix, char c) {
        if (c == 'J') c = 'I';
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (matrix[i][j] == c)
                    return new int[]{i, j};
        return null;
    }

    private static String formatText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder(text);

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'X');
            }
        }
        if (sb.length() % 2 != 0) sb.append('X');

        return sb.toString();
    }

    public static String encrypt(String text, String key) {
        char[][] matrix = generateKeyMatrix(key);
        text = formatText(text);

        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            int[] pos1 = findPosition(matrix, a);
            int[] pos2 = findPosition(matrix, b);

            if (pos1[0] == pos2[0]) {
                cipher.append(matrix[pos1[0]][(pos1[1] + 1) % 5]);
                cipher.append(matrix[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                cipher.append(matrix[(pos1[0] + 1) % 5][pos1[1]]);
                cipher.append(matrix[(pos2[0] + 1) % 5][pos2[1]]);
            } else {
                cipher.append(matrix[pos1[0]][pos2[1]]);
                cipher.append(matrix[pos2[0]][pos1[1]]);
            }
        }
        return cipher.toString();
    }

    public static void main(String[] args) {
        String key = "SECURITY";
        String plaintext = "INFORMATION";

        String encrypted = encrypt(plaintext, key);

        System.out.println("Encrypted: " + encrypted);
    }
}
