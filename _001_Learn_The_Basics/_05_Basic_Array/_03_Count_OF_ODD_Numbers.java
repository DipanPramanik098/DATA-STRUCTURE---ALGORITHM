package _05_Basic_Array;

import java.util.Scanner;

public class _03_Count_OF_ODD_Numbers {

    // Method to count odd numbers
    public static int countOdd(int[] arr, int n) {

        int count = 0;

        // Traverse array
        for (int i = 0; i < n; i++) {

            // Check if number is odd
            if (arr[i] % 2 != 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Function call
        int result = countOdd(arr, n);

        // Output
        System.out.println(result);

        sc.close();
    }
}