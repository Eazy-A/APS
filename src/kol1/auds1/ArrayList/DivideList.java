package kol1.auds1.ArrayList;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class DivideList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SLL<Integer> lista = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            lista.insertLast(scanner.nextInt());
        }

        SLLNode<Integer> node = lista.getFirst();

        SLL<Integer> oddList = new SLL<Integer>();
        SLL<Integer> evenList = new SLL<Integer>();
        while (node != null) {

            if (node.succ == null || (node.element % 2 != node.succ.element % 2)) {
                if (node.element % 2 == 0) {
                    evenList.insertLast(node.element);
                } else {
                    oddList.insertLast(node.element);
                }
            }
            node = node.succ;
        }

        System.out.println(evenList.toString());
        System.out.println(oddList.toString());
    }
}
