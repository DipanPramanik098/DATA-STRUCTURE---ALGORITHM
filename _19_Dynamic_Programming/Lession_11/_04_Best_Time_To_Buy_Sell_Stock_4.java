package _19_Dynamic_Programming.Lession_11;

import java.util.Arrays;

public class _04_Best_Time_To_Buy_Sell_Stock_4 {

    // Space Optimized
    public static int spaceOptimized(int[] prices, int transactions) {

        int n = prices.length;
        int buy = 1;

        int[][] prev = new int[2][transactions + 1];

        for (int i = n - 1; i >= 0; i--) {

            int[][] curr = new int[2][transactions + 1];

            // Base Case
            for (int[] row : curr) {
                Arrays.fill(row, 0);
            }

            for (int j = 0; j <= buy; j++) {
                for (int k = 1; k <= transactions; k++) {

                    if (j == 1) {
                        curr[j][k] = Math.max(
                                -prices[i] + prev[0][k], // Buy
                                prev[1][k]               // Skip
                        );
                    } else {
                        curr[j][k] = Math.max(
                                prices[i] + prev[1][k - 1], // Sell
                                prev[0][k]                  // Skip
                        );
                    }
                }
            }

            prev = curr;
        }

        return prev[1][transactions];
    }

    public static void main(String[] args) {

        int[] prices1 = {2, 4, 1};
        int k1 = 2;
        System.out.println("Maximum Profit: " + spaceOptimized(prices1, k1)); // 2

        int[] prices2 = {3, 2, 6, 5, 0, 3};
        int k2 = 2;
        System.out.println("Maximum Profit: " + spaceOptimized(prices2, k2)); // 7

        int[] prices3 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int k3 = 4;
        System.out.println("Maximum Profit: " + spaceOptimized(prices3, k3)); // 15
    }
}