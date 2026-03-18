package _009_Recursion._05_FAQs;

public class _02_Word_Search {

    // Recursive DFS function
    public static boolean solve(char[][] board, int i, int j, String word, int k) {

        // ✅ If all characters are matched
        if (k == word.length()) {
            return true;
        }

        // ❌ Out of bounds or character mismatch
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(k)) {
            return false;
        }

        // Store original character
        char temp = board[i][j];

        // Mark current cell as visited
        board[i][j] = '#';

        // Explore 4 directions
        boolean found = solve(board, i + 1, j, word, k + 1) ||   // down
                        solve(board, i - 1, j, word, k + 1) ||   // up
                        solve(board, i, j + 1, word, k + 1) ||   // right
                        solve(board, i, j - 1, word, k + 1);     // left

        // Restore original character (backtrack)
        board[i][j] = temp;

        return found;
    }

    // Main function
    public static boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        // Start search from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (solve(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        System.out.println(exist(board, word)); // true
    }
}