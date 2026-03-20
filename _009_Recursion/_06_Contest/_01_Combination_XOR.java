package _009_Recursion._06_Contest;

import java.util.ArrayList;
import java.util.List;

public class _01_Combination_XOR {
    public List<List<Integer>> combinationXor(int[] nums, int k) {
        // Final answer list to store all valid combinations
        List<List<Integer>> ans = new ArrayList<>();

        // Start backtracking from index 0
        // current XOR = 0
        // current path = empty
        backtrack(0, nums, k, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int[] nums, int k, int currentXor,
                           List<Integer> path, List<List<Integer>> ans) {

        // Base case:
        // if we have processed all elements
        if (index == nums.length) {

            // store only if:
            // 1) subset is non-empty
            // 2) XOR equals k
            if (!path.isEmpty() && currentXor == k) {
                ans.add(new ArrayList<>(path)); // store copy of current path
            }
            return;
        }

        // -----------------------------
        // Choice 1: Take current element
        // -----------------------------
        path.add(nums[index]); // add current number to combination

        backtrack(
            index + 1,              // move to next index
            nums,
            k,
            currentXor ^ nums[index], // update XOR
            path,
            ans
        );

        // Backtrack:
        // remove last added element before exploring next choice
        path.remove(path.size() - 1);

        // -----------------------------
        // Choice 2: Skip current element
        // -----------------------------
        backtrack(
            index + 1,   // move to next index
            nums,
            k,
            currentXor,  // XOR remains unchanged
            path,
            ans
        );
    }
}
