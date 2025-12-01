package labs.lab2.HCifri;

import java.util.Arrays;
import java.util.Scanner;

public class Cifri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = scanner.nextInt();
        }
        Arrays.sort(digits);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            stringBuilder.append(digits[i]);
        }
        System.out.println(stringBuilder);
    }
}
