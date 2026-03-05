package _005_ARRAY._03_Medium_Questions;

public class _01_Majority_Element {

    public static int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};

        int result = majorityElement(nums);

        System.out.println("Majority Element: " + result);
    }
}