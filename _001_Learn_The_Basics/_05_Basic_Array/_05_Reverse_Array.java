package _05_Basic_Array;

import java.util.Scanner;
import java.util.Arrays;

public class _05_Reverse_Array {

    // Method to reverse array in-place
    public static void reverse(int[] arr, int n) {

        int left = 0;
        int right = n - 1;

        // Swap until pointers meet
        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
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

        // Reverse array
        reverse(arr, n);

        // Output reversed array
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}