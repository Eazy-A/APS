package labs.auds2.DLL;

import java.util.Scanner;

public class ListofLists {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        DLLNode<DLL<Integer>> current = list.getFirst();
        long product = 1;
        while (true) {
            int sum = 0;
            DLLNode<Integer> current1 = current.element.getFirst();
            while (true) {
                sum += current1.element;
                if (current1 == current.element.getLast()) {
                    break;
                }
                current1 = current1.succ;
            }
            product *= sum;
            if (current == list.getLast()) {
                break;
            }
            current = current.succ;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> temp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                temp.insertLast(scanner.nextInt());
            }
            list.insertLast(temp);
        }
        scanner.close();
        System.out.println(findMagicNumber(list));
    }
}
