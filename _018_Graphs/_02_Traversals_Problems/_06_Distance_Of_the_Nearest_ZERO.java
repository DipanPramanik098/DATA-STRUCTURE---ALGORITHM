package _018_Graphs._02_Traversals_Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _06_Distance_Of_the_Nearest_ZERO {

    public static int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] visited = new int[m][n];

        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }

        int[][] ans = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        // Add all initial 0's with distance 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {

                    // {row, column, distance}
                    q.add(new int[]{i, j, 0});

                    visited[i][j] = 1;
                    ans[i][j] = 0;
                }
            }
        }

        // Left, Up, Right, Down
        int[] row = {0, -1, 0, +1};
        int[] col = {-1, 0, +1, 0};

        // Multi-source BFS
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            for (int i = 0; i < 4; i++) {

                int nr = r + row[i];
                int nc = c + col[i];

                // Boundary + not visited
                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    visited[nr][nc] != 1) {

                    q.add(new int[]{nr, nc, d + 1});

                    visited[nr][nc] = 1;

                    ans[nr][nc] = d + 1;
                }
            }
        }

        return ans;
    }

    // Print matrix
    public static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {

            for (int value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println("Input Matrix:");

        printMatrix(mat);

        int[][] result = updateMatrix(mat);

        System.out.println("\nDistance Matrix:");

        printMatrix(result);
    }
}