package _003_Sorting_Algo;

public class _03_Insertion_Sort {

    // Insertion Sort Method
    public static int[] insertionSort(int[] nums) {

        int n = nums.length;

        // Start from index 1
        for (int i = 1; i < n; i++) {

            int key = nums[i];   // Element to be placed correctly
            int j = i - 1;

            // Shift elements greater than key
            // to one position ahead
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            // Place key at correct position
            nums[j + 1] = key;
        }

        return nums;
    }

    // Main method for testing
    public static void main(String[] args) {

        int[] nums = {7, 4, 1, 5, 3};

        System.out.print("Array Before Sorting: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        insertionSort(nums);

        System.out.print("\nArray After Sorting: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}