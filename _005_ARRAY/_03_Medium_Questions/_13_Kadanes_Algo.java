package _005_ARRAY._03_Medium_Questions;

public class _13_Kadanes_Algo {

    // Function to find maximum subarray sum
    public static int maxSubArray(int[] nums) {

        long maxSum = Long.MIN_VALUE; // stores maximum sum found
        long currentSum = 0;          // running sum

        for (int i = 0; i < nums.length; i++) {

            // Add current element
            currentSum += nums[i];

            // Update maximum sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // If current sum becomes negative, reset it
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return (int) maxSum;
    }

    // public static int maxSubArrayPrint(int[] nums) {

    //     long maxSum = Long.MIN_VALUE;
    //     long currentSum = 0;

    //     int start = 0;
    //     int ansStart = -1;
    //     int ansEnd = -1;

    //     for (int i = 0; i < nums.length; i++) {

    //         if (currentSum == 0) {
    //             start = i;
    //         }

    //         currentSum += nums[i];

    //         if (currentSum > maxSum) {
    //             maxSum = currentSum;
    //             ansStart = start;
    //             ansEnd = i;
    //         }

    //         if (currentSum < 0) {
    //             currentSum = 0;
    //         }
    //     }

    //     // Print the subarray
    //     System.out.print("Maximum Subarray: ");

    //     for (int i = ansStart; i <= ansEnd; i++) {
    //         System.out.print(nums[i] + " ");
    //     }

    //     System.out.println();

    //     return (int) maxSum;
    // }

    public static void main(String[] args) {

        int[] nums = {-1, 2, 3, -1, 2, -6, 5};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum = " + result);
    }
}