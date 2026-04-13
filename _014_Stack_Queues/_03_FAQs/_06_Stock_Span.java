package _014_Stack_Queues._03_FAQs;

import java.util.Stack;

public class _06_Stock_Span {
    static class Solution {
        public int[] stockSpan(int[] arr) {
            int n = arr.length;
            int[] span = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                // Pop while stack top value <= current price
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                // Previous greater element index
                int pgeIndex = stack.isEmpty() ? -1 : stack.peek();
                span[i] = i - pgeIndex;
                stack.push(i);
            }
            return span;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] prices1 = { 120, 100, 60, 80, 90, 110, 115 };
        System.out.println(java.util.Arrays.toString(sol.stockSpan(prices1)));

        // Example 2
        int[] prices2 = { 15, 13, 12, 14, 16, 20 };
        System.out.println(java.util.Arrays.toString(sol.stockSpan(prices2)));

        // Quiz input
        int[] quiz = { 30, 20, 25, 28, 27, 29, 35, 40 };
        System.out.println(java.util.Arrays.toString(sol.stockSpan(quiz)));
    }
}
