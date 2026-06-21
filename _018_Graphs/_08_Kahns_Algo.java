package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _08_Kahns_Algo {

    public static void topoSort(HashMap<Integer, ArrayList<Integer>> graph, int V) {

        int[] indegree = new int[V];

        // Calculate indegree
        for (int node : graph.keySet()) {
            for (int nbr : graph.get(node)) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            int curr = q.poll();
            ans.add(curr);

            for (int nbr : graph.get(curr)) {

                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        System.out.println("Topological Order: " + ans);
    }

    public static void addEdge(int u, int v,
                               HashMap<Integer, ArrayList<Integer>> graph) {

        graph.get(u).add(v);
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