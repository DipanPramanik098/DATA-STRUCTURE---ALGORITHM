package _005_ARRAY._01_Fundamentals;

public class _05_Left_Rotate_By_One {

    // Method to rotate array left by one
    public static void rotateArrayByOne(int[] nums) {

        // Edge case
        if (nums.length <= 1) {
            return;
        }

        // Store first element
        int temp = nums[0];

        // Shift elements left
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        // Place first element at end
        nums[nums.length - 1] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {7, 6, 5, 4};

        rotateArrayByOne(nums);

        // Print rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}