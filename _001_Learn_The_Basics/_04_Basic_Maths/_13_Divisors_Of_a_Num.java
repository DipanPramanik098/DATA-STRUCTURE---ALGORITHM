package _04_Basic_Maths;

import java.util.Arrays;

public class _13_Divisors_Of_a_Num {

    public static int[] divisors(int n) {

        // Temporary array to store divisors
        int[] temp = new int[n];   // Maximum possible size
        int count = 0;

        int sqrtN = (int) Math.sqrt(n);

        // Loop from 1 to sqrt(n)
        for (int i = 1; i <= sqrtN; i++) {

            if (n % i == 0) {

                // Add divisor
                temp[count++] = i;

                // Add counterpart divisor if different
                if (i != n / i) {
                    temp[count++] = n / i;
                }
            }
        }

        // Copy only valid elements
        int[] ans = Arrays.copyOf(temp, count);

        // Sort the result
        Arrays.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        int n = 6;

        int[] result = divisors(n);

        System.out.print("Divisors of " + n + " are: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}