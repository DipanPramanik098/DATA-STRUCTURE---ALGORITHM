package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _19_Pattern {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print hollow butterfly pattern
     * Example (n = 4):
     * ********
     * ***  ***
     * **    **
     * *      *
     * *      *
     * **    **
     * ***  ***
     * ********
     */
    public static void printPattern(int n) {

        // -------------------------
        // 1️⃣ Upper Half
        // -------------------------
        for (int row = 1; row <= n; row++) {

            // Left stars
            for (int star = 1; star <= n - row + 1; star++) {
                System.out.print("*");
            }

            // Middle spaces
            for (int space = 1; space <= 2 * (row - 1); space++) {
                System.out.print(" ");
            }

            // Right stars
            for (int star = 1; star <= n - row + 1; star++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // -------------------------
        // 2️⃣ Lower Half
        // -------------------------
        for (int row = 1; row <= n; row++) {

            // Left stars
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }

            // Middle spaces
            for (int space = 1; space <= 2 * (n - row); space++) {
                System.out.print(" ");
            }

            // Right stars
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}