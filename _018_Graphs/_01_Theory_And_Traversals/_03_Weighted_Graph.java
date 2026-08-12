package _018_Graphs._01_Theory_And_Traversals;

import java.util.ArrayList;

public class _03_Weighted_Graph {

    // Stores: neighbour + weight
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + node + ", " + weight + ")";
        }
    }

    public static ArrayList<ArrayList<Pair>> buildGraph(
            int n, int[][] edges) {

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            // Undirected weighted graph
            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

        return graph;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
                {1, 2, 5},
                {1, 3, 3},
                {2, 4, 7},
                {2, 5, 2},
                {3, 4, 4},
                {4, 5, 6}
        };

        ArrayList<ArrayList<Pair>> graph = buildGraph(n, edges);

        // Print graph
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " -> " + graph.get(i));
        }
    }
}