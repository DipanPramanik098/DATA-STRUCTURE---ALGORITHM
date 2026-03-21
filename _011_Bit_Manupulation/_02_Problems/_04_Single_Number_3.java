package _011_Bit_Manupulation._02_Problems;

public class _04_Single_Number_3 {

    // Function to find two unique numbers
    public int[] singleNumber(int[] nums) {

        // Step 1: XOR of all elements
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        // Step 2: Find rightmost set bit
        // This bit is different in the two unique numbers
        int rightmostSetBit = xor & -xor;

        // Step 3: Divide numbers into two groups and XOR separately
        int bucket1 = 0;
        int bucket2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightmostSetBit) != 0) {
                bucket1 ^= nums[i];
            } else {
                bucket2 ^= nums[i];
            }
        }

        // Step 4: Return in ascending order
        if (bucket1 < bucket2) {
            return new int[]{bucket1, bucket2};
        } else {
            return new int[]{bucket2, bucket1};
        }
    }

    public static void main(String[] args) {
        _04_Single_Number_3 obj = new _04_Single_Number_3();

        int[] nums1 = {1, 2, 1, 3, 5, 2};
        int[] nums2 = {-1, 0};
        int[] nums3 = {1, 9, 1, 2, 8, 2};

        int[] ans1 = obj.singleNumber(nums1);
        int[] ans2 = obj.singleNumber(nums2);
        int[] ans3 = obj.singleNumber(nums3);

        System.out.println("Example 1 Answer: [" + ans1[0] + ", " + ans1[1] + "]");
        System.out.println("Example 2 Answer: [" + ans2[0] + ", " + ans2[1] + "]");
        System.out.println("Test Case Answer: [" + ans3[0] + ", " + ans3[1] + "]");
    }
}