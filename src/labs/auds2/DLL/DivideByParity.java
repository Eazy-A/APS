package labs.auds2.DLL;

import java.util.Scanner;

public class DivideByParity {

    public void divideByParity(DLL<Integer> list) {
        DLL<Integer> evenList = new DLL<Integer>();
        DLL<Integer> oddList = new DLL<Integer>();
        DLLNode<Integer> node = list.getFirst();

        while (node != null) {
            if (node.element % 2 == 0) evenList.insertLast(node.element);
            else oddList.insertLast(node.element);
            node = node.succ;
        }

        System.out.println(evenList.toString());
        System.out.println(oddList.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        scanner.close();
        DivideByParity d = new DivideByParity();
        d.divideByParity(list);
    }
}
