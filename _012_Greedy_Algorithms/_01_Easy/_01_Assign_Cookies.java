package _012_Greedy_Algorithms._01_Easy;

import java.util.Arrays;

public class _01_Assign_Cookies {

    // Function to find maximum students that can be satisfied
    public int findMaximumCookieStudents(int[] student, int[] cookie) {

        // Sort both arrays
        Arrays.sort(student);
        Arrays.sort(cookie);

        // Pointer for student and cookie
        int i = 0;
        int j = 0;

        // Traverse both arrays
        while (i < student.length && j < cookie.length) {

            // If current cookie can satisfy current student
            if (cookie[j] >= student[i]) {
                i++; // student satisfied
            }

            // Always move to next cookie
            j++;
        }

        // i represents number of satisfied students
        return i;
    }

    public static void main(String[] args) {
        _01_Assign_Cookies obj = new _01_Assign_Cookies();

        int[] student1 = {1, 2, 3};
        int[] cookie1 = {1, 1};

        int[] student2 = {1, 2};
        int[] cookie2 = {1, 2, 3};

        int[] student3 = {4, 5, 1};
        int[] cookie3 = {6, 4, 2};

        System.out.println("Example 1 Answer: " +
                obj.findMaximumCookieStudents(student1, cookie1)); // 1

        System.out.println("Example 2 Answer: " +
                obj.findMaximumCookieStudents(student2, cookie2)); // 2

        System.out.println("Test Case Answer: " +
                obj.findMaximumCookieStudents(student3, cookie3)); // 3
    }
}