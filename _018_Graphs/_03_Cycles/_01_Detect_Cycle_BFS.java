package _018_Graphs._03_Cycles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _01_Detect_Cycle_BFS {

    // Pair class to store:
    // current node + parent node
    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    // BFS to detect cycle in an undirected graph
    public static boolean bfs(int start, List<List<Integer>> adj,
                              boolean[] visited) {

        Queue<Pair> q = new LinkedList<>();

        // Starting node has no parent
        q.add(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {

            Pair current = q.poll();

            int node = current.node;
            int parent = current.parent;

            // Traverse all neighbours
            for (int neighbour : adj.get(node)) {

                // If neighbour is not visited
                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    q.add(new Pair(neighbour, node));

                }
                // If already visited and it is NOT the parent
                else if (neighbour != parent) {

                    // Cycle detected
                    return true;
                }
            }
        }

        return false;
    }

    // Detect cycle in the complete graph
    public static boolean detectCycle(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];

        // Graph can have multiple components
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Add an undirected edge
    public static void addEdge(List<List<Integer>> adj,
                               int u, int v) {

        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {

        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        //
        // 0 ----- 1
        // |       |
        // |       |
        // 3 ----- 2
        //
        // 4 is separate
        //
        // 0 -> 1 -> 2 -> 3 -> 0 forms a cycle

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        boolean result = detectCycle(V, adj);

        if (result) {
            System.out.println("Cycle exists");
        } else {
            System.out.println("Cycle does not exist");
        }
    }
}