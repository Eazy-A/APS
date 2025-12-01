package labs.auds1.ArrayList;

import java.util.Scanner;

public class LastAppearance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SLL<Integer> lista = new SLL<>();

        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            lista.insertLast(element);
        }

        int deleteNumber = scanner.nextInt();

        deleteLastAppearance(lista, deleteNumber);

        System.out.println(lista.toString());
    }

    public static void deleteLastAppearance(SLL<Integer> lista, int toDelete) {
        SLLNode<Integer> node = lista.getFirst();
        SLLNode<Integer> lastMatch = null;

        while (node != null) {
            if (node.element.equals(toDelete)) {
                lastMatch = node;
            }
            node = node.succ;
        }

        if (lastMatch != null) {
            lista.delete(lastMatch);
        }
    }
}
