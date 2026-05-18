package tehniki;
import java.util.Scanner;

public class zad9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // broj na cifri
        int m = scanner.nextInt(); // suma na cifri


        if (m > 9 * n || m < 1) {
            System.out.println("Ne postoi");
            return;
        }

        int[] digits = new int[n];

        for (int i = 0; i < n; i++) { //  run the loop number of digits times
            int start = (i == 0) ? 1 : 0; // the first number cant be 0, but the other number could be
            for (int d = start; d <= 9; d++) { // 1 - 9
                int remaining = m - d;
                int remainingSlots = n - i - 1;
                if (remaining >= 0 && remaining <= 9 * remainingSlots) {
                    digits[i] = d;
                    m -= d;
                    break;
                }
            }
        }

        for (int d : digits) System.out.print(d);


    }
}
