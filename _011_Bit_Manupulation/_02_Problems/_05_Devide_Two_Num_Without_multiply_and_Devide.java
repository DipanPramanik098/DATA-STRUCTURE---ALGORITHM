package _011_Bit_Manupulation._02_Problems;

public class _05_Devide_Two_Num_Without_multiply_and_Devide {

    public int divide(int dividend, int divisor) {

        // Edge Case: same numbers
        if (dividend == divisor) return 1;

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Determine sign
        boolean isPositive = (dividend >= 0) == (divisor >= 0);

        // Convert to long to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;

        // Main loop
        while (n >= d) {

            int count = 0;

            // Find largest shift
            while (n >= (d << (count + 1))) {
                count++;
            }

            // Add to answer
            ans += (1 << count);

            // Subtract from dividend
            n -= (d << count);
        }

        // Apply sign
        return isPositive ? ans : -ans;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        _05_Devide_Two_Num_Without_multiply_and_Devide obj =
                new _05_Devide_Two_Num_Without_multiply_and_Devide();

        System.out.println("10 / 3 = " + obj.divide(10, 3));
        System.out.println("7 / -3 = " + obj.divide(7, -3));
        System.out.println("7 / 2 = " + obj.divide(7, 2));
    }
}