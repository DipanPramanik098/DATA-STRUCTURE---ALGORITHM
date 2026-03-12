package _006_Hashing._002_Problems;

import java.util.HashSet;
import java.util.Set;

public class _01_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {

        // Length of array
        int n = nums.length;

        // If array is empty
        if(n == 0)
            return 0;

        // Variable to store the longest sequence length
        int longest = 1;

        // HashSet for fast lookup O(1)
        Set<Integer> set = new HashSet<>();


        // Step 1: Insert all elements into the HashSet
        for(int num : nums)
        {
            set.add(num);
        }


        /*
         Traverse the set to find sequences
         */
        for(int it : set)
        {

            /*
             Check if current number is the
             START of a sequence

             A number starts sequence only if
             previous number does not exist
             */

            if(!set.contains(it - 1))
            {

                // Current number becomes start
                int x = it;

                // Current sequence length
                int cnt = 1;


                /*
                 Keep checking next numbers
                 like x+1, x+2, x+3
                 */
                while(set.contains(x + 1))
                {
                    // Move forward
                    x = x + 1;

                    // Increase sequence count
                    cnt = cnt + 1;
                }


                // Update longest sequence
                longest = Math.max(longest, cnt);
            }

        }

        // Return final answer
        return longest;
    }



    public static void main(String[] args)
    {
        _01_Longest_Consecutive_Sequence obj =
                new _01_Longest_Consecutive_Sequence();

        int[] nums = {100,4,200,1,3,2};

        int ans = obj.longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + ans);
    }
}