package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _09_Cycle_Detection_Directed_Graph_Using_BFS {
    private HashMap<Integer, ArrayList<Integer>> graph;

    public _09_Cycle_Detection_Directed_Graph_Using_BFS() {
        graph = new HashMap<>();
    }

    // Add edge u -> v
    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(v);
    }

    // Detect cycle using Kahn's Algorithm (BFS)
    public boolean hasCycle() {

        // Store indegree of each node
        HashMap<Integer, Integer> indegree = new HashMap<>();

        // Initialize indegree with 0
        for (int node : graph.keySet()) {
            indegree.put(node, 0);
        }

        // Calculate indegree
        for (int node : graph.keySet()) {
            for (int neighbour : graph.get(node)) {
                indegree.put(neighbour,
                        indegree.get(neighbour) + 1);
            }
        }

        // Queue for nodes having indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        int processedNodes = 0;

        // BFS
        while (!queue.isEmpty()) {

            int current = queue.poll();
            processedNodes++;

            for (int neighbour : graph.get(current)) {

                indegree.put(neighbour,
                        indegree.get(neighbour) - 1);

                if (indegree.get(neighbour) == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        // If all nodes processed => No Cycle
        // Else => Cycle Exists
        return processedNodes != graph.size();
    }

    public static void main(String[] args) {

        _09_Cycle_Detection_Directed_Graph_Using_BFS g = new _09_Cycle_Detection_Directed_Graph_Using_BFS();

        /*
         * 1 → 2 → 3
         * ↑ ↓
         * └── 4
         * 
         * Cycle: 2 → 3 → 4 → 2
         */

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 2);

        if (g.hasCycle()) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Present");
        }
    }
}
