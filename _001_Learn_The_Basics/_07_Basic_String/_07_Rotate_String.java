package _07_Basic_String;

public class _07_Rotate_String {

    // Method to check if goal is rotation of s
    public static boolean rotateString(String s, String goal) {

        // Step 1: Length must be equal
        if (s.length() != goal.length()) {
            return false;
        }

        // Step 2: Concatenate string with itself
        String doubled = s + s;

        // Step 3: Check if goal exists inside doubled string
        return doubled.contains(goal);
    }

    public static void main(String[] args) {

        String s1 = "abcde";
        String goal1 = "cdeab";

        String s2 = "abcde";
        String goal2 = "adeac";

        System.out.println("Example 1: " + rotateString(s1, goal1));
        System.out.println("Example 2: " + rotateString(s2, goal2));
    }
}