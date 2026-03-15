package _007_Binary_Search._03_BS_On_Answers;

public class _04_Minimum_Days_To_Make_M_Bouquets {

    // Helper function to check whether it is possible
    // to make m bouquets on a given day
    private boolean possible(int[] nums, int day, int m, int k) {
        int cnt = 0;       // count consecutive bloomed flowers
        int noOfB = 0;     // total bouquets formed

        for (int bloomDay : nums) {
            if (bloomDay <= day) {
                cnt++;
            } else {
                noOfB += cnt / k;
                cnt = 0;
            }
        }

        // Add bouquets from the last consecutive segment
        noOfB += cnt / k;

        return noOfB >= m;
    }

    // Function to find the minimum day to make m bouquets
    public int roseGarden(int n, int[] nums, int k, int m) {
        long required = (long) m * k;

        // Impossible case
        if (required > n) return -1;

        // Find minimum and maximum bloom day
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for (int bloomDay : nums) {
            mini = Math.min(mini, bloomDay);
            maxi = Math.max(maxi, bloomDay);
        }

        int left = mini;
        int right = maxi;
        int ans = -1;

        // Binary search on answer
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (possible(nums, mid, m, k)) {
                ans = mid;
                right = mid - 1; // try to find smaller valid day
            } else {
                left = mid + 1;  // need more days
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _04_Minimum_Days_To_Make_M_Bouquets obj =
                new _04_Minimum_Days_To_Make_M_Bouquets();

        int[] nums1 = {7, 7, 7, 7, 13, 11, 12, 7};
        System.out.println(obj.roseGarden(nums1.length, nums1, 3, 2)); // 12

        int[] nums2 = {1, 10, 3, 10, 2};
        System.out.println(obj.roseGarden(nums2.length, nums2, 2, 3)); // -1

        int[] nums3 = {1, 10, 3, 10, 2};
        System.out.println(obj.roseGarden(nums3.length, nums3, 1, 3)); // 3
    }
}