package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _09_Pattern_09 {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        // Call function to print diamond pattern
        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print diamond pattern
     * Example (n = 4):
     *    *
     *   ***
     *  *****
     * *******
     * *******
     *  *****
     *   ***
     *    *
     */
    public static void printPattern(int n) {

        // --------------------
        // 1️⃣ Upper Pyramid
        // --------------------
        for (int row = 1; row <= n; row++) {

            // Print spaces
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }

            // Print stars (odd count)
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }

            // Move to next line
            System.out.println();
        }

        // --------------------
        // 2️⃣ Lower Inverted Pyramid
        // --------------------
        for (int row = 1; row <= n; row++) {

            // Print spaces
            for (int space = 1; space <= row - 1; space++) {
                System.out.print(" ");
            }

            // Print decreasing stars
            for (int star = 1; star <= 2 * (n - row) + 1; star++) {
                System.out.print("*");
            }

            // Move to next line
            System.out.println();
        }
    }
}