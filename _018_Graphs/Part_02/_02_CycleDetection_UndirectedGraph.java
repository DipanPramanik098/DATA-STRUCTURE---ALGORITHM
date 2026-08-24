
import java.util.ArrayList;

public class _02_CycleDetection_UndirectedGraph {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create Undirected Graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *      0
         *     / \
         *    1---2
         *        |
         *        3
         *
         * Cycle → 0 → 1 → 2 → 0
         */

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
    }

    // DFS for one connected component
    static boolean dfs(
            ArrayList<Edge>[] graph,
            int curr,
            int parent,
            boolean[] visited) {

        visited[curr] = true;

        for (Edge e : graph[curr]) {

            int neighbour = e.dest;

            // Case 1: neighbour is not visited
            if (!visited[neighbour]) {

                if (dfs(graph, neighbour, curr, visited)) {
                    return true;
                }
            }

            // Case 2:
            // neighbour is already visited
            // AND it is NOT the parent
            // => Cycle exists
            else if (neighbour != parent) {
                return true;
            }
        }

        return false;
    }

    // Handles disconnected components
    static boolean cycleDetectionUtil(ArrayList<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {

                // Starting node has no parent
                if (dfs(graph, i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(
                "Cycle Present: " + cycleDetectionUtil(graph)
        );
    }
}