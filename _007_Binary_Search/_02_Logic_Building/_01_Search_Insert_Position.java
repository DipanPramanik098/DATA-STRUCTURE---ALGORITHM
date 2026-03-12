package _007_Binary_Search._02_Logic_Building;

public class _01_Search_Insert_Position {

    // Function to return index of target
    // or the position where it should be inserted
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;

        // Left pointer
        int low = 0;

        // Right pointer
        int high = n - 1;

        // Default answer is n (insert at end)
        int ans = n;

        // Binary Search
        while (low <= high) {

            // Calculate middle index
            int mid = low + (high - low) / 2;

            // If nums[mid] >= target
            // this could be the insertion position
            if (nums[mid] >= target) {

                ans = mid;

                // Continue searching left half
                high = mid - 1;
            }
            else {

                // Target must be in right half
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        _01_Search_Insert_Position obj =
                new _01_Search_Insert_Position();

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int index = obj.searchInsert(nums, target);

        System.out.println("Insert Position: " + index);
    }
}