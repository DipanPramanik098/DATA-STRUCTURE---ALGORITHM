package _018_Graphs._03_Cycles;

import java.util.ArrayList;
import java.util.Arrays;

public class _04_Detect_Cycle_In_A_Directed_Graph {

    // DFS-based cycle detection
    public static boolean dfs(
            int node,
            ArrayList<ArrayList<Integer>> g,
            int[] vis,
            int[] path
    ) {

        // Mark current node as visited
        vis[node] = 1;

        // Mark current node in the current DFS path
        path[node] = 1;

        // Visit all adjacent nodes
        for (int nbr : g.get(node)) {

            // Neighbour is not visited
            if (vis[nbr] == 0) {

                // If cycle is found in DFS, return true
                if (dfs(nbr, g, vis, path)) {
                    return true;
                }
            }

            // Neighbour is already in current DFS path
            else if (path[nbr] == 1) {

                // Back edge found → cycle exists
                return true;
            }
        }

        // Remove current node from DFS path
        path[node] = 0;

        // No cycle found from this node
        return false;
    }

    // Checks whether the directed graph contains a cycle
    public static boolean isCycleDirected(
            int V,
            ArrayList<ArrayList<Integer>> g
    ) {

        // Visited array
        int[] vis = new int[V];

        // Current DFS path array
        int[] path = new int[V];

        // Initially all nodes are unvisited
        Arrays.fill(vis, 0);
        Arrays.fill(path, 0);

        // Check all vertices for disconnected components
        for (int i = 0; i < V; i++) {

            if (vis[i] == 0) {

                // Start DFS from this unvisited vertex
                if (dfs(i, g, vis, path)) {
                    return true;
                }
            }
        }

        // No cycle found
        return false;
    }

    public static void main(String[] args) {

        // Number of vertices
        int V = 4;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            g.add(new ArrayList<>());
        }

        /*
         * Directed Graph:
         *
         *     0 → 1
         *         ↓
         *         2
         *        ↙
         *       3
         *       ↑
         *       └── 1
         *
         * Cycle: 1 → 2 → 3 → 1
         */

        // Add directed edges
        g.get(0).add(1);
        g.get(1).add(2);
        g.get(2).add(3);
        g.get(3).add(1);

        // Check for cycle
        boolean result = isCycleDirected(V, g);

        // Print result
        if (result) {
            System.out.println("Cycle exists in the directed graph.");
        } else {
            System.out.println("No cycle exists in the directed graph.");
        }
    }
}