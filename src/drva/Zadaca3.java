package drva;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zadaca3 {
    static int nodesWith2Children(BNode<String> node){
        if(node == null) return 0;
        int current = (node.left != null && node.right != null) ? 1 : 0;
        return current + nodesWith2Children(node.left) + nodesWith2Children(node.right);
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
                map.put(rootVal, tree.root);
            } else if (operation.equals("add")) {
                String parentVal = scanner.next();
                String childVal = scanner.next();
                String direction = scanner.next();

                BNode<String> parent = map.get(parentVal);
                BNode<String> child = tree.addChild(parent, direction.equals("LEFT") ? BNode.LEFT : BNode.RIGHT, childVal);
                map.put(childVal, child);
            } else if (operation.equals("ask")) {
                BNode<String> node = map.get(scanner.next());
                System.out.println(nodesWith2Children(node));
            }
        }

    }
}
