package _018_Graphs;

import java.util.*;

public class _02_DFS {

    static void dfs(int node,
                    HashMap<Integer, ArrayList<Integer>> graph,
                    HashSet<Integer> vis) {

        vis.add(node);
        System.out.print(node + " ");

        for (int nbr : graph.get(node)) {
            if (!vis.contains(nbr)) {
                dfs(nbr, graph, vis);
            }
        }
    }

    static void addEdge(HashMap<Integer, ArrayList<Integer>> graph,
                        int u, int v) {

        graph.get(u).add(v);
        graph.get(v).add(u); // Remove for directed graph
    }

    public static void main(String[] args) {

        int V = 5;

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);

        HashSet<Integer> vis = new HashSet<>();

        System.out.print("DFS: ");
        dfs(0, graph, vis);
    }
}