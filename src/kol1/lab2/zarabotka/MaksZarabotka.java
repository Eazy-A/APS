package kol1.lab2.zarabotka;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class MaksZarabotka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxVreme = 40;

        int[] vreme = new int[n];
        int[] zarabotka = new int[n];

        for (int i = 0; i < n; i++) {
            vreme[i] = sc.nextInt();
            zarabotka[i] = sc.nextInt();
        }

        double total = 0;
        int preostanatoVreme = maxVreme;

        for (int i = 0; i < n; i++) {
            if (preostanatoVreme == 0) break;;
            if (vreme[i] <= preostanatoVreme) {
                total += zarabotka[i];
                preostanatoVreme -= vreme[i];
            } else {
                total += zarabotka[i] * ((double) preostanatoVreme / vreme[i]);
                preostanatoVreme = 0;
            }
        }

        System.out.println((int) total);
    }
}
