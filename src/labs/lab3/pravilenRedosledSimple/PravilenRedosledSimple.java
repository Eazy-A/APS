package labs.lab3.pravilenRedosledSimple;

import java.util.*;

public class PravilenRedosledSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        List<Integer> wrong = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
           if(array[i] < array[i-1]){
               wrong.add(array[i]);
               int iterator = i, counter = 0;
               while (array[iterator] > array[iterator-1] ){
                   counter++;
                   iterator--;
               }
               diff.add(counter);
           }
        }

        System.out.println(wrong.size());
        for (int i = 0; i < wrong.size(); i++) {
            System.out.print(wrong.get(i) + " ");
            System.out.println(diff.get(i));
        }
    }
}
