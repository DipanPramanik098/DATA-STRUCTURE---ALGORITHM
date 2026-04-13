package _014_Stack_Queues._01_Implementation_Using_Dufferent_DS;

import java.util.Stack;

public class _07_Balanced_Parenthesis {
    static class Solution {
        // Helper to match opening and closing brackets
        private boolean isMatched(char open, char close) {
            return (open == '(' && close == ')') ||
                    (open == '[' && close == ']') ||
                    (open == '{' && close == '}');
        }

        public boolean isValid(String str) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                // If opening bracket, push to stack
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                }
                // Else closing bracket
                else {
                    // No matching open bracket
                    if (stack.isEmpty())
                        return false;

                    char top = stack.pop();
                    if (!isMatched(top, ch))
                        return false;
                }
            }

            // Stack must be empty for all brackets to be matched
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Example 1
        String str1 = "()[{}()]";
        System.out.println("Input: " + str1);
        System.out.println("Output: " + sol.isValid(str1)); // true

        // Test Example 2
        String str2 = "[()";
        System.out.println("Input: " + str2);
        System.out.println("Output: " + sol.isValid(str2)); // false

        // Quiz input
        String quizStr = "{[()]}";
        System.out.println("Quiz Input: " + quizStr);
        System.out.println("Output: " + sol.isValid(quizStr)); // true
    }
}
