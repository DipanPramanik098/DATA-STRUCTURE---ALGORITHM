package _005_ARRAY._01_Fundamentals;

public class _06_Left_Rotate_Array_K_Places {

    // Helper method to reverse array between start and end
    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Method to rotate array left by k positions
    public static void rotateArray(int[] nums, int k) {

        int n = nums.length;

        // Edge case
        if (n == 0) return;

        k = k % n;  // Handle k > n

        // Step 1: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 2: Reverse remaining elements
        reverse(nums, k, n - 1);

        // Step 3: Reverse whole array
        reverse(nums, 0, n - 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int k = 4;

        rotateArray(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}