package _007_Binary_Search._05_2D_Arrays;

public class _05_Matrix_Median {

    // Find first index where value > x
    // This gives count of elements <= x in that row
    private int upperBound(int[] arr, int x, int m) {
        int low = 0, high = m - 1;
        int ans = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                ans = mid;      // possible upper bound
                high = mid - 1; // try smaller index
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Count total elements <= x in whole matrix
    private int countSmallEqual(int[][] matrix, int n, int m, int x) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += upperBound(matrix[i], x, m);
        }

        return count;
    }

    // Main function to find median
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum from matrix
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);       // first element of row
            high = Math.max(high, matrix[i][m - 1]); // last element of row
        }

        // Required position of median
        int req = (n * m) / 2;

        // Binary search on value range
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallEqual = countSmallEqual(matrix, n, m, mid);

            if (smallEqual <= req) {
                low = mid + 1;   // median is bigger
            } else {
                high = mid - 1;  // median may be smaller
            }
        }

        return low;
    }

    public static void main(String[] args) {
        _05_Matrix_Median obj = new _05_Matrix_Median();

        int[][] matrix1 = {
            {1, 4, 9},
            {2, 5, 6},
            {3, 7, 8}
        };
        System.out.println(obj.findMedian(matrix1)); // 5

        int[][] matrix2 = {
            {1, 3, 8},
            {2, 3, 4},
            {1, 2, 5}
        };
        System.out.println(obj.findMedian(matrix2)); // 3

        int[][] matrix3 = {
            {1, 4, 15},
            {2, 5, 6},
            {3, 8, 11}
        };
        System.out.println(obj.findMedian(matrix3)); // 5
    }
}