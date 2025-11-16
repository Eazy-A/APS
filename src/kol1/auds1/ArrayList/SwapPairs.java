package kol1.auds1.ArrayList;

import java.util.Scanner;

public class SwapPairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SLL<Integer> lista = new SLL<Integer>();

        for (int i = 0; i < n; i++) {
            lista.insertLast(scanner.nextInt());
        }

        SLLNode<Integer> node = lista.getFirst();
        while (node != null && node.succ != null) {
            Integer temp = node.element;
            node.element = node.succ.element;
            node.succ.element = temp;
            node = node.succ.succ;
        }

        System.out.println(lista.toString());
    }
}
