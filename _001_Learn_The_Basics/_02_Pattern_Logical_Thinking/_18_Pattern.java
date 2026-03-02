package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _18_Pattern {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print reverse starting alphabet triangle
     * Example (n = 4):
     * D
     * C D
     * B C D
     * A B C D
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // Calculate starting character for this row
            char start = (char) ('A' + n - row);

            // Print characters from start to last letter
            for (char ch = start; ch <= (char) ('A' + n - 1); ch++) {

                System.out.print(ch + " ");
            }

            // Move to next line
            System.out.println();
        }
    }
}