package _018_Graphs._01_Theory_And_Traversals;

import java.util.ArrayList;

public class _05_DFS {

    // DFS function
    public static void dfs(
            int node,
            ArrayList<ArrayList<Integer>> graph,
            boolean[] visited) {

        // Mark current node as visited
        visited[node] = true;

        // Process current node
        System.out.print(node + " ");

        // Visit all adjacent nodes
        for (int neighbour : graph.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, graph, visited);
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 4},
                {4, 5}
        };

        // Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Visited array
        boolean[] visited = new boolean[n + 1];

        // Start DFS from vertex 1
        System.out.print("DFS: ");
        dfs(1, graph, visited);
    }
}