package _02_Pattern_Logical_Thinking;

import java.util.Scanner;

public class _11_Pattern_11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        printPattern(n);

        sc.close();
    }

    public static void printPattern(int n) {

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {

                if ((row + col) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }

            System.out.println();
        }
    }
}