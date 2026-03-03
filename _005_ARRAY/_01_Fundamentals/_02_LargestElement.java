package _005_ARRAY._01_Fundamentals;

public class _02_LargestElement {

    // Method to find largest element
    public static int largestElement(int[] nums) {

        // Assume first element is largest
        int max = nums[0];

        // Traverse array
        for (int i = 1; i < nums.length; i++) {

            // Update max if current element is greater
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {-4, -3, 0, 1, -8};

        int result = largestElement(nums);

        System.out.println("Largest Element: " + result);
    }
}