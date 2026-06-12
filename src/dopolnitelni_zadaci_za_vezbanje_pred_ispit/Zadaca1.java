// package dopolnitelni_zadaci_za_vezbanje_pred_ispit;
//
//// BinarySearchTree class
//
//import java.util.Scanner;
//
////
//// CONSTRUCTION: with no initializer
////
//// ******************PUBLIC OPERATIONS*********************
//// void insert( x )       --> Insert x
//// void remove( x )       --> Remove x
//// Comparable find( x )   --> Return item that matches x
//// Comparable findMin( )  --> Return smallest item
//// Comparable findMax( )  --> Return largest item
//// boolean isEmpty( )     --> Return true if empty; else false
//// void makeEmpty( )      --> Remove all items
//// void printTree( )      --> Print tree in sorted order
///**
// * Implements an unbalanced binary search tree.
// * Note that all "matching" is based on the compareTo method.
// * @author Mark Allen Weiss
// */
//class BinarySearchTree<E extends Comparable<E>> {
//
//    /**
//     * The tree root.
//     */
//    private dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> root;
//
//    /**
//     * Construct the tree.
//     */
//    public BinarySearchTree() {
//        root = null;
//    }
//
//    /**
//     * Insert into the tree; duplicates are ignored.
//     *
//     * @param x the item to insert.
//     */
//    public void insert(E x) {
//        root = insert(x, root);
//    }
//
//    /**
//     * Remove from the tree. Nothing is done if x is not found.
//     *
//     * @param x the item to remove.
//     */
//    public void remove(E x) {
//        root = remove(x, root);
//    }
//
//    /**
//     * Find the smallest item in the tree.
//     *
//     * @return smallest item or null if empty.
//     */
//    public E findMin() {
//        return elementAt(findMin(root));
//    }
//
//    /**
//     * Find the largest item in the tree.
//     *
//     * @return the largest item of null if empty.
//     */
//    public E findMax() {
//        return elementAt(findMax(root));
//    }
//
//    /**
//     * Find an item in the tree.
//     *
//     * @param x the item to search for.
//     * @return the matching item or null if not found.
//     */
//    public dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> find(E x) {
//        return find(x, root);
//    }
//
//    /**
//     * Make the tree logically empty.
//     */
//    public void makeEmpty() {
//        root = null;
//    }
//
//    /**
//     * Test if the tree is logically empty.
//     *
//     * @return true if empty, false otherwise.
//     */
//    public boolean isEmpty() {
//        return root == null;
//    }
//
//    /**
//     * Print the tree contents in sorted order.
//     */
//    public void printTree() {
//        if (isEmpty()) {
//            System.out.println("Empty tree");
//        } else {
//            printTree(root);
//        }
//    }
//
//    /**
//     * Internal method to get element field.
//     *
//     * @param t the node.
//     * @return the element field or null if t is null.
//     */
//    private E elementAt(dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> t) {
//        if (t == null)
//            return null;
//        return t.info;
//    }
//
//    /**
//     * Internal method to insert into a subtree.
//     *
//     * @param x the item to insert.
//     * @param t the node that roots the tree.
//     * @return the new root.
//     */
//    private dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> insert(E x, dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> t) {
//        if (t == null) {
//            t = new dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E>(x, null, null);
//        } else if (x.compareTo(t.info) < 0) {
//            t.left = insert(x, t.left);
//        } else if (x.compareTo(t.info) > 0) {
//            t.right = insert(x, t.right);
//        } else ;  // Duplicate; do nothing
//        return t;
//    }
//
//    /**
//     * Internal method to remove from a subtree.
//     *
//     * @param x the item to remove.
//     * @param t the node that roots the tree.
//     * @return the new root.
//     */
//    @SuppressWarnings({"raw", "unchecked"})
//    private dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> remove(Comparable x, dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> t) {
//        if (t == null)
//            return t;   // Item not found; do nothing
//
//        if (x.compareTo(t.info) < 0) {
//            t.left = remove(x, t.left);
//        } else if (x.compareTo(t.info) > 0) {
//            t.right = remove(x, t.right);
//        } else if (t.left != null && t.right != null) { // Two children
//            t.info = findMin(t.right).info;
//            t.right = remove(t.info, t.right);
//        } else {
//            if (t.left != null)
//                return t.left;
//            else
//                return t.right;
//        }
//        return t;
//    }
//
//    /**
//     * Internal method to find the smallest item in a subtree.
//     *
//     * @param t the node that roots the tree.
//     * @return node containing the smallest item.
//     */
//    private dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> findMin(dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> t) {
//        if (t == null) {
//            return null;
//        } else if (t.left == null) {
//            return t;
//        }
//        return findMin(t.left);
//    }
//
//    /**
//     * Internal method to find the largest item in a subtree.
//     *
//     * @param t the node that roots the tree.
//     * @return node containing the largest item.
//     */
//    private dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> findMax(dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> t) {
//        if (t == null) {
//            return null;
//        } else if (t.right == null) {
//            return t;
//        }
//        return findMax(t.right);
//    }
//
//    /**
//     * Internal method to find an item in a subtree.
//     *
//     * @param x is item to search for.
//     * @param t the node that roots the tree.
//     * @return node containing the matched item.
//     */
//    private dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> find(E x, dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> t) {
//        if (t == null)
//            return null;
//
//        if (x.compareTo(t.info) < 0) {
//            return find(x, t.left);
//        } else if (x.compareTo(t.info) > 0) {
//            return find(x, t.right);
//        } else {
//            return t;    // Match
//        }
//    }
//
//    /**
//     * Internal method to print a subtree in sorted order.
//     *
//     * @param t the node that roots the tree.
//     */
//    private void printTree(dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> t) {
//        if (t != null) {
//            printTree(t.left);
//            System.out.println(t.info);
//            printTree(t.right);
//        }
//    }
//
//    public void printTreeWithIndent() {
//        printTreeWithIndent(root, 0);
//    }
//
//    private void printTreeWithIndent(dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> t, int indent) {
//        if (t != null) {
//            printTreeWithIndent(t.left, indent + 1);
//            for (int i = 0; i < indent; i++) System.out.print("   ");
//            System.out.println(t.info);
//            printTreeWithIndent(t.right, indent + 1);
//        }
//    }
//
//    public dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> getRoot() {
//        return root;
//    }
//}
//class BNode<E extends Comparable<E>> {
//
//    public E info;
//    public dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> left;
//    public dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> right;
//
//    public BNode(E info) {
//        this.info = info;
//        left = null;
//        right = null;
//    }
//
//    public BNode(E info, dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> left, dopolnitelni_zadaci_za_vezbanje_pred_ispit.node_distance.BNode<E> right) {
//        this.info = info;
//        this.left = left;
//        this.right = right;
//    }
//
//}
//
//public class Zadaca1 {
//    //    static int inorderSuccessor(){
////
////    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//        for (int i = 0; i < n; i++) {
//            tree.insert(scanner.nextInt());
//        }
//        tree.printTree();
//    }
//}
