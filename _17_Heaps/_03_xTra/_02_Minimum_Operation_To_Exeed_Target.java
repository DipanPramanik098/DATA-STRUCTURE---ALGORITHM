package _17_Heaps._03_xTra;

import java.util.List;
import java.util.PriorityQueue;

/*

===============================================================================
                    Minimum Operations To Exceed Target
===============================================================================

Problem Statement:
------------------
You are given a 0-indexed integer array scores, where each element represents
the score of a player in a competition, and an integer targetScore.

Your task is to determine the minimum number of operations required to ensure
that all scores in the array are greater than or equal to targetScore.

If it is not possible to make all scores greater than or equal to targetScore,
return -1.

In one operation:

1. Select the two lowest scores x and y from the array.
2. Remove x and y from the array.
3. Add a new score equal to:

        min(x, y) * 2 + max(x, y)

back into the array.

-------------------------------------------------------------------------------

Example 1:
-----------
Input:
scores = [4, 1, 7, 3, 6]
targetScore = 5

Output:
2

Explanation:

Operation 1:
-------------
Take 1 and 3

newValue = 2*1 + 3
         = 5

Updated array:
[4, 5, 7, 6]

Operation 2:
-------------
Take 4 and 5

newValue = 2*4 + 5
         = 13

Updated array:
[13, 7, 6]

Now all elements >= 5

Hence answer = 2

-------------------------------------------------------------------------------

Example 2:
-----------
Input:
scores = [5, 2, 8, 1, 10]
targetScore = 12

Output:
3

Explanation:

Operation 1:
-------------
Take 1 and 2

newValue = 2*1 + 2
         = 4

Updated array:
[4, 5, 8, 10]

Operation 2:
-------------
Take 4 and 5

newValue = 2*4 + 5
         = 13

Updated array:
[13, 8, 10]

Operation 3:
-------------
Take 8 and 10

newValue = 2*8 + 10
         = 26

Updated array:
[26, 13]

Now all elements >= 12

Hence answer = 3

-------------------------------------------------------------------------------

Constraints:
-------------
2 <= scores.length <= 2 * 10^5
1 <= scores[i] <= 10^9
1 <= targetScore <= 10^9

===============================================================================
Intuition:
===============================================================================

We repeatedly need:

1. The smallest element
2. The second smallest element

If we use sorting every time:

- Finding smallest elements becomes expensive.
- Time Complexity becomes very large.

A Min Heap is perfect because:

- Smallest element is always at the top.
- Removing smallest takes O(logN)
- Inserting new element takes O(logN)

So:

1. Put all elements into Min Heap.
2. While smallest element < target:
       - Remove 2 smallest values
       - Create new value
       - Insert new value back
       - Count operation
3. Return total operations.

===============================================================================
Dry Run:
===============================================================================

Input:
scores = [4, 1, 7, 3, 6]
target = 5

Step 1:
-------
Min Heap:
[1, 3, 7, 4, 6]

Top = 1 < 5

Take:
x = 1
y = 3

newValue = 2*1 + 3
         = 5

Insert 5

Heap becomes:
[4, 5, 7, 6]

operations = 1

------------------------------------------------

Step 2:
-------
Top = 4 < 5

Take:
x = 4
y = 5

newValue = 2*4 + 5
         = 13

Insert 13

Heap becomes:
[6, 7, 13]

operations = 2

------------------------------------------------

Now:
Top = 6 >= 5

Answer = 2

===============================================================================
Approach:
===============================================================================

1. Create a Min Heap using PriorityQueue.
2. Insert all elements into heap.
3. While:
       heap size >= 2
       AND smallest element < target

       a. Remove two smallest elements.
       b. Create new value:
              min(x,y)*2 + max(x,y)
       c. Insert new value back.
       d. Increment operation count.

4. After loop:
       - If smallest element >= target
             return operations
       - Else
             return -1

===============================================================================
Complexity Analysis:
===============================================================================

Time Complexity:
----------------
Each insertion/removal from heap takes:

O(logN)

In worst case, we process almost all elements.

Overall Complexity:

O(N logN)

-------------------------------------------------------------------------------

Space Complexity:
-----------------
Heap stores all elements.

O(N)

===============================================================================
*/

public class _02_Minimum_Operation_To_Exeed_Target {

    static class Solution {

        public int minOperationsToExceedTarget(List<Integer> nums,
                                               int targetValue) {

            // Min Heap
            PriorityQueue<Long> pq = new PriorityQueue<>();

            // Insert all elements into heap
            for (int num : nums) {
                pq.offer((long) num);
            }

            int operations = 0;

            // Continue until all elements become >= target
            while (pq.size() >= 2 && pq.peek() < targetValue) {

                // Smallest element
                long x = pq.poll();

                // Second smallest element
                long y = pq.poll();

                // Create new value
                long newValue =
                        (2 * Math.min(x, y))
                        + Math.max(x, y);

                // Insert back into heap
                pq.offer(newValue);

                operations++;
            }

            // Final validation
            if (!pq.isEmpty() && pq.peek() >= targetValue) {
                return operations;
            }

            return -1;
        }
    }

    // Driver Code
    public static void main(String[] args) {

        Solution sol = new Solution();

        List<Integer> nums1 = List.of(4, 1, 7, 3, 6);
        int target1 = 5;

        int ans1 =
                sol.minOperationsToExceedTarget(nums1, target1);

        System.out.println("Answer 1 : " + ans1);

        System.out.println();

        List<Integer> nums2 = List.of(5, 2, 8, 1, 10);
        int target2 = 12;

        int ans2 =
                sol.minOperationsToExceedTarget(nums2, target2);

        System.out.println("Answer 2 : " + ans2);
    }
}