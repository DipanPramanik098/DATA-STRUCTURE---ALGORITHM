package _013_Sliding_Window_And_Two_Pointer._05_Contest;

public class _03_Number_of_Subarrays_with_Or_less_than_K {

    private int[] bitCnt = new int[32];   // how many numbers in window have each bit set
    private int curOR = 0;                // OR of current window

    // Add a number to the window
    private void add(int x) {
        for (int b = 0; b < 32; b++) {
            if ((x & (1 << b)) != 0) {
                if (bitCnt[b]++ == 0) {
                    curOR |= (1 << b);
                }
            }
        }
    }

    // Remove a number from the window
    private void remove(int x) {
        for (int b = 0; b < 32; b++) {
            if ((x & (1 << b)) != 0) {
                if (--bitCnt[b] == 0) {
                    curOR &= ~(1 << b);
                }
            }
        }
    }

    public long subarrayOrLessThanKCount(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            add(nums[right]);

            while (left <= right && curOR > k) {
                remove(nums[left]);
                left++;
            }

            ans += (right - left + 1);
        }
        return ans;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _03_Number_of_Subarrays_with_Or_less_than_K solver = new _03_Number_of_Subarrays_with_Or_less_than_K();

        int[] nums1 = {2, 3, 3, 2, 9, 2, 5};
        int k1 = 4;
        System.out.println(solver.subarrayOrLessThanKCount(nums1, k1)); // 11

        int[] nums2 = {9, 2, 2, 5, 8, 6};
        int k2 = 3;
        System.out.println(solver.subarrayOrLessThanKCount(nums2, k2)); // 3
    }
}