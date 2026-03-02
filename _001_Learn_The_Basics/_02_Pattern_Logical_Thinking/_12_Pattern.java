package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _12_Pattern {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print mirror number palindrome pattern
     * Example (n = 4):
     * 1      1
     * 12    21
     * 123  321
     * 12344321
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // 1️⃣ Print increasing numbers (1 → row)
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }

            // 2️⃣ Print middle spaces
            for (int space = 1; space <= 2 * (n - row); space++) {
                System.out.print(" ");
            }

            // 3️⃣ Print decreasing numbers (row → 1)
            for (int col = row; col >= 1; col--) {
                System.out.print(col);
            }

            // Move to next line
            System.out.println();
        }
    }
}