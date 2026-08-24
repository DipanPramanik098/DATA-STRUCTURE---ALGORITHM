
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _01_KahnsAlgo {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create Directed Acyclic Graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *      5 ----→ 0 ←---- 4
         *      |               |
         *      ↓               ↓
         *      2 ----→ 3 ----→ 1
         */

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
    }

    // Calculate indegree of every vertex
    static void calculateIndegree(ArrayList<Edge>[] graph, int[] indegree) {

        for (int i = 0; i < graph.length; i++) {

            for (Edge e : graph[i]) {
                indegree[e.dest]++;
            }
        }
    }

    // Kahn's Algorithm - BFS Topological Sort
    static void kahnsAlgo(ArrayList<Edge>[] graph) {

        int[] indegree = new int[graph.length];

        calculateIndegree(graph, indegree);

        Queue<Integer> q = new LinkedList<>();

        // Add all vertices whose indegree = 0
        for (int i = 0; i < graph.length; i++) {

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int curr = q.poll();

            System.out.print(curr + " ");

            // Remove curr logically from graph
            for (Edge e : graph[curr]) {

                indegree[e.dest]--;

                // If indegree becomes 0,
                // it is ready to be processed
                if (indegree[e.dest] == 0) {
                    q.offer(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("Topological Sort using Kahn's Algorithm:");

        kahnsAlgo(graph);
    }
}