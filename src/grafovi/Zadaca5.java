package grafovi;

import java.awt.*;
import java.util.Scanner;
public class Zadaca5 {

    static int dfs(Integer vertex, AdjacencyListGraph<Integer> graph, int remaining){
        if (remaining == 0) return 1;
        if (remaining < 0) return 0;

        int count = 0;
        for (Integer neighbor : graph.getNeighbors(vertex)){
            count += dfs(neighbor, graph, remaining - neighbor);
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        int startVertex = scanner.nextInt();
        int sumToFind = scanner.nextInt();


        System.out.println(dfs(startVertex, graph, sumToFind - startVertex));

    }
}
