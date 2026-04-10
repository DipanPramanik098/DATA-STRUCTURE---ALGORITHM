package _013_Sliding_Window_And_Two_Pointer._03_Longest_And_Smallest_Window_Problem;

public class _05_Longest_Repeating_Character_Replacement {

    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxFreq = 0;
        int l = 0, r = 0;
        int[] freq = new int[26]; // frequency of 'A' to 'Z'

        while (r < s.length()) {
            char rightChar = s.charAt(r);
            freq[rightChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[rightChar - 'A']);

            // Window invalid if we need more than k replacements
            if ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                freq[leftChar - 'A']--;
                l++;
            }

            // Window is now valid (or we just shrunk it)
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _05_Longest_Repeating_Character_Replacement solver = new _05_Longest_Repeating_Character_Replacement();

        String s1 = "BAABAABBBAAA";
        int k1 = 2;
        System.out.println(solver.characterReplacement(s1, k1)); // 6

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(solver.characterReplacement(s2, k2)); // 4

        String s3 = "ABCDEF";
        int k3 = 1;
        System.out.println(solver.characterReplacement(s3, k3)); // 2
    }
}