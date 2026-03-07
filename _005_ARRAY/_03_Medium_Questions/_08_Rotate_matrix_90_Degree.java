package _005_ARRAY._03_Medium_Questions;

public class _08_Rotate_matrix_90_Degree {

    public static void rotateMatrix(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose matrix
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n / 2; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;

            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 2},
                {5, 3, 1},
                {5, 3, 5}
        };

        rotateMatrix(matrix);

        System.out.println("Rotated Matrix:");

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();
        }
    }
}