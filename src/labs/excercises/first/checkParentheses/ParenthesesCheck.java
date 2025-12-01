package labs.excercises.first.checkParentheses;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesCheck {
    public static boolean areParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char parenthesis = expression.charAt(i);
            if(parenthesis == '(' || parenthesis == '{' || parenthesis == '[' ){
                stack.push(parenthesis);
            } else if (parenthesis == ')' || parenthesis == '}' || parenthesis == ']') {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((parenthesis == ')' && top != '(') ||
                        (parenthesis == '}' && top != '{')
                || (parenthesis == ']' && top != '[')){
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
