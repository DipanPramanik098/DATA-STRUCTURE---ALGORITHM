package _012_Greedy_Algorithms._03_Hard;

public class _01_Valid_Parenthesis_Checker {

    // Function to check valid parenthesis with '*'
    public boolean isValid(String s) {

        int minOpen = 0; // minimum possible open brackets
        int maxOpen = 0; // maximum possible open brackets

        // Traverse the string
        for (char c : s.toCharArray()) {

            if (c == '(') {
                // Increase both
                minOpen++;
                maxOpen++;
            }
            else if (c == ')') {
                // Decrease both
                minOpen--;
                maxOpen--;
            }
            else { // c == '*'
                // '*' can be '(', ')' or empty
                minOpen--;  // treat as ')'
                maxOpen++;  // treat as '('
            }

            // If maxOpen < 0 → too many ')'
            if (maxOpen < 0) return false;

            // minOpen should not go below 0
            if (minOpen < 0) minOpen = 0;
        }

        // If minOpen == 0 → valid
        return minOpen == 0;
    }

    public static void main(String[] args) {

        _01_Valid_Parenthesis_Checker obj = new _01_Valid_Parenthesis_Checker();

        String s1 = "(*))";
        String s2 = "*(()";
        String s3 = "(*()*)";

        System.out.println("Input: " + s1 + " → " + obj.isValid(s1)); // true
        System.out.println("Input: " + s2 + " → " + obj.isValid(s2)); // false
        System.out.println("Input: " + s3 + " → " + obj.isValid(s3)); // true
    }
}