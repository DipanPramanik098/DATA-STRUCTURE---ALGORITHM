package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class _10_Number_Of_provinces {
    // https://leetcode.com/problems/number-of-provinces/description/
    // DFS Traversal
    public static void dfs(HashMap<Integer, ArrayList<Integer>> graph,
                           int node,
                           HashSet<Integer> vis) {

        // Mark current node as visited
        vis.add(node);

        // Visit all unvisited neighbors
        for (int nbr : graph.get(node)) {
            if (!vis.contains(nbr)) {
                dfs(graph, nbr, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        /*
         * Step 1: Create Graph
         * Key   -> City
         * Value -> List of connected cities
         */
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        int n = isConnected.length;

        // Initialize graph
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        /*
         * Step 2: Convert Adjacency Matrix
         * into Adjacency List (HashMap Graph)
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (isConnected[i][j] == 1) {

                    // Add edge i -> j
                    graph.get(i + 1).add(j + 1);

                    // Add edge j -> i
                    // (Undirected Graph)
                    graph.get(j + 1).add(i + 1);
                }
            }
        }

        /*
         * Step 3:
         * Count Connected Components
         * Each connected component = 1 Province
         */
        int provinces = 0;

        HashSet<Integer> vis = new HashSet<>();

        for (int city = 1; city <= n; city++) {

            // New unvisited city found
            if (!vis.contains(city)) {

                // Visit entire component
                dfs(graph, city, vis);

                // One province completed
                provinces++;
            }
        }

        return provinces;
    }
}