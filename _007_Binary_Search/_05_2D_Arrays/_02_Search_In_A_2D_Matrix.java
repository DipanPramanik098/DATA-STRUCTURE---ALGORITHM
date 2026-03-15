package _007_Binary_Search._05_2D_Arrays;

public class _02_Search_In_A_2D_Matrix {

    /*
     -------------------------------------------------------------
     FUNCTION: searchMatrix
     PURPOSE : Search a target element inside a sorted 2D matrix
     RETURN  : true  -> if target exists
               false -> if target does not exist
     -------------------------------------------------------------

     IMPORTANT MATRIX PROPERTY (for this approach to work):
     1. Each row is sorted in ascending order
     2. The first element of each row is greater than the last element of previous row

     Example matrix:
        1   2   3   4
        5   6   7   8
        9  10  11  12

     If we flatten this matrix, it becomes:

        1 2 3 4 5 6 7 8 9 10 11 12

     So we can apply BINARY SEARCH on it.
     -------------------------------------------------------------
    */

    public boolean searchMatrix(int[][] mat, int target) {

        // Number of rows
        int n = mat.length;

        // Number of columns
        int m = mat[0].length;

        /*
         We treat the matrix like a 1D sorted array.

         Total elements = n * m

         Index range in imaginary 1D array:
         0 -> (n*m - 1)
        */

        int low = 0;
        int high = (n * m) - 1;

        /*
         Standard Binary Search Loop
        */
        while (low <= high) {

            // Find middle index safely (avoid overflow)
            int mid = low + (high - low) / 2;

            /*
             Convert 1D index -> 2D matrix position

             Example:
             Matrix columns = m

             row = mid / m
             col = mid % m

             Example:
             mid = 7, m = 4

             row = 7 / 4 = 1
             col = 7 % 4 = 3

             mat[1][3] -> element 8
            */

            int row = mid / m;
            int col = mid % m;

            /*
             Compare matrix value with target
            */

            if (mat[row][col] == target) {
                // Target found
                return true;
            }

            else if (mat[row][col] < target) {
                /*
                 Target is larger
                 -> discard left half
                 -> search right half
                */
                low = mid + 1;
            }

            else {
                /*
                 Target is smaller
                 -> discard right half
                 -> search left half
                */
                high = mid - 1;
            }
        }

        // Target not found
        return false;
    }


    /*
     -------------------------------------------------------------
     MAIN METHOD (Testing the function)
     -------------------------------------------------------------
    */

    public static void main(String[] args) {

        // Create object of the class
        _02_Search_In_A_2D_Matrix obj = new _02_Search_In_A_2D_Matrix();


        /*
         ---------------------------
         TEST CASE 1
         ---------------------------
        */

        int[][] mat1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Search for 8
        // Expected Output -> true
        System.out.println(obj.searchMatrix(mat1, 8));


        /*
         ---------------------------
         TEST CASE 2
         ---------------------------
        */

        int[][] mat2 = {
            {1, 2, 4},
            {6, 7, 8},
            {9, 10, 34}
        };

        // Search for 78
        // Expected Output -> false
        System.out.println(obj.searchMatrix(mat2, 78));


        /*
         ---------------------------
         TEST CASE 3
         ---------------------------
        */

        int[][] mat3 = {
            {1, 2, 4},
            {6, 7, 8},
            {9, 10, 34}
        };

        // Search for 7
        // Expected Output -> true
        System.out.println(obj.searchMatrix(mat3, 7));
    }
}