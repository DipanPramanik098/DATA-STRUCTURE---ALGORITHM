package _014_Stack_Queues._03_FAQs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _02_Sliding_Window_Maximum {
    static class Solution {
        public int[] maxSlidingWindow(int[] arr, int k) {
            int n = arr.length;
            int[] ans = new int[n - k + 1];
            Deque<Integer> dq = new ArrayDeque<>(); // stores indices

            for (int i = 0; i < n; i++) {
                // remove indices out of current window
                if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    dq.pollFirst();
                }
                // maintain decreasing order: remove smaller elements from back
                while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                    dq.pollLast();
                }
                dq.offerLast(i);
                // record maximum for windows of size k
                if (i >= k - 1) {
                    ans[i - k + 1] = arr[dq.peekFirst()];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] arr1 = { 4, 0, -1, 3, 5, 3, 6, 8 };
        int k1 = 3;
        System.out.println("Input: " + Arrays.toString(arr1) + ", k=" + k1);
        System.out.println("Output: " + Arrays.toString(sol.maxSlidingWindow(arr1, k1)));

        // Quiz input
        int[] quiz = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int kq = 3;
        System.out.println("Quiz Input: " + Arrays.toString(quiz) + ", k=" + kq);
        System.out.println("Output: " + Arrays.toString(sol.maxSlidingWindow(quiz, kq)));
    }
}
