package _018_Graphs;

import java.util.*;

public class _16_Is_Graph_Bipartite {

    // DFS Coloring
    public static boolean dfs(int node,
                              int color,
                              HashMap<Integer, ArrayList<Integer>> graph,
                              int[] colors) {

        // Assign color to current node
        colors[node] = color;

        // Visit all neighbors
        for (int nbr : graph.get(node)) {

            // If neighbor is not colored
            if (colors[nbr] == -1) {

                // Color with opposite color
                if (!dfs(nbr, 1 - color, graph, colors)) {
                    return false;
                }
            }

            // If neighbor has same color
            // Graph is not Bipartite
            else if (colors[nbr] == color) {
                return false;
            }
        }

        return true;
    }

    public static boolean isBipartite(int[][] graphArray) {

        int n = graphArray.length;

        // Create Graph using HashMap
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int nbr : graphArray[i]) {
                graph.get(i).add(nbr);
            }
        }

        // -1 = Uncolored
        // 0 = Red
        // 1 = Blue
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        // Handle disconnected graph
        for (int i = 0; i < n; i++) {

            if (colors[i] == -1) {

                if (!dfs(i, 0, graph, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };

        if (isBipartite(graph)) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is NOT Bipartite");
        }
    }
}