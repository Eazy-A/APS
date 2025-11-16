package kol1.excercises.first.checkParentheses;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesCheck {
    public static boolean areParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else if(c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        if(areParenthesesBalanced(expression)){
            System.out.println("Balanced");
        }else{
            System.out.println("Not balanced");
        }
    }
}
