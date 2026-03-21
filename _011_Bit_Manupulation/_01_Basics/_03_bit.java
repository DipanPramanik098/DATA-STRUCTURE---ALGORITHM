package _011_Bit_Manupulation._01_Basics;

public class _03_bit {

    // 1. Decimal to Binary
    public static String decimalToBinary(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }

    // 2. Binary to Decimal
    public static int binaryToDecimal(String binary) {
        int ans = 0;
        for (int i = 0; i < binary.length(); i++) {
            ans = ans * 2 + (binary.charAt(i) - '0');
        }
        return ans;
    }

    // 3. Check ith bit is set or not
    public static boolean isIthBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    // 4. Set ith bit
    public static int setIthBit(int n, int i) {
        return n | (1 << i);
    }

    // 5. Clear ith bit
    public static int clearIthBit(int n, int i) {
        return n & ~(1 << i);
    }

    // 6. Toggle ith bit
    public static int toggleIthBit(int n, int i) {
        return n ^ (1 << i);
    }

    // 7. Remove last set bit
    public static int removeLastSetBit(int n) {
        return n & (n - 1);
    }

    // 8. Check power of 2
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // 9. Count set bits - normal way
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    // 10. Count set bits - optimized way
    public static int countSetBitsOptimal(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    // 11. One's Complement
    public static int onesComplement(int n) {
        return ~n;
    }

    // 12. Two's Complement
    public static int twosComplement(int n) {
        return ~n + 1;
    }

    // 13. Left Shift
    public static int leftShift(int n, int i) {
        return n << i;
    }

    // 14. Right Shift
    public static int rightShift(int n, int i) {
        return n >> i;
    }

    // 15. Swap using XOR
    public static void swapUsingXOR(int a, int b) {
        System.out.println("Before Swap: a = " + a + ", b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After Swap: a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        String binary = "1101";

        System.out.println("Decimal to Binary of " + n + ": " + decimalToBinary(n));
        System.out.println("Binary to Decimal of " + binary + ": " + binaryToDecimal(binary));

        System.out.println("Is " + i + "th bit set in " + n + "? " + isIthBitSet(n, i));
        System.out.println("Set " + i + "th bit of " + n + ": " + setIthBit(n, i));
        System.out.println("Clear " + i + "th bit of " + n + ": " + clearIthBit(n, i));
        System.out.println("Toggle " + i + "th bit of " + n + ": " + toggleIthBit(n, i));

        System.out.println("Remove last set bit of " + n + ": " + removeLastSetBit(n));
        System.out.println("Is " + n + " a power of 2? " + isPowerOfTwo(n));
        System.out.println("Is 16 a power of 2? " + isPowerOfTwo(16));

        System.out.println("Count set bits in " + n + ": " + countSetBits(n));
        System.out.println("Count set bits in " + n + " (Optimal): " + countSetBitsOptimal(n));

        System.out.println("One's Complement of " + n + ": " + onesComplement(n));
        System.out.println("Two's Complement of " + n + ": " + twosComplement(n));

        System.out.println("Left Shift " + n + " by 1: " + leftShift(n, 1));
        System.out.println("Right Shift " + n + " by 1: " + rightShift(n, 1));

        swapUsingXOR(5, 6);
    }
}