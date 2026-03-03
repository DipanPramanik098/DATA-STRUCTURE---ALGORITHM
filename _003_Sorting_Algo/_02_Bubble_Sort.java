package _003_Sorting_Algo;

public class _02_Bubble_Sort {

    // Bubble Sort Method
    public static int[] bubbleSort(int[] nums) {

        int n = nums.length;

        // Outer loop controls the unsorted boundary
        for (int i = n - 1; i >= 0; i--) {

            // To check if any swap happens
            boolean isSwapped = false;

            // Inner loop pushes the largest element
            // in range [0...i] to index i
            for (int j = 0; j <= i - 1; j++) {

                // If current element is greater than next
                if (nums[j] > nums[j + 1]) {

                    // Swap elements
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    isSwapped = true;
                }
            }

            // If no swap occurred, array is already sorted
            if (!isSwapped) {
                break;
            }
        }

        return nums;
    }

    // Main method to test Bubble Sort
    public static void main(String[] args) {

        int[] nums = {7, 4, 1, 5, 3};

        System.out.print("Array Before Sorting: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        bubbleSort(nums);

        System.out.print("\nArray After Sorting: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}