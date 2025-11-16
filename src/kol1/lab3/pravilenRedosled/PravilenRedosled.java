package kol1.lab3.pravilenRedosled;

import java.util.*;

import java.util.*;

public class PravilenRedosled {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int[] sorted = array.clone();
        Arrays.sort(sorted);

        Map<Integer, Queue<Integer>> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(sorted[i], k -> new LinkedList<>()).add(i);
        }

        List<Integer> wrong = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();

        int last = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            int correctPos = positions.get(array[i]).poll();

            if (array[i] < last) {
                wrong.add(array[i]);
                diff.add(Math.abs(i - correctPos));
            }
            last = Math.max(last, array[i]);
        }

        System.out.println(wrong.size());
        for (int i = 0; i < wrong.size(); i++) {
            System.out.print(wrong.get(i) + " ");
            System.out.println(diff.get(i));
        }
    }
}
