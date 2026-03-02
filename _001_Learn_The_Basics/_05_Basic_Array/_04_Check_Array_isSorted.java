package _05_Basic_Array;

import java.util.Scanner;

public class _04_Check_Array_isSorted {

    // Method to check if array is sorted
    public static boolean arraySortedOrNot(int[] arr, int n) {

        // Traverse array
        for (int i = 0; i < n - 1; i++) {

            // Compare current element with next
            if (arr[i] > arr[i + 1]) {
                return false;   // Not sorted
            }
        }

        return true;  // Sorted
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

        boolean result = arraySortedOrNot(arr, n);

        if (result) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        sc.close();
    }
}