package _005_ARRAY._01_Fundamentals;

public class _01_Linear_Search {

    // Linear Search Method
    public static int linearSearch(int[] nums, int target) {

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Check if current element equals target
            if (nums[i] == target) {
                return i;   // Return index if found
            }
        }

        // If target not found
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5, 3};
        int target = 3;

        int result = linearSearch(nums, target);

        System.out.println("Index: " + result);
    }
}