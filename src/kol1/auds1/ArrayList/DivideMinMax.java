package kol1.auds1.ArrayList;

import java.util.Scanner;

import static java.lang.Math.abs;

public class DivideMinMax {

    public void divideMinMax(SLL<Integer> list) {
        SLLNode<Integer> node = list.getFirst();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        while (node != null) {
            if (node.element > max) max = node.element;
            if (node.element < min) min = node.element;
            node = node.succ;
        }
        SLL<Integer> closerToMax = new SLL<>();
        SLL<Integer> closerToMin = new SLL<>();

        node = list.getFirst();
        while (node != null) {
            if (abs(node.element - min) > abs(node.element - max)) {
                closerToMax.insertLast(node.element);
            } else {
                closerToMin.insertLast(node.element);
            }
            node = node.succ;
        }
        System.out.println(closerToMin);
        System.out.println(closerToMax);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        DivideMinMax dm = new DivideMinMax();
        dm.divideMinMax(list);
    }
}
