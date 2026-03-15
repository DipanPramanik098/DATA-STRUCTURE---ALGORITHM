package _007_Binary_Search._03_BS_On_Answers;

public class _04_Koko_Eating_Bananas {

    // Helper function to find maximum element in array
    private int findMax(int[] nums) {
        int maxi = Integer.MIN_VALUE;

        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }

        return maxi;
    }

    // Helper function to calculate total hours needed at a given eating speed
    private long calculateTotalHours(int[] nums, int hourly) {
        long totalH = 0;

        for (int num : nums) {
            // Ceiling division using integer math
            totalH += (num + hourly - 1L) / hourly;
        }

        return totalH;
    }

    // Function to find minimum eating speed
    public int minimumRateToEatBananas(int[] nums, int h) {
        int low = 1;
        int high = findMax(nums);

        // Binary search on answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalH = calculateTotalHours(nums, mid);

            if (totalH <= h) {
                // mid works, try to find a smaller valid speed
                high = mid - 1;
            } else {
                // mid is too slow, need higher speed
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        _04_Koko_Eating_Bananas obj = new _04_Koko_Eating_Bananas();

        int[] nums1 = {7, 15, 6, 3};
        int h1 = 8;
        System.out.println(obj.minimumRateToEatBananas(nums1, h1)); // 5

        int[] nums2 = {25, 12, 8, 14, 19};
        int h2 = 5;
        System.out.println(obj.minimumRateToEatBananas(nums2, h2)); // 25

        int[] nums3 = {3, 7, 6, 11};
        int h3 = 8;
        System.out.println(obj.minimumRateToEatBananas(nums3, h3)); // 4
    }
}