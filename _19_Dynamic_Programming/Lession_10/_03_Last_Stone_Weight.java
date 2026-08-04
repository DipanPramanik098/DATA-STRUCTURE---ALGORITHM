package _19_Dynamic_Programming.Lession_10;

public class _03_Last_Stone_Weight {

    /*
     * ===========================================================
     * Last Stone Weight II
     * ===========================================================
     *
     * Observation
     * ----------
     *
     * Every smash finally becomes
     *
     * |Group1 - Group2|
     *
     * Therefore,
     *
     * Instead of simulating smashing,
     * divide all stones into two groups.
     *
     * Let
     *
     * Group1 = S1
     * Group2 = S2
     *
     * S1 + S2 = TotalSum
     *
     * Final Answer
     *
     * = |S1-S2|
     *
     * = |TotalSum-2*S1|
     *
     * Therefore,
     * maximize S1 such that
     *
     * S1 <= TotalSum/2
     *
     * This becomes
     *
     * 0/1 Knapsack
     * /
     * Subset Sum
     */

    // =====================================================
    // Recursive
    // =====================================================

    public static int solve1(int idx, int sum, int[] stones) {

        if (idx == stones.length)
            return sum;

        int take =
                solve1(idx + 1,
                        sum + stones[idx],
                        stones);

        int notTake =
                solve1(idx + 1,
                        sum,
                        stones);

        return Math.max(take, notTake);
    }

    // =====================================================
    // Top Down DP
    // =====================================================

    public static int solve2(int idx,
                             int sum,
                             int[] stones,
                             int limit,
                             int[][] dp) {

        if (sum > limit)
            return Integer.MIN_VALUE;

        if (idx == stones.length)
            return sum;

        if (dp[idx][sum] != -1)
            return dp[idx][sum];

        int take =
                solve2(idx + 1,
                        sum + stones[idx],
                        stones,
                        limit,
                        dp);

        int notTake =
                solve2(idx + 1,
                        sum,
                        stones,
                        limit,
                        dp);

        return dp[idx][sum] =
                Math.max(take, notTake);
    }

    // =====================================================
    // Bottom Up DP
    // =====================================================

    public static int solve3(int[] stones) {

        int total = 0;

        for (int x : stones)
            total += x;

        int target = total / 2;

        /*
         * dp[j]
         *
         * Maximum subset sum achievable
         * not exceeding j.
         */

        int[] dp = new int[target + 1];

        for (int stone : stones) {

            /*
             * Reverse traversal because
             * every stone can be picked
             * only once.
             */

            for (int j = target; j >= stone; j--) {

                dp[j] =
                        Math.max(
                                dp[j],
                                stone + dp[j - stone]);
            }
        }

        int subset = dp[target];

        return total - 2 * subset;
    }

    // =====================================================
    // Driver
    // =====================================================

    public static void main(String[] args) {

        int[] stones =
                {2, 7, 4, 1, 8, 1};

        System.out.println(solve3(stones));
    }
}



// class Solution {

//     public int lastStoneWeightII(int[] stones) {

//         int sum = 0;

//         for (int x : stones)
//             sum += x;

//         int target = sum / 2;

//         int[] dp = new int[target + 1];

//         for (int stone : stones) {

//             for (int j = target; j >= stone; j--) {

//                 dp[j] = Math.max(dp[j],
//                         stone + dp[j - stone]);
//             }
//         }

//         return sum - 2 * dp[target];
//     }
// }