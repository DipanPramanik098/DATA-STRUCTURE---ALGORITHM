package _07_Basic_String;

import java.util.*;

public class _09_Sort_Character_by_freq {

    // Helper class to store frequency and character
    static class Pair {
        int freq;
        char ch;

        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }

    public static List<Character> frequencySort(String s) {

        // Step 1: Create frequency array for 'a' to 'z'
        Pair[] freq = new Pair[26];

        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char) (i + 'a'));
        }

        // Step 2: Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        // Step 3: Sort using custom comparator
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq)
                return p2.freq - p1.freq;   // Higher frequency first
            return p1.ch - p2.ch;           // Alphabetical order
        });

        // Step 4: Collect result
        List<Character> result = new ArrayList<>();

        for (Pair p : freq) {
            if (p.freq > 0) {
                result.add(p.ch);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String s1 = "tree";
        String s2 = "raaaajj";

        System.out.println("Example 1: " + frequencySort(s1));
        System.out.println("Example 2: " + frequencySort(s2));
    }
}