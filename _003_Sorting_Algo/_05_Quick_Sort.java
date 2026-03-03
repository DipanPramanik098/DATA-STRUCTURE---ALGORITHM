package _003_Sorting_Algo;

import java.util.Random;

public class _05_Quick_Sort {

    // Partition function
    public static int partition(int[] arr, int low, int high) {

        // Random pivot selection
        int randomIndex = low + new Random().nextInt(high - low + 1);
        swap(arr, low, randomIndex);

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Place pivot at correct position
        swap(arr, low, j);

        return j;
    }

    // Recursive Quick Sort
    public static void quickSortHelper(int[] arr, int low, int high) {

        if (low < high) {

            int pIndex = partition(arr, low, high);

            quickSortHelper(arr, low, pIndex - 1);
            quickSortHelper(arr, pIndex + 1, high);
        }
    }

    // Main quick sort function
    public static int[] quickSort(int[] nums) {

        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    // Swap helper function
    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method
    public static void main(String[] args) {

        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};

        System.out.print("Before Sorting: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr);

        System.out.print("\nAfter Sorting: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}