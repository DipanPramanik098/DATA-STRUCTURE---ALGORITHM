package _07_Basic_String;

public class _08_Valid_Anagrams {

    // Method to check if two strings are anagrams
    public static boolean anagramStrings(String s, String t) {

        // Step 1: Length must be equal
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency array for 26 lowercase letters
        int[] count = new int[26];

        // Step 3: Count characters of first string
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Step 4: Decrease count using second string
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        // Step 5: Check if all counts are zero
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "dog";
        String t2 = "cat";

        System.out.println("Example 1: " + anagramStrings(s1, t1));
        System.out.println("Example 2: " + anagramStrings(s2, t2));
    }
}