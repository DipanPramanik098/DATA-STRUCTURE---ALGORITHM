package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _08_Pattern_08 {

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        // Call function to print inverted pyramid
        printPattern(n);

        sc.close(); // Close scanner
    }

    /*
     * Function to print inverted centered pyramid
     * Example (n = 4):
     * *******
     *  *****
     *   ***
     *    *
     */
    public static void printPattern(int n) {

        // Outer loop → controls rows
        for (int row = 1; row <= n; row++) {

            // 1️⃣ Print leading spaces
            for (int space = 1; space <= row - 1; space++) {
                System.out.print(" ");
            }

            // 2️⃣ Print decreasing odd number of stars
            for (int star = 1; star <= 2 * (n - row) + 1; star++) {
                System.out.print("*");
            }

            // 3️⃣ Move to next line
            System.out.println();
        }
    }
}