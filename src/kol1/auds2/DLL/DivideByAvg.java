package kol1.auds2.DLL;

import kol1.auds1.ArrayList.SLL;
import kol1.auds1.ArrayList.SLLNode;

import java.sql.ClientInfoStatus;
import java.util.Scanner;

public class DivideByAvg {
    public double averageOfList(DLL<Integer> list) {
        DLLNode<Integer> current = list.getFirst();
        double sum = 0;
        while (current != null) {
            sum += current.element;
            current = current.succ;
        }
        return sum / list.getSize();
    }

    public void divideByAvgRev(DLL<Integer> list) {
        DLL<Integer> lower = new DLL<Integer>();
        DLL<Integer> upper = new DLL<Integer>();
        DLLNode<Integer> current = list.getLast();
        double average = averageOfList(list);
        while (current != null) {
            DLLNode<Integer> prev = current.pred;
            current.pred = current.succ = null;

            if (current.element <= average) {
                if (lower.getFirst() == null) {
                    lower.setFirst(current);
                    lower.setLast(current);
                } else {
                    lower.getLast().succ = current;
                    current.pred = lower.getLast();
                    lower.setLast(current);
                }
            } else {
                if (upper.getLast() == null) {
                    upper.setFirst(current);
                    upper.setLast(current);
                } else {
                    upper.getLast().succ = current;
                    current.pred = upper.getLast();
                    upper.setLast(current);
                }
            }
            current = prev;
        }

        System.out.println(lower.toString());
        System.out.println(upper.toString());
    }

    public void divideByAvg(DLL<Integer> list) {
        DLL<Integer> lower = new DLL<>();
        DLL<Integer> upper = new DLL<>();
        DLLNode<Integer> current = list.getFirst();
        double average = averageOfList(list);
        while (current != null) {
            DLLNode<Integer> next = current.succ;
            current.pred = current.succ = null;
            if (current.element <= average) {
                if (lower.getFirst() == null) {
                    lower.setFirst(current);
                    lower.setLast(current);
                } else {
                    lower.getLast().succ = current;
                    current.pred = lower.getLast();
                    lower.setLast(current);
                }
            } else {
                if (upper.getFirst() == null) {
                    upper.setFirst(current);
                    upper.setLast(current);
                } else {
                    upper.getLast().succ = current;
                    current.pred = upper.getLast();
                    upper.setLast(current);
                }
            }
            current = next;
        }
        System.out.println(lower.toString());
        System.out.println(upper.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        DivideByAvg d = new DivideByAvg();
        d.divideByAvg(list);
    }
}
