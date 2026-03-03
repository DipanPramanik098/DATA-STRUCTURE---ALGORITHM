package _005_ARRAY._01_Fundamentals;

public class _03_Second_Largest {

    // Method to find second largest element
    public static int secondLargestElement(int[] nums) {

        // If less than 2 elements, no second largest
        if (nums.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse array
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } 
            else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        // If no valid second largest found
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }

    public static void main(String[] args) {

        int[] nums = {7, 7, 2, 2, 10, 10, 10};

        int result = secondLargestElement(nums);

        System.out.println("Second Largest Element: " + result);
    }
}