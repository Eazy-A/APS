package grafovi;

import graphW.AdjacencyListGraph;

import java.util.Map;
import java.util.Scanner;

public class Zadaca9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[][] pairs = new String[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = scanner.next();
            pairs[i][1] = scanner.next();
        }

        int m = scanner.nextInt();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < m; i++) {
            String from = scanner.next();
            String to = scanner.next();
            int cost = scanner.nextInt();
            graph.addEdge(from, to, cost);
        }

        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            if (pairs[i][0].equals(pairs[i][1])) continue;
            Map<String, Integer> costMap = graph.shortestPath(pairs[i][0]);
            totalCost += costMap.get(pairs[i][1]);
        }

        System.out.println(totalCost);
    }
}
