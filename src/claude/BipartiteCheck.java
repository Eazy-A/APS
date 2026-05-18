package claude;
import java.util.*;

public class BipartiteCheck {

    static boolean bfs(String startVertex, AdjacencyListGraph<String> graph,  Set<String> visited){
        Queue<String> queue = new LinkedList<>();

        Map<String, Integer> color = new HashMap<>();

        visited.add(startVertex);
        queue.add(startVertex);
        color.put(startVertex, 1);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            int currentColor = color.get(vertex);
            int neighborColor = currentColor == 1 ? 2 : 1;

            for (String neighbor : graph.getNeighbors(vertex).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    color.put(neighbor, neighborColor);
                } else if (color.get(neighbor) == currentColor) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < m; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String from = parts[0];
            String to = parts[1];

            graph.addEdge(from, to, 0);
        }

        Set<String> visited = new HashSet<>();
        boolean bipartite = true;

        for (String vertex : graph.adjacencyList.keySet()){
            if (!visited.contains(vertex)){
                if (!bfs(vertex, graph, visited)){
                    bipartite = false;
                    break;
                }
            }
        }

        System.out.println(bipartite ? "YES" : "NO");
    }
}
