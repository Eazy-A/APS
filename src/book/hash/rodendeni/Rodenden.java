package book.hash.rodendeni;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Rodenden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, Integer> dates = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] words = line.split("\\.");
            int month = Integer.parseInt(words[1]);

            dates.put(month, dates.getOrDefault(month, 0)+1);
        }

        int month = scanner.nextInt();
        System.out.println(dates.getOrDefault(month, 0));
    }
}