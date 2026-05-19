package grafovi;

import java.util.*;

public class Zadaca7 {

    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> moduleTimeMap = new HashMap<>();
    static Map<String, Integer> memorizationMap = new HashMap<>();

    static int calculateCompileTime(String module){
        if (memorizationMap.containsKey(module)) return memorizationMap.get(module);

        int compileTime = 0;

        for (String dependentModule : graph.get(module)){
            compileTime = Math.max(
              compileTime,
              calculateCompileTime(dependentModule)
            );
        }

        int totalCompileTime = moduleTimeMap.get(module) + compileTime;

        memorizationMap.put(module, totalCompileTime);

        return totalCompileTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String module = scanner.next();
            int duration = scanner.nextInt();

            moduleTimeMap.put(module, duration);
            graph.put(module, new ArrayList<>());
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            String firstModule = scanner.next();
            String dependantModule = scanner.next();

            graph.get(firstModule).add(dependantModule);
        }

        int minCompileTime = 0;

        for (String module : graph.keySet()){
            minCompileTime = Math.max(
                    minCompileTime,
                    calculateCompileTime(module)
            );
        }

        System.out.println(minCompileTime);

    }
}
