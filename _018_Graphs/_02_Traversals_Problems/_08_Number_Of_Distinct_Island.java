package _018_Graphs._02_Traversals_Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _08_Number_Of_Distinct_Island {

    // DFS to traverse one complete island
    public static void dfs(int row, int col,
                           int baseRow, int baseCol,
                           int[][] grid,
                           boolean[][] visited,
                           List<String> shape) {

        // Mark current cell as visited
        visited[row][col] = true;

        /*
         * Store the relative position of the current cell
         * with respect to the starting cell of the island.
         *
         * Example:
         * Starting cell = (1, 2)
         * Current cell  = (2, 3)
         *
         * Relative position = (1, 1)
         *
         * This allows us to compare island shapes independent
         * of their actual position in the grid.
         */
        shape.add((row - baseRow) + "_" + (col - baseCol));

        // Four possible directions:
        // Up, Right, Down, Left
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        // Traverse all four directions
        for (int i = 0; i < 4; i++) {

            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            // Check:
            // 1. Inside grid
            // 2. Cell is land
            // 3. Cell is not visited
            if (nrow >= 0 && nrow < grid.length &&
                ncol >= 0 && ncol < grid[0].length &&
                grid[nrow][ncol] == 1 &&
                !visited[nrow][ncol]) {

                dfs(nrow, ncol,
                    baseRow, baseCol,
                    grid, visited, shape);
            }
        }
    }

    // Returns number of distinct island shapes
    public static int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // Visited array
        boolean[][] visited = new boolean[n][m];

        /*
         * Each List<String> represents one island shape.
         *
         * HashSet automatically removes duplicate shapes.
         */
        Set<List<String>> set = new HashSet<>();

        // Traverse entire grid
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Found an unvisited island
                if (grid[i][j] == 1 && !visited[i][j]) {

                    // Store the shape of current island
                    List<String> shape = new ArrayList<>();

                    /*
                     * (i, j) is the base/start position.
                     *
                     * Every cell of this island will be stored
                     * relative to (i, j).
                     */
                    dfs(i, j,
                        i, j,
                        grid, visited, shape);

                    // Add island shape to Set
                    set.add(shape);
                }
            }
        }

        // Number of unique island shapes
        return set.size();
    }

    // Print grid
    public static void printGrid(int[][] grid) {

        for (int[] row : grid) {

            for (int cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };

        System.out.println("Grid:");

        printGrid(grid);

        int result = countDistinctIslands(grid);

        System.out.println("\nNumber of Distinct Islands: " + result);
    }
}