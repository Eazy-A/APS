package drva;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zadaca5 {
    static int sumOfDeg(BNode<String> node){
        if (node == null) return 0;
        int current = 0;
        if (node.left != null && node.right != null) current = 2;
        else if (node.left != null) {
            current = 1;
        } else if (node.right != null) {
            current = 1;
        }
        return current + sumOfDeg(node.left) + sumOfDeg(node.right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        BTree<String> tree = new BTree<>();
        Map<String, BNode<String>> map = new HashMap<>();

        for (int i = 0; i < n + q; i++) {
            String operation = scanner.next();
            if (operation.equals("root")){
                String rootVal = scanner.next();
                tree.makeRoot(rootVal);
                BNode<String> root = tree.root;
                map.put(rootVal, root);
            } else if (operation.equals("add")) {
                String parentVal = scanner.next();
                String childVal = scanner.next();
                String direction = scanner.next();

                BNode<String> parent = map.get(parentVal);
                BNode<String> child = tree.addChild(parent, direction.equals("LEFT") ? BNode.LEFT : BNode.RIGHT, childVal);
                map.put(childVal, child);
            } else if (operation.equals("ask")) {
                BNode<String> node = map.get(scanner.next());
                System.out.println(sumOfDeg(node));
            }
        }
    }
}
