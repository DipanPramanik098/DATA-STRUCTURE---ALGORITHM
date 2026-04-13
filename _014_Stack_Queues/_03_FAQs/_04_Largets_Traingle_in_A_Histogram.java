package _014_Stack_Queues._03_FAQs;

import java.util.Stack;

public class _04_Largets_Traingle_in_A_Histogram {
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0;

            for (int i = 0; i <= n; i++) {
                int currHeight = (i == n) ? 0 : heights[i];
                while (!stack.isEmpty() && heights[stack.peek()] >= currHeight) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }
            return maxArea;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] heights1 = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Example 1: " + sol.largestRectangleArea(heights1)); // 10

        // Example 2
        int[] heights2 = { 3, 5, 1, 7, 5, 9 };
        System.out.println("Example 2: " + sol.largestRectangleArea(heights2)); // 15

        // Quiz input
        int[] quiz = { 2, 4 };
        System.out.println("Quiz Input: [2,4]");
        System.out.println("Output: " + sol.largestRectangleArea(quiz));
    }
}
