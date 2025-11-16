package kol1.auds2.DLL;

import java.util.Scanner;

public class DeleteSubLists {

    public void deleteSubLists(DLL<Integer> list, DLL<Integer> subList) {
        if (list == null || subList == null) return;

        DLLNode<Integer> current = list.getFirst();

        while (current != null) {
            DLLNode<Integer> listNode = current;
            DLLNode<Integer> subListNode = subList.getFirst();

            while (listNode != null && subListNode != null && listNode.element.equals(subListNode.element)) {
                listNode = listNode.succ;
                subListNode = subListNode.succ;
            }

            if (subListNode == null) {
                DLLNode<Integer> before = current.pred;
                if (before != null) before.succ = listNode;
                if (listNode != null) listNode.pred = before;
                current = listNode;
            } else {
                current = current.succ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLL<Integer> list = new DLL<>();
        DLL<Integer> subList = new DLL<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) list.insertLast(scanner.nextInt());

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) subList.insertLast(scanner.nextInt());

        DeleteSubLists d = new DeleteSubLists();
        d.deleteSubLists(list, subList);
        System.out.println(list);
    }
}
