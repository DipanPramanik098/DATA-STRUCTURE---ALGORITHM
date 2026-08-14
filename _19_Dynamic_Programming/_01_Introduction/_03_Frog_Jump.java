package _19_Dynamic_Programming._01_Introduction;

import java.util.Arrays;

public class _03_Frog_Jump {

    // 1. Recursion
    public static int recursion(int[] height, int n) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Jump from n-1 to n
        int oneJump = recursion(height, n - 1)
                + Math.abs(height[n] - height[n - 1]);

        // Jump from n-2 to n
        int twoJump = Integer.MAX_VALUE;

        if (n > 1) {
            twoJump = recursion(height, n - 2)
                    + Math.abs(height[n] - height[n - 2]);
        }

        return Math.min(oneJump, twoJump);
    }


    // 2. Top-Down DP (Memoization)
    public static int topDown(int[] height, int n, int[] dp) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // Jump from n-1 to n
        int oneJump = topDown(height, n - 1, dp)
                + Math.abs(height[n] - height[n - 1]);

        // Jump from n-2 to n
        int twoJump = Integer.MAX_VALUE;

        if (n > 1) {
            twoJump = topDown(height, n - 2, dp)
                    + Math.abs(height[n] - height[n - 2]);
        }

        dp[n] = Math.min(oneJump, twoJump);

        return dp[n];
    }


    // 3. Bottom-Up DP (Tabulation)
    public static int bottomUp(int[] height) {

        int n = height.length;

        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n];

        // Cost to reach first stair
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            // Jump from i-1 to i
            int oneJump = dp[i - 1]
                    + Math.abs(height[i] - height[i - 1]);

            // Jump from i-2 to i
            int twoJump = Integer.MAX_VALUE;

            if (i > 1) {
                twoJump = dp[i - 2]
                        + Math.abs(height[i] - height[i - 2]);
            }

            dp[i] = Math.min(oneJump, twoJump);
        }

        return dp[n - 1];
    }


    // 4. Space Optimization
    public static int spaceOptimized(int[] height) {

        int n = height.length;

        if (n <= 1) {
            return 0;
        }

        // dp[i-2]
        int prev2 = 0;

        // dp[i-1]
        int prev1 = 0;

        for (int i = 1; i < n; i++) {

            // Jump from i-1 to i
            int oneJump = prev1
                    + Math.abs(height[i] - height[i - 1]);

            // Jump from i-2 to i
            int twoJump = Integer.MAX_VALUE;

            if (i > 1) {
                twoJump = prev2
                        + Math.abs(height[i] - height[i - 2]);
            }

            int curr = Math.min(oneJump, twoJump);

            // Shift
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


    public static void main(String[] args) {

        int[] height = {20, 30, 40, 20};

        int n = height.length;

        // 1. Recursion
        System.out.println(
                "Recursion: " + recursion(height, n - 1)
        );

        // 2. Top Down
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(
                "Top Down: " + topDown(height, n - 1, dp)
        );

        // 3. Bottom Up
        System.out.println(
                "Bottom Up: " + bottomUp(height)
        );

        // 4. Space Optimized
        System.out.println(
                "Space Optimized: " + spaceOptimized(height)
        );
    }
}