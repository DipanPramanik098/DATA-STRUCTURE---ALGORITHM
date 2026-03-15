package _007_Binary_Search._03_BS_On_Answers;

public class _03_Find_The_Smallest_Divisor {

    // Helper function to calculate the sum after dividing by divisor
    private int sumByD(int[] nums, int divisor) {
        int sum = 0;

        for (int num : nums) {
            // Ceiling of num / divisor using integer math
            sum += (num + divisor - 1) / divisor;
        }

        return sum;
    }

    // Function to find the smallest divisor
    public int smallestDivisor(int[] nums, int limit) {
        int n = nums.length;

        // Extra safety check
        if (n > limit) return -1;

        // Find maximum element in the array
        int maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }

        int low = 1;
        int high = maxi;

        // Binary search on answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int sum = sumByD(nums, mid);

            if (sum <= limit) {
                // mid is a possible answer, try smaller divisor
                high = mid - 1;
            } else {
                // mid is too small, need larger divisor
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        _03_Find_The_Smallest_Divisor obj = new _03_Find_The_Smallest_Divisor();

        int[] nums1 = {1, 2, 3, 4, 5};
        int limit1 = 8;
        System.out.println("Smallest Divisor: " + obj.smallestDivisor(nums1, limit1)); // 3

        int[] nums2 = {8, 4, 2, 3};
        int limit2 = 10;
        System.out.println("Smallest Divisor: " + obj.smallestDivisor(nums2, limit2)); // 2

        int[] nums3 = {8, 4, 2, 3};
        int limit3 = 4;
        System.out.println("Smallest Divisor: " + obj.smallestDivisor(nums3, limit3)); // 8
    }
}