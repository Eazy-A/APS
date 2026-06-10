package drva;

import java.util.*;

public class Zadaca4 {
    static int maxDepth(BNode<String> node){
        if (node == null)
            return 0;
        if ((node.left == null) && (node.right == null))
            return 0;
        return (1 + Math.max(maxDepth(node.left), maxDepth(node.right)));
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
                System.out.println(maxDepth(node) + 1);
            }
        }
    }
}
