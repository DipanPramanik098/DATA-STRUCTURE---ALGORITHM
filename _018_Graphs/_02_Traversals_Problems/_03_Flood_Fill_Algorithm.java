package _018_Graphs._02_Traversals_Problems;

public class _03_Flood_Fill_Algorithm {

    public static void dfs(int sr, int sc, int[][] ans, int[][] image,
                           int newColor, int[] row, int[] col, int initial) {

        ans[sr][sc] = newColor;

        int m = image.length;
        int n = image[0].length;

        for (int i = 0; i < 4; i++) {

            int nrow = sr + row[i];
            int ncol = sc + col[i];

            if (nrow >= 0 && nrow < m &&
                ncol >= 0 && ncol < n &&
                image[nrow][ncol] == initial &&
                ans[nrow][ncol] != newColor) {

                dfs(nrow, ncol, ans, image, newColor,
                    row, col, initial);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int initial = image[sr][sc];

        int[][] ans = image;

        int[] row = {-1, 0, +1, 0};
        int[] col = {0, +1, 0, -1};

        // If old color == new color, avoid unnecessary DFS
        if (initial != newColor) {
            dfs(sr, sc, ans, image, newColor, row, col, initial);
        }

        return ans;
    }

    // Print the matrix
    public static void printImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        System.out.println("Before Flood Fill:");

        printImage(image);

        int[][] result = floodFill(image, sr, sc, newColor);

        System.out.println("\nAfter Flood Fill:");

        printImage(result);
    }
}