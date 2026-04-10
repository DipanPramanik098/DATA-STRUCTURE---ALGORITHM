package _013_Sliding_Window_And_Two_Pointer._02_Constant_Window;

public class _01_Maximum_Points_You_Can_Obtain_from_Cards {

    public static int maxScore(int[] cardScore, int k) {

        int lSum = 0, rSum = 0, maxSum = 0;

        // Step 1: Take first k elements
        for (int i = 0; i < k; i++) {
            lSum += cardScore[i];
        }

        maxSum = lSum;

        int rightIndex = cardScore.length - 1;

        // Step 2: Slide window
        for (int i = k - 1; i >= 0; i--) {

            // Remove from left
            lSum -= cardScore[i];

            // Add from right
            rSum += cardScore[rightIndex];
            rightIndex--;

            // Update max
            maxSum = Math.max(maxSum, lSum + rSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3;

        int result = maxScore(arr, k);

        System.out.println("Maximum Score: " + result);
    }
}