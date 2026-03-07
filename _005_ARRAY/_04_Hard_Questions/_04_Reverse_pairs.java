package _005_ARRAY._04_Hard_Questions;

import java.util.*;

public class _04_Reverse_pairs {

    // Main function
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Merge sort function
    private static int mergeSort(int[] nums, int low, int high) {

        if (low >= high)
            return 0;

        int mid = (low + high) / 2;

        int count = 0;

        // Count pairs in left half
        count += mergeSort(nums, low, mid);

        // Count pairs in right half
        count += mergeSort(nums, mid + 1, high);

        // Count cross reverse pairs
        count += countPairs(nums, low, mid, high);

        // Merge the sorted halves
        merge(nums, low, mid, high);

        return count;
    }

    // Count reverse pairs between two halves
    private static int countPairs(int[] nums, int low, int mid, int high) {

        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {

            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }

            count += (right - (mid + 1));
        }

        return count;
    }

    // Merge two sorted halves
    private static void merge(int[] nums, int low, int mid, int high) {

        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid)
            temp.add(nums[left++]);

        while (right <= high)
            temp.add(nums[right++]);

        // Copy back to original array
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {

        int[] nums = {6,4,4,2,2};

        int result = reversePairs(nums);

        System.out.println("Reverse pairs: " + result);
    }
}