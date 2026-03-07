package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _03_Rearrange_Element_by_Sign {

    public static int[] rearrangeArray(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < n; i++) {

            if (nums[i] >= 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } 
            else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {-4, 4, -4, 4, -4, 4};

        int[] result = rearrangeArray(nums);

        System.out.println("Rearranged Array:");

        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}