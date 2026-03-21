package _011_Bit_Manupulation._02_Problems;

public class _01_Minimum_Number_Of_Flip_TO_Convert_Number {

    // Function to find minimum bit flips
    public int minBitsFlip(int start, int goal) {

        // Step 1: XOR → gives bits that are different
        int num = start ^ goal;

        int count = 0;

        // Step 2: Count set bits (normal way)
        while (num != 0) {

            // Check last bit
            count += (num & 1);

            // Right shift
            num = num >> 1;
        }

        return count;
    }

    // Optimized version (IMPORTANT for interview)
    public int minBitsFlipOptimal(int start, int goal) {

        int num = start ^ goal;
        int count = 0;

        // Brian Kernighan’s Algorithm
        while (num != 0) {
            num = num & (num - 1); // remove last set bit
            count++;
        }

        return count;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        _01_Minimum_Number_Of_Flip_TO_Convert_Number obj =
                new _01_Minimum_Number_Of_Flip_TO_Convert_Number();

        int start = 10, goal = 7;

        int ans1 = obj.minBitsFlip(start, goal);
        int ans2 = obj.minBitsFlipOptimal(start, goal);

        System.out.println("Minimum Bit Flips (Normal): " + ans1);
        System.out.println("Minimum Bit Flips (Optimal): " + ans2);

        // Test Case
        int s2 = 1, g2 = 7;
        System.out.println("Test Case (1 → 7): " + obj.minBitsFlipOptimal(s2, g2));
    }
}