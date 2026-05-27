package _017_Heaps._03_xTra;

import java.util.List;
import java.util.PriorityQueue;

/*

===============================================================================
                    Furthest Reachable Mountain
===============================================================================

Problem Statement:
------------------
Given an integer array heights representing the heights of peaks in a
mountain range, and two integers energyDrinks and climbingRopes,
determine the furthest peak index you can reach starting from peak 0.

You can move from peak i to peak i+1 using the following rules:

1. If the next peak is smaller than or equal to the current peak:
      -> No resources are required.

2. If the next peak is higher:
      -> Either use energy drinks equal to the height difference
      -> OR use one climbing rope.

You must use the resources optimally.

Return the furthest reachable peak index.

===============================================================================

Example 1:
-----------
Input:
heights = [10, 15, 5, 12, 8, 20, 30, 35]
energyDrinks = 13
climbingRopes = 2

Output:
6

Explanation:
------------

Peak 0 -> Peak 1
10 -> 15
Need 5 energy drinks

Remaining energy = 8

------------------------------------------------

Peak 1 -> Peak 2
15 -> 5

No resources needed

------------------------------------------------

Peak 2 -> Peak 3
5 -> 12

Need 7 energy drinks

Remaining energy = 1

------------------------------------------------

Peak 3 -> Peak 4
12 -> 8

No resources needed

------------------------------------------------

Peak 4 -> Peak 5
8 -> 20

Difference = 12

Use climbing rope

------------------------------------------------

Peak 5 -> Peak 6
20 -> 30

Difference = 10

Use climbing rope

------------------------------------------------

Peak 6 -> Peak 7
30 -> 35

Difference = 5

No ropes left
Not enough energy

Cannot move further

Answer = 6

===============================================================================

Example 2:
-----------
Input:
heights = [7, 9, 12, 3, 15, 19, 18]
energyDrinks = 10
climbingRopes = 0

Output:
3

Explanation:
------------

7 -> 9
Need 2 energy drinks

Remaining = 8

------------------------------------------------

9 -> 12
Need 3 energy drinks

Remaining = 5

------------------------------------------------

12 -> 3

No resources needed

------------------------------------------------

3 -> 15
Need 12 energy drinks

Not enough energy

Answer = 3

===============================================================================

Intuition:
===============================================================================

We should use climbing ropes for the BIGGEST jumps.

Why?

Because ropes can completely ignore a height difference,
while energy drinks are consumed according to the difference.

So:
- Small jumps should use energy drinks.
- Large jumps should use ropes.

How to decide dynamically?

Use a Min Heap.

Whenever we encounter a positive jump:

1. Store the jump in heap.
2. If heap size exceeds number of ropes:
      -> Remove the smallest jump
      -> Pay that jump using energy drinks.

This guarantees:
- Largest jumps always use ropes.
- Smaller jumps use energy drinks.

This is the optimal greedy strategy.

===============================================================================

Dry Run:
===============================================================================

Input:
heights = [10,15,5,12,8,20,30,35]

energyDrinks = 13
climbingRopes = 2

-------------------------------------------------------------------------------

i = 0
10 -> 15

jump = 5

Heap = [5]

Heap size <= ropes
Use rope temporarily

-------------------------------------------------------------------------------

i = 1
15 -> 5

No climb needed

-------------------------------------------------------------------------------

i = 2
5 -> 12

jump = 7

Heap = [5,7]

Still <= ropes

-------------------------------------------------------------------------------

i = 3
12 -> 8

No climb needed

-------------------------------------------------------------------------------

i = 4
8 -> 20

jump = 12

Heap = [5,7,12]

Heap size > ropes

Remove smallest jump = 5

Use energy drinks for 5

energyDrinks = 13 - 5
              = 8

-------------------------------------------------------------------------------

i = 5
20 -> 30

jump = 10

Heap = [7,12,10]

Remove smallest = 7

Use energy drinks

energyDrinks = 8 - 7
              = 1

-------------------------------------------------------------------------------

i = 6
30 -> 35

jump = 5

Heap = [5,12,10]

Remove smallest = 5

Use energy drinks

energyDrinks = 1 - 5
              = -4

Cannot continue

Answer = 6

===============================================================================

Approach:
===============================================================================

1. Traverse the array from left to right.

2. For every upward climb:
      diff = heights[i+1] - heights[i]

3. Store diff in Min Heap.

4. If heap size becomes greater than climbing ropes:
      -> Remove smallest climb from heap
      -> Pay using energy drinks

5. If energy drinks become negative:
      -> Return current index

6. If traversal completes:
      -> Return last index

===============================================================================

Complexity Analysis:
===============================================================================

Time Complexity:
----------------
Each insertion/removal from heap takes:

O(logR)

Where:
R = climbing ropes

Overall:

O(N logR)

-------------------------------------------------------------------------------

Space Complexity:
-----------------
Heap stores at most (ropes + 1) jumps.

O(R)

===============================================================================
*/

public class _03_Furthest_Reachable_Mountain {

    static class Solution {

        public int furthestReachableBuilding(List<Integer> heights,
                                             int energyDrinks,
                                             int climbingRopes) {

            // Min Heap
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int n = heights.size();

            for (int i = 0; i < n - 1; i++) {

                int current = heights.get(i);
                int next = heights.get(i + 1);

                int diff = next - current;

                // No resources needed
                if (diff <= 0) {
                    continue;
                }

                // Store positive climb
                pq.offer(diff);

                // If climbs exceed ropes
                if (pq.size() > climbingRopes) {

                    // Use energy drinks
                    energyDrinks -= pq.poll();
                }

                // Not enough energy
                if (energyDrinks < 0) {
                    return i;
                }
            }

            // Reached last building
            return n - 1;
        }
    }

    // Driver Code
    public static void main(String[] args) {

        Solution sol = new Solution();

        List<Integer> heights1 =
                List.of(10, 15, 5, 12, 8, 20, 30, 35);

        int energy1 = 13;
        int ropes1 = 2;

        int ans1 =
                sol.furthestReachableBuilding(
                        heights1,
                        energy1,
                        ropes1
                );

        System.out.println("Answer 1 : " + ans1);

        System.out.println();

        List<Integer> heights2 =
                List.of(7, 9, 12, 3, 15, 19, 18);

        int energy2 = 10;
        int ropes2 = 0;

        int ans2 =
                sol.furthestReachableBuilding(
                        heights2,
                        energy2,
                        ropes2
                );

        System.out.println("Answer 2 : " + ans2);
    }
}