package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _21_Pattern {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print hollow square pattern
     * Example (n = 4):
     * ****
     * *  *
     * *  *
     * ****
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // Inner loop → controls columns
            for (int col = 1; col <= n; col++) {

                // Condition for printing star
                if (row == 1 || row == n || col == 1 || col == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // Move to next line after each row
            System.out.println();
        }
    }
}