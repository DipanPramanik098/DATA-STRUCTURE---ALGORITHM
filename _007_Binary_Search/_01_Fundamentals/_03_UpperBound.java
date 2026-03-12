package _007_Binary_Search._01_Fundamentals;

public class _03_UpperBound {

    // Function to find the upper bound of x
    public int upperBound(int[] nums, int x) {

        // Left pointer
        int low = 0;

        // Right pointer
        int high = nums.length - 1;

        // Default answer = array size
        // returned if no element > x exists
        int ans = nums.length;

        // Binary Search loop
        while (low <= high) {

            // Calculate middle index
            int mid = low + (high - low) / 2;

            // If nums[mid] is greater than x
            // it can be the upper bound
            if (nums[mid] > x) {

                // Store potential answer
                ans = mid;

                // Continue searching on left side
                high = mid - 1;
            }

            // Otherwise search right half
            else {
                low = mid + 1;
            }
        }

        // Return final upper bound index
        return ans;
    }

    public static void main(String[] args) {

        _03_UpperBound obj = new _03_UpperBound();

        int[] nums = {1,2,2,3};
        int x = 2;

        int index = obj.upperBound(nums, x);

        System.out.println("Upper Bound Index: " + index);
    }
}