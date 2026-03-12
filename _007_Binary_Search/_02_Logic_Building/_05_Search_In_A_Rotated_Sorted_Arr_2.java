package _007_Binary_Search._02_Logic_Building;

public class _05_Search_In_A_Rotated_Sorted_Arr_2 {

    // Function to search target in rotated sorted array with duplicates
    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {

        int low = 0;
        int high = nums.length - 1;

        // Binary Search
        while (low <= high) {

            // Find middle index
            int mid = low + (high - low) / 2;

            // If target found
            if (nums[mid] == k) {
                return true;
            }

            // If duplicates at low, mid and high
            // we cannot decide the sorted half
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {

                // Check if target lies in left sorted half
                if (nums[low] <= k && k < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Otherwise right half is sorted
            else {

                // Check if target lies in right sorted half
                if (nums[mid] < k && k <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // Target not found
        return false;
    }

    public static void main(String[] args) {

        _05_Search_In_A_Rotated_Sorted_Arr_2 obj =
                new _05_Search_In_A_Rotated_Sorted_Arr_2();

        int[] nums = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 7;

        boolean found = obj.searchInARotatedSortedArrayII(nums, k);

        System.out.println("Target found: " + found);
    }
}