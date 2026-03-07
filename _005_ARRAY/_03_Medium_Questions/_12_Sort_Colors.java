package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _12_Sort_Colors {

    // Function to sort array of 0s, 1s and 2s
    public static void sortColors(int[] nums) {

        // Initialize three pointers
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // Traverse the array
        while (mid <= high) {

            // Case 1: element is 0
            if (nums[mid] == 0) {

                // Swap nums[mid] and nums[low]
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                // Move both pointers forward
                low++;
                mid++;
            }

            // Case 2: element is 1
            else if (nums[mid] == 1) {

                // 1 is already in correct region
                mid++;
            }

            // Case 3: element is 2
            else {

                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                // Move high pointer backward
                high--;

                // Do NOT move mid here
                // because swapped value needs checking
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 1};

        sortColors(nums);

        System.out.println("Sorted Array:");

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}