package _018_Graphs._02_Traversals_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class _02_Number_Of_Islands {

    // BFS to traverse one complete island
    public static void bfs(
            int row,
            int col,
            boolean[][] visited,
            char[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        // Add starting cell
        queue.offer(new int[]{row, col});

        // Mark starting cell visited
        visited[row][col] = true;

        // 8 directions
        int[] dRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dCol = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            // Check all 8 directions
            for (int i = 0; i < 8; i++) {

                int newRow = r + dRow[i];
                int newCol = c + dCol[i];

                // Check valid cell
                if (newRow >= 0 &&
                    newRow < grid.length &&
                    newCol >= 0 &&
                    newCol < grid[0].length &&
                    !visited[newRow][newCol] &&
                    grid[newRow][newCol] == '1') {

                    visited[newRow][newCol] = true;

                    queue.offer(new int[]{
                            newRow,
                            newCol
                    });
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        // Traverse entire grid
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Found a new island
                if (!visited[i][j] && grid[i][j] == '1') {

                    count++;

                    bfs(i, j, visited, grid);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}