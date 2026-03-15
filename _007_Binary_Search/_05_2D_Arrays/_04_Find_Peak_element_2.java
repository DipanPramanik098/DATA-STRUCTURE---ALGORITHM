package _007_Binary_Search._05_2D_Arrays;

public class _04_Find_Peak_element_2 {

    /*
     ------------------------------------------------------------
     Helper Function: maxElement
     Purpose:
        Find the row index of the maximum element
        in a given column.

     Why needed?
        During binary search, we pick a middle column.
        In that column, we need the row where the element
        is maximum, because that element is the best candidate
        for being a peak in that column.
     ------------------------------------------------------------
    */
    public int maxElement(int[][] mat, int col) {

        // Total number of rows
        int n = mat.length;

        // Store the maximum value found in the given column
        int max = Integer.MIN_VALUE;

        // Store the row index where maximum value is found
        int index = -1;

        /*
         Traverse all rows in the given column
         and keep track of the largest element
        */
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                index = i;
            }
        }

        // Return row index of maximum element
        return index;
    }

    /*
     ------------------------------------------------------------
     Function: findPeakGrid
     Purpose:
        Find any peak element in a 2D matrix and return
        its position as {row, col}.

     Peak condition:
        Current element must be strictly greater than
        top, bottom, left, and right neighbors.

     Optimized Approach:
        Binary Search on columns
     ------------------------------------------------------------
    */
    public int[] findPeakGrid(int[][] mat) {

        // Number of rows
        int n = mat.length;

        // Number of columns
        int m = mat[0].length;

        /*
         Binary search will be applied on columns.
         So low and high represent column indices.
        */
        int low = 0;
        int high = m - 1;

        /*
         Continue binary search until search space is valid
        */
        while (low <= high) {

            // Find middle column
            int mid = low + (high - low) / 2;

            /*
             Find row index of the maximum element
             in the middle column
            */
            int row = maxElement(mat, mid);

            /*
             Find left and right neighbors of mat[row][mid]

             If neighbor does not exist, take it as
             Integer.MIN_VALUE (acts like negative infinity)
             because matrix outside is smaller than all valid cells
            */
            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = (mid + 1 < m) ? mat[row][mid + 1] : Integer.MIN_VALUE;

            /*
             Current candidate element
            */
            int current = mat[row][mid];

            /*
             If current is greater than both left and right,
             then it is a peak.

             Why?
             Because current is already the maximum in its column,
             so top and bottom are automatically smaller.
            */
            if (current > left && current > right) {
                return new int[]{row, mid};
            }

            /*
             If left neighbor is greater,
             peak must exist on the left half
            */
            else if (left > current) {
                high = mid - 1;
            }

            /*
             Otherwise, peak must exist on the right half
            */
            else {
                low = mid + 1;
            }
        }

        /*
         This line is just a safety return.
         Practically, problem guarantees a peak exists.
        */
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        // Create object of the class
        _04_Find_Peak_element_2 obj = new _04_Find_Peak_element_2();

        /*
         Test Case 1
        */
        int[][] mat1 = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };

        int[] ans1 = obj.findPeakGrid(mat1);
        System.out.println("Peak found at: [" + ans1[0] + ", " + ans1[1] + "]");

        /*
         Test Case 2
        */
        int[][] mat2 = {
            {10, 7},
            {11, 17}
        };

        int[] ans2 = obj.findPeakGrid(mat2);
        System.out.println("Peak found at: [" + ans2[0] + ", " + ans2[1] + "]");

        /*
         Test Case 3
        */
        int[][] mat3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] ans3 = obj.findPeakGrid(mat3);
        System.out.println("Peak found at: [" + ans3[0] + ", " + ans3[1] + "]");
    }
}