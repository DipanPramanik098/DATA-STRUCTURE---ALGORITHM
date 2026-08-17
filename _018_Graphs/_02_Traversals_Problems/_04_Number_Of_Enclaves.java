package _018_Graphs._02_Traversals_Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _04_Number_Of_Enclaves {

    public static int noOfEnclaves(int[][] graph) {

        int m = graph.length;
        int n = graph[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] visited = new int[m][n];

        // Fill visited with -1
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }

        // Add all boundary 1's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1)
                        && graph[i][j] == 1) {

                    q.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        // Directions: Up, Right, Down, Left
        int[] row = {-1, 0, +1, 0};
        int[] col = {0, +1, 0, -1};

        // BFS
        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {

                int nrow = r + row[i];
                int ncol = c + col[i];

                // Check valid cell
                if (nrow >= 0 && nrow < m &&
                    ncol >= 0 && ncol < n &&
                    graph[nrow][ncol] == 1 &&
                    visited[nrow][ncol] == -1) {

                    visited[nrow][ncol] = 1;

                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        // Count 1's which are NOT connected to boundary
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (graph[i][j] == 1 && visited[i][j] == -1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int result = noOfEnclaves(graph);

        System.out.println("Number of Enclaves: " + result);
    }
}