
import java.util.ArrayList;

public class _02_All_Paths_From_Src_To_Dest {

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
         * 0
         * / \
         * ↓ ↓
         * 1 2
         * \ /
         * ↓ ↓
         * 3
         * |
         * ↓
         * 4
         *
         * Source = 0
         * Destination = 4
         *
         * Paths:
         * 0 → 1 → 3 → 4
         * 0 → 2 → 3 → 4
         */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));
    }

    // DFS + Backtracking
    static void dfs(
            ArrayList<Edge>[] graph,
            int curr,
            int dest,
            ArrayList<Integer> path,
            ArrayList<ArrayList<Integer>> allPaths) {

        // Add current node to current path
        path.add(curr);

        // Destination reached
        if (curr == dest) {

            // Store a COPY of current path
            allPaths.add(new ArrayList<>(path));
        } else {

            // Explore all neighbours
            for (Edge e : graph[curr]) {
                dfs(graph, e.dest, dest, path, allPaths);
            }
        }

        // Backtrack
        path.remove(path.size() - 1);
    }

    // Return all paths from source to destination
    static ArrayList<ArrayList<Integer>> allPaths(
            ArrayList<Edge>[] graph,
            int src,
            int dest) {

        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dfs(graph, src, dest, path, allPaths);

        return allPaths;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int src = 0;
        int dest = 4;

        // Function returns List of Lists
        ArrayList<ArrayList<Integer>> paths = allPaths(graph, src, dest);

        // Print only inside main()
        for (ArrayList<Integer> path : paths) {
            System.out.println(path);
        }
    }
}