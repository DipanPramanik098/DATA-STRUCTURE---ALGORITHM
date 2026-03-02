package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _02_Pattern_02 {

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
     * Function to print right triangle star pattern
     * Example (n = 4):
     * *
     * **
     * ***
     * ****
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        // Runs from 1 to n
        for (int row = 1; row <= n; row++) {

            // Inner loop → prints stars equal to row number
            for (int col = 1; col <= row; col++) {

                System.out.print("*");
            }

            // After printing stars for one row,
            // move to next line
            System.out.println();
        }
    }
}