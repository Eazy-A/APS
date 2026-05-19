package grafovi;

import java.util.*;

public class Zadaca6 {

    static int calculateCompletionTime(String task) {
        if (memorizationMap.containsKey(task)) return memorizationMap.get(task);

        int longestDependantChain = 0;

        for (String dependantTask : graph.get(task)){
            longestDependantChain = Math.max(
                    longestDependantChain,
                    calculateCompletionTime(dependantTask)
            );
        }

        int totalCompletionTime =
                durationsMap.get(task) + longestDependantChain;

        memorizationMap.put(task, totalCompletionTime);

        return totalCompletionTime;
    }

    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> durationsMap = new HashMap<>();
    static Map<String, Integer> memorizationMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String taskName = scanner.next();
            int duration = scanner.nextInt();
            durationsMap.put(taskName, duration);
            graph.put(taskName, new ArrayList<>());
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            String dependantTask = scanner.next();
            String firstTask = scanner.next();
            graph.get(firstTask).add(dependantTask);
        }

        int minimumProjectCompletionTime = 0;
        for (String task : graph.keySet()) {
            minimumProjectCompletionTime = Math.max(
                    minimumProjectCompletionTime,
                    calculateCompletionTime(task)
            );
        }

        System.out.println(minimumProjectCompletionTime);
    }
}