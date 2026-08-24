

import java.util.ArrayList;

public class _04_Cycle_Detection_Directed {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create Directed Graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         * 0 → 1
         *     ↓
         *     2
         *    ↙
         *   3
         *   ↑
         *   └──── 1
         *
         * Cycle: 1 → 2 → 3 → 1
         */

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
    }

    // DFS for one component
    static boolean dfs(
            ArrayList<Edge>[] graph,
            int curr,
            boolean[] visited,
            boolean[] pathVisited) {

        // Mark current node visited
        visited[curr] = true;

        // Current node is part of current DFS path
        pathVisited[curr] = true;

        for (Edge e : graph[curr]) {

            int neighbour = e.dest;

            // Case 1: Unvisited neighbour
            if (!visited[neighbour]) {

                if (dfs(graph, neighbour, visited, pathVisited)) {
                    return true;
                }
            }

            // Case 2:
            // Neighbour is already in current DFS path
            // => Cycle exists
            else if (pathVisited[neighbour]) {
                return true;
            }
        }

        // Backtracking:
        // remove current node from current DFS path
        pathVisited[curr] = false;

        return false;
    }

    // Handles disconnected graph
    static boolean isCycle(ArrayList<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length];

        // Tracks nodes in current DFS recursion path
        boolean[] pathVisited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {

                if (dfs(graph, i, visited, pathVisited)) {
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

        System.out.println("Cycle Present: " + isCycle(graph));
    }
}