package _007_Binary_Search._06_Contest;

import java.util.Arrays;

public class _02_Neighbours_Within_K_Distance {

    // First index where arr[index] >= target
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // First index where arr[index] > target
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int[] neighboursWithKDistance(int[] nums, int k) {
        int n = nums.length;

        // Copy original array and sort it
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        int[] ans = new int[n];

        // Find neighbour count for each original element
        for (int i = 0; i < n; i++) {
            int leftValue = nums[i] - k;
            int rightValue = nums[i] + k;

            int left = lowerBound(sorted, leftValue);
            int right = upperBound(sorted, rightValue);

            ans[i] = right - left;
        }

        return ans;
    }

    public static void main(String[] args) {
        _02_Neighbours_Within_K_Distance obj = new _02_Neighbours_Within_K_Distance();

        int[] nums1 = {1, 4, 7, 8, 9};
        int k1 = 3;
        System.out.println(Arrays.toString(obj.neighboursWithKDistance(nums1, k1)));
        // [2, 3, 4, 3, 3]

        int[] nums2 = {10, 3, 6, 9, 4};
        int k2 = 4;
        System.out.println(Arrays.toString(obj.neighboursWithKDistance(nums2, k2)));
        // [3, 3, 5, 3, 3]
    }
}