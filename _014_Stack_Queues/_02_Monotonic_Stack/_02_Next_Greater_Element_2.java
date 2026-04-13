package _014_Stack_Queues._02_Monotonic_Stack;

import java.util.Arrays;
import java.util.Stack;

public class _02_Next_Greater_Element_2 {
    static class Solution {
        public int[] nextGreaterElements(int[] arr) {
            int n = arr.length;
            int[] ans = new int[n];
            Stack<Integer> stack = new Stack<>();

            // Traverse 2n elements virtually
            for (int i = 2 * n - 1; i >= 0; i--) {
                int idx = i % n;
                int curr = arr[idx];

                // Maintain decreasing stack
                while (!stack.isEmpty() && stack.peek() <= curr) {
                    stack.pop();
                }

                // Only record answer for original indices (first half)
                if (i < n) {
                    ans[idx] = stack.isEmpty() ? -1 : stack.peek();
                }

                stack.push(curr);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] arr1 = { 3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9 };
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(sol.nextGreaterElements(arr1)));

        // Example 2
        int[] arr2 = { 5, 7, 1, 7, 6, 0 };
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(sol.nextGreaterElements(arr2)));

        // Quiz input
        int[] quizArr = { 1, 2, 3, 4, 5 };
        System.out.println("Quiz Input: " + Arrays.toString(quizArr));
        System.out.println("Output: " + Arrays.toString(sol.nextGreaterElements(quizArr)));
    }
}
