package _009_Recursion._03_Medium;

import java.util.*;

public class _02_Combination_Sum2 {

    // Recursive function
    public static void solve(int index, int[] arr, int target,
                             List<Integer> current, List<List<Integer>> ans) {

        // ✅ Found valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Loop through candidates
        for (int i = index; i < arr.length; i++) {

            // ❗ Skip duplicates
            if (i > index && arr[i] == arr[i - 1]) continue;

            // ❌ If element exceeds target → stop further (array sorted)
            if (arr[i] > target) break;

            // 👉 Pick element
            current.add(arr[i]);

            // Move to next index (no reuse)
            solve(i + 1, arr, target - arr[i], current, ans);

            // 👉 Backtrack
            current.remove(current.size() - 1);
        }
    }

    // Main function
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        // 🔥 Sort to handle duplicates
        Arrays.sort(candidates);

        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 1, 2, 7, 6, 1, 5};
        int target = 8;

        System.out.println(combinationSum2(candidates, target));
    }
}