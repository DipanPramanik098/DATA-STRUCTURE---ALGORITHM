package _005_ARRAY._04_Hard_Questions;

import java.util.*;

public class _01_Majority_Element2 {

    public static List<Integer> majorityElementTwo(int[] nums) {

        int n = nums.length;

        // Two candidates and their counts
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Step 1: Voting phase
        for (int num : nums) {

            if (candidate1 == num) {
                count1++;
            }

            else if (candidate2 == num) {
                count2++;
            }

            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }

            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }

            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Validation phase
        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1)
                count1++;

            if (num == candidate2)
                count2++;
        }

        List<Integer> result = new ArrayList<>();

        int threshold = n / 3;

        if (count1 > threshold)
            result.add(candidate1);

        if (count2 > threshold && candidate2 != candidate1)
            result.add(candidate2);

        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 1, 3, 2, 2, 3};

        List<Integer> ans = majorityElementTwo(nums);

        System.out.println("Majority Elements (> n/3): " + ans);
    }
}