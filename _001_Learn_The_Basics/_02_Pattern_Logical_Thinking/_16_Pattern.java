package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _16_Pattern {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print alphabet repeating triangle
     * Example (n = 4):
     * A
     * BB
     * CCC
     * DDDD
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // Calculate character for current row
            char ch = (char) ('A' + row - 1);

            // Inner loop → prints character 'row' times
            for (int col = 1; col <= row; col++) {

                System.out.print(ch);
            }

            // Move to next line
            System.out.println();
        }
    }
}