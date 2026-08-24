
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _03_Bipartite_Graph {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create undirected graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *      0 ------- 1
         *      |         |
         *      |         |
         *      3 ------- 2
         *
         * Bipartite:
         *
         * Color 0 → {0, 2}
         * Color 1 → {1, 3}
         */

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3));
    }

    // BFS to check one connected component
    static boolean bfs(ArrayList<Edge>[] graph, int src, int[] color) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(src);

        // Give first node color 0
        color[src] = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (Edge e : graph[curr]) {

                int neighbour = e.dest;

                // Neighbour is not colored
                if (color[neighbour] == -1) {

                    // Give opposite color
                    color[neighbour] = 1 - color[curr];

                    q.offer(neighbour);
                }

                // Same color on both ends of an edge
                // => Not Bipartite
                else if (color[neighbour] == color[curr]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Handles disconnected graph
    static boolean isBipartite(ArrayList<Edge>[] graph) {

        int[] color = new int[graph.length];

        // -1 means node is not colored yet
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }

        // Check every connected component
        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("Is Bipartite: " + isBipartite(graph));
    }
}