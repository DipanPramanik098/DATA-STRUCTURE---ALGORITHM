package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _14_Next_Permutation {

    // Function to generate next permutation
    public static void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: Find pivot (first decreasing element from right)
        int pivot = -1;

        for (int i = n - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If pivot not found, array is last permutation
        if (pivot == -1) {

            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find element just greater than pivot
        for (int i = n - 1; i > pivot; i--) {

            if (nums[i] > nums[pivot]) {

                swap(nums, i, pivot);
                break;
            }
        }

        // Step 4: Reverse suffix
        reverse(nums, pivot + 1, n - 1);
    }

    // Swap helper
    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse helper
    private static void reverse(int[] nums, int start, int end) {

        while (start < end) {

            swap(nums, start, end);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 5};

        System.out.print("Original: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }

        nextPermutation(nums);

        System.out.print("\nNext Permutation: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}