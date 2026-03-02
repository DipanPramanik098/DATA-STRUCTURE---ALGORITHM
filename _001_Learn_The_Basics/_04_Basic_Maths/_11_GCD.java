package _04_Basic_Maths;

public class _11_GCD {

    // Function to calculate GCD using Euclidean Algorithm
    public static int GCD(int n1, int n2) {

        // Continue until one becomes zero
        while (n1 > 0 && n2 > 0) {

            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }

        // If n1 becomes zero, return n2
        if (n1 == 0) {
            return n2;
        }

        // Otherwise return n1
        return n1;
    }

    public static void main(String[] args) {

        int n1 = 4, n2 = 6;

        int result = GCD(n1, n2);

        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + result);
    }
}