package _04_Basic_Maths;

public class _12_LCM {

    // Function to calculate GCD using Euclidean Algorithm
    public static int GCD(int n1, int n2) {

        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }

        return n1;
    }

    // Function to calculate LCM
    public static int LCM(int n1, int n2) {

        int gcd = GCD(n1, n2);

        // Using formula: LCM = (n1 * n2) / GCD
        int lcm = (n1 * n2) / gcd;

        return lcm;
    }

    public static void main(String[] args) {

        int n1 = 3, n2 = 5;

        int result = LCM(n1, n2);

        System.out.println("LCM of " + n1 + " and " + n2 + " is: " + result);
    }
}