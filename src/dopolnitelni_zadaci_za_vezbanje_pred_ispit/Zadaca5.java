package dopolnitelni_zadaci_za_vezbanje_pred_ispit;

import java.util.*;

public class Zadaca5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Set<String> dictionary = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.next().toLowerCase();
            dictionary.add(word);
        }

        scanner.nextLine();
        String text = scanner.nextLine();

        String[] words = text.split(" ");
        if (words.length == 1 && Objects.equals(words[0], ".")){
            System.out.println("Bravo");
        }
        boolean clean = true;
        for (String word : words) {
            char sign = word.charAt(word.length() - 1);
            String cleanWord = word;
            if (sign == '.' || sign == ',' || sign == '!' || sign == '?') {
                cleanWord = word.substring(0, word.length() - 1);
            }
            cleanWord = cleanWord.toLowerCase();
            if (!dictionary.contains(cleanWord)) {
                System.out.println(cleanWord);
                clean = false;
            }
        }
        if (clean) {
            System.out.println("Bravo");
        }

    }
}
