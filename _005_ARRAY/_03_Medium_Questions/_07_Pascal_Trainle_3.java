package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _07_Pascal_Trainle_3 {

    // Function to generate one row
    private static List<Integer> generateRow(int row) {

        long ans = 1;
        List<Integer> rowList = new ArrayList<>();

        rowList.add(1);

        for (int col = 1; col < row; col++) {

            ans = ans * (row - col);
            ans = ans / col;

            rowList.add((int) ans);

        }

        return rowList;
    }

    // Function to generate Pascal Triangle
    public static List<List<Integer>> pascalTriangleIII(int n) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 1; row <= n; row++) {

            triangle.add(generateRow(row));

        }

        return triangle;
    }

    public static void main(String[] args) {

        int n = 5;

        List<List<Integer>> triangle = pascalTriangleIII(n);

        for (List<Integer> row : triangle) {

            for (int num : row) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}