package labs.lab3.proizvodPodniza;

import java.util.Scanner;

public class ProizvodPodniza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n], dp = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();

        long ans = a[0];
        for (int i = 0; i < n; i++) {
            dp[i] = a[i];
            for (int j = 0; j < i; j++)
                if (a[j] < a[i])
                    dp[i] = Math.max(dp[i], dp[j] * a[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
