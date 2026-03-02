package _08_Basic_Recursion;

import java.util.ArrayList;

/**
 * Program to reverse a string using recursion.
 *
 * Approach:
 * 1. Use two pointers (left and right)
 * 2. Swap characters
 * 3. Move inward recursively
 *
 * Time Complexity  : O(N)
 * Space Complexity : O(N) (recursion stack)
 */

public class _04_Reverse_String {

    // Recursive helper function
    private static void reverse(ArrayList<Character> s, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        // Swap characters
        char temp = s.get(left);
        s.set(left, s.get(right));
        s.set(right, temp);

        // Recursive Call
        reverse(s, left + 1, right - 1);
    }

    // Function to reverse string
    public static ArrayList<Character> reverseString(ArrayList<Character> s) {

        reverse(s, 0, s.size() - 1);

        return s;
    }

    public static void main(String[] args) {

        ArrayList<Character> s = new ArrayList<>();

        s.add('h');
        s.add('e');
        s.add('l');
        s.add('l');
        s.add('o');

        System.out.println("Original: " + s);

        ArrayList<Character> reversed = reverseString(s);

        System.out.println("Reversed: " + reversed);
    }
}