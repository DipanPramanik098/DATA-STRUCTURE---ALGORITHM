package _007_Binary_Search._02_Logic_Building;

public class _04_Search_In_A_Rotated_Sorted_Arr_1 {

    // Function to search target in rotated sorted array
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        // Binary Search
        while (low <= high) {

            // Find middle index
            int mid = low + (high - low) / 2;

            // If target found
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {

                // Check if target lies in left sorted half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Otherwise right half is sorted
            else {

                // Check if target lies in right sorted half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {

        _04_Search_In_A_Rotated_Sorted_Arr_1 obj =
                new _04_Search_In_A_Rotated_Sorted_Arr_1();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;

        int index = obj.search(nums, target);

        System.out.println("Target index: " + index);
    }
}