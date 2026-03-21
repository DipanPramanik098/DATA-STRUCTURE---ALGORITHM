package _011_Bit_Manupulation._02_Problems;

public class _03_Single_Num_2 {

    // Function to find the single number
    public int singleNumber(int[] nums) {

        // Bucket for bits appearing once
        int ones = 0;

        // Bucket for bits appearing twice
        int twos = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Add current number to ones if it is not present in twos
            ones = (ones ^ nums[i]) & ~twos;

            // Add current number to twos if it is not present in ones
            twos = (twos ^ nums[i]) & ~ones;
        }

        // ones contains the number appearing once
        return ones;
    }

    public static void main(String[] args) {
        _03_Single_Num_2 obj = new _03_Single_Num_2();

        int[] nums1 = {2, 2, 2, 3};
        int[] nums2 = {1, 0, 3, 0, 1, 1, 3, 3, 10, 0};
        int[] nums3 = {5, 0, 1, 10, 1, 1, 5, 5, 10, 10};

        System.out.println("Single Number (Example 1): " + obj.singleNumber(nums1));
        System.out.println("Single Number (Example 2): " + obj.singleNumber(nums2));
        System.out.println("Single Number (Test Case): " + obj.singleNumber(nums3));
    }
}