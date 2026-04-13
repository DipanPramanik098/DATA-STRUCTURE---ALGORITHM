package _014_Stack_Queues._04_Contest;

import java.util.Stack;

public class _03_Maximum_Value_Of_A_Subarray {

    public static int maximumValueOfSubarray(int[] nums, int k) {
        int n = nums.length;

        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int maxValue = 0;

        // Try taking nums[i] as the minimum of subarray
        for (int i = 0; i < n; i++) {
            int left = prevSmaller[i] + 1;
            int right = nextSmaller[i] - 1;

            // Subarray must include index k
            if (left <= k && k <= right) {
                int length = right - left + 1;
                int value = nums[i] * length;
                maxValue = Math.max(maxValue, value);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 2, 8};
        int k1 = 2;

        int[] nums2 = {4, 6, 3, 5, 7, 8};
        int k2 = 4;

        System.out.println(maximumValueOfSubarray(nums1, k1)); // 8
        System.out.println(maximumValueOfSubarray(nums2, k2)); // 18
    }
}