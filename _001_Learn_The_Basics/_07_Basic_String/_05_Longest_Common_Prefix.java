package _07_Basic_String;

import java.util.Arrays;

public class _05_Longest_Common_Prefix {

    // Method to find longest common prefix
    public static String longestCommonPrefix(String[] arr) {

        // Edge case
        if (arr == null || arr.length == 0) {
            return "";
        }

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Take first and last string
        String first = arr[0];
        String last = arr[arr.length - 1];

        int i = 0;

        // Step 3: Compare characters
        while (i < first.length() && i < last.length()
                && first.charAt(i) == last.charAt(i)) {

            i++;
        }

        // Step 4: Return common prefix
        return first.substring(0, i);
    }

    public static void main(String[] args) {

        String[] arr1 = {"flowers", "flow", "fly", "flight"};
        String[] arr2 = {"dog", "cat", "animal", "monkey"};
        String[] arr3 = {"lady", "lazy"};

        System.out.println("Result 1: " + longestCommonPrefix(arr1));
        System.out.println("Result 2: " + longestCommonPrefix(arr2));
        System.out.println("Result 3: " + longestCommonPrefix(arr3));
    }
}