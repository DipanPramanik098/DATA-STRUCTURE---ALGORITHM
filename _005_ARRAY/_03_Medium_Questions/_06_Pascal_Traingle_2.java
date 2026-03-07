package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _06_Pascal_Traingle_2 {

    // Function to return rth row of Pascal's Triangle
    public static int[] pascalTriangleII(int r) {

        int[] ans = new int[r];

        // First element is always 1
        ans[0] = 1;

        for (int i = 1; i < r; i++) {

            ans[i] = (ans[i - 1] * (r - i)) / i;

        }

        return ans;
    }

    public static void main(String[] args) {

        int r = 5;

        int[] row = pascalTriangleII(r);

        System.out.print("Row " + r + ": ");

        for (int num : row) {
            System.out.print(num + " ");
        }

    }
}