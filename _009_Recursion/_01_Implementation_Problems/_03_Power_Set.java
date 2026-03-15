package _009_Recursion._01_Implementation_Problems;

import java.util.ArrayList;
import java.util.List;

public class _03_Power_Set {

    // Recursive helper function
    private void backtrack(int index, int n, int[] nums,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Base Case:
        // When all elements are processed
        if (index == n) {

            // Add a copy of current subset
            ans.add(new ArrayList<>(current));
            return;
        }

        // Case 1: Exclude current element
        backtrack(index + 1, n, nums, current, ans);

        // Case 2: Include current element
        current.add(nums[index]);

        backtrack(index + 1, n, nums, current, ans);

        // Backtrack
        current.remove(current.size() - 1);
    }

    // Main function
    public List<List<Integer>> powerSet(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums.length, nums, current, ans);

        return ans;
    }

    public static void main(String[] args) {

        _03_Power_Set obj = new _03_Power_Set();

        int[] nums = {1,2,3};

        List<List<Integer>> result = obj.powerSet(nums);

        System.out.println(result);
    }
}