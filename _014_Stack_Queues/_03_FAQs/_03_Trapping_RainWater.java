package _014_Stack_Queues._03_FAQs;

public class _03_Trapping_RainWater {
    static class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int left = 0, right = n - 1;
            int leftMax = 0, rightMax = 0;
            int total = 0;

            while (left < right) {
                if (height[left] <= height[right]) {
                    if (height[left] < leftMax) {
                        total += leftMax - height[left];
                    } else {
                        leftMax = height[left];
                    }
                    left++;
                } else {
                    if (height[right] < rightMax) {
                        total += rightMax - height[right];
                    } else {
                        rightMax = height[right];
                    }
                    right--;
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] heights1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Example 1: " + sol.trap(heights1)); // 6

        // Example 2
        int[] heights2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println("Example 2: " + sol.trap(heights2)); // 9

        // Quiz input
        int[] quiz = { 7, 4, 0, 9 };
        System.out.println("Quiz Input: " + java.util.Arrays.toString(quiz));
        System.out.println("Output: " + sol.trap(quiz));
    }
}
