package _005_ARRAY._02_Logic_Building;

public class _01_Move_Zeros_To_End {

    public static void moveZeroes(int[] nums) {

        // j stores position for next non-zero element
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            // If element is non-zero
            if (nums[i] != 0) {

                // Swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // Move j forward
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 0, 5};

        moveZeroes(arr);

        System.out.println("Array after moving zeros to end:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}