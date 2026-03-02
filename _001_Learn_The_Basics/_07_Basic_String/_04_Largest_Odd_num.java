package _07_Basic_String;

public class _04_Largest_Odd_num {

    // Function to find largest odd substring
    public static String largeOddNum(String s) {

        int endIndex = -1;

        // Step 1: Traverse from end to find first odd digit
        for (int i = s.length() - 1; i >= 0; i--) {

            int digit = s.charAt(i) - '0';

            if (digit % 2 == 1) {
                endIndex = i;
                break;
            }
        }

        // Step 2: If no odd digit found
        if (endIndex == -1) {
            return "";
        }

        // Step 3: Skip leading zeroes
        int startIndex = 0;
        while (startIndex <= endIndex && s.charAt(startIndex) == '0') {
            startIndex++;
        }

        // Step 4: Return substring
        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] args) {

        String s1 = "5347";
        String s2 = "0214638";
        String s3 = "4206";   // No odd number case

        System.out.println("Input: " + s1);
        System.out.println("Largest Odd: " + largeOddNum(s1));

        System.out.println("Input: " + s2);
        System.out.println("Largest Odd: " + largeOddNum(s2));

        System.out.println("Input: " + s3);
        System.out.println("Largest Odd: " + largeOddNum(s3));
    }
}