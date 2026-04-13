package _014_Stack_Queues._04_Contest;

import java.util.Stack;

public class _02_Lexicographically_Smallest_String {

    public static String smallestString(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        // Step 1: Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Stack<Character> st = new Stack<>();

        // Step 2: Traverse the string
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            // Current character is now being processed,
            // so reduce its remaining frequency
            freq[idx]--;

            // If already present in stack, skip it
            if (visited[idx]) {
                continue;
            }

            // Remove characters from stack while:
            // 1. stack is not empty
            // 2. top character is greater than current character
            // 3. top character appears later again
            while (!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] > 0) {
                visited[st.pop() - 'a'] = false;
            }

            // Push current character into stack
            st.push(ch);
            visited[idx] = true;
        }

        // Step 3: Build answer from stack
        StringBuilder ans = new StringBuilder();
        for (char ch : st) {
            ans.append(ch);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s1 = "ecbacd";
        String s2 = "aaaabbbbcccc";

        System.out.println(smallestString(s1)); // ebacd
        System.out.println(smallestString(s2)); // abc
    }
}