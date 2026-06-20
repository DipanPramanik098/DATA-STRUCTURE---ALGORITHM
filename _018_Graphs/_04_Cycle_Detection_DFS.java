package _018_Graphs;

import java.util.*;

public class _04_Cycle_Detection_DFS {

    // DFS function for cycle detection
    static boolean dfs(int node,
                       int parent,
                       HashMap<Integer, ArrayList<Integer>> graph,
                       HashSet<Integer> vis) {

        // Mark current node as visited
        vis.add(node);

        // Traverse all neighbors
        for (int nbr : graph.get(node)) {

            // If neighbor is not visited, go deeper
            if (!vis.contains(nbr)) {

                if (dfs(nbr, node, graph, vis)) {
                    return true;
                }
            }

            // If neighbor is visited and is not parent
            // then cycle exists
            else if (nbr != parent) {
                return true;
            }
        }

        return false;
    }

    static void addEdge(HashMap<Integer, ArrayList<Integer>> graph,
                        int u, int v) {

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {

        int V = 5;

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Graph with cycle
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 0);

        HashSet<Integer> vis = new HashSet<>();

        boolean hasCycle = false;

        // Check every component
        for (int i = 0; i < V; i++) {

            if (!vis.contains(i)) {

                if (dfs(i, -1, graph, vis)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle Present : " + hasCycle);
    }
}