package tehniki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class zad8 {

    static class Worker {
        int remaining = 8;

        boolean IsDoneForToday() {
            return remaining == 0;
        }

        void work(int hours) {
            remaining -= hours;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt(); // number of workers

        int[] workHours = new int[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            workHours[i] = scanner.nextInt();
        }

        Arrays.sort(workHours);

        int days = 0;
        int assigned = 0;
        int totalFree = 0;
        while (assigned < n) {
            days++;
            List<Worker> workers = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                workers.add(new Worker());
            }
            for (int i = 0; i < m; i++) {
                Worker currentWorker = workers.get(i);
                for (int j = n - 1; j >= 0; j--) {
                    if (!used[j] && currentWorker.remaining <= 8) {
                        if (currentWorker.remaining - workHours[j] < 0) continue;
                        currentWorker.work(workHours[j]);
                        used[j] = true;
                        assigned++;
                    }
                }
                totalFree += currentWorker.remaining;
            }
        }

        System.out.println(days + " " + totalFree);
    }
}
