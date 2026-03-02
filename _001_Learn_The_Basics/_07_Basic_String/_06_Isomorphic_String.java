package _07_Basic_String;

public class _06_Isomorphic_String {

    // Method to check if two strings are isomorphic
    public static boolean isomorphicString(String s, String t) {

        // If lengths differ, not isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        int[] map1 = new int[256];
        int[] map2 = new int[256];

        int n = s.length();

        for (int i = 0; i < n; i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If previous mapping doesn't match
            if (map1[c1] != map2[c2]) {
                return false;
            }

            // Update mapping position
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "egg";
        String t1 = "add";

        String s2 = "apple";
        String t2 = "bbnbm";

        System.out.println("Example 1: " + isomorphicString(s1, t1));
        System.out.println("Example 2: " + isomorphicString(s2, t2));
    }
}