package _01_Language_Basics;

import java.util.Arrays;

public class _05_Array_String_Demo {

    public static void main(String[] args) {

        System.out.println("===== ARRAY DEMO =====");

        int[] arr = {5, 2, 9, 1};

        System.out.println("Original: " + Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        System.out.println("Length: " + arr.length);
        System.out.println("Binary Search (9): " + Arrays.binarySearch(arr, 9));

        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println("Copied Array: " + Arrays.toString(copy));


        System.out.println("\n===== 2D ARRAY =====");

        int[][] matrix = {{1,2},{3,4}};
        System.out.println("Matrix[1][1]: " + matrix[1][1]);


        System.out.println("\n===== STRING DEMO =====");

        String str = "  Java Programming  ";

        System.out.println("Length: " + str.length());
        System.out.println("Trim: '" + str.trim() + "'");
        System.out.println("UpperCase: " + str.toUpperCase());
        System.out.println("LowerCase: " + str.toLowerCase());
        System.out.println("Substring(2,6): " + str.substring(2,6));
        System.out.println("Replace: " + str.replace("Java","C++"));
        System.out.println("Contains 'Java': " + str.contains("Java"));
        System.out.println("IndexOf 'a': " + str.indexOf("a"));

        String[] words = str.trim().split(" ");
        System.out.println("Split: " + Arrays.toString(words));


        System.out.println("\n===== STRING BUILDER =====");

        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Rocks");
        sb.reverse();

        System.out.println("StringBuilder Result: " + sb);
    }
}