package kol1_2024.vlezna.soStack;


// Stack
//
//Најди ја фунцкијата што повикува највеќе фунцкии во неа. Секоја фунцкија има Call x - x е името на фунцкијата - и Return.
//
//Input
//12
//Call a
//Call b
//Call c
//Return
//Call d
//Return
//Call e
//Return
//Return
//Call f
//Return
//Return
//
//Output
//b 3
//
//Објаснување: во b се повикани c d и e
import java.util.*;

public class Funkcii {

    static class Func {
        String name;
        int count;
        Func(String name) { this.name = name; this.count = 0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Stack<String> stack = new Stack<>();
        List<Func> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String op = parts[0];

            if (op.equals("Call")) {
                String f = parts[1];

                // find or create function
                Func curr = null;
                for (Func x : list)
                    if (x.name.equals(f)) curr = x;

                if (curr == null) {
                    curr = new Func(f);
                    list.add(curr);
                }

                // increase counter of caller
                if (!stack.isEmpty()) {
                    String caller = stack.peek();
                    for (Func x : list)
                        if (x.name.equals(caller)) x.count++;
                }

                stack.push(f);

            } else { // Return
                stack.pop();
            }
        }

        // find function with most calls
        Func best = list.get(0);
        for (Func x : list)
            if (x.count > best.count) best = x;

        System.out.println(best.name + " " + best.count);
    }
}


