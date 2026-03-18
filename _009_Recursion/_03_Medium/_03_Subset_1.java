package _009_Recursion._03_Medium;

import java.util.*;

public class _03_Subset_1 {

    // Recursive function
    public static void solve(int index, int sum, int[] nums, List<Integer> ans) {

        // ✅ Base case: all elements processed
        if (index == nums.length) {
            ans.add(sum);
            return;
        }

        // 👉 Choice 1: Take element
        solve(index + 1, sum + nums[index], nums, ans);

        // 👉 Choice 2: Skip element
        solve(index + 1, sum, nums, ans);
    }

    // Main function
    public static List<Integer> subsetSums(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        solve(0, 0, nums, ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3};

        System.out.println(subsetSums(nums));
    }
}