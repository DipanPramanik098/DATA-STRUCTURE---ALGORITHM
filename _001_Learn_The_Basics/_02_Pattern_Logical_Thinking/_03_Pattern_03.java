package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _03_Pattern_03 {

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        // Call function to print pattern
        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print number triangle pattern
     * Example (n = 4):
     * 1
     * 12
     * 123
     * 1234
     */
    public static void printPattern(int n) {

        // Outer loop → controls number of rows
        for (int row = 1; row <= n; row++) {

            // Inner loop → prints numbers from 1 to row
            for (int col = 1; col <= row; col++) {

                // Print current column number
                System.out.print(col);
            }

            // Move to next line after each row
            System.out.println();
        }
    }
}