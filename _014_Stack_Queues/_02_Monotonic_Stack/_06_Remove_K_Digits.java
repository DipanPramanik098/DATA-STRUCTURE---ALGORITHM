package _014_Stack_Queues._02_Monotonic_Stack;

import java.util.Stack;

public class _06_Remove_K_Digits {
    static class Solution {
        public String removeKdigits(String nums, int k) {
            Stack<Character> stack = new Stack<>();

            for (char digit : nums.toCharArray()) {
                while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                    stack.pop();
                    k--;
                }
                stack.push(digit);
            }

            // If still need to remove, remove from the end
            while (k > 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }

            // Build result from stack (reversed order)
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            // Remove leading zeros (which are at the end of sb)
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            }

            // Reverse to correct order
            sb.reverse();

            return sb.length() == 0 ? "0" : sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        System.out.println(sol.removeKdigits("541892", 2)); // "1892"
        // Example 2
        System.out.println(sol.removeKdigits("1002991", 3)); // "21"
        // Quiz input
        System.out.println(sol.removeKdigits("10", 2)); // "0"
    }
}
