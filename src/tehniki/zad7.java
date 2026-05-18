package tehniki;

import java.util.Scanner;

public class zad7 {

    static void search(int[] arr, int low, int high, int m){
        if (low > high) {
            System.out.println("Ne postoi");
            return;
        }
        int mid = (low + high) / 2;

        if (arr[mid] == m) {
            System.out.println(mid);
            return;
        }
        if (arr[mid] < m) search(arr, mid+1, high, m);
        if (arr[mid] > m) search(arr, low, mid-1, m);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt(); // the number we are looking for

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        search(arr, 0, n-1, m);

    }
}
