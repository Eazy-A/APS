package labs.lab5.l5odDoma;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mreza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, Integer> networkMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] words = scanner.nextLine().trim().split("\\.");
            String network = words[0] + "." + words[1] + "." + words[2];
            networkMap.put(network, networkMap.getOrDefault(network, 0) + 1);
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            String[] words = scanner.nextLine().trim().split("\\.");
            String network = words[0] + "." + words[1] + "." + words[2];
            System.out.println(networkMap.getOrDefault(network, 0));
        }
    }
}
