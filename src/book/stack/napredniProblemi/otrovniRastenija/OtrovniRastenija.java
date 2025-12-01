package book.stack.napredniProblemi.otrovniRastenija;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class OtrovniRastenija {

    public int howManyDays(List<Integer> plants) {
        int days = 0;
        while (true){
            List<Integer> toRemove = new ArrayList<>();

            for (int i = 1; i < plants.size(); i++) {
                if(plants.get(i) > plants.get(i - 1)){
                    toRemove.add(i);
                }
            }
            if(toRemove.isEmpty()) return days;

            for (int i = toRemove.size() - 1; i >= 0; i--) {
                plants.remove((int)toRemove.get(i));
            }
            days++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> plants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plants.add(scanner.nextInt());
        }

        OtrovniRastenija rastenija = new OtrovniRastenija();
        System.out.println(rastenija.howManyDays(plants));
    }
}
