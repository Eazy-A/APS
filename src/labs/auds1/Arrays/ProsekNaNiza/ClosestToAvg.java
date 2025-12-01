package labs.auds1.Arrays.ProsekNaNiza;

import labs.auds1.ArrayList.Array;

import java.util.Scanner;

import static java.lang.Math.abs;

public class ClosestToAvg {

    private static int ElementClosestToMean(Array<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.getSize(); i++) {
            sum += arr.get(i);
        }
        double avg = (double) sum / arr.getSize();
        double minDiff = Integer.MAX_VALUE, diff = 0.0;
        int index = -1;
        for (int i = 0; i < arr.getSize(); i++) {

            diff = abs(arr.get(i) - avg);
            if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }
        return arr.get(index);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Array<Integer> arr = new Array<>(n);

        for (int i = 0; i < n; i++) {
            arr.insertLast(input.nextInt());
        }
        System.out.println(ElementClosestToMean(arr));
    }

}
