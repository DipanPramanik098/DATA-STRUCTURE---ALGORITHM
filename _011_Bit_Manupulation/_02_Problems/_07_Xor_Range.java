package _011_Bit_Manupulation._02_Problems;

public class _07_Xor_Range {

    // Function to find XOR from 1 to n
    private int xorTillN(int n) {

        // Pattern based on n % 4
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0; // n % 4 == 3
    }

    // Function to find XOR from L to R
    public int findRangeXOR(int L, int R) {

        // Apply formula
        return xorTillN(R) ^ xorTillN(L - 1);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        _07_Xor_Range obj = new _07_Xor_Range();

        int L1 = 3, R1 = 5;
        int L2 = 1, R2 = 3;
        int L3 = 4, R3 = 10;

        System.out.println("XOR from 3 to 5: " + obj.findRangeXOR(L1, R1));
        System.out.println("XOR from 1 to 3: " + obj.findRangeXOR(L2, R2));
        System.out.println("XOR from 4 to 10: " + obj.findRangeXOR(L3, R3));
    }
}