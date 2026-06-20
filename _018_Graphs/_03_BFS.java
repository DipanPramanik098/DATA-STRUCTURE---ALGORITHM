package _018_Graphs;

import java.util.*;

public class _03_BFS {

    static void bfs(int start,
                    HashMap<Integer, ArrayList<Integer>> graph) {

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();

        q.offer(start);
        vis.add(start);

        while (!q.isEmpty()) {

            int curr = q.poll();
            System.out.print(curr + " ");

            for (int nbr : graph.get(curr)) {

                if (!vis.contains(nbr)) {
                    vis.add(nbr);
                    q.offer(nbr);
                }
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

        System.out.print("BFS: ");
        bfs(0, graph);
    }
}