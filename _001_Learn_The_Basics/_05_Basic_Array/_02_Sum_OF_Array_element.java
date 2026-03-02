package _05_Basic_Array;

import java.util.Scanner;

public class _02_Sum_OF_Array_element {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Calculate sum
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Output
        System.out.println(sum);

        sc.close();
    }
}