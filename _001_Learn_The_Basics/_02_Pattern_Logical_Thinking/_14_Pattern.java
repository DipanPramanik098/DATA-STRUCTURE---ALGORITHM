package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _14_Pattern {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print alphabet increasing triangle
     * Example (n = 4):
     * A
     * AB
     * ABC
     * ABCD
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // Inner loop → prints characters from A
            for (int col = 1; col <= row; col++) {

                // Convert integer to character
                char ch = (char) ('A' + col - 1);
                System.out.print(ch);
            }

            // Move to next line after each row
            System.out.println();
        }
    }
}