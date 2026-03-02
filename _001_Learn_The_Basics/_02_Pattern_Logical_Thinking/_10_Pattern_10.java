package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _10_Pattern_10 {

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        // Call function to print pattern
        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print half diamond star pattern
     * Example (n = 4):
     * *
     * **
     * ***
     * ****
     * ***
     * **
     * *
     */
    public static void printPattern(int n) {

        // ------------------------
        // 1️⃣ Upper Increasing Part
        // ------------------------
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }

            System.out.println(); // Move to next line
        }

        // ------------------------
        // 2️⃣ Lower Decreasing Part
        // ------------------------
        for (int row = n - 1; row >= 1; row--) {

            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }

            System.out.println(); // Move to next line
        }
    }
}