package _007_Binary_Search._04_AdvanceQS;

public class _07_Split_Arr_Largest_Sum {

    // Helper function to count partitions such that
    // each partition has sum <= maxSum
    private int countPartitions(int[] a, int maxSum) {
        int partitions = 1;
        long subarraySum = 0;

        for (int num : a) {
            if (subarraySum + num <= maxSum) {
                subarraySum += num;
            } else {
                partitions++;
                subarraySum = num;
            }
        }

        return partitions;
    }

    // Function to minimize the largest subarray sum
    public int largestSubarraySumMinimized(int[] a, int k) {
        int low = a[0];
        int high = 0;

        // Find max element and total sum
        for (int num : a) {
            low = Math.max(low, num);
            high += num;
        }

        // Binary search on answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int partitions = countPartitions(a, mid);

            if (partitions > k) {
                // mid is too small
                low = mid + 1;
            } else {
                // mid is valid, try smaller answer
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        _07_Split_Arr_Largest_Sum obj = new _07_Split_Arr_Largest_Sum();

        int[] a1 = {1, 2, 3, 4, 5};
        System.out.println(obj.largestSubarraySumMinimized(a1, 3)); // 6

        int[] a2 = {3, 5, 1};
        System.out.println(obj.largestSubarraySumMinimized(a2, 3)); // 5

        int[] a3 = {1, 2, 3, 4, 5};
        System.out.println(obj.largestSubarraySumMinimized(a3, 2)); // 9
    }
}