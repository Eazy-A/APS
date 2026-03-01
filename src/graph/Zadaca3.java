package graph;

import java.util.*;

public class Zadaca3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");

            String source = parts[0];
            String dest = parts[1];

            graph.addEdge(source, dest);
        }

        String start = scanner.nextLine();

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();
        Stack<String> path = new Stack<>();

        queue.add(start);
        distanceMap.put(start, 0);

        while (!queue.isEmpty()) {
            String lastNode = queue.poll();
            Set<String> neighbors = graph.getNeighbors(lastNode);
            System.out.println("These are the nbrs of " + lastNode + " " + neighbors);
            for (String neighbor : neighbors) {
                if (!distanceMap.containsKey(neighbor)) {
                    int lastDistance = distanceMap.get(lastNode);
                    distanceMap.put(neighbor, lastDistance + 1);
                    parentMap.put(neighbor, lastNode);
                    queue.add(neighbor);
                }
            }
        }

        distanceMap.keySet().forEach(end -> {
            String current = end;
            while (current != null) {
                path.add(current);
                current = parentMap.get(current);
            }
            System.out.print("The path to " + end + ": ");
            while (!path.isEmpty()) {
                System.out.print(path.pop() + " ");
            }
            System.out.println();
        });


    }
}