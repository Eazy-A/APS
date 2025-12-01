package labs.auds2.DLL;

import java.util.Scanner;

public class Palindrome<E> {
        /*public int isPalindrome(DLL<E> list){
            DLLNode<E> start = list.getFirst();
            DLLNode<E> end = list.getLast();
            StringBuilder startString = new StringBuilder();
            StringBuilder endString = new StringBuilder();

            while(start != null){
                startString.append(start.element);
                start = start.succ;
            }

            while (end != null){
                endString.append(end.element);
                end = end.pred;
            }

            if(startString.compareTo(endString) == 0) return 1;
            else return -1;
        }*/

    public int isPalindrome(DLL<E> list) {
        DLLNode<E> start = list.getFirst();
        DLLNode<E> end = list.getLast();

        while (start != null && end != null) {
            if (!(start.element.equals(end.element))) return -1;
            start = start.succ;
            end = end.pred;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        scanner.close();
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(list));
    }
}
