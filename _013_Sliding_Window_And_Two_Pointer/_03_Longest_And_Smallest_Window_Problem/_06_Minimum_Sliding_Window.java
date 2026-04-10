package _013_Sliding_Window_And_Two_Pointer._03_Longest_And_Smallest_Window_Problem;

public class _06_Minimum_Sliding_Window {

    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int[] hash = new int[256]; // frequency of characters in t (needed)

        // Count required characters
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        int count = 0; // number of characters from t satisfied in current window
        int l = 0, r = 0;

        while (r < s.length()) {
            char rightChar = s.charAt(r);
            // If this character is still needed, increment count
            if (hash[rightChar] > 0) {
                count++;
            }
            hash[rightChar]--; // consume this occurrence

            // Window is valid: contains all characters of t
            while (count == t.length()) {
                // Update minimum window
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                // Try to shrink from left
                char leftChar = s.charAt(l);
                hash[leftChar]++;
                // If after restoring we now need this character again, decrement count
                if (hash[leftChar] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }

        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _06_Minimum_Sliding_Window solver = new _06_Minimum_Sliding_Window();

        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(solver.minWindow(s1, t1)); // "BANC"

        String s2 = "a";
        String t2 = "a";
        System.out.println(solver.minWindow(s2, t2)); // "a"

        String s3 = "aAbBDdcC";
        String t3 = "Bc";
        System.out.println(solver.minWindow(s3, t3)); // "BDdc"
    }
}