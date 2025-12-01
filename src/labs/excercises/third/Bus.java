package labs.excercises.third;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // number of adults
        int M = Integer.parseInt(br.readLine()); // number of kids

        br.close();


        int minCost = 0;
        for (int i = 0; i < N; i++) {
            int kidsForThisAdult = M / N;
            if (i < M % N) kidsForThisAdult++;
            if (kidsForThisAdult > 0) {
                minCost += kidsForThisAdult * 100;
            } else {
                minCost += 100;
            }
        }
        int maxCost = 0;


        if (M > 0) maxCost += M * 100;
        else maxCost += 100;
        maxCost += (N - 1) * 100;

        System.out.println(minCost);
        System.out.println(maxCost);


    }

}
