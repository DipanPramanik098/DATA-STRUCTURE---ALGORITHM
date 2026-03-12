package _007_Binary_Search._01_Fundamentals;

public class _02_Lower_Bound {

    // Function to find the lower bound of x
    public int lowerBound(int[] nums, int x) {

        // Left pointer
        int low = 0;

        // Right pointer
        int high = nums.length - 1;

        // Default answer = array size
        // This will be returned if no element >= x exists
        int ans = nums.length;

        // Binary search loop
        while (low <= high) {

            // Find middle index
            int mid = low + (high - low) / 2;

            // If nums[mid] is >= x
            // it can be a potential answer
            if (nums[mid] >= x) {

                // Store the index
                ans = mid;

                // Try to find a smaller index on the left
                high = mid - 1;
            }

            // If nums[mid] < x
            // lower bound must be on the right
            else {
                low = mid + 1;
            }
        }

        // Return final answer
        return ans;
    }

    public static void main(String[] args) {

        _02_Lower_Bound obj = new _02_Lower_Bound();

        int[] nums = {1,2,2,3};
        int x = 2;

        int index = obj.lowerBound(nums, x);

        System.out.println("Lower Bound Index: " + index);
    }
}