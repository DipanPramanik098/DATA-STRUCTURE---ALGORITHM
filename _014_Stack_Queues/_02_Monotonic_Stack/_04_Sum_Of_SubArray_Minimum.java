package _014_Stack_Queues._02_Monotonic_Stack;

import java.util.Arrays;
import java.util.Stack;

public class _04_Sum_Of_SubArray_Minimum {
    static class Solution {
        private static final int MOD = (int) 1e9 + 7;

        // Find indices of next smaller element (strictly smaller)
        private int[] findNSE(int[] arr) {
            int n = arr.length;
            int[] nse = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                nse[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            return nse;
        }

        // Find indices of previous smaller or equal element
        private int[] findPSEE(int[] arr) {
            int n = arr.length;
            int[] psee = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                psee[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            return psee;
        }

        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            int[] nse = findNSE(arr);
            int[] psee = findPSEE(arr);

            long total = 0;
            for (int i = 0; i < n; i++) {
                long left = i - psee[i]; // number of starting positions
                long right = nse[i] - i; // number of ending positions
                long freq = (left * right) % MOD;
                total = (total + (freq * arr[i]) % MOD) % MOD;
            }
            return (int) total;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] arr1 = { 3, 1, 2, 5 };
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + sol.sumSubarrayMins(arr1)); // 18

        // Example 2
        int[] arr2 = { 2, 3, 1 };
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + sol.sumSubarrayMins(arr2)); // 10

        // Quiz input
        int[] quiz = { 11, 81, 94, 43, 3 };
        System.out.println("Quiz Input: " + Arrays.toString(quiz));
        System.out.println("Output: " + sol.sumSubarrayMins(quiz));
    }
}
