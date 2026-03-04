package _005_ARRAY._02_Logic_Building;

public class _03_Find_Missing_Number {

    // Method to find the missing number
    public static int missingNumber(int[] nums) {

        // xor1 will store XOR of numbers from 1 to N
        int xor1 = 0;

        // xor2 will store XOR of all elements in the array
        int xor2 = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // XOR numbers from 1 to N
            // (i + 1) generates numbers 1,2,3,...N
            xor1 = xor1 ^ (i + 1);

            // XOR all array elements
            xor2 = xor2 ^ nums[i];
        }

        // XOR of xor1 and xor2 gives the missing number
        // Because equal numbers cancel each other (A ^ A = 0)
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {

        // Example array
        int[] nums = {1, 3, 6, 4, 2, 5};

        // Call the function to find the missing number
        int ans = missingNumber(nums);

        // Print the result
        System.out.println("Missing Number: " + ans);
    }
}