package _014_Stack_Queues._02_Monotonic_Stack;

import java.util.Arrays;
import java.util.Stack;

public class _05_Sum_Of_SubArray_Ranges {
    static class Solution {

        // Next smaller element (strictly smaller) index to right
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

        // Previous smaller or equal element index to left
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

        // Next greater element (strictly greater) index to right
        private int[] findNGE(int[] arr) {
            int n = arr.length;
            int[] nge = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                nge[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            return nge;
        }

        // Previous greater or equal element index to left
        private int[] findPGEE(int[] arr) {
            int n = arr.length;
            int[] pgee = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    stack.pop();
                }
                pgee[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            return pgee;
        }

        private long sumSubarrayMins(int[] arr) {
            int[] nse = findNSE(arr);
            int[] psee = findPSEE(arr);
            long total = 0;
            for (int i = 0; i < arr.length; i++) {
                long left = i - psee[i];
                long right = nse[i] - i;
                total += left * right * arr[i];
            }
            return total;
        }

        private long sumSubarrayMaxs(int[] arr) {
            int[] nge = findNGE(arr);
            int[] pgee = findPGEE(arr);
            long total = 0;
            for (int i = 0; i < arr.length; i++) {
                long left = i - pgee[i];
                long right = nge[i] - i;
                total += left * right * arr[i];
            }
            return total;
        }

        public long subArrayRanges(int[] nums) {
            return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] arr1 = { 1, 2, 3 };
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + sol.subArrayRanges(arr1)); // 4

        // Example 2
        int[] arr2 = { 1, 3, 3 };
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + sol.subArrayRanges(arr2)); // 4

        // Quiz input
        int[] quiz = { 4, -2, -3, 4, 1 };
        System.out.println("Quiz Input: " + Arrays.toString(quiz));
        System.out.println("Output: " + sol.subArrayRanges(quiz));
    }
}
