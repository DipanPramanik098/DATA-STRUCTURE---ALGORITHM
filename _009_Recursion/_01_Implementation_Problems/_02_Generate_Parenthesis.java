package _009_Recursion._01_Implementation_Problems;

import java.util.ArrayList;
import java.util.List;

public class _02_Generate_Parenthesis {

    // Main function that returns all valid parenthesis combinations
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // Start recursion with 0 open, 0 close, empty string
        generate(0, 0, n, "", result);

        return result;
    }

    // Recursive helper function
    private void generate(int open, int close, int n, String current, List<String> result) {

        // Base case:
        // If current string length becomes 2*n,
        // then one valid combination is formed
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add opening bracket if we still have opening brackets left
        if (open < n) {
            generate(open + 1, close, n, current + "(", result);
        }

        // Add closing bracket only if it does not make string invalid
        // close should always be less than open before adding ')'
        if (close < open) {
            generate(open, close + 1, n, current + ")", result);
        }
    }

    public static void main(String[] args) {
        _02_Generate_Parenthesis obj = new _02_Generate_Parenthesis();

        int n = 3;
        List<String> ans = obj.generateParenthesis(n);

        System.out.println(ans);
    }
}