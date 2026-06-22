package _018_Graphs;

import java.util.*;

public class _13_Course_Schedule_2_BFS {

    // Kahn's Algorithm (BFS Topological Sort)
    public static boolean solve(HashMap<Integer, ArrayList<Integer>> graph,
                                ArrayList<Integer> ans) {

        // Store indegree of every node
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

        // Queue for nodes having indegree = 0
        Queue<Integer> q = new LinkedList<>();

        for (int node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                q.offer(node);
            }
        }

        int processed = 0;

        // BFS
        while (!q.isEmpty()) {
            int curr = q.poll();
            processed++;

            // Add node to topological order
            ans.add(curr);

            // Reduce indegree of neighbors
            for (int nbr : graph.get(curr)) {
                indegree.put(nbr, indegree.get(nbr) - 1);

                if (indegree.get(nbr) == 0) {
                    q.offer(nbr);
                }
            }
        }

        // If all nodes processed => no cycle
        return processed == graph.size();
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create Graph
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build graph
        // prerequisite = [course, prerequisite]
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course); // prereq -> course
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // Topological sort possible
        if (solve(graph, ans)) {

            int[] result = new int[ans.size()];

            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }

            return result;
        }

        // Cycle exists
        return new int[0];
    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] order = findOrder(numCourses, prerequisites);

        if (order.length == 0) {
            System.out.println("Cycle detected! Course order not possible.");
        } else {
            System.out.println("Course Order:");
            for (int course : order) {
                System.out.print(course + " ");
            }
        }
    }
}