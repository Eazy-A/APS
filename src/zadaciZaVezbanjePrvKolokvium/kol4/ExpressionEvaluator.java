package zadaciZaVezbanjePrvKolokvium.kol4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        char operator = '+';
        while (i < expression.length()) {
            int j = i;
            while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                j++;
            }
            int num = Integer.parseInt(expression.substring(i, j));
            i = j;
            if (operator == '+') stack.push(num);
            else if (operator == '*') stack.push(num * stack.pop());

            if (i < expression.length()) {
                operator = expression.charAt(i);
                i++;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}