package _005_ARRAY._03_Medium_Questions;

public class _05_Pascal_Traingle_1 {

    // Function to return value at rth row and cth column
    public static int pascalTriangleI(int r, int c) {

        return nCr(r - 1, c - 1);
    }

    // Function to compute nCr
    private static int nCr(int n, int r) {

        if (r > n - r) {
            r = n - r;
        }

        int res = 1;

        for (int i = 0; i < r; i++) {

            res = res * (n - i);
            res = res / (i + 1);

        }

        return res;
    }

    public static void main(String[] args) {

        int r = 5;
        int c = 3;

        int ans = pascalTriangleI(r, c);

        System.out.println(
            "Value at row " + r + " column " + c + " is: " + ans
        );

    }
}