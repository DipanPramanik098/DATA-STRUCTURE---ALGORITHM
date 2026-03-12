package _007_Binary_Search._02_Logic_Building;

public class _08_Single_Element_In_Sorted_Arr {

    // Function to find single element
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        // Edge case: only one element
        if (n == 1) return nums[0];

        // Check first element
        if (nums[0] != nums[1]) return nums[0];

        // Check last element
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1;
        int high = n - 2;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check if nums[mid] is the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Check if we are in the left part
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {

                // Move right
                low = mid + 1;
            }

            // Otherwise move left
            else {
                high = mid - 1;
            }
        }

        // Dummy return
        return -1;
    }

    public static void main(String[] args) {

        _08_Single_Element_In_Sorted_Arr obj =
                new _08_Single_Element_In_Sorted_Arr();

        int[] nums = {1,1,2,2,3,3,4,5,5};

        int result = obj.singleNonDuplicate(nums);

        System.out.println("Single element: " + result);
    }
}