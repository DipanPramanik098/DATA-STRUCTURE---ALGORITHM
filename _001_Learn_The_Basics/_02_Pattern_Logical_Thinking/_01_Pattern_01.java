package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _01_Pattern_01 {

    public static void main(String[] args) {

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Read integer n
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        // Call function to print pattern
        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print n x n star square pattern
     * Example:
     * n = 4
     * ****
     * ****
     * ****
     * ****
     */
    public static void printPattern(int n) {

        // Outer loop -> Controls number of rows
        // It will run n times
        for (int row = 1; row <= n; row++) {

            // Inner loop -> Controls number of columns (stars per row)
            // It will also run n times for each row
            for (int col = 1; col <= n; col++) {

                // Print star without moving to next line
                System.out.print("*");
            }

            // After printing one complete row,
            // move cursor to next line
            System.out.println();
        }
    }
}