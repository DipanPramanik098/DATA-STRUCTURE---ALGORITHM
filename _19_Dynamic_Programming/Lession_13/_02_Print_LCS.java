package _19_Dynamic_Programming.Lession_13;

public class _02_Print_LCS {
    // ! https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383

    /*
     * ------------------------------------------------------------
     * DP Definition
     * ------------------------------------------------------------
     * dp[i][j] =
     * Length of LCS between
     * s1[0...i-1] and s2[0...j-1]
     *
     * After filling the DP table,
     * we backtrack from dp[n][m]
     * to construct the actual LCS.
     *
     * Time  : O(n*m)
     * Space : O(n*m)
     */

    // ============================================================
    // TABULATION + BACKTRACKING
    // ============================================================

    public String tabulation(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Build DP Table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        // -------------------------
        // Reconstruct the LCS
        // -------------------------

        StringBuilder ans = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                ans.append(s1.charAt(i - 1));

                i--;
                j--;

            }

            else if (dp[i - 1][j] > dp[i][j - 1]) {

                i--;

            }

            else {

                j--;

            }
        }

        // Characters are collected in reverse order
        return ans.reverse().toString();
    }

    // ============================================================
    // DRIVER
    // ============================================================

    public String findLCS(String s1, String s2) {

        return tabulation(s1, s2);
    }
}