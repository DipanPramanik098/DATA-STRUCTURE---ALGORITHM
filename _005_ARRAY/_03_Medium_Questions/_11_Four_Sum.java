package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _11_Four_Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix first element
        for (int i = 0; i < n; i++) {

            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Step 3: Fix second element
            for (int j = i + 1; j < n; j++) {

                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // Two pointers for remaining elements
                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    // If sum equals target
                    if (sum == target) {

                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // Move pointers
                        k++;
                        l--;

                        // Skip duplicates for k
                        while (k < l && nums[k] == nums[k - 1])
                            k++;

                        // Skip duplicates for l
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }

                    // If sum is smaller than target
                    else if (sum < target) {
                        k++;
                    }

                    // If sum is greater than target
                    else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 3, 4, -3};
        int target = 5;

        List<List<Integer>> result = fourSum(nums, target);

        System.out.println("Quadruplets:");

        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }
}