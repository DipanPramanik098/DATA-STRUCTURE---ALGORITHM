package _009_Recursion._03_Medium;

import java.util.*;

public class _05_Combination_Sum_3 {

    // Recursive function
    public static void solve(int start, int k, int target,
                             List<Integer> current, List<List<Integer>> ans) {

        // ✅ Valid combination found
        if (target == 0 && current.size() == k) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // ❌ Invalid path
        if (target < 0 || current.size() > k) return;

        // Try numbers from start to 9
        for (int i = start; i <= 9; i++) {

            // 👉 Pick current number
            current.add(i);

            // Move to next number (no reuse allowed)
            solve(i + 1, k, target - i, current, ans);

            // 👉 Backtrack
            current.remove(current.size() - 1);
        }
    }

    // Main function
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;

        System.out.println(combinationSum3(k, n));
    }
}