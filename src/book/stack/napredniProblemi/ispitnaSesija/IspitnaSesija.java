package book.stack.napredniProblemi.ispitnaSesija;

import java.util.*;

public class IspitnaSesija {


    public void premestuvanja(Stack<String> knigi, Queue<String> ispiti) {
        Stack<String> tmp = new Stack<>();
        Stack<Integer> moves = new Stack<>(); // parallel stack for move counts

        // initialize moves stack with 0 for each book
        Stack<String> original = new Stack<>();
        for (String b : knigi) {
            original.push(b);
            moves.push(0);
        }
        Collections.reverse(original); // because stack pushes reverse order
        Collections.reverse(moves);

        knigi = original; // replace knigi with fixed order

        while (!ispiti.isEmpty()) {
            String x = ispiti.poll();
            Stack<Integer> tmpMoves = new Stack<>();

            // pop books above target
            while (!knigi.isEmpty() && !knigi.peek().equals(x)) {
                tmp.push(knigi.pop());
                tmpMoves.push(moves.pop() + 1); // increment move
            }

            // pop target book
            if (!knigi.isEmpty()) {
                knigi.pop();
                moves.pop();
            }

            // restore popped books
            while (!tmp.isEmpty()) {
                knigi.push(tmp.pop());
                moves.push(tmpMoves.pop());
            }

            // put exam book on top
            knigi.push(x);
            moves.push(1); // exam book moved once
        }

        // print results
        Stack<String> knigiCopy = new Stack<>();
        Stack<Integer> movesCopy = new Stack<>();
        while (!knigi.isEmpty()) {
            knigiCopy.push(knigi.pop());
            movesCopy.push(moves.pop());
        }
        while (!knigiCopy.isEmpty()) {
            System.out.println(knigiCopy.pop() + " moved " + movesCopy.pop() + " times");
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); // broj na knigi
        int n = scanner.nextInt(); // broj na ispiti

        Stack<String> knigi = new Stack<>();
        Queue<String> ispiti = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            knigi.push(scanner.next());
        }
        for (int i = 0; i < n; i++) {
            ispiti.offer(scanner.next());
        }

        IspitnaSesija ispitnaSesija = new IspitnaSesija();
        ispitnaSesija.premestuvanja(knigi, ispiti);
    }
}
