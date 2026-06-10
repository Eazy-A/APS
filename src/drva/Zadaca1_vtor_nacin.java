package drva;

import java.io.Flushable;
import java.util.*;

public class Zadaca1_vtor_nacin {
    static int countLeaves(int index, Map<Integer, List<Integer>> children){
       if (children.get(index).isEmpty()) return 1;
       int count = 0;

       for (int child : children.get(index)){
           count += countLeaves(child, children);
       }

       return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // number of nodes
        int q = scanner.nextInt(); // number of questions

        Map<Integer, List<Integer>> children = new HashMap<>();

        for (int i = 0; i < n + q; i++) {
            String operation = scanner.next();
            if (operation.equals("root")) {
                int rootVal = scanner.nextInt();
                children.put(rootVal, new ArrayList<>());
            } else if (operation.equals("add")) {
                int parentVal = scanner.nextInt();
                int childVal = scanner.nextInt();
                children.putIfAbsent(parentVal, new ArrayList<>());
                children.putIfAbsent(childVal, new ArrayList<>());
                children.get(parentVal).add(childVal);
            } else if (operation.equals("ask")) {
                System.out.println(countLeaves(scanner.nextInt(), children));
            }
        }

    }
}
