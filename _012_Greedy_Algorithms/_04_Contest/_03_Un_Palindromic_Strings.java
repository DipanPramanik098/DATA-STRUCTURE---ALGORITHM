package _012_Greedy_Algorithms._04_Contest;

public class _03_Un_Palindromic_Strings {

    // Function to find minimum cost to make string Un-Palindromic
    public int unPalindrome(String s) {
        int n = s.length();

        // Impossible if length is odd
        if ((n & 1) == 1) return -1;

        // Impossible if more than 26 distinct letters are needed
        if (n > 26) return -1;

        // Cost matrix: n rows (characters), 26 columns (target letters)
        int[][] cost = new int[n + 1][27]; // 1-based for Hungarian

        for (int i = 1; i <= n; i++) {
            char current = s.charAt(i - 1);

            for (int j = 1; j <= 26; j++) {
                char target = (char) ('a' + (j - 1));
                cost[i][j] = circularDistance(current, target);
            }
        }

        // Hungarian Algorithm for rectangular matrix (n <= 26)
        return hungarian(cost, n, 26);
    }

    // Minimum cyclic distance between two lowercase letters
    private int circularDistance(char a, char b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 26 - diff);
    }

    // Hungarian Algorithm for minimum assignment cost
    // cost matrix is 1-based indexed: rows = n, cols = m
    private int hungarian(int[][] cost, int n, int m) {
        int[] u = new int[n + 1];
        int[] v = new int[m + 1];
        int[] p = new int[m + 1];
        int[] way = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            p[0] = i;
            int j0 = 0;

            int[] minv = new int[m + 1];
            boolean[] used = new boolean[m + 1];

            for (int j = 0; j <= m; j++) {
                minv[j] = Integer.MAX_VALUE;
            }

            do {
                used[j0] = true;
                int i0 = p[j0];
                int delta = Integer.MAX_VALUE;
                int j1 = 0;

                for (int j = 1; j <= m; j++) {
                    if (!used[j]) {
                        int cur = cost[i0][j] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0;
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }

                for (int j = 0; j <= m; j++) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }

                j0 = j1;

            } while (p[j0] != 0);

            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }

        // p[j] = assigned row for column j
        int answer = 0;
        for (int j = 1; j <= m; j++) {
            if (p[j] != 0) {
                answer += cost[p[j]][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _03_Un_Palindromic_Strings obj = new _03_Un_Palindromic_Strings();

        String s1 = "abccba";
        String s2 = "xxuvva";
        String s3 = "abc";     // odd length -> impossible
        String s4 = "aaaa";    // needs all distinct

        System.out.println("Example 1: " + obj.unPalindrome(s1)); // 5
        System.out.println("Example 2: " + obj.unPalindrome(s2)); // 2
        System.out.println("Odd length case: " + obj.unPalindrome(s3)); // -1
        System.out.println("All same case: " + obj.unPalindrome(s4)); // some minimum cost
    }
}