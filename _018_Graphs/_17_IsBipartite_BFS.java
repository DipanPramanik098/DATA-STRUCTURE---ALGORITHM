package _018_Graphs;

import java.util.*;

public class _17_IsBipartite_BFS {

    // BFS Traversal for Bipartite Check
    public static boolean bfs(int start,
                              HashMap<Integer, ArrayList<Integer>> graph,
                              int[] color) {

        Queue<Integer> q = new LinkedList<>();

        // Color starting node with 0
        color[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {

            int curr = q.poll();

            // Visit all neighbors
            for (int nbr : graph.get(curr)) {

                // If neighbor is uncolored
                if (color[nbr] == -1) {

                    // Assign opposite color
                    color[nbr] = 1 - color[curr];

                    q.offer(nbr);
                }

                // If neighbor has same color
                else if (color[nbr] == color[curr]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartite(HashMap<Integer, ArrayList<Integer>> graph) {

        int n = graph.size();

        // -1 = Uncolored
        //  0 = Color A
        //  1 = Color B
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // Handle disconnected graph
        for (int node : graph.keySet()) {

            if (color[node] == -1) {

                if (!bfs(node, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        int n = 4;

        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Undirected Graph
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(0);
        graph.get(0).add(3);

        if (isBipartite(graph)) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is Not Bipartite");
        }
    }
}