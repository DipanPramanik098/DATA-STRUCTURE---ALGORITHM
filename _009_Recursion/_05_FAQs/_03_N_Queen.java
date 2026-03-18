package _009_Recursion._05_FAQs;

import java.util.*;

public class _03_N_Queen {

    // Check if placing queen at (row, col) is safe
    public static boolean isSafe(List<String> board, int row, int col) {

        int r = row;
        int c = col;

        // Check upper-left diagonal
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        // Check upward column
        while (r >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
        }

        r = row;
        c = col;

        // Check upper-right diagonal
        while (r >= 0 && c < board.size()) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c++;
        }

        return true;
    }

    // Recursive function to place queens row by row
    public static void solve(int row, List<String> board, List<List<String>> ans) {

        // ✅ All queens placed
        if (row == board.size()) {
            ans.add(new ArrayList<>(board));
            return;
        }

        // Try placing queen in every column of current row
        for (int col = 0; col < board.size(); col++) {

            if (isSafe(board, row, col)) {

                // Convert row string into char array to modify it
                char[] currentRow = board.get(row).toCharArray();

                // Place queen
                currentRow[col] = 'Q';
                board.set(row, new String(currentRow));

                // Move to next row
                solve(row + 1, board, ans);

                // Backtrack: remove queen
                currentRow[col] = '.';
                board.set(row, new String(currentRow));
            }
        }
    }

    // Main function
    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        // Initialize board with dots
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        solve(0, board, ans);

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}