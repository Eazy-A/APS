package kol1.auds1.ArrayList;

public class ChangeList<E> {

    public SLL<E> change(SLL<E> list) {

        SLL<E> firstHalf = new SLL<>();
        SLL<E> secondHalf = new SLL<>();
        SLL<E> changedList = new SLL<>();

        SLLNode<E> sredina = list.getFirst();

        for (int i = 0; i < list.size() / 2; i++) {
            sredina = sredina.succ;
        }
        SLLNode<E> node = list.getFirst();
        while (node != sredina) {
            firstHalf.insertLast(node.element);
            node = node.succ;
        }

        while (node != null) {
            secondHalf.insertLast(node.element);
            node = node.succ;
        }
        secondHalf.mirror();
        SLLNode<E> node1 = firstHalf.getFirst();
        SLLNode<E> node2 = secondHalf.getFirst();

        while (node1 != null || node2 != null) {
            if (node1 != null) {
                changedList.insertLast(node1.element);
                node1 = node1.succ;
            }
            if (node2 != null) {
                changedList.insertLast(node2.element);
                node2 = node2.succ;
            }
        }
        return changedList;

    }

    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(8);

        System.out.print("Original list: ");
        System.out.println(list);

        ChangeList<Integer> changer = new ChangeList<>();
        SLL<Integer> changedList = changer.change(list);

        System.out.print("Changed list: ");
        System.out.println(changedList);
    }
}
