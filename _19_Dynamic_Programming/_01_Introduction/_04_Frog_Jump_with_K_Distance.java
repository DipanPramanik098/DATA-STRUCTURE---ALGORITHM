package _19_Dynamic_Programming._01_Introduction;

import java.util.Arrays;

public class _04_Frog_Jump_with_K_Distance {


    // =========================================================
    // 1. RECURSION
    // =========================================================

    public static int recursion(int[] height, int n, int k) {

        // Base case
        if (n == 0) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        // Try all possible jumps: 1 to k
        for (int jump = 1; jump <= k; jump++) {

            if (n - jump >= 0) {

                int cost = recursion(height, n - jump, k)
                        + Math.abs(height[n] - height[n - jump]);

                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }


    // =========================================================
    // 2. TOP-DOWN DP (MEMOIZATION)
    // =========================================================

    public static int topDown(int[] height, int n, int k, int[] dp) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        int minCost = Integer.MAX_VALUE;

        // Try all possible jumps: 1 to k
        for (int jump = 1; jump <= k; jump++) {

            if (n - jump >= 0) {

                int cost = topDown(height, n - jump, k, dp)
                        + Math.abs(height[n] - height[n - jump]);

                minCost = Math.min(minCost, cost);
            }
        }

        dp[n] = minCost;

        return dp[n];
    }


    // =========================================================
    // 3. BOTTOM-UP DP (TABULATION)
    // =========================================================

    public static int bottomUp(int[] height, int k) {

        int n = height.length;

        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n];

        // Cost to reach first stair
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int minCost = Integer.MAX_VALUE;

            // Try all possible jumps
            for (int jump = 1; jump <= k; jump++) {

                if (i - jump >= 0) {

                    int cost = dp[i - jump]
                            + Math.abs(height[i] - height[i - jump]);

                    minCost = Math.min(minCost, cost);
                }
            }

            dp[i] = minCost;
        }

        return dp[n - 1];
    }


    // =========================================================
    // 4. SPACE OPTIMIZATION
    // =========================================================

    public static int spaceOptimized(int[] height, int k) {

        int n = height.length;

        if (n <= 1) {
            return 0;
        }

        /*
         * We need the previous k dp values.
         *
         * So instead of dp[n],
         * we maintain a circular array of size k.
         */

        int[] dp = new int[k];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int minCost = Integer.MAX_VALUE;

            for (int jump = 1; jump <= k; jump++) {

                if (i - jump >= 0) {

                    int previousIndex = (i - jump) % k;

                    int cost = dp[previousIndex]
                            + Math.abs(height[i] - height[i - jump]);

                    minCost = Math.min(minCost, cost);
                }
            }

            // Store current dp value
            dp[i % k] = minCost;
        }

        return dp[(n - 1) % k];
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        int[] height = {10, 30, 40, 50, 20};

        int k = 3;

        int n = height.length;


        // 1. Recursion
        System.out.println(
                "Recursion: "
                        + recursion(height, n - 1, k)
        );


        // 2. Top-Down
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(
                "Top Down: "
                        + topDown(height, n - 1, k, dp)
        );


        // 3. Bottom-Up
        System.out.println(
                "Bottom Up: "
                        + bottomUp(height, k)
        );


        // 4. Space Optimized
        System.out.println(
                "Space Optimized: "
                        + spaceOptimized(height, k)
        );
    }
}