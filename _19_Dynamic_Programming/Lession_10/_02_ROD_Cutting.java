package _19_Dynamic_Programming.Lession_10;

import java.util.Arrays;

public class _02_ROD_Cutting {

    /*
     * ==========================================================
     * ROD CUTTING PROBLEM
     * ==========================================================
     *
     * Given
     *
     * price[i]
     *
     * price of rod having length (i+1)
     *
     * Example
     *
     * Length : 1 2 3 4 5 6 7 8
     * Price  : 1 5 8 9 10 17 17 20
     *
     * Rod Length = 8
     *
     * We can cut the rod into any number of pieces.
     *
     * Objective:
     *
     * Find maximum selling price.
     *
     * ----------------------------------------------------------
     * Example
     * ----------------------------------------------------------
     *
     * Length = 8
     *
     * Possible cuts
     *
     * 8
     * 7+1
     * 6+2
     * 5+3
     * 4+4
     * 3+3+2
     * 2+2+2+2
     * ...
     *
     * Best answer
     *
     * 6 + 2
     *
     * 17 + 5 = 22
     *
     */

    // ==========================================================
    // 1. RECURSION
    // ==========================================================

    /*
     * solve(len)
     *
     * Returns maximum price obtainable
     * from rod of length len.
     *
     * For every possible first cut,
     * recursively solve remaining rod.
     */

    public static int solve1(int len, int[] price) {

        if (len == 0)
            return 0;

        int ans = 0;

        /*
         * Try every first cut.
         */

        for (int cut = 1; cut <= len; cut++) {

            ans = Math.max(
                    ans,
                    price[cut - 1] + solve1(len - cut, price));
        }

        return ans;
    }

    /*
     * Time
     *
     * Exponential
     *
     * Same states are solved repeatedly.
     */


    // ==========================================================
    // 2. TOP DOWN DP
    // ==========================================================

    /*
     * dp[len]
     *
     * Maximum obtainable price
     * from rod of length len.
     */

    public static int solve2(int len,
                             int[] price,
                             int[] dp) {

        if (len == 0)
            return 0;

        if (dp[len] != -1)
            return dp[len];

        int ans = 0;

        for (int cut = 1; cut <= len; cut++) {

            ans = Math.max(
                    ans,
                    price[cut - 1]
                            + solve2(
                                    len - cut,
                                    price,
                                    dp));
        }

        return dp[len] = ans;
    }

    /*
     * Time
     *
     * O(N²)
     *
     * Space
     *
     * O(N)
     */


    // ==========================================================
    // 3. BOTTOM UP DP
    // ==========================================================

    /*
     * dp[i]
     *
     * Maximum obtainable price
     * for rod length i.
     *
     * Transition
     *
     * dp[i]
     * =
     * max(
     * price[firstCut]
     * +
     * dp[remainingLength]
     * )
     */

    public static int solve3(int[] price) {

        int n = price.length;

        int[] dp = new int[n + 1];

        /*
         * Rod length 0
         *
         * Profit =0
         */

        dp[0] = 0;

        /*
         * Build answer
         * from smaller lengths.
         */

        for (int len = 1; len <= n; len++) {

            int best = 0;

            for (int cut = 1; cut <= len; cut++) {

                best = Math.max(
                        best,
                        price[cut - 1]
                                + dp[len - cut]);
            }

            dp[len] = best;
        }

        return dp[n];
    }

    /*
     * Time
     *
     * O(N²)
     *
     * Space
     *
     * O(N)
     */


    // ==========================================================
    // 4. SPACE OPTIMIZATION
    // ==========================================================

    /*
     * Unlike Knapsack,
     * Rod Cutting already uses
     * only ONE array.
     *
     * Therefore
     *
     * Bottom-Up itself
     * is the most space optimized solution.
     *
     * No further optimization exists.
     */

    public static int solve4(int[] price) {

        return solve3(price);
    }


    // ==========================================================
    // Driver
    // ==========================================================

    public static void main(String[] args) {

        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        int n = price.length;

        System.out.println("Recursive      : "
                + solve1(n, price));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Top Down DP    : "
                + solve2(n, price, dp));

        System.out.println("Bottom Up DP   : "
                + solve3(price));

        System.out.println("Space Optimized: "
                + solve4(price));
    }
}