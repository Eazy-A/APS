package kol1.auds1.Arrays;

import java.util.Scanner;

public class deleteDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();
        int[] result = removeDuplicates(array, n);
        for (int j : result)
            System.out.print(j + " ");

    }

    static int[] removeDuplicates(int[] arr, int n) {
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            boolean duplicate = false;
            for (int k = 0; k < j; k++) {
                if (arr[i] == temp[k]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate)
                temp[j++] = arr[i];
        }
        int[] result = new int[j];
        System.arraycopy(temp, 0, result, 0, j);

        return result;
    }
}
