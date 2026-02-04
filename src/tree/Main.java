package tree;

import com.sun.source.tree.Tree;

import javax.sound.midi.MidiFileFormat;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.time.temporal.Temporal;
import java.util.Map;
import java.util.Scanner;

class TreeNode<T extends Comparable<T>> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

class BinaryTree<T extends Comparable<T>> {
    protected TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public void makeRoot(T data) {
        root = new TreeNode<T>(data);
    }

    private void preorder(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data.toString() + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void preorder() {
        System.out.println("Preorder traversal: ");
        preorder(root);
        System.out.println();
    }

    private void inorder(TreeNode<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data.toString() + " ");
            inorder(node.right);
        }
    }

    public void inorder() {
        System.out.println("Inorder traversal: ");
        inorder(root);
        System.out.println();
    }

    private void postorder(TreeNode<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data.toString() + " ");
        }
    }

    public void postorder() {
        System.out.println("Postorder traversal: ");
        postorder(root);
        System.out.println();
    }

    public TreeNode<T> addLeftChild(T x, TreeNode<T> parent) {
        TreeNode<T> newNode = new TreeNode<>(x);

        if (parent == null) {
            this.root = newNode;
            System.out.println("Added " + x + " as the root.");
        } else {
            newNode.left = parent.left;
            parent.left = newNode;
            System.out.println("Added " + x + " as the left child of " + parent.data);
        }
        return newNode;
    }

    public TreeNode<T> addRightChild(T x, TreeNode<T> parent) {
        TreeNode<T> newNode = new TreeNode<>(x);

        if (parent == null) {
            this.root = newNode;
            System.out.println("Added " + x + " as the root.");
        } else {
            newNode.right = parent.right;
            parent.right = newNode;
            System.out.println("Added " + x + " as the right child of " + parent.data);
        }
        return newNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        toStringHelper(sb, this.root, 0, 7);

        return sb.toString();
    }

    private void toStringHelper(StringBuilder sb, TreeNode<T> node, int space, int count) {
        if (node == null) return;

        space += count;

        toStringHelper(sb, node.right, space, count);

        sb.append("\n");
        sb.append(" ".repeat(Math.max(0, space - count)));
        sb.append(node.data).append("\n");

        toStringHelper(sb, node.left, space, count);
    }

    public TreeNode<T> findNode(TreeNode<T> n, T key) {
        if (n == null) return null;

        if (n.data.equals(key)) return n;

        TreeNode<T> foundLeft = findNode(n.left, key);

        if (foundLeft != null) {
            return foundLeft;
        }

        return findNode(n.right, key);
    }

    public void findNode(T data) {
        if (findNode(root, data) != null)
            System.out.println("Node with value " + data + " exists in the given binary tree");
        else
            System.out.println("Node with value " + data + " does not exist in the given binary tree");
    }

    private int findLevel(TreeNode<T> node, T key, int level) {
        if (node == null) return 0;
        if (node.data.equals(key)) return level;

        int tempLevel = findLevel(node.left, key, level + 1);
        if (tempLevel != 0) return tempLevel;
        return findLevel(node.right, key, level + 1);
    }

    public int findLevel(T key) {
        return findLevel(root, key, 1);
    }

    public int sum(TreeNode<Integer> node) {
        if (node == null) return 0;
        return (node.data + sum(node.left) + sum(node.right));
    }

}

public class Main {
    // primer 5
    public static int sumSmallerInLeftSubtree(TreeNode<Integer> node) {
        if (node == null || node.left == null) return 0;
        return summingFunction(node.left, node.data, true);
    }

    public static int sumGreaterInRightSubtree(TreeNode<Integer> node) {
        return summingFunction(node.right, node.data, false);
    }

    private static int summingFunction(TreeNode<Integer> node, int threshold, boolean isSmaller) {
        if (node == null) return 0;

        int currentVal = 0;
        if (isSmaller) {
            if (node.data < threshold) currentVal = node.data;
        } else {
            if (node.data > threshold) currentVal = node.data;
        }
        return currentVal + summingFunction(node.left, threshold, isSmaller) + summingFunction(node.right, threshold, isSmaller);
    }

    // primer  6
    public static int distanceBetweenNodes(TreeNode<Integer> root, int first, int second) {
        if (root == null) return -1;
        TreeNode<Integer> lca = findLCA(root, first, second);
        if (lca == null) return -1;
        int distance1 = getLevel(lca, first, 0);
        int distance2 = getLevel(lca, second, 0);

        return distance1 + distance2;
    }

    public static int getLevel(TreeNode<Integer> node, int value, int level) {
        if (node == null) return -1;
        if (node.data == value) return level;

        int left = getLevel(node.left, value, level + 1);
        if (left != -1) return left;

        return getLevel(node.right, value, level + 1);
    }

    public static TreeNode<Integer> findLCA(TreeNode<Integer> node, int first, int second) {
        if (node == null) return null;
        if (node.data == first || node.data == second) return node;

        TreeNode<Integer> leftLca = findLCA(node.left, first, second);
        TreeNode<Integer> rightLca = findLCA(node.right, first, second);

        if (leftLca != null && rightLca != null) return node;
        return (leftLca != null) ? leftLca : rightLca;
    }
    // zad1
    public static int sumNodesWithOnlyLeftChild(TreeNode<Integer> node){
        if (node == null) return 0;

        int currentVal = 0;
        if (node.left != null && node.right == null)  currentVal += node.data;

        return currentVal + sumNodesWithOnlyLeftChild(node.left) + sumNodesWithOnlyLeftChild(node.right);
    }
    // zad2
    public static int checkSumTree(TreeNode<Integer> node){
        if (node == null) return 0;

        if (node.left == null && node.right == null) return node.data;

        int leftSum = checkSumTree(node.left);
        int rightSum = checkSumTree(node.right);

        if (leftSum == -1 || rightSum == -1) return -1;

        if (node.data == leftSum + rightSum){
            return node.data + leftSum + rightSum;
        }else{
            return -1;
        }
    }
    public static boolean isSumTree(TreeNode<Integer> node){
        return checkSumTree(node) != -1;
    }
    public static void main(String[] args) {
        TreeNode<Integer> temp1, temp2, temp3;

        BinaryTree<Integer> tree = new BinaryTree<>();


        tree.makeRoot(26);

        temp1 = tree.addLeftChild(10, tree.root);

        temp2 = tree.addLeftChild(4, temp1);

        temp3 = tree.addRightChild(6, temp1);

        temp1 = tree.addRightChild(3, tree.root);

        temp2 = tree.addRightChild(3, temp1);


        Scanner scanner = new Scanner(System.in);
        System.out.println(tree.toString());
        System.out.println(isSumTree(tree.root));
    }
}


