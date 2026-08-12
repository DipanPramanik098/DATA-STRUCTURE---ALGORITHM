package _018_Graphs._01_Theory_And_Traversals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import _018_Graphs.Graph;

public class _04_BFS {
    public static ArrayList<ArrayList<Integer>> buildG(int n, int[][] edge) {

        // Graph = ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialize adjacency list for every vertex
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        for (int i = 0; i < edge.length; i++) {

            int v1 = edge[i][0];
            int v2 = edge[i][1];

            // Undirected graph
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return graph;
    }

    public static void BFS(ArrayList<ArrayList<Integer>> Graph, int start, HashSet<Integer> visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node +" ");
            // Add Neighbours
            for(int val : Graph.get(node)){
                if(!visited.contains(val)){
                    q.offer(val);
                    visited.add(val);
                }
            }
        }
    }
    public static void main(String[] args) {

        // Number of vertices
        int n = 8;


        // Edge array
        int[][] edge = {
                { 1, 2 },
                { 1, 6 },
                { 2, 3 },
                { 2, 4 },
                { 4, 5 },
                { 6, 7 },
                { 6, 8 },
                { 7, 5 }
        };

        ArrayList<ArrayList<Integer>> graph = buildG(n, edge);

        // * BFS ===> 
            HashSet<Integer> st = new HashSet<>();
            BFS(graph, 1, st);
    }

}
