package _05_Basic_Array;

import java.util.Arrays;
import java.util.Scanner;

public class _01_Array_Demo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ============================
        // 1D ARRAY
        // ============================

        System.out.println("Enter size of 1D array:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Output
        System.out.println("Array elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Using for-each
        System.out.println("Using for-each:");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Sum
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        System.out.println("Sum = " + sum);

        // Maximum
        int max = arr[0];
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }
        System.out.println("Maximum = " + max);

        // Reverse
        System.out.println("Reverse:");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // ============================
        // Arrays Utility Methods
        // ============================

        // Sort
        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        // Binary Search
        System.out.println("Enter element to search:");
        int key = sc.nextInt();
        int index = Arrays.binarySearch(arr, key);
        System.out.println("Binary Search Result Index: " + index);

        // Copy
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        System.out.println("Copy of Array: " + Arrays.toString(copyArr));

        // Copy Range
        if (arr.length >= 2) {
            int[] rangeArr = Arrays.copyOfRange(arr, 0, 2);
            System.out.println("Copy of Range (0-2): " + Arrays.toString(rangeArr));
        }

        // Fill
        int[] fillArr = new int[5];
        Arrays.fill(fillArr, 10);
        System.out.println("Filled Array: " + Arrays.toString(fillArr));

        // Equals
        System.out.println("arr equals copyArr? " + Arrays.equals(arr, copyArr));

        // ============================
        // 2D ARRAY
        // ============================

        System.out.println("\nEnter rows and columns for 2D array:");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        // Input
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output
        System.out.println("Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // for-each traversal
        System.out.println("Matrix using for-each:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // Deep ToString
        System.out.println("Deep ToString:");
        System.out.println(Arrays.deepToString(matrix));

        // Deep Equals
        int[][] matrixCopy = Arrays.copyOf(matrix, matrix.length);
        System.out.println("Deep Equals? " + Arrays.deepEquals(matrix, matrixCopy));

        // ============================
        // Jagged Array
        // ============================

        int[][] jagged = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[3];
        jagged[2] = new int[1];

        jagged[0][0] = 1;
        jagged[0][1] = 2;

        jagged[1][0] = 3;
        jagged[1][1] = 4;
        jagged[1][2] = 5;

        jagged[2][0] = 6;

        System.out.println("Jagged Array:");
        System.out.println(Arrays.deepToString(jagged));

        sc.close();
    }
}
