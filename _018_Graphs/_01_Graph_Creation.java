package _018_Graphs;

import java.util.*;

public class _01_Graph_Creation {

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        int V = 5;

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);

        System.out.println(graph);
    }

    static void addEdge(HashMap<Integer, ArrayList<Integer>> graph,
                        int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
}

// package _018_Graphs;

// import java.util.ArrayList;

// public class _01_Graph_Creation {

//     public static void main(String[] args) {

//         int V = 5; // Number of vertices

//         // Adjacency List
//         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

//         // Initialize each vertex with an empty list
//         for (int i = 0; i < V; i++) {
//             graph.add(new ArrayList<>());
//         }

//         // Add edges (Undirected Graph)
//         addEdge(graph, 0, 1);
//         addEdge(graph, 0, 2);
//         addEdge(graph, 1, 3);
//         addEdge(graph, 2, 4);

//         // Print Graph
//         for (int i = 0; i < V; i++) {
//             System.out.println(i + " -> " + graph.get(i));
//         }
//     }

//     static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
//         graph.get(u).add(v);
//         graph.get(v).add(u); // Remove this line for Directed Graph
//     }
// }