
import java.util.ArrayList;
import java.util.Stack;

public class _05_TopologicalSort {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create Directed Acyclic Graph (DAG)
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

    // DFS for one node
    static void dfs(
            ArrayList<Edge>[] graph,
            int curr,
            boolean[] visited,
            Stack<Integer> stack) {

        visited[curr] = true;

        // Visit all unvisited neighbours
        for (Edge e : graph[curr]) {

            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited, stack);
            }
        }

        // Add node AFTER visiting all its neighbours
        stack.push(curr);
    }

    // Topological Sort using DFS
    static void topologicalSort(ArrayList<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length];

        Stack<Integer> stack = new Stack<>();

        // Handle all components
        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }

        // Stack gives Topological Order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("Topological Sort:");

        topologicalSort(graph);
    }
}