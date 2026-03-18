package _009_Recursion._03_Medium;

import java.util.*;

public class _04_Subset_2 {

    // Recursive function to generate all unique subsets
    public static void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {

        // ✅ Add current subset to answer
        ans.add(new ArrayList<>(current));

        // Try all elements from current index
        for (int i = index; i < nums.length; i++) {

            // ❗ Skip duplicates at same recursion level
            if (i > index && nums[i] == nums[i - 1]) continue;

            // 👉 Pick current element
            current.add(nums[i]);

            // Move to next index
            solve(i + 1, nums, current, ans);

            // 👉 Backtrack
            current.remove(current.size() - 1);
        }
    }

    // Main function
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        // 🔥 Sort array to bring duplicates together
        Arrays.sort(nums);

        solve(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        System.out.println(subsetsWithDup(nums));
    }
}