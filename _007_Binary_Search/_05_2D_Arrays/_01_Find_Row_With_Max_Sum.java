package _007_Binary_Search._05_2D_Arrays;

public class _01_Find_Row_With_Max_Sum {

    // Helper function to find the lower bound of x
    private int lowerBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1; // search on left side
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Function to find row with maximum number of 1's
    public int rowWithMax1s(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int cnt_max = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int cnt_ones = m - lowerBound(mat[i], m, 1);

            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        _01_Find_Row_With_Max_Sum obj = new _01_Find_Row_With_Max_Sum();

        int[][] mat1 = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 0, 0}
        };
        System.out.println(obj.rowWithMax1s(mat1)); // 0

        int[][] mat2 = {
            {0, 0},
            {0, 0}
        };
        System.out.println(obj.rowWithMax1s(mat2)); // -1

        int[][] mat3 = {
            {0, 0, 1},
            {0, 1, 1},
            {0, 1, 1}
        };
        System.out.println(obj.rowWithMax1s(mat3)); // 1
    }
}