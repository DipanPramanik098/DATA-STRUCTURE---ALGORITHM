package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _13_Pattern {

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print Floyd's Triangle
     * Example (n = 4):
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     */
    public static void printPattern(int n) {

        // Variable to keep track of current number
        int number = 1;

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // Inner loop → prints 'row' numbers
            for (int col = 1; col <= row; col++) {

                System.out.print(number + " ");
                number++; // Increment after printing
            }

            // Move to next line after each row
            System.out.println();
        }
    }
}