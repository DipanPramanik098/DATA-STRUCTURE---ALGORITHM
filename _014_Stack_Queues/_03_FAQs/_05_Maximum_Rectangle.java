package _014_Stack_Queues._03_FAQs;

import java.util.Stack;

public class _05_Maximum_Rectangle {
    static class Solution {
        // Helper: largest rectangle in histogram (from previous problem)
        private int largestRectangleArea(int[] heights) {
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

        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[] heights = new int[n];
            int maxArea = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        heights[j]++;
                    } else {
                        heights[j] = 0;
                    }
                }
                maxArea = Math.max(maxArea, largestRectangleArea(heights));
            }
            return maxArea;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        char[][] matrix1 = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        System.out.println("Example 1: " + sol.maximalRectangle(matrix1)); // 6

        // Quiz input
        char[][] quiz = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' }
        };
        System.out.println("Quiz Input: " + java.util.Arrays.deepToString(quiz));
        System.out.println("Output: " + sol.maximalRectangle(quiz));
    }
}
