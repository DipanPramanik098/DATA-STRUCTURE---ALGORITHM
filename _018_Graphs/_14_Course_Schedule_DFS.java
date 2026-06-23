package _018_Graphs;

import java.util.*;

public class _14_Course_Schedule_DFS {

    // DFS for cycle detection
    public static boolean dfs(int node,
                              HashMap<Integer, ArrayList<Integer>> graph,
                              boolean[] visited,
                              boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        // Visit all neighbors
        for (int nbr : graph.get(node)) {

            // If not visited, do DFS
            if (!visited[nbr]) {
                if (dfs(nbr, graph, visited, pathVisited)) {
                    return true;
                }
            }

            // Back edge found -> cycle exists
            else if (pathVisited[nbr]) {
                return true;
            }
        }

        // Remove from current DFS path
        pathVisited[node] = false;

        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create Graph
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course); // prereq -> course
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        // Run DFS from every unvisited node
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, pathVisited)) {
                    return false; // cycle found
                }
            }
        }

        return true; // no cycle
    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        if (canFinish(numCourses, prerequisites)) {
            System.out.println("All courses can be completed.");
        } else {
            System.out.println("Cycle detected! Courses cannot be completed.");
        }
    }
}