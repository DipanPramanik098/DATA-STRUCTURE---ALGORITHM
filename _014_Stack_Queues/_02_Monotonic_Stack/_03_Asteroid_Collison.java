package _014_Stack_Queues._02_Monotonic_Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _03_Asteroid_Collison {
    static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            // Use list as stack for easy final order
            List<Integer> stack = new ArrayList<>();

            for (int ast : asteroids) {
                if (ast > 0) {
                    // Right-moving: push
                    stack.add(ast);
                } else {
                    // Left-moving: check collisions
                    while (!stack.isEmpty() && stack.get(stack.size() - 1) > 0
                            && stack.get(stack.size() - 1) < -ast) {
                        stack.remove(stack.size() - 1); // smaller right asteroid explodes
                    }
                    if (!stack.isEmpty() && stack.get(stack.size() - 1) == -ast) {
                        stack.remove(stack.size() - 1); // equal sizes: both explode
                    } else if (stack.isEmpty() || stack.get(stack.size() - 1) < 0) {
                        stack.add(ast); // no collision
                    }
                }
            }

            // Convert to int[]
            int[] result = new int[stack.size()];
            for (int i = 0; i < stack.size(); i++) {
                result[i] = stack.get(i);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] arr1 = { 1, 2, 3, -4, -2 };
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(sol.asteroidCollision(arr1)));

        // Example 2
        int[] arr2 = { 5, 10, -5, -10, 8, -8, -3, 12 };
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(sol.asteroidCollision(arr2)));

        // Quiz input
        int[] quiz = { 10, 2, -5 };
        System.out.println("Quiz Input: " + Arrays.toString(quiz));
        System.out.println("Output: " + Arrays.toString(sol.asteroidCollision(quiz)));
    }
}
