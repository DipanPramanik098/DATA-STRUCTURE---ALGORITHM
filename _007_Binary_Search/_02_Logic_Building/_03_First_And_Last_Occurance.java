package _007_Binary_Search._02_Logic_Building;

public class _03_First_And_Last_Occurance {

    // Function to find first occurrence
    private int firstOccurrence(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        // store first occurrence
        int first = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // if target found
            if (nums[mid] == target) {

                first = mid;

                // search left side for earlier occurrence
                high = mid - 1;
            }

            // move right
            else if (nums[mid] < target) {

                low = mid + 1;
            }

            // move left
            else {

                high = mid - 1;
            }
        }

        return first;
    }

    // Function to find last occurrence
    private int lastOccurrence(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        int last = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // if target found
            if (nums[mid] == target) {

                last = mid;

                // search right side for later occurrence
                low = mid + 1;
            }

            else if (nums[mid] < target) {

                low = mid + 1;
            }

            else {

                high = mid - 1;
            }
        }

        return last;
    }

    // Function to return both first and last positions
    public int[] searchRange(int[] nums, int target) {

        // find first occurrence
        int first = firstOccurrence(nums, target);

        // if target not present
        if (first == -1) {
            return new int[]{-1, -1};
        }

        // find last occurrence
        int last = lastOccurrence(nums, target);

        return new int[]{first, last};
    }

    public static void main(String[] args) {

        _03_First_And_Last_Occurance obj =
                new _03_First_And_Last_Occurance();

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] result = obj.searchRange(nums, target);

        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}