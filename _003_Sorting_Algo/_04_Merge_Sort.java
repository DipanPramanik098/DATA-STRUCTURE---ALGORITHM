package _003_Sorting_Algo;

import java.util.*;

public class _04_Merge_Sort {

    // Merge two sorted halves
    public static void merge(int[] arr, int low, int mid, int high) {

        List<Integer> temp = new ArrayList<>();

        int left = low;       // Start of left half
        int right = mid + 1;  // Start of right half

        // Compare elements from both halves
        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transfer sorted elements back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Recursive Merge Sort function
    public static void mergeSortHelper(int[] arr, int low, int high) {

        // Base case
        if (low >= high)
            return;

        int mid = (low + high) / 2;

        // Sort left half
        mergeSortHelper(arr, low, mid);

        // Sort right half
        mergeSortHelper(arr, mid + 1, high);

        // Merge both halves
        merge(arr, low, mid, high);
    }

    // Main merge sort function
    public static int[] mergeSort(int[] nums) {

        mergeSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    // Main method
    public static void main(String[] args) {

        int[] arr = {9, 4, 7, 6, 3, 1, 5};

        System.out.print("Before Sorting: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        mergeSort(arr);

        System.out.print("\nAfter Sorting: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}