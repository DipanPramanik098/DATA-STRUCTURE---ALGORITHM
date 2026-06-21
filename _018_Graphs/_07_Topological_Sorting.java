package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class _07_Topological_Sorting {

    public static void topoSort(HashMap<Integer, ArrayList<Integer>> graph, int V) {

        HashSet<Integer> vis = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis.contains(i)) {
                dfs(i, graph, vis, st);
            }
        }

        System.out.print("Topological Order: ");

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void dfs(int node,
                           HashMap<Integer, ArrayList<Integer>> graph,
                           HashSet<Integer> vis,
                           Stack<Integer> st) {

        vis.add(node);

        for (int nbr : graph.get(node)) {
            if (!vis.contains(nbr)) {
                dfs(nbr, graph, vis, st);
            }
        }

        // Add node after exploring all neighbors
        st.push(node);
    }

    public static void addEdge(int u, int v,
                               HashMap<Integer, ArrayList<Integer>> graph) {

        graph.get(u).add(v); // Directed Edge
    }

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        int V = 6;

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        addEdge(5, 0, graph);
        addEdge(5, 2, graph);
        addEdge(4, 0, graph);
        addEdge(4, 1, graph);
        addEdge(2, 3, graph);
        addEdge(3, 1, graph);

        topoSort(graph, V);
    }
}