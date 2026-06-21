package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class _06_Directed_Grapph_Cycle {

    public static boolean isCycle(HashMap<Integer, ArrayList<Integer>> graph, int V) {

        HashSet<Integer> vis = new HashSet<>();
        HashSet<Integer> pathVis = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (!vis.contains(i)) {
                if (dfs(i, graph, vis, pathVis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(int node,
                              HashMap<Integer, ArrayList<Integer>> graph,
                              HashSet<Integer> vis,
                              HashSet<Integer> pathVis) {

        vis.add(node);
        pathVis.add(node);

        for (int nbr : graph.get(node)) {

            // If neighbor not visited
            if (!vis.contains(nbr)) {

                if (dfs(nbr, graph, vis, pathVis)) {
                    return true;
                }
            }

            // If neighbor already in current DFS path
            else if (pathVis.contains(nbr)) {
                return true;
            }
        }

        // Backtracking
        pathVis.remove(node);

        return false;
    }

    public static void addEdge(int u, int v,
                               HashMap<Integer, ArrayList<Integer>> graph) {

        graph.get(u).add(v); // Directed Edge
    }

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        int V = 5;

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        addEdge(0, 1, graph);
        addEdge(1, 2, graph);
        addEdge(2, 3, graph);
        addEdge(3, 1, graph); // Creates Cycle

        System.out.println(isCycle(graph, V));
    }
}