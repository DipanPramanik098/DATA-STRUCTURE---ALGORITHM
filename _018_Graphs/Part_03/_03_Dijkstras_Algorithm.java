
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _03_Dijkstras_Algorithm {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Stores vertex and current shortest distance
    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        // Minimum distance should come first
        @Override
        public int compareTo(Pair other) {
            return this.dist - other.dist;
        }
    }

    // Create weighted directed graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *       2
         *   0 -----> 1
         *   |        |
         *  4|        |7
         *   ↓        ↓
         *   2 -----> 3
         *      1     |
         *            |3
         *            ↓
         *            4
         */

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 4, 3));
    }

    static int[] dijkstra(ArrayList<Edge>[] graph, int src) {

        int V = graph.length;

        // dist[i] = shortest distance from src to i
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance from source to itself = 0
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair pair = pq.poll();

            int curr = pair.node;
            int currDist = pair.dist;

            // Ignore outdated PriorityQueue entry
            if (currDist > dist[curr]) {
                continue;
            }

            // Check all outgoing edges
            for (Edge e : graph[curr]) {

                int neighbour = e.dest;
                int weight = e.wt;

                // Relaxation
                if (dist[curr] + weight < dist[neighbour]) {

                    dist[neighbour] = dist[curr] + weight;

                    pq.offer(
                            new Pair(neighbour, dist[neighbour])
                    );
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int src = 0;

        int[] dist = dijkstra(graph, src);

        // Print shortest distance from source
        for (int i = 0; i < V; i++) {
            System.out.println(
                    src + " -> " + i + " = " + dist[i]
            );
        }
    }
}