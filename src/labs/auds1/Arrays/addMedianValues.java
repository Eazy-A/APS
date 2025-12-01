package labs.auds1.Arrays;


import labs.auds1.ArrayList.Array;

import java.util.Scanner;

public class addMedianValues {

    public static Array<Integer> addMedian(Array<Integer> array, int n) {
        for (int i = n - 2; i >= 0; i--) {
            int mid = (array.get(i) + array.get(i + 1)) / 2;
            array.insert(i + 1, mid);
        }
        return array;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Array<Integer> array = new Array<Integer>(n * 2 - 1);

        for (int i = 0; i < n; i++)
            array.insertLast(input.nextInt());
        System.out.println(addMedian(array, n));
    }

}
