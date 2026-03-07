package _005_ARRAY._04_Hard_Questions;

import java.util.*;

public class _03_Count_Inversion {

    // Merge two sorted halves and count inversions
    private static long merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        long count = 0;

        // Compare elements from both halves
        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {

                temp[index++] = arr[left++];
            } else {

                temp[index++] = arr[right++];

                // All remaining elements in left half
                // will form inversions
                count += (mid - left + 1);
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[index++] = arr[right++];
        }

        // Copy sorted elements back to original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return count;
    }

    // Recursive merge sort function
    private static long mergeSort(int[] arr, int low, int high) {

        long count = 0;

        if (low < high) {

            int mid = (low + high) / 2;

            // Count inversions in left half
            count += mergeSort(arr, low, mid);

            // Count inversions in right half
            count += mergeSort(arr, mid + 1, high);

            // Count cross inversions
            count += merge(arr, low, mid, high);
        }

        return count;
    }

    // Main function
    public static long numberOfInversions(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {

        int[] nums = {9, 5, 4, 2};

        long result = numberOfInversions(nums);

        System.out.println("Number of inversions: " + result);
    }
}