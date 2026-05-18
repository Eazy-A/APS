package zadaci_za_vezbaanje_prv_kol;

import java.util.Scanner;

public class zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // vozrasni
        int m = scanner.nextInt(); // deca


        /*
        min:

        4
        10

        4 * 100 = 400;
        10 / 4 = 2
        10 % 4 = 2

        2 2 2 2;
        100 100 100 100;

        2 * 100 = 200;
         */

        int minSum = n * 100;

        int howManyChildrenPerAdult = m / n;

        if (howManyChildrenPerAdult != 0) {
            minSum += (howManyChildrenPerAdult - 1) * n * 100;
            int leftOutChildren = m % n;

            minSum += leftOutChildren * 100;
        }

        System.out.println(minSum);

        /*
        max:
        4 adults
        10 kids

        1 10 kids - 1000
        3 adults alone - 300
         */

        int maxSum = 0;
        if (m != 0) {
            maxSum = m * 100;
        }else{
            maxSum += 100;
        }
        maxSum += (n - 1) * 100;

        System.out.println(maxSum);
    }
}
