package kol1.lab2.Vozovi;

import java.util.Arrays;
import java.util.Scanner;

public class Trains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arrival = new int[n];
        int[] departure = new int[n];

        for (int i = 0; i < n; i++) {
            arrival[i] = scanner.nextInt();
            departure[i] = scanner.nextInt();
        }

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platforms = 0, maxPlatforms = 0;
        int i = 0, j = 0;

        while(i < n && j < n){
            if(arrival[i] <= departure[j]){
                platforms++;
                if(platforms > maxPlatforms) maxPlatforms = platforms;
                i++;
            }else{
                platforms--;
                j++;
            }
        }

        System.out.println(maxPlatforms);
    }

}
