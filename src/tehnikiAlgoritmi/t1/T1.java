package tehnikiAlgoritmi.t1;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);
        Collections.reverse(list);

        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i));
        }
    }
}
