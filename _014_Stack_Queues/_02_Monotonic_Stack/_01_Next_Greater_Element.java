package _014_Stack_Queues._02_Monotonic_Stack;

import java.util.Arrays;
import java.util.Stack;

public class _01_Next_Greater_Element {
    static class Solution {
        public int[] nextLargerElement(int[] arr) {
            int n = arr.length;
            int[] ans = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = n - 1; i >= 0; i--) {
                // Remove smaller or equal elements
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                // Top is the next greater, or -1 if stack empty
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
                // Push current element (maintain decreasing order)
                stack.push(arr[i]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] arr1 = { 1, 3, 2, 4 };
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(sol.nextLargerElement(arr1)));

        // Example 2
        int[] arr2 = { 6, 8, 0, 1, 3 };
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(sol.nextLargerElement(arr2)));

        // Quiz input
        int[] quizArr = { 1, 3, 2 };
        System.out.println("Quiz Input: " + Arrays.toString(quizArr));
        System.out.println("Output: " + Arrays.toString(sol.nextLargerElement(quizArr)));
    }
}
