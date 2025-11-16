package kol1.auds1.ArrayList;

import java.util.Scanner;

public class DeleteNodesFromList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        DeleteNodesFromList dn = new DeleteNodesFromList();
        dn.deleteNodesFromList(list);
    }

    public void deleteNodesFromList(SLL<Integer> list) {
        SLLNode<Integer> node = list.getFirst();
        int leave = 1; 

        while (node != null) {
            for (int i = 0; i < leave - 1 && node != null; i++) {
                node = node.succ;
            }
            if (node == null || node.succ == null) break;
            list.delete(node.succ);
            node = node.succ;
            leave++;
        }

        System.out.println(list);
    }

}
