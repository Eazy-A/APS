package book.stack.napredniProblemi.dupliZagradi;

import java.util.Scanner;
import java.util.Stack;

public class DoubleParenthesis {

//    public boolean hasDoubleParenthesis(String expression) {
//        return expression.contains("((") || expression.contains("))");
//    }

    public boolean hasDoubleParenthesis(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == ')') {
                if (stack.peek() == '(') return true;
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        DoubleParenthesis dp = new DoubleParenthesis();
        if (dp.hasDoubleParenthesis(expression)) {
            System.out.println("Najdeni se dupli zagradi");
        } else {
            System.out.println("/");
        }
    }
}
