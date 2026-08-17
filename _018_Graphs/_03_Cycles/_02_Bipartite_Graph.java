package _018_Graphs._03_Cycles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _02_Bipartite_Graph {

    // BFS to check whether a component is bipartite
    public static boolean bfs(int start, List<List<Integer>> adj, int[] color) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbour : adj.get(node)) {

                // Not colored yet
                if (color[neighbour] == -1) {

                    // Give opposite color
                    color[neighbour] = 1 - color[node];

                    q.add(neighbour);

                }
                // Same color on adjacent nodes -> not bipartite
                else if (color[neighbour] == color[node]) {

                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartite(int V, List<List<Integer>> adj) {

        // -1 = not colored
        //  0 = color 0
        //  1 = color 1
        int[] color = new int[V];

        java.util.Arrays.fill(color, -1);

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {

            if (color[i] == -1) {

                if (!bfs(i, adj, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Add undirected edge
    public static void addEdge(List<List<Integer>> adj, int u, int v) {

        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {

        int V = 4;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        if (isBipartite(V, adj)) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is NOT Bipartite");
        }
    }
}