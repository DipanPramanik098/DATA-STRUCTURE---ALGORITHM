package _018_Graphs._02_Traversals_Problems;

import java.util.Arrays;

public class _07_Replace_Zero_With_X {

    public static void dfs(int r, int c, int[][] vis,
                           char[][] b, int[] row, int[] col) {

        vis[r][c] = 1;

        int m = b.length;
        int n = b[0].length;

        for (int i = 0; i < 4; i++) {

            int nr = r + row[i];
            int nc = c + col[i];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                vis[nr][nc] == 0 &&
                b[nr][nc] == 'O') {

                dfs(nr, nc, vis, b, row, col);
            }
        }
    }

    public static void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];

        // Fill visited with 0
        for (int[] row : visited) {
            Arrays.fill(row, 0);
        }

        // Up, Right, Down, Left
        int[] row = {-1, 0, +1, 0};
        int[] col = {0, +1, 0, -1};

        // Traverse first and last row
        for (int j = 0; j < n; j++) {

            // First row
            if (visited[0][j] == 0 &&
                board[0][j] == 'O') {

                dfs(0, j, visited, board, row, col);
            }

            // Last row
            if (visited[m - 1][j] == 0 &&
                board[m - 1][j] == 'O') {

                dfs(m - 1, j, visited, board, row, col);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < m; i++) {

            // First column
            if (visited[i][0] == 0 &&
                board[i][0] == 'O') {

                dfs(i, 0, visited, board, row, col);
            }

            // Last column
            if (visited[i][n - 1] == 0 &&
                board[i][n - 1] == 'O') {

                dfs(i, n - 1, visited, board, row, col);
            }
        }

        // Replace surrounded O with X
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (visited[i][j] == 0 &&
                    board[i][j] == 'O') {

                    board[i][j] = 'X';
                }
            }
        }
    }

    // Print the board
    public static void printBoard(char[][] board) {

        for (char[] row : board) {

            for (char ch : row) {
                System.out.print(ch + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        System.out.println("Before:");

        printBoard(board);

        solve(board);

        System.out.println("\nAfter:");

        printBoard(board);
    }
}