package _018_Graphs._02_Traversals_Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _05_Rotten_Oranges {

    public static int orangeRotting(int[][] g) {

        int m = g.length;
        int n = g[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] visited = new int[m][n];

        // Fill visited
        for (int[] row : visited) {
            Arrays.fill(row, 1);
        }

        // Add all initially rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (g[i][j] == 2) {

                    // {row, col, time}
                    q.add(new int[] { i, j, 0 });

                    visited[i][j] = 2;

                } else if (g[i][j] == 1) {

                    visited[i][j] = 1;

                } else {

                    visited[i][j] = 0;
                }
            }
        }

        // Up, Right, Down, Left
        int[] row = { -1, 0, +1, 0 };
        int[] col = { 0, +1, 0, -1 };

        int time = 0;

        // BFS
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {

                int nr = r + row[i];
                int nc = c + col[i];

                // Boundary + fresh orange check
                if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        visited[nr][nc] == 1) {

                    q.add(new int[] { nr, nc, t + 1 });

                    visited[nr][nc] = 2;
                }
            }
        }

        // Check if any fresh orange is remaining
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (visited[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {

        int[][] g = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        int result = orangeRotting(g);

        System.out.println("Minimum time required: " + result);
    }
}