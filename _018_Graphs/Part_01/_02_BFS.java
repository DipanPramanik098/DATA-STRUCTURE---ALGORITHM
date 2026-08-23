package _018_Graphs.Part_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _02_BFS {

    // Edge class
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create Graph using Adjacency List
    static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize every index with an empty ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         * Graph:
         *
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

    // BFS Traversal
    static void bfs(ArrayList<Edge>[] graph, int start) {

        // Queue stores vertices that need to be processed
        Queue<Integer> queue = new LinkedList<>();

        // visited[i] = true means vertex i is already visited
        boolean[] visited = new boolean[graph.length];

        // Start BFS from given vertex
        queue.offer(start);

        while (!queue.isEmpty()) {

            // Remove first vertex from queue
            int current = queue.poll();

            // Process only if not already visited
            if (!visited[current]) {

                // Mark as visited
                visited[current] = true;

                // Print current vertex
                System.out.print(current + " ");

                // Add all unvisited neighbours into queue
                for (Edge edge : graph[current]) {

                    int neighbour = edge.dest;

                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 5;

        ArrayList<Edge>[] graph = new ArrayList[vertices];

        // Build graph
        createGraph(graph);

        // BFS starting from vertex 0
        bfs(graph, 0);
    }
}