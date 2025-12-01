package labs.auds1.ArrayList;

public class JoinSortedLists<E extends Comparable<E>> {

    public SLL<E> join(SLL<E> list1, SLL<E> list2) {
        SLL<E> joint = new SLL<>();
        SLLNode<E> node1 = list1.getFirst();
        SLLNode<E> node2 = list2.getFirst();

        while (node1 != null && node2 != null) {
            if (node1.element.compareTo(node2.element) <= 0) {
                joint.insertLast(node1.element);
                node1 = node1.succ;
            } else {
                joint.insertLast(node2.element);
                node2 = node2.succ;
            }
        }
        while (node1 != null) {
            joint.insertLast(node1.element);
            node1 = node1.succ;
        }
        while (node2 != null) {
            joint.insertLast(node2.element);
            node2 = node2.succ;
        }
        return joint;
    }

    //    public static void main(String[] args){
//        SLL<String> lista1 = new SLL<String>();
//        lista1.insertLast("Ana");lista1.insertLast("Bojana");lista1.insertLast("Dejan");
//        SLL<String> lista2 = new SLL<String>();
//        lista2.insertLast("Andrijana");lista2.insertLast("Biljana");lista2.insertLast("Darko");
//
//        JoinSortedLists<String> js = new JoinSortedLists<String>();
//        System.out.println(js.join(lista1, lista2));
//
//    }
    public static void main(String[] args) {
        SLL<Integer> lista1 = new SLL<>();
        lista1.insertLast(1);
        lista1.insertLast(2);
        lista1.insertLast(3);

        SLL<Integer> lista2 = new SLL<>();
        lista2.insertLast(5);
        lista2.insertLast(6);
        lista2.insertLast(7);

        JoinSortedLists<Integer> js = new JoinSortedLists<>();
        System.out.println(js.join(lista1, lista2));
    }
}
