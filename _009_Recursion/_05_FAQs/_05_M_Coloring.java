package _009_Recursion._05_FAQs;

import java.util.*;

public class _05_M_Coloring {

    // Check if current color can be assigned to the node
    public static boolean isSafe(int node, int color, int[] colors, List<List<Integer>> adj) {

        // Check all adjacent nodes
        for (int neighbor : adj.get(node)) {
            if (colors[neighbor] == color) {
                return false;
            }
        }

        return true;
    }

    // Recursive function to color nodes
    public static boolean solve(int node, int m, int n, int[] colors, List<List<Integer>> adj) {

        // ✅ All nodes are colored
        if (node == n) {
            return true;
        }

        // Try every color from 1 to m
        for (int color = 1; color <= m; color++) {

            if (isSafe(node, color, colors, adj)) {

                // Assign color
                colors[node] = color;

                // Recur for next node
                if (solve(node + 1, m, n, colors, adj)) {
                    return true;
                }

                // Backtrack
                colors[node] = 0;
            }
        }

        return false;
    }

    // Main function
    public static boolean graphColoring(int[][] edges, int m, int n) {

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // colors[i] = assigned color of node i
        int[] colors = new int[n];

        return solve(0, m, n, colors, adj);
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {0, 2}, {2, 3}, {2, 4}, {3, 4}
        };

        int n = 5;
        int m = 3;

        System.out.println(graphColoring(edges, m, n)); // true
    }
}