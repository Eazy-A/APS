package graph;

import java.util.Scanner;

public class Zadaca1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] parts = line.split("\\s+");

        int numVertices = 0;

        if (parts[0].equalsIgnoreCase("create")) {
            numVertices = Integer.parseInt(parts[1]);
            System.out.println("created");
        }

        AdjacencyMatrixGraph<Character> graph = new AdjacencyMatrixGraph<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            graph.addVertex(i, (char) ('A' + i));
        }

        for (int i = 0; i < numCommands; i++) {
            String[] p = scanner.nextLine().split("\\s+");

            switch (p[0]) {
                case "addedge":
                    graph.addEdge(Integer.parseInt(p[1]), Integer.parseInt(p[2]));
                    System.out.println("edge added");
                    break;
                case "deleteedge":
                    graph.removeEdge(Integer.parseInt(p[1]), Integer.parseInt(p[2]));
                    System.out.println("edge deleted");
                    break;
                case "adjacent":
                    System.out.println(graph.isEdge(Integer.parseInt(p[1]), Integer.parseInt(p[2])) ? 1 : 0);
                    break;
                case "printmatrix":
                    graph.printMatrix();
                    break;
                case "printnode":
                    System.out.println(graph.getVertex(Integer.parseInt(p[1])));
                    break;
                default:
                    System.out.println("Nevalidna komanda: " + p[0]);
                    break;
            }
        }
        scanner.close();


    }
}


