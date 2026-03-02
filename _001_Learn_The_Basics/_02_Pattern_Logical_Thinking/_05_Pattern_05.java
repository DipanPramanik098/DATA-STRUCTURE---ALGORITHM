package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _05_Pattern_05 {

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
     * Function to print inverted star triangle
     * Example (n = 4):
     * ****
     * ***
     * **
     * *
     */
    public static void printPattern(int n) {

        // Outer loop → controls number of rows
        for (int row = 1; row <= n; row++) {

            // Inner loop → prints decreasing stars
            // Number of stars = n - row + 1
            for (int col = 1; col <= n - row + 1; col++) {

                System.out.print("*");
            }

            // Move to next line after completing one row
            System.out.println();
        }
    }
}