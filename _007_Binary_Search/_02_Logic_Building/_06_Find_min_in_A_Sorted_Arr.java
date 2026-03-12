package _007_Binary_Search._02_Logic_Building;

public class _06_Find_min_in_A_Sorted_Arr {

    // Function to find minimum element in rotated sorted array
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        // Store minimum value
        int ans = Integer.MAX_VALUE;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {

                // Update minimum with leftmost element
                ans = Math.min(ans, nums[low]);

                // Move to right half
                low = mid + 1;
            }

            else {

                // Update minimum with mid element
                ans = Math.min(ans, nums[mid]);

                // Move to left half
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        _06_Find_min_in_A_Sorted_Arr obj =
                new _06_Find_min_in_A_Sorted_Arr();

        int[] nums = {4,5,6,7,0,1,2,3};

        int result = obj.findMin(nums);

        System.out.println("Minimum element: " + result);
    }
}