package _007_Binary_Search._02_Logic_Building;

public class _07_Find_How_Many_Time_Array_Rotated {

    // Function to find number of rotations
    public int findKRotation(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If entire search space is sorted
            if (nums[low] <= nums[high]) {

                if (nums[low] < ans) {
                    ans = nums[low];
                    index = low;
                }
                break;
            }

            // If left half is sorted
            if (nums[low] <= nums[mid]) {

                if (nums[low] < ans) {
                    ans = nums[low];
                    index = low;
                }

                // move to right half
                low = mid + 1;
            }

            // Otherwise right half is sorted
            else {

                if (nums[mid] < ans) {
                    ans = nums[mid];
                    index = mid;
                }

                // move to left half
                high = mid - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {

        _07_Find_How_Many_Time_Array_Rotated obj =
                new _07_Find_How_Many_Time_Array_Rotated();

        int[] nums = {4,5,6,7,0,1,2,3};

        int rotations = obj.findKRotation(nums);

        System.out.println("Array rotated " + rotations + " times.");
    }
}