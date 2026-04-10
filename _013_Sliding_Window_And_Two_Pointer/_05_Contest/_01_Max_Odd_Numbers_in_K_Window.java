package _013_Sliding_Window_And_Two_Pointer._05_Contest;

public class _01_Max_Odd_Numbers_in_K_Window {

    public int maxOddinKSizeWindow(int[] nums, int k) {
        int n = nums.length;
        int oddCount = 0;
        int maxOddCount = 0;

        // Count odds in the first window
        for (int i = 0; i < k; i++) {
            if (nums[i] % 2 != 0) oddCount++;
        }
        maxOddCount = oddCount;

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove element leaving the window
            if (nums[i - k] % 2 != 0) oddCount--;
            // Add element entering the window
            if (nums[i] % 2 != 0) oddCount++;
            // Update maximum
            maxOddCount = Math.max(maxOddCount, oddCount);
        }
        return maxOddCount;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _01_Max_Odd_Numbers_in_K_Window solver = new _01_Max_Odd_Numbers_in_K_Window();

        int[] nums1 = {2, 3, 3, 2, 9, 2, 5};
        int k1 = 4;
        System.out.println(solver.maxOddinKSizeWindow(nums1, k1)); // 3

        int[] nums2 = {9, 2, 2, 5, 8, 6};
        int k2 = 3;
        System.out.println(solver.maxOddinKSizeWindow(nums2, k2)); // 1

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k3 = 3;
        System.out.println(solver.maxOddinKSizeWindow(nums3, k3)); // 2 (e.g., [1,2,3] or [3,4,5] etc.)
    }
}