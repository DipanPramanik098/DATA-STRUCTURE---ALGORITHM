package _005_ARRAY._04_Hard_Questions;

import java.util.*;

public class _02_Missing_and_Repeating_Num {

    public static int[] findMissingRepeatingNumbers(int[] nums) {

        int n = nums.length;

        int xr = 0;

        // Step 1: XOR all array elements and numbers 1..n
        for (int i = 0; i < n; i++) {

            xr ^= nums[i];
            xr ^= (i + 1);
        }

        // Step 2: Find rightmost set bit
        int bit = xr & ~(xr - 1);

        int zero = 0;
        int one = 0;

        // Step 3: Divide numbers into groups
        for (int i = 0; i < n; i++) {

            if ((nums[i] & bit) != 0)
                one ^= nums[i];
            else
                zero ^= nums[i];
        }

        for (int i = 1; i <= n; i++) {

            if ((i & bit) != 0)
                one ^= i;
            else
                zero ^= i;
        }

        // Step 4: Identify repeating number
        int count = 0;

        for (int num : nums) {
            if (num == zero)
                count++;
        }

        if (count == 2)
            return new int[]{zero, one};
        else
            return new int[]{one, zero};
    }

    public static void main(String[] args) {

        int[] nums = {6,5,7,1,8,6,4,3,2};

        int[] result = findMissingRepeatingNumbers(nums);

        System.out.println("Repeating Number: " + result[0]);
        System.out.println("Missing Number: " + result[1]);
    }
}