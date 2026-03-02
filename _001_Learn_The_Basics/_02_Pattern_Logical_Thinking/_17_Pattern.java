package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _17_Pattern {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print alphabet palindrome pyramid
     * Example (n = 4):
     *    A
     *   ABA
     *  ABCBA
     * ABCDCBA
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // 1️⃣ Print leading spaces
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }

            // 2️⃣ Print increasing letters (A → row)
            for (int col = 1; col <= row; col++) {
                char ch = (char) ('A' + col - 1);
                System.out.print(ch);
            }

            // 3️⃣ Print decreasing letters (row-1 → A)
            for (int col = row - 1; col >= 1; col--) {
                char ch = (char) ('A' + col - 1);
                System.out.print(ch);
            }

            // Move to next line
            System.out.println();
        }
    }
}