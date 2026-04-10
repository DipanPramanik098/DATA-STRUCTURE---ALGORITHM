package _013_Sliding_Window_And_Two_Pointer._03_Longest_And_Smallest_Window_Problem;

import java.util.HashMap;

public class _03_Fruit_Into_Basket {

    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int l = 0, r = 0;

        while (r < n) {
            // Add current fruit to window
            freq.put(fruits[r], freq.getOrDefault(fruits[r], 0) + 1);

            // If more than 2 types, shrink from left
            while (freq.size() > 2) {
                freq.put(fruits[l], freq.get(fruits[l]) - 1);
                if (freq.get(fruits[l]) == 0) {
                    freq.remove(fruits[l]);
                }
                l++;
            }

            // Now window is valid (≤ 2 types)
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _03_Fruit_Into_Basket solver = new _03_Fruit_Into_Basket();

        int[] fruits1 = {1, 2, 1};
        System.out.println(solver.totalFruits(fruits1)); // 3

        int[] fruits2 = {1, 2, 3, 2, 2};
        System.out.println(solver.totalFruits(fruits2)); // 4

        int[] fruits3 = {1, 2, 3, 4, 5};
        System.out.println(solver.totalFruits(fruits3)); // 2
    }
}