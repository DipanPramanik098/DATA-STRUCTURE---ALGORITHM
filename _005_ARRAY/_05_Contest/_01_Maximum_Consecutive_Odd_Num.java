package _005_ARRAY._05_Contest;

import java.util.HashSet;
import java.util.Set;

public class _01_Maximum_Consecutive_Odd_Num {

    public int maxConsecutiveGoodNums(int[] nums, int[] goodNumbers) {

        // HashSet to store all good numbers
        Set<Integer> set = new HashSet<>();

        // Insert all good numbers into set
        for (int num : goodNumbers) {
            set.add(num);
        }

        int max = 0;   // stores maximum consecutive good numbers
        int count = 0; // current consecutive count

        // Traverse the nums array
        for (int num : nums) {

            // If current number is a good number
            if (set.contains(num)) {

                count++; // increase consecutive count

                // update maximum
                max = Math.max(max, count);
            } 
            else {

                // reset if not a good number
                count = 0;
            }
        }

        // return maximum consecutive good numbers
        return max;
    }

    public static void main(String[] args) {

        _01_Maximum_Consecutive_Odd_Num obj = new _01_Maximum_Consecutive_Odd_Num();

        int[] nums = {1,2,3,5,4,5,1};
        int[] goodNumbers = {3,5};

        int result = obj.maxConsecutiveGoodNums(nums, goodNumbers);

        System.out.println("Maximum consecutive good numbers: " + result);
    }
}