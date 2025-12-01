package book.stack.napredniProblemi.Topcinja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PonistuvanjeTopcinja {

    public void CalculatePairs(String line){
        String[] words = line.split("\\s+");
        Stack<String> red = new Stack<>();
        Stack<String> blue = new Stack<>();
        Stack<String> green = new Stack<>();

        for (String word : words) {
            if (word.contains("R")) {
                if (red.isEmpty() || red.contains(word)) red.push(word);
                else red.pop();
            }
            if (word.contains("B")) {
                if (blue.isEmpty() || blue.contains(word)) blue.push(word);
                else blue.pop();
            }
            if (word.contains("G")) {
                if (green.isEmpty() || green.contains(word)) green.push(word);
                else green.pop();
            }
        }

        System.out.println(red);
        System.out.println(blue);
        System.out.println(green);

        int number = red.size() + blue.size() + green.size();

        System.out.println(number);

        List<String> list = new ArrayList<>();
        for (int i = 0; i <= red.size(); i++) {
            if(red.peek().contains("+")){
                list.add("R-");
            }else if (red.peek().contains("-")){
                list.add("R+");
            }
            red.pop();
        }
        for (int i = 0; i <= green.size(); i++) {
            if(green.peek().contains("+")){
                list.add("G-");
            }else if (green.peek().contains("-")){
                list.add("G+");
            }
            green.pop();
        }
        for (int i = 0; i <= blue.size(); i++) {
            if(blue.peek().contains("+")){
                list.add("B-");
            }else if (blue.peek().contains("-")){
                list.add("B+");
            }
            blue.pop();
        }

        for (String s : list) {
            System.out.print(s + " ");
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        PonistuvanjeTopcinja pt = new PonistuvanjeTopcinja();
        pt.CalculatePairs(line);

    }
}
