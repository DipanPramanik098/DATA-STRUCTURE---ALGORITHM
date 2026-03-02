package _07_Basic_String;

public class _02_Reverse_String {

    // Method to reverse character array in place
    public static void reverse(char[] s) {

        int start = 0;
        int end = s.length - 1;

        // Continue swapping until pointers meet
        while (start < end) {

            // Swap characters
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            // Move pointers
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        // Example 1
        char[] arr1 = {'h', 'e', 'l', 'l', 'o'};
        reverse(arr1);

        System.out.print("Reversed String 1: ");
        for (char c : arr1) {
            System.out.print(c);
        }

        System.out.println();

        // Example 2
        char[] arr2 = {'b', 'y', 'e'};
        reverse(arr2);

        System.out.print("Reversed String 2: ");
        for (char c : arr2) {
            System.out.print(c);
        }
    }
}