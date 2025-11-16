package kol1.auds1.Arrays;

import java.util.Scanner;

public class largestSubSum {
    public int subSum(int[] arr, int n) {
        int maxSum = 0;
        int i = 0;
        int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
                else{
                    if(sum < 0){
                        i = j + 1;sum = 0;
                    }
                }
            }

        return maxSum;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        largestSubSum lss = new largestSubSum();
        int maxSum = lss.subSum(arr, n);

        System.out.println("The largest subarray sum is: " + maxSum);
    }
}
