package labs.auds2.DLL;

import java.util.Scanner;

public class PomestiPosledniElementi {

    public void pomestiPosledniElementi(DLL<Integer> list, int k){
        DLLNode<Integer> node = list.getLast();
        System.out.println(list.toString());
        while (node != null && k != 0){
            DLLNode<Integer> prev = node.pred;
            node.pred = null;
            node.succ = list.getFirst();
            list.getFirst().pred = node;
            list.setFirst(node);
            list.setLast(prev);
            if (prev != null) prev.succ = null;
            node = prev;
            k--;
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        int k = scanner.nextInt();
        PomestiPosledniElementi p = new PomestiPosledniElementi();
        p.pomestiPosledniElementi(list, k);
    }
}
