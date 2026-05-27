package _017_Heaps._03_xTra;

import java.util.*;

/*
===============================================================================
                            K Nearest Integers
===============================================================================

PROBLEM:
---------
Given an integer array arr and two integers k and x.

Find k integers from the array that are nearest to x.

Rules:
------
1. Nearness is measured using:
       |arr[i] - x|

2. If two numbers have same distance from x,
   choose the SMALLER number.

3. Return answer in ascending order.

===============================================================================
EXAMPLE:
===============================================================================

Input:
arr = [4, 1, 3, 2, 5]
k = 3
x = 3

Output:
[2, 3, 4]

Explanation:
------------
Distance from 3:

4 -> 1
1 -> 2
3 -> 0
2 -> 1
5 -> 2

Nearest 3 numbers:
3, 2, 4

Sorted answer:
[2, 3, 4]

===============================================================================
INTUITION:
===============================================================================

We only need K nearest elements.

If we already selected K elements and a new element comes,
we should remove the WORST element among selected ones.

Worst means:
-------------
1. Larger distance from x
2. If same distance:
      larger number is worse
      because smaller number is preferred

This can be efficiently handled using a MAX HEAP.

===============================================================================
WHY MAX HEAP?
===============================================================================

Heap top should contain:
the farthest element among current K nearest numbers.

So whenever heap size exceeds K,
remove the top element.

Finally heap contains exactly K nearest integers.

===============================================================================
APPROACH:
===============================================================================

1. Create MAX HEAP.

2. Traverse array.

3. Insert every element with:
      distance = |num - x|

4. If heap size exceeds K:
      remove top element
      (worst candidate)

5. Extract all elements from heap.

6. Sort final answer in ascending order.

===============================================================================
DRY RUN:
===============================================================================

arr = [4,1,3,2,5]
k = 3
x = 3

-------------------------------------------------------------------------------
STEP 1:
-------------------------------------------------------------------------------

Insert 4
distance = 1

Heap:
[(1,4)]

-------------------------------------------------------------------------------
STEP 2:
-------------------------------------------------------------------------------

Insert 1
distance = 2

Heap:
[(2,1), (1,4)]

-------------------------------------------------------------------------------
STEP 3:
-------------------------------------------------------------------------------

Insert 3
distance = 0

Heap:
[(2,1), (1,4), (0,3)]

-------------------------------------------------------------------------------
STEP 4:
-------------------------------------------------------------------------------

Insert 2
distance = 1

Heap size = 4

Remove worst:
(2,1)

Heap:
[(1,4), (1,2), (0,3)]

-------------------------------------------------------------------------------
STEP 5:
-------------------------------------------------------------------------------

Insert 5
distance = 2

Heap size = 4

Remove worst:
(2,5)

Heap:
[(1,4), (1,2), (0,3)]

-------------------------------------------------------------------------------
FINAL:
-------------------------------------------------------------------------------

Elements:
4,2,3

After sorting:
[2,3,4]

===============================================================================
TIME COMPLEXITY:
===============================================================================

Traversing array:
O(N)

Heap insertion/removal:
O(logK)

Overall:
O(N logK)

Sorting final K elements:
O(K logK)

===============================================================================
SPACE COMPLEXITY:
===============================================================================

Heap stores at most K elements.

O(K)

===============================================================================
*/

public class _01_K_Nearest_Integers {

    /*
    ---------------------------------------------------------------------------
    Pair Class
    ---------------------------------------------------------------------------
    Stores:
    1. distance from x
    2. actual value
    */
    static class Pair {

        int distance;
        int value;

        Pair(int distance, int value) {
            this.distance = distance;
            this.value = value;
        }
    }

    /*
    ---------------------------------------------------------------------------
    FUNCTION:
    Returns K nearest integers
    ---------------------------------------------------------------------------
    */
    public List<Integer> kNearestIntegers(int[] arr, int k, int x) {

        /*
        -----------------------------------------------------------------------
        MAX HEAP
        -----------------------------------------------------------------------

        Priority:
        ----------
        1. Larger distance first
        2. If same distance:
              larger value first
        */
        PriorityQueue<Pair> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> {

                            // Compare distance
                            if (a.distance != b.distance) {
                                return b.distance - a.distance;
                            }

                            // Compare value
                            return b.value - a.value;
                        }
                );

        /*
        -----------------------------------------------------------------------
        Traverse all elements
        -----------------------------------------------------------------------
        */
        for (int num : arr) {

            // Calculate distance from x
            int distance = Math.abs(num - x);

            // Insert into heap
            maxHeap.offer(new Pair(distance, num));

            /*
            -------------------------------------------------------------------
            Keep only K elements
            -------------------------------------------------------------------
            */
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        /*
        -----------------------------------------------------------------------
        Extract remaining K nearest elements
        -----------------------------------------------------------------------
        */
        List<Integer> ans = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll().value);
        }

        /*
        -----------------------------------------------------------------------
        Sort answer in ascending order
        -----------------------------------------------------------------------
        */
        Collections.sort(ans);

        return ans;
    }

    /*
    ---------------------------------------------------------------------------
    MAIN METHOD
    ---------------------------------------------------------------------------
    */
    public static void main(String[] args) {

        int[] arr = {4, 1, 3, 2, 5};

        int k = 3;

        int x = 3;

        /*
        -----------------------------------------------------------------------
        Create Object
        -----------------------------------------------------------------------
        */
        _01_K_Nearest_Integers obj =
                new _01_K_Nearest_Integers();

        /*
        -----------------------------------------------------------------------
        Function Call
        -----------------------------------------------------------------------
        */
        List<Integer> ans = obj.kNearestIntegers(arr, k, x);

        /*
        -----------------------------------------------------------------------
        Print Final Answer
        -----------------------------------------------------------------------
        */
        System.out.println("K Nearest Integers: " + ans);
    }
}