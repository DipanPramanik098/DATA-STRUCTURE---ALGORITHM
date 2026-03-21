package _011_Bit_Manupulation._03_Contest;

public class _02_numberOccursTwice {

    // Function to find the number that appears exactly twice
    public int numberOccursTwice(int[] nums) {

        int result = 0;

        // Traverse all 32 bits
        for (int i = 0; i < 32; i++) {

            int count = 0;

            // Count how many numbers have ith bit set
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }

            // If remainder is 2 → this bit belongs to the number appearing twice
            if (count % 3 == 2) {
                result |= (1 << i);
            }
        }

        return result;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        _02_numberOccursTwice obj = new _02_numberOccursTwice();

        int[] nums1 = {1, 1, 2, 2, 2, 3, 3, 3};
        int[] nums2 = {9, 0, 9, 9, 0};

        System.out.println("Answer 1: " + obj.numberOccursTwice(nums1)); // 1
        System.out.println("Answer 2: " + obj.numberOccursTwice(nums2)); // 0
    }
}