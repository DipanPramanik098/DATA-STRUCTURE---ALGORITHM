package _19_Dynamic_Programming.Lession_13;

import java.util.Arrays;

public class _01_Longest_Common_Subsequence {
    // ! https://leetcode.com/problems/longest-common-subsequence/description/

    // ==========================================================
    // 1. RECURSION
    // ==========================================================

    /*
     * TC : O(2^(n+m))
     * SC : O(n+m)
     */

    public int recursion(String s1, String s2, int i, int j) {

        // Base Case
        if (i == s1.length() || j == s2.length())
            return 0;

        // Characters Match
        if (s1.charAt(i) == s2.charAt(j))
            return 1 + recursion(s1, s2, i + 1, j + 1);

        // Characters Don't Match
        return Math.max(
                recursion(s1, s2, i + 1, j),
                recursion(s1, s2, i, j + 1)
        );
    }

    // ==========================================================
    // 2. MEMOIZATION (TOP DOWN)
    // ==========================================================

    /*
     * TC : O(n*m)
     * SC : O(n*m) + O(n+m)
     */

    public int memoization(String s1, String s2, int i, int j, int[][] dp) {

        if (i == s1.length() || j == s2.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {

            dp[i][j] = 1 + memoization(s1, s2, i + 1, j + 1, dp);

        } else {

            dp[i][j] = Math.max(
                    memoization(s1, s2, i + 1, j, dp),
                    memoization(s1, s2, i, j + 1, dp)
            );
        }

        return dp[i][j];
    }

    // ==========================================================
    // 3. TABULATION (BOTTOM UP)
    // ==========================================================

    /*
     * TC : O(n*m)
     * SC : O(n*m)
     */

    public int tabulation(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base Case already 0

        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {

                    dp[i][j] = 1 + dp[i + 1][j + 1];

                } else {

                    dp[i][j] = Math.max(
                            dp[i + 1][j],
                            dp[i][j + 1]
                    );
                }
            }
        }

        return dp[0][0];
    }

    // ==========================================================
    // 4. SPACE OPTIMIZATION
    // ==========================================================

    /*
     * TC : O(n*m)
     * SC : O(m)
     */

    public int spaceOptimization(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[] next = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {

                    curr[j] = 1 + next[j + 1];

                } else {

                    curr[j] = Math.max(
                            next[j],
                            curr[j + 1]
                    );
                }
            }

            next = curr;
            curr = new int[m + 1];
        }

        return next[0];
    }

    // ==========================================================
    // DRIVER METHOD
    // ==========================================================

    public int longestCommonSubsequence(String text1, String text2) {

        // ---------- Recursion ----------
        // return recursion(text1, text2, 0, 0);

        // ---------- Memoization ----------
        int[][] dp = new int[text1.length()][text2.length()];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        // return memoization(text1, text2, 0, 0, dp);

        // ---------- Tabulation ----------
        // return tabulation(text1, text2);

        // ---------- Space Optimization ----------
        return spaceOptimization(text1, text2);
    }
}