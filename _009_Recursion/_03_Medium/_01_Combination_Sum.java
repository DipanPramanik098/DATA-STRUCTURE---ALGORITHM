package _009_Recursion._03_Medium;

import java.util.*;

public class _01_Combination_Sum {

    // Recursive function
    public static void solve(int index, int[] arr, int target,
                             List<Integer> current, List<List<Integer>> ans) {

        // ✅ If target becomes 0 → valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // ❌ If out of bounds or target negative
        if (index == arr.length || target < 0) return;

        // 👉 Choice 1: Take current element (reuse allowed → same index)
        current.add(arr[index]);
        solve(index, arr, target - arr[index], current, ans);

        // Backtrack (remove last element)
        current.remove(current.size() - 1);

        // 👉 Choice 2: Skip current element (move to next index)
        solve(index + 1, arr, target, current, ans);
    }

    // Main function
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }
}