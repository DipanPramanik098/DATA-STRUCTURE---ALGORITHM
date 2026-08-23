package _018_Graphs.Part_01;

import java.util.ArrayList;

public class _03_DFS {

    // Edge of the graph
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create adjacency list
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *      0
         *     / \
         *    1   2
         *    |   |
         *    3---4
         */

        // Undirected edges
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 2));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    // Depth First Search
    static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {

        // Mark current node as visited
        visited[curr] = true;

        // Process current node
        System.out.print(curr + " ");

        // Visit all unvisited neighbours
        for (Edge edge : graph[curr]) {

            int neighbour = edge.dest;

            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {

        int v = 5;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        boolean[] visited = new boolean[v];

        // Start DFS from vertex 0
        dfs(graph, 0, visited);
    }
}