package book.stack.napredniProblemi.molekuliNaVoda;

import java.util.*;

public class MolekulaNaVoda {

    public void calculateMolecules(String line) {
        String[] words = line.split("\\s+");
        Stack<String> hydrogen = new Stack<>();
        Stack<String> oxygen = new Stack<>();

        Queue<String> queue = new LinkedList<>();
        for (String w : words) {
            if (w.equals("H")) hydrogen.push("H");
            if (w.equals("O")) oxygen.push("O");
        }

        int counter = 0;
        while (hydrogen.size() >= 2 && oxygen.size() >= 1) {
            hydrogen.pop();
            hydrogen.pop();
            oxygen.pop();
            counter++;
        }

        System.out.println(counter);
        System.out.println(hydrogen);
        System.out.println(oxygen);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        new MolekulaNaVoda().calculateMolecules(line);
    }
}
