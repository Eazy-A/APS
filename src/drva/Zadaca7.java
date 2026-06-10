package drva;

import java.util.Scanner;

public class Zadaca7 {
    static int numberOfLowerElements(BNode<Integer> node, int value) {
        if (node == null) return 0;
        int count = (node.info < value) ? 1 : 0;
        return count + numberOfLowerElements(node.left, value) + numberOfLowerElements(node.right, value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for (int i = 0; i < n + q; i++) {
            String operation = scanner.next();
            if (operation.equals("insert")) {
                tree.insert(scanner.nextInt());
            } else if (operation.equals("ask")) {
                System.out.println(numberOfLowerElements(tree.getRoot(), scanner.nextInt()));
            }
        }
    }
}
