package book.stack.zad2;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    public double evaluate(String expression) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == ' ') continue;
            else if (Character.isDigit(c)){
                stack.push((double) (c - '0'));
            }else{
                if(stack.size() >= 2){
                    Double lastNumber = stack.pop();
                    Double preLast = stack.pop();
                    if(c == '+') stack.push(lastNumber + preLast);
                    if(c == '-') stack.push(lastNumber - preLast);
                    if(c == '*') stack.push(lastNumber * preLast);
                    if(c == '/') stack.push(lastNumber / preLast);
                }else {
                    System.out.println("No valid input");
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Postfix postfix = new Postfix();
        System.out.println(postfix.evaluate(expression));
    }

}
