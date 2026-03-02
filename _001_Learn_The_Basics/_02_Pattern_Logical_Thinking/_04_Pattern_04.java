package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _04_Pattern_04 {

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
     * Function to print pattern:
     * 1
     * 22
     * 333
     * 4444
     * ...
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // Inner loop → prints row number 'row' times
            for (int col = 1; col <= row; col++) {

                // Print the current row number
                System.out.print(row);
            }

            // Move to next line after completing one row
            System.out.println();
        }
    }
}