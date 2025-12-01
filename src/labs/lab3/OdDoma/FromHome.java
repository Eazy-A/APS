package labs.lab3.OdDoma;

import java.util.Scanner;

public class FromHome {

    public int find(int[] array, int start, int end, int m) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (array[mid] == m)
            return mid;
        else if (m < array[mid]) {
//                end = mid - 1;
            return find(array, start, mid - 1, m);
        } else {
//                start = mid + 1;
            return find(array, mid + 1, end, m);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        FromHome fh = new FromHome();
        int result = fh.find(numbers, 0, n - 1, m);
        if (result == -1) {
            System.out.println("Ne postoi");
        } else {
            System.out.println(result);
        }
    }
}
