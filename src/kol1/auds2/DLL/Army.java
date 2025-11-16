package kol1.auds2.DLL;

import java.util.Scanner;

public class Army {

    public void changeArmySequence(DLL<Integer> soldierIDs, int f1, int l1, int f2, int l2) {

        if(f1 > l1 || f2 > l2) return;

        DLLNode<Integer> start1 = soldierIDs.getFirst();
        for(int i = 1; i < f1; i++) start1 = start1.succ;

        DLLNode<Integer> end1 = start1;
        for(int i = f1; i < l1; i++) end1 = end1.succ;

        DLLNode<Integer> start2 = soldierIDs.getFirst();
        for(int i = 1; i < f2; i++) start2 = start2.succ;

        DLLNode<Integer> end2 = start2;
        for(int i = f2; i < l2; i++) end2 = end2.succ;

        DLLNode<Integer> before1 = start1.pred;
        DLLNode<Integer> after1 = end1.succ;
        DLLNode<Integer> before2 = start2.pred;
        DLLNode<Integer> after2 = end2.succ;

        // Case if intervals are adjacent
        if(end1.succ == start2) {
            if(before1 != null) before1.succ = start2; else soldierIDs.setFirst(start2);
            start2.pred = before1;

            end2.succ = start1;
            start1.pred = end2;

            end1.succ = after2;
            if(after2 != null) after2.pred = end1;
        }
        else {
            // Connect before1 -> start2
            if(before1 != null) before1.succ = start2; else soldierIDs.setFirst(start2);
            start2.pred = before1;

            // Connect end2 -> after1
            end2.succ = after1;
            if(after1 != null) after1.pred = end2;

            // Connect before2 -> start1
            if(before2 != null) before2.succ = start1; else soldierIDs.setFirst(start1);
            start1.pred = before2;

            // Connect end1 -> after2
            end1.succ = after2;
            if(after2 != null) after2.pred = end1;
        }

        System.out.println(soldierIDs.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> soldierIDs = new DLL<>();
        for(int i = 0; i < n; i++) soldierIDs.insertLast(scanner.nextInt());

        int f1 = scanner.nextInt();
        int l1 = scanner.nextInt();
        int f2 = scanner.nextInt();
        int l2 = scanner.nextInt();

        Army a = new Army();
        a.changeArmySequence(soldierIDs, f1, l1, f2, l2);
    }
}
