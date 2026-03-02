package _08_Basic_Recursion;

/**
 * Program to reverse an array using recursion.
 *
 * Approach:
 * 1. Use two pointers (left and right).
 * 2. Swap elements.
 * 3. Move inward recursively.
 *
 * Time Complexity  : O(N)
 * Space Complexity : O(N) (recursion stack)
 */

public class _07_Reverse_array {

    // Public method to reverse array
    public static int[] reverseArray(int[] nums) {
        reverse(nums, 0, nums.length - 1);
        return nums;
    }

    // Recursive helper method
    private static void reverse(int[] nums, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        // Swap elements
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        // Recursive call
        reverse(nums, left + 1, right - 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        System.out.print("Original Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        reverseArray(nums);

        System.out.print("\nReversed Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}