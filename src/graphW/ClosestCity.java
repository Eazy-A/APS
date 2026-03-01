package graphW;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ClosestCity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("\\s+");
            String source = parts[0];
            String destination = parts[1];
            int weight = Integer.parseInt(parts[2]);

            graph.addEdge(source, destination, weight);

        }

        String[] parts = scanner.nextLine().split("\\s+");
        String start = parts[0];
        String end = parts[1];

        Set<String> visited = new HashSet<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        Stack<String> path = new Stack<>();
        Map<String, String> parentMap = new HashMap<>();

        PriorityQueue<String> priorityQueue = new PriorityQueue<>((a, b) -> {
            int dista = distanceMap.getOrDefault(a, Integer.MAX_VALUE);
            int distb = distanceMap.getOrDefault(b, Integer.MAX_VALUE);
            return Integer.compare(dista, distb);
        });

        distanceMap.put(start, 0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            String lowestCity = priorityQueue.poll();
            visited.add(lowestCity);
            int currentCityDistance = distanceMap.get(lowestCity);

            Map<String, Integer> neighbors = graph.getNeighbors(lowestCity);

            for (String neighbor : neighbors.keySet()) {
                if (visited.contains(neighbor)) continue;

                int newPath = currentCityDistance + neighbors.get(neighbor);

                if (newPath < distanceMap.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distanceMap.put(neighbor, newPath);
                    priorityQueue.add(neighbor);
                    parentMap.put(neighbor, lowestCity);
                }

            }
        }
        String current = end;
        while (current != null) {
            path.push(current);
            current = parentMap.get(current);
        }
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
        System.out.println();
        System.out.println(distanceMap.getOrDefault(end, -1));

    }

}
