package _018_Graphs._01_Theory_And_Traversals;

import java.util.ArrayList;

public class _02_Graph_Using_Adjacency_List {

    public static ArrayList<ArrayList<Integer>> buildG(int n, int[][] edge) {

        // Graph = ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialize adjacency list for every vertex
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        for (int i = 0; i < edge.length; i++) {

            int v1 = edge[i][0];
            int v2 = edge[i][1];

            // Undirected graph
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return graph;
    }

    public static void main(String[] args) {

        // Number of vertices
        int n = 5;

        // Number of edges
        int m = 6;

        // Edge array
        int[][] edge = {
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 4},
                {4, 5}
        };

        ArrayList<ArrayList<Integer>> graph = buildG(n, edge);

        // Print graph
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " -> " + graph.get(i));
        }
    }
}