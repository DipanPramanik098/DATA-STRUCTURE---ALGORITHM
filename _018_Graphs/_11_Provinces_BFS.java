package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _11_Provinces_BFS {
    // https://leetcode.com/problems/number-of-provinces/description/

    // BFS Traversal
    public static void bfs(HashMap<Integer, ArrayList<Integer>> graph,
                           int start,
                           HashSet<Integer> vis) {

        Queue<Integer> q = new LinkedList<>();

        // Mark source as visited and add to queue
        vis.add(start);
        q.offer(start);

        while (!q.isEmpty()) {

            int node = q.poll();

            // Visit all neighbors
            for (int nbr : graph.get(node)) {

                if (!vis.contains(nbr)) {

                    vis.add(nbr);
                    q.offer(nbr);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        /*
         * Step 1: Create Graph
         * Key   -> City
         * Value -> Connected Cities
         */
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        int n = isConnected.length;

        // Initialize graph
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        /*
         * Step 2:
         * Convert Adjacency Matrix
         * into Adjacency List
         */
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (isConnected[i][j] == 1) {

                    // Add edge i -> j
                    graph.get(i + 1).add(j + 1);

                    // Add edge j -> i
                    // Undirected Graph
                    graph.get(j + 1).add(i + 1);
                }
            }
        }

        /*
         * Step 3:
         * Count Connected Components
         * using BFS
         */
        int provinces = 0;

        HashSet<Integer> vis = new HashSet<>();

        for (int city = 1; city <= n; city++) {

            if (!vis.contains(city)) {

                // Traverse entire component
                bfs(graph, city, vis);

                // One province found
                provinces++;
            }
        }

        return provinces;
    }
}