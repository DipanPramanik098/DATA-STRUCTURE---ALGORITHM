package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _22_Pattern {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close();
    }

    /*
     * Function to print concentric number square pattern
     * Example (n = 4):
     * 4 4 4 4 4 4 4
     * 4 3 3 3 3 3 4
     * 4 3 2 2 2 3 4
     * 4 3 2 1 2 3 4
     * 4 3 2 2 2 3 4
     * 4 3 3 3 3 3 4
     * 4 4 4 4 4 4 4
     */
    public static void printPattern(int n) {

        int size = 2 * n - 1;

        // Outer loop → rows
        for (int i = 0; i < size; i++) {

            // Inner loop → columns
            for (int j = 0; j < size; j++) {

                int top = i;
                int left = j;
                int bottom = size - 1 - i;
                int right = size - 1 - j;

                int minDistance = Math.min(
                        Math.min(top, bottom),
                        Math.min(left, right)
                );

                int value = n - minDistance;

                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}