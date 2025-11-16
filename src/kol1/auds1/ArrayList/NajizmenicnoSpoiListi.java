package kol1.auds1.ArrayList;

import java.util.Scanner;

public class NajizmenicnoSpoiListi {

    public SLL<Integer> najzmenicnoSpoiListi(SLL<Integer> list1, SLL<Integer> list2) {
        SLLNode<Integer> node1 = list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();  
        SLL<Integer> jointList = new SLL<>();

        while (node1 != null || node2 != null) {
            for (int i = 0; i < 2 && node1 != null; i++) {
                jointList.insertLast(node1.element);
                node1 = node1.succ;
            }
            for (int i = 0; i < 2 && node2 != null; i++) {
                jointList.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        return jointList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        SLL<Integer> list1 = new SLL<>();
        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.nextInt());
        }

        int m = scanner.nextInt();
        SLL<Integer> list2 = new SLL<>();
        for (int i = 0; i < m; i++) {
            list2.insertLast(scanner.nextInt());
        }

        NajizmenicnoSpoiListi najzimenicno = new NajizmenicnoSpoiListi();
        SLL<Integer> joint = najzimenicno.najzmenicnoSpoiListi(list1, list2);

        System.out.println(joint);
    }
}
