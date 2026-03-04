package _005_ARRAY._02_Logic_Building;

public class _02_Remove_Duplicate_From_Sorted_Array {

    public static int removeDuplicates(int[] nums) {

        int i = 0; // pointer for unique elements

        for (int j = 1; j < nums.length; j++) {

            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

        }

        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = {-30, -30, 0, 0, 10, 20, 30, 30};

        int k = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);

        System.out.print("Array after removing duplicates: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}