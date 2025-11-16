package kol1.auds2.DLL;

import java.util.Scanner;

public class ReverseList {
    public void reverseList(DLL<Integer> list) {
        DLLNode<Integer> current = list.getFirst();
        DLLNode<Integer> prev = null;
        DLLNode<Integer> next;

        while (current != null) {
            next = current.succ;
            current.succ = current.pred;
            current.pred = next;
            prev = current;
            current = next;
        }
        DLLNode<Integer> temp = list.getFirst();
        list.setFirst(list.getLast());
        list.setLast(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        ReverseList rl = new ReverseList();
        rl.reverseList(list);
        System.out.println(list);
    }
}
