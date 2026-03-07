package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _02_Leaders_In_An_Array {

    public static List<Integer> leaders(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        if (n == 0) return ans;

        // Last element is always a leader
        int max = nums[n - 1];
        ans.add(max);

        // Traverse from right
        for (int i = n - 2; i >= 0; i--) {

            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }

        }

        // Reverse to maintain original order
        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {-3, 4, 5, 1, -30, -10};

        List<Integer> result = leaders(nums);

        System.out.println("Leaders in array: " + result);
    }
}