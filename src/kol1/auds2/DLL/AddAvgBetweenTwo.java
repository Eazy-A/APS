package kol1.auds2.DLL;

import java.util.Scanner;

public class AddAvgBetweenTwo {

    public void addAvgBetweenTwo(DLL<Integer> list){
        DLLNode<Integer> node = list.getFirst();
        while(node != null && node.succ != null){
            DLLNode<Integer> midNode = new DLLNode<>(0, node, node.succ);
            midNode.element = (node.element + node.succ.element) / 2;
            node.succ.pred = midNode;
            node.succ = midNode;
            node = midNode.succ;
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
        AddAvgBetweenTwo obj = new AddAvgBetweenTwo();
        obj.addAvgBetweenTwo(list);
    }
}
