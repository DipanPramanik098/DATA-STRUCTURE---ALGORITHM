package _007_Binary_Search._05_2D_Arrays;

public class _03_Search_In_A_2D_Matrix_2 {

    /*
     -----------------------------------------------------------
     Function Name: searchMatrix
     Purpose:
        Search a target element in a 2D matrix where:
        1. Each row is sorted left to right
        2. Each column is sorted top to bottom

     Returns:
        true  -> if target is found
        false -> if target is not found
     -----------------------------------------------------------
    */
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows in the matrix
        int n = matrix.length;

        // Number of columns in the matrix
        int m = matrix[0].length;

        /*
         Start from the top-right corner.

         Why top-right?
         - Left side contains smaller values
         - Down side contains bigger values

         So from here:
         - if current > target -> move left
         - if current < target -> move down
        */
        int row = 0;
        int col = m - 1;

        /*
         Continue until:
         - row is inside the matrix
         - col is inside the matrix
        */
        while (row < n && col >= 0) {

            // Current element at position (row, col)
            int current = matrix[row][col];

            // Case 1: target found
            if (current == target) {
                return true;
            }

            /*
             Case 2: current value is smaller than target
             We need a bigger value.

             Since row is sorted left to right,
             all elements on the left are even smaller.

             So we eliminate this row and move downward.
            */
            else if (current < target) {
                row++;
            }

            /*
             Case 3: current value is greater than target
             We need a smaller value.

             Since column is sorted top to bottom,
             all elements below are even bigger.

             So we eliminate this column and move left.
            */
            else {
                col--;
            }
        }

        // If loop ends, target is not present
        return false;
    }

    public static void main(String[] args) {

        // Create object of the class
        _03_Search_In_A_2D_Matrix_2 obj = new _03_Search_In_A_2D_Matrix_2();

        // Sample matrix
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        // Test case 1
        int target1 = 5;
        System.out.println("Target " + target1 + " found? " + obj.searchMatrix(matrix, target1));
        // Expected: true

        // Test case 2
        int target2 = 20;
        System.out.println("Target " + target2 + " found? " + obj.searchMatrix(matrix, target2));
        // Expected: false

        // Test case 3
        int target3 = 1;
        System.out.println("Target " + target3 + " found? " + obj.searchMatrix(matrix, target3));
        // Expected: true

        // Test case 4
        int target4 = 14;
        System.out.println("Target " + target4 + " found? " + obj.searchMatrix(matrix, target4));
        // Expected: true
    }
}