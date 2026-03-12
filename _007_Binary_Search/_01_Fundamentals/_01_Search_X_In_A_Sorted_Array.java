package _007_Binary_Search._01_Fundamentals;

public class _01_Search_X_In_A_Sorted_Array {

    public int search(int[] nums, int target) {

        // Left pointer starting from beginning
        int left = 0;

        // Right pointer starting from end
        int right = nums.length - 1;

        // Continue searching while valid range exists
        while (left <= right) {

            // Find middle index
            // Using this formula prevents overflow
            int mid = left + (right - left) / 2;

            // If target found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // If target is greater than mid value
            // search in right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller than mid value
            // search in left half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {

        _01_Search_X_In_A_Sorted_Array obj =
                new _01_Search_X_In_A_Sorted_Array();

        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        int index = obj.search(nums, target);

        System.out.println("Target index: " + index);
    }
}