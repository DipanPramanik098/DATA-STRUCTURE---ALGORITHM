package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _12_Course_Schedule {

    // Kahn's Algorithm (BFS Topological Sort)
    public boolean solve(HashMap<Integer, ArrayList<Integer>> graph) {

        // Store indegree of each node
        HashMap<Integer, Integer> indegree = new HashMap<>();

        // Initialize indegree with 0
        for (int node : graph.keySet()) {
            indegree.put(node, 0);
        }

        // Calculate indegree
        for (int node : graph.keySet()) {
            for (int nbr : graph.get(node)) {
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }

        // Queue for nodes having indegree 0
        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                q.offer(node);
            }
        }

        int processed = 0;

        // BFS
        while (!q.isEmpty()) {

            int current = q.poll();
            processed++;

            for (int nbr : graph.get(current)) {

                // Decrease indegree
                indegree.put(nbr, indegree.get(nbr) - 1);

                // If indegree becomes 0
                if (indegree.get(nbr) == 0) {
                    q.offer(nbr);
                }
            }
        }

        // If all nodes processed => No Cycle
        return processed == graph.size();
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create Graph
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        // Initialize Graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build Graph
        for (int[] pre : prerequisites) {

            int u = pre[0];
            int v = pre[1];

            // v -> u
            graph.get(v).add(u);
        }

        return solve(graph);
    }

    public static void main(String[] args) {

        _12_Course_Schedule obj = new _12_Course_Schedule();

        /*
         * Example 1
         *
         * 0 -> 1
         *
         * Can finish all courses
         */

        int numCourses1 = 2;

        int[][] prerequisites1 = {
                {1, 0}
        };

        System.out.println(
                obj.canFinish(numCourses1, prerequisites1));

        /*
         * Output:
         * true
         */

        /*
         * Example 2
         *
         * 0 -> 1
         * 1 -> 0
         *
         * Cycle Exists
         */

        int numCourses2 = 2;

        int[][] prerequisites2 = {
                {1, 0},
                {0, 1}
        };

        System.out.println(
                obj.canFinish(numCourses2, prerequisites2));

        /*
         * Output:
         * false
         */
    }
}