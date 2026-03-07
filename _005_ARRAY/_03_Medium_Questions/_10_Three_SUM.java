package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _10_Three_SUM {

    public static List<List<Integer>> threeSum(int[] nums) {

        // List to store all unique triplets
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix one element and find the other two using two pointers
        for (int i = 0; i < n; i++) {

            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Two pointers
            int left = i + 1;
            int right = n - 1;

            // Step 3: Move pointers to find valid pairs
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // If sum is smaller than 0, move left pointer to increase sum
                if (sum < 0) {
                    left++;
                }

                // If sum is greater than 0, move right pointer to decrease sum
                else if (sum > 0) {
                    right--;
                }

                // If sum equals 0, we found a valid triplet
                else {

                    // Add triplet to answer list
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move pointers
                    left++;
                    right--;

                    // Skip duplicate elements for left pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate elements for right pointer
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {2, -2, 0, 3, -3, 5};

        List<List<Integer>> result = threeSum(nums);

        System.out.println("Triplets with sum = 0:");

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}