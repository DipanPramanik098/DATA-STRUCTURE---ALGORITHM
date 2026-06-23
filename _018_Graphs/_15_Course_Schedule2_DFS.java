package _018_Graphs;

import java.util.*;

public class _15_Course_Schedule2_DFS {

    // DFS Topological Sort
    public static boolean dfs(int node,
                              HashMap<Integer, ArrayList<Integer>> graph,
                              boolean[] visited,
                              boolean[] pathVisited,
                              Stack<Integer> st) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int nbr : graph.get(node)) {

            // Visit unvisited neighbor
            if (!visited[nbr]) {
                if (dfs(nbr, graph, visited, pathVisited, st)) {
                    return true; // Cycle found
                }
            }

            // Back edge found
            else if (pathVisited[nbr]) {
                return true;
            }
        }

        // Backtracking
        pathVisited[node] = false;

        // Add node after processing all neighbors
        st.push(node);

        return false;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create Graph
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build Graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        Stack<Integer> st = new Stack<>();

        // DFS on every component
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, pathVisited, st)) {
                    return new int[0]; // Cycle exists
                }
            }
        }

        // Stack -> Answer
        int[] ans = new int[numCourses];
        int idx = 0;

        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }

        return ans;
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
            System.out.println("Cycle Detected!");
        } else {
            System.out.println("Course Order:");

            for (int x : order) {
                System.out.print(x + " ");
            }
        }
    }
}