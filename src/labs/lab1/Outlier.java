package labs.lab1;

import java.util.Scanner;

public class Outlier {
    public void outlier(SLL<String> list, int l) {
        SLLNode<String> node = list.getFirst();
        System.out.println(list.toString());
        while (node != null) {
            if (node.getElement().length() > l && node.getElement().compareTo("Outlier") != 0) {
                list.insertBefore("Outlier", node);
            }
            node = node.succ;
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SLL<String> list = new SLL<String>();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.next());
        }
        int l = scanner.nextInt();
        Outlier o = new Outlier();
        o.outlier(list, l);
    }
}
