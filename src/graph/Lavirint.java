package graph;

import java.util.Scanner;

public class Lavirint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] parts = firstLine.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        String[][] grid = new String[x][y];
        String startNode = "";
        String endNode = "";

        for (int i = 0; i < x; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < y; j++) {
                String character = String.valueOf(line.charAt(j));
                grid[i][j] = character;
                String vertexName = i + "," + j;
                if (!character.equals("#")) {
                   graph.addVertex(vertexName);
                   if (character.equals("S")) startNode = vertexName;
                   if (character.equals("E")) endNode = vertexName;
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j].equals("#")) continue;

                String currentPos = i + "," + j;

                if (j + 1 < y && !grid[i][j + 1].equals("#")) {
                    String rightNeighbor = i + "," + (j + 1);
                    graph.addEdge(currentPos, rightNeighbor);
                }

                if (i + 1 < x && !grid[i + 1][j].equals("#")) {
                    String downNeighbor = (i + 1) + "," + j;
                    graph.addEdge(currentPos, downNeighbor);
                }
            }
        }
        graph.findPath(startNode, endNode);
    }
}
