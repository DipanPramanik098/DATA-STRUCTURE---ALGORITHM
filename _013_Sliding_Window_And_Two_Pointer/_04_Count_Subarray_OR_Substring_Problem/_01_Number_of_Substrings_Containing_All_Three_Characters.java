package _013_Sliding_Window_And_Two_Pointer._04_Count_Subarray_OR_Substring_Problem;

public class _01_Number_of_Substrings_Containing_All_Three_Characters {

    public int numberOfSubstrings(String s) {
        // lastSeen[0] for 'a', [1] for 'b', [2] for 'c'
        int[] lastSeen = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastSeen[c - 'a'] = i;   // update last seen index

            // If all three characters have been seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                int minLast = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                count += (1 + minLast);   // add all valid substrings ending at i
            }
        }
        return count;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _01_Number_of_Substrings_Containing_All_Three_Characters solver = new _01_Number_of_Substrings_Containing_All_Three_Characters();

        String s1 = "abcba";
        System.out.println(solver.numberOfSubstrings(s1)); // 5

        String s2 = "ccabcc";
        System.out.println(solver.numberOfSubstrings(s2)); // 8

        String s3 = "abccba";
        System.out.println(solver.numberOfSubstrings(s3)); // 7
    }
}