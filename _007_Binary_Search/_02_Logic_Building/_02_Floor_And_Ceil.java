package _007_Binary_Search._02_Logic_Building;

public class _02_Floor_And_Ceil {

    // Function to find floor value
    private int findFloor(int[] nums, int n, int x) {

        int low = 0;
        int high = n - 1;

        // Stores floor value
        int ans = -1;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If element <= x it can be floor
            if (nums[mid] <= x) {

                ans = nums[mid];

                // search right side for larger floor
                low = mid + 1;
            }
            else {

                // eliminate right half
                high = mid - 1;
            }
        }

        return ans;
    }

    // Function to find ceil value
    private int findCeil(int[] nums, int n, int x) {

        int low = 0;
        int high = n - 1;

        // Stores ceil value
        int ans = -1;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If element >= x it can be ceil
            if (nums[mid] >= x) {

                ans = nums[mid];

                // search left side for smaller ceil
                high = mid - 1;
            }
            else {

                // eliminate left half
                low = mid + 1;
            }
        }

        return ans;
    }

    // Function to return both floor and ceil
    public int[] getFloorAndCeil(int[] nums, int x) {

        int n = nums.length;

        // find floor
        int floor = findFloor(nums, n, x);

        // find ceil
        int ceil = findCeil(nums, n, x);

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {

        _02_Floor_And_Ceil obj = new _02_Floor_And_Ceil();

        int[] nums = {3,4,4,7,8,10};
        int x = 5;

        int[] result = obj.getFloorAndCeil(nums, x);

        System.out.println("Floor = " + result[0]);
        System.out.println("Ceil = " + result[1]);
    }
}