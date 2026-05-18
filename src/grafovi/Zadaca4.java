package grafovi;

import javax.swing.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Zadaca4 {

    static void dfs(String vertex, Set<String> visited, AdjacencyListGraph<String> graph){
        visited.add(vertex);
        for (String neighbor : graph.getNeighbors(vertex)){
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, graph);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        scanner.nextLine();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.next(), scanner.next());
        }

        int k = scanner.nextInt();

        for (int i = 0; i < k; i++) {
            graph.removeEdge(scanner.next(), scanner.next());
        }

        Set<String> visited = new HashSet<>();
        int count = 0;

        for (String vertex : graph.adjacencyList.keySet()){
            if (!visited.contains(vertex)){
                count++;
                dfs(vertex, visited, graph);
            }
        }

        System.out.println(count);


    }
}
