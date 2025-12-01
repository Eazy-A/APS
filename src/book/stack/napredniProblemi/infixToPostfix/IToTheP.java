package book.stack.napredniProblemi.infixToPostfix;

import java.util.Scanner;
import java.util.Stack;

public class IToTheP {
    public void transformer(String expression) {
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)){
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }
        while(!operatorStack.isEmpty()){
            postfix.append(operatorStack.pop());
        }
        System.out.println(postfix);

    }

    private int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        IToTheP object = new IToTheP();
        object.transformer(expression);
    }
}
