package _009_Recursion._05_FAQs;

import java.util.*;

public class _04_Rat_In_A_MAZE {

    // Recursive function to find all paths
    public static void solve(int i, int j, int[][] grid, int n,
                             String path, List<String> ans) {

        // ✅ Destination reached
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        // Mark current cell as visited
        grid[i][j] = 0;

        // Move Up
        if (i > 0 && grid[i - 1][j] == 1) {
            solve(i - 1, j, grid, n, path + "U", ans);
        }

        // Move Left
        if (j > 0 && grid[i][j - 1] == 1) {
            solve(i, j - 1, grid, n, path + "L", ans);
        }

        // Move Down
        if (i < n - 1 && grid[i + 1][j] == 1) {
            solve(i + 1, j, grid, n, path + "D", ans);
        }

        // Move Right
        if (j < n - 1 && grid[i][j + 1] == 1) {
            solve(i, j + 1, grid, n, path + "R", ans);
        }

        // Backtrack: unmark current cell
        grid[i][j] = 1;
    }

    // Main function
    public static List<String> findPath(int[][] grid) {

        int n = grid.length;
        List<String> ans = new ArrayList<>();

        // If start or destination blocked, no path
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0) {
            return ans;
        }

        solve(0, 0, grid, n, "", ans);

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(findPath(grid)); // [DRDR]
    }
}