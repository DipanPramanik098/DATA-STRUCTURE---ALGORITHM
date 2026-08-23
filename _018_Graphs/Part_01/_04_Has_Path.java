package _018_Graphs.Part_01;

import java.util.ArrayList;

public class _04_Has_Path {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

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

    // Check whether a path exists from src to dest using DFS
    static boolean hasPath(
            ArrayList<Edge>[] graph,
            int src,
            int dest,
            boolean[] visited) {

        // Destination reached
        if (src == dest) {
            return true;
        }

        // Mark current node visited
        visited[src] = true;

        // Explore all neighbours
        for (Edge edge : graph[src]) {

            int neighbour = edge.dest;

            if (!visited[neighbour]) {

                // If destination is found through this neighbour
                if (hasPath(graph, neighbour, dest, visited)) {
                    return true;
                }
            }
        }

        // No path found
        return false;
    }

    public static void main(String[] args) {

        int v = 5;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        int src = 0;
        int dest = 4;

        boolean[] visited = new boolean[v];

        System.out.println(hasPath(graph, src, dest, visited));
    }
}