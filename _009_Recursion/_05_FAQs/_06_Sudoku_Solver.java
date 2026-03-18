package _009_Recursion._05_FAQs;

public class _06_Sudoku_Solver {

    // Main function
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    // Recursive function to solve Sudoku
    public static boolean solve(char[][] board) {

        // Traverse whole board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Find empty cell
                if (board[row][col] == '.') {

                    // Try digits 1 to 9
                    for (char digit = '1'; digit <= '9'; digit++) {

                        // Check if digit can be placed
                        if (isValid(board, row, col, digit)) {

                            // Place digit
                            board[row][col] = digit;

                            // Recur for remaining board
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack if this choice fails
                            board[row][col] = '.';
                        }
                    }

                    // No digit worked for this empty cell
                    return false;
                }
            }
        }

        // ✅ No empty cell left, board solved
        return true;
    }

    // Check whether digit can be placed at board[row][col]
    public static boolean isValid(char[][] board, int row, int col, char digit) {

        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) return false;
            if (board[i][col] == digit) return false;
        }

        // Find starting row and column of 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check 3x3 sub-box
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);

        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}