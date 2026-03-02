package _08_Basic_Recursion;

public class _03_Sum_Of_Array_Elements {
    // Public method (starting point)
    public static int arraySum(int[] nums) {
        return sum(nums, 0);
    }

    // Recursive helper method
    private static int sum(int[] nums, int index) {

        // Base Case: if index goes out of bounds
        if (index >= nums.length) {
            return 0;
        }

        // Recursive Case
        return nums[index] + sum(nums, index + 1);
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        int result = arraySum(nums);

        System.out.println("Sum of array elements is: " + result);
    }
}
