package zadaci_za_vezbaanje_prv_kol;

import java.util.Scanner;
import java.util.Stack;

public class zad4{

    static int precedence(char op){
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }
    static void apply(Stack<Integer> numbers, Stack<Character> operators){
        int a = numbers.pop();
        int b = numbers.pop();
        char op = operators.pop();

        if (op == '+') numbers.push(a + b);
        if (op == '-') numbers.push(b - a);
        if (op == '*') numbers.push(a * b);
        if (op == '/') numbers.push(b / a);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < input.length()){
            char c = input.charAt(i);
            if (Character.isDigit(c)){
                int num = 0;
                while (i < input.length() && Character.isDigit(input.charAt(i))){
                    num = num * 10 + Integer.parseInt(String.valueOf(input.charAt(i)));
                    i++;
                }
                numbers.push(num);
                continue;
            } else if (c == '+' || c == '-' || c == '/' || c == '*') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)){
                    apply(numbers, operators);
                }
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '('){
                    apply(numbers, operators);
                }
                operators.pop();
            }
            i++;
        }
        while (!operators.isEmpty()){
            apply(numbers, operators);
        }
        System.out.println(numbers.pop());
    }
}