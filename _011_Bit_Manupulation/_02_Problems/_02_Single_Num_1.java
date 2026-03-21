package _011_Bit_Manupulation._02_Problems;

public class _02_Single_Num_1 {

    // Function to find single number
    public int singleNumber(int[] nums) {

        // Step 1: Initialize XOR = 0
        int xor = 0;

        // Step 2: XOR all elements
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        // Step 3: return result
        return xor;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        _02_Single_Num_1 obj = new _02_Single_Num_1();

        int[] nums1 = {1, 2, 2, 4, 3, 1, 4};
        int[] nums2 = {5};
        int[] nums3 = {1, 3, 10, 3, 5, 1, 5};

        System.out.println("Single Number (Example 1): " + obj.singleNumber(nums1));
        System.out.println("Single Number (Example 2): " + obj.singleNumber(nums2));
        System.out.println("Single Number (Test Case): " + obj.singleNumber(nums3));
    }
}