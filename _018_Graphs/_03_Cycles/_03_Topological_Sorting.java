package _018_Graphs._03_Cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class _03_Topological_Sorting {

    // DFS function for Topological Sort
    public static void dfs(
            int node,
            int[] vis,
            Stack<Integer> st,
            ArrayList<ArrayList<Integer>> g) {
        // Mark the current node as visited
        vis[node] = 1;

        // Visit all adjacent nodes
        for (int nbr : g.get(node)) {

            // If the neighbour is not visited, perform DFS
            if (vis[nbr] == 0) {
                dfs(nbr, vis, st, g);
            }
        }

        /*
         * Push the node after visiting all its neighbours.
         * This ensures that a node comes before its dependencies
         * in the reversed DFS finishing order.
         */
        st.push(node);
    }

    // Returns the Topological Ordering of the graph
    public static int[] toposort(
            int V,
            ArrayList<ArrayList<Integer>> g) {
        Stack<Integer> st = new Stack<>();

        // Stores the final topological ordering
        int[] ans = new int[V];

        // Visited array
        int[] vis = new int[V];
        Arrays.fill(vis, 0);

        // Run DFS from every unvisited vertex
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, g);
            }
        }

        // Pop elements from stack to get topological order
        int i = 0;

        while (!st.isEmpty()) {
            ans[i] = st.pop();
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
         * Example Directed Graph:
         *
         * 5 → 0
         * ↓
         * 2 → 3
         * ↓
         * 1
         *
         * 4 → 1
         * 4 → 0
         */

        int V = 6;

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            g.add(new ArrayList<>());
        }

        // Add directed edges
        g.get(5).add(0);
        g.get(5).add(2);
        g.get(4).add(0);
        g.get(4).add(1);
        g.get(2).add(3);
        g.get(3).add(1);

        // Get topological ordering
        int[] ans = toposort(V, g);

        // Print the result
        System.out.println("Topological Sort:");

        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}