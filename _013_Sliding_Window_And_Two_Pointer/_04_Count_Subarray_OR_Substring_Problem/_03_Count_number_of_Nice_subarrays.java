package _013_Sliding_Window_And_Two_Pointer._04_Count_Subarray_OR_Substring_Problem;

public class _03_Count_number_of_Nice_subarrays {

    public int numberOfOddSubarrays(int[] nums, int k) {
        // Number of subarrays with ≤ k odds minus number with ≤ k-1 odds
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    private int countAtMost(int[] nums, int goal) {
        if (goal < 0) return 0; // No subarray can have negative odd count

        int l = 0, oddCount = 0, count = 0;
        for (int r = 0; r < nums.length; r++) {
            // Treat odd as 1, even as 0
            if (nums[r] % 2 == 1) oddCount++;

            // Shrink window if we exceed goal
            while (oddCount > goal) {
                if (nums[l] % 2 == 1) oddCount--;
                l++;
            }
            // All subarrays ending at r with start in [l, r] are valid
            count += (r - l + 1);
        }
        return count;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _03_Count_number_of_Nice_subarrays solver = new _03_Count_number_of_Nice_subarrays();

        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        System.out.println(solver.numberOfOddSubarrays(nums1, k1)); // 2

        int[] nums2 = {4, 8, 2};
        int k2 = 1;
        System.out.println(solver.numberOfOddSubarrays(nums2, k2)); // 0

        int[] nums3 = {41, 3, 5};
        int k3 = 2;
        System.out.println(solver.numberOfOddSubarrays(nums3, k3)); // 2
    }
}