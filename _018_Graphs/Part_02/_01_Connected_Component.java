import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _01_Connected_Component {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create disconnected graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         * Component 1: 0 -- 1 -- 2
         * Component 2: 3 -- 4
         * Component 3: 5
         */

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    // Actual BFS for one connected component
    static void bfs(ArrayList<Edge>[] graph, int src, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {

            int curr = q.poll();

            System.out.print(curr + " ");

            for (Edge e : graph[curr]) {

                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    q.offer(e.dest);
                }
            }
        }
    }

    // Extra loop to cover all connected components
    static void bfsUtil(ArrayList<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                bfs(graph, i, visited);
            }
        }
    }

    // Actual DFS for one connected component
    static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {

        visited[curr] = true;

        System.out.print(curr + " ");

        for (Edge e : graph[curr]) {

            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    // Extra loop to cover all connected components
    static void dfsUtil(ArrayList<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("BFS Traversal:");
        bfsUtil(graph);

        System.out.println();

        System.out.println("DFS Traversal:");
        dfsUtil(graph);
    }
}