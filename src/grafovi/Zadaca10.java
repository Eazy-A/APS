package grafovi;

import graphW.AdjacencyListGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Zadaca10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<String> cityList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cityList.add(scanner.next());
        }
        int m = scanner.nextInt();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.next(), scanner.next(), scanner.nextInt());
        }


        System.out.println(graph.prim());


    }
}
