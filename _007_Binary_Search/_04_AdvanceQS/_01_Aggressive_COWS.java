package _007_Binary_Search._04_AdvanceQS;

import java.util.Arrays;

public class _01_Aggressive_COWS {

    // Helper function to check whether we can place
    // 'cows' cows with at least 'dist' distance apart
    private boolean canWePlace(int[] nums, int dist, int cows) {
        int cntCows = 1;   // first cow placed at first stall
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= dist) {
                cntCows++;
                last = nums[i];

                if (cntCows >= cows) {
                    return true;
                }
            }
        }

        return false;
    }

    // Function to find the maximum possible minimum distance
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int low = 1;
        int high = nums[n - 1] - nums[0];

        // Binary search on answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canWePlace(nums, mid, k)) {
                // mid is possible, try bigger distance
                low = mid + 1;
            } else {
                // mid is not possible, try smaller distance
                high = mid - 1;
            }
        }

        return high; // largest valid distance
    }

    public static void main(String[] args) {
        _01_Aggressive_COWS obj = new _01_Aggressive_COWS();

        int[] nums1 = {0, 3, 4, 7, 10, 9};
        int k1 = 4;
        System.out.println(obj.aggressiveCows(nums1, k1)); // 3

        int[] nums2 = {4, 2, 1, 3, 6};
        int k2 = 2;
        System.out.println(obj.aggressiveCows(nums2, k2)); // 5

        int[] nums3 = {10, 1, 2, 7, 5};
        int k3 = 3;
        System.out.println(obj.aggressiveCows(nums3, k3)); // 4
    }
}