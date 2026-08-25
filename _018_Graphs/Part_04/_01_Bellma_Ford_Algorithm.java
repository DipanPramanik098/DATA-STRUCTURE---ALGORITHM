
import java.util.ArrayList;
import java.util.Arrays;

public class _01_Bellma_Ford_Algorithm {

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

    // Create weighted directed graph
    static void createGraph(ArrayList<Edge> edges) {

        /*
         * 0 --2--> 1
         * |        |
         * 4       -4
         * ↓        ↓
         * 2 --2--> 3 --4--> 4
         */

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 3, -4));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 4));
    }

    static int[] bellmanFord(ArrayList<Edge> edges, int V, int src) {

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Relax all edges V - 1 times
        for (int i = 1; i <= V - 1; i++) {

            for (Edge e : edges) {

                if (dist[e.src] != Integer.MAX_VALUE
                        && dist[e.src] + e.wt < dist[e.dest]) {

                    dist[e.dest] = dist[e.src] + e.wt;
                }
            }
        }

        // Check Negative Weight Cycle
        for (Edge e : edges) {

            if (dist[e.src] != Integer.MAX_VALUE
                    && dist[e.src] + e.wt < dist[e.dest]) {

                System.out.println("Negative Weight Cycle Exists");
                return null;
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 5;
        int src = 0;

        ArrayList<Edge> edges = new ArrayList<>();

        createGraph(edges);

        int[] dist = bellmanFord(edges, V, src);

        if (dist != null) {

            for (int i = 0; i < V; i++) {
                System.out.println(
                        src + " -> " + i + " = " + dist[i]
                );
            }
        }
    }
}