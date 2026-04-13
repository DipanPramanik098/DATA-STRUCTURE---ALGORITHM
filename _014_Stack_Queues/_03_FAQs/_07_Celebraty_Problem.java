package _014_Stack_Queues._03_FAQs;

public class _07_Celebraty_Problem {
    static class Solution {
        public int celebrity(int[][] M) {
            int n = M.length;
            int top = 0, down = n - 1;

            // Eliminate non-candidates
            while (top < down) {
                if (M[top][down] == 1) {
                    top++; // top knows down → top not celebrity
                } else if (M[down][top] == 1) {
                    down--; // down knows top → down not celebrity
                } else {
                    top++;
                    down--;
                }
            }

            // No candidate
            if (top > down)
                return -1;

            int candidate = top;
            // Validate candidate
            for (int i = 0; i < n; i++) {
                if (i == candidate)
                    continue;
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1;
                }
            }
            return candidate;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] matrix1 = {
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 0 }
        };
        System.out.println("Celebrity index: " + sol.celebrity(matrix1)); // 1

        // Quiz input
        int[][] quiz = {
                { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 }
        };
        System.out.println("Quiz celebrity index: " + sol.celebrity(quiz)); // 1
    }
}
