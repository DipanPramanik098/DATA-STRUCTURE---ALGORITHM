package _17_Heaps._02_FAQs;

import java.util.PriorityQueue;

/*
===============================================================================
                    Kth Largest Element In A Stream
===============================================================================

PROBLEM:
---------
Design a class KthLargest that continuously returns the kth largest element
from a stream of integers.

We need to implement:

1. KthLargest(int k, int[] nums)
   -> Initialize the object with k and existing numbers.

2. add(int val)
   -> Add a new number into the stream.
   -> Return the kth largest element after insertion.

-------------------------------------------------------------------------------
EXAMPLE:
-------------------------------------------------------------------------------

Input:
K = 3
nums = [1, 2, 3, 4]

Heap after processing:
[2, 4, 3]

Explanation:
Top 3 largest numbers are:
[2, 3, 4]

The smallest among them = 2
So 3rd largest = 2

Now:

add(5)

Top 3 largest:
[3, 4, 5]

Return = 3

-------------------------------------------------------------------------------
INTUITION:
-------------------------------------------------------------------------------

Brute Force:
-------------
Every time:
1. Insert new number
2. Sort entire stream
3. Return kth largest

Time Complexity:
O(N logN) for every insertion

Very inefficient.

-------------------------------------------------------------------------------
OPTIMAL IDEA:
-------------------------------------------------------------------------------

We DO NOT need all elements.

We only need:
"The K largest elements"

Because:
The kth largest element is simply:
"The smallest among the top K elements"

This is exactly what a MIN HEAP does efficiently.

-------------------------------------------------------------------------------
WHY MIN HEAP?
-------------------------------------------------------------------------------

Suppose:
K = 3

Stream:
[10, 20, 30, 40]

Top 3 largest:
[20, 30, 40]

3rd largest = 20

Notice:
20 is the SMALLEST among the top 3 elements.

Thus:
Maintain a MIN HEAP of size K.

Heap top always stores kth largest element.

-------------------------------------------------------------------------------
WORKING:
-------------------------------------------------------------------------------

1. Keep only K elements in heap.
2. Smallest among them = kth largest.
3. If a new element is bigger than heap top:
      remove heap top
      insert new element

-------------------------------------------------------------------------------
VISUALIZATION:
-------------------------------------------------------------------------------

K = 3

Stream:
[4, 5, 8, 2]

Step 1:
Insert 4
Heap = [4]

Step 2:
Insert 5
Heap = [4, 5]

Step 3:
Insert 8
Heap = [4, 5, 8]

Step 4:
Insert 2

2 < heap top (4)
Ignore

Heap still:
[4, 5, 8]

3rd largest = 4

-------------------------------------------------------------------------------
ADD OPERATION:
-------------------------------------------------------------------------------

add(10)

10 > heap top (4)

Remove 4
Insert 10

Heap:
[5, 8, 10]

3rd largest = 5

-------------------------------------------------------------------------------
DRY RUN:
-------------------------------------------------------------------------------

K = 3
nums = [1,2,3,4]

Initial Processing:

Insert 1
Heap = [1]

Insert 2
Heap = [1,2]

Insert 3
Heap = [1,2,3]

Insert 4

4 > heap top (1)

Remove 1
Insert 4

Heap:
[2,3,4]

Current kth largest = 2

---------------------------------

add(5)

5 > 2

Remove 2
Insert 5

Heap:
[3,4,5]

Return 3

---------------------------------

add(2)

2 < 3

Ignore

Heap:
[3,4,5]

Return 3

---------------------------------

add(7)

7 > 3

Remove 3
Insert 7

Heap:
[4,5,7]

Return 4

-------------------------------------------------------------------------------
ALGORITHM:
-------------------------------------------------------------------------------

CONSTRUCTOR:
-------------
1. Store K
2. Create min heap
3. Traverse nums
4. Insert elements carefully:
      - If heap size < K:
            insert directly
      - Else:
            if current element > heap top
                  remove top
                  insert current element

-------------------------------------------------------------------------------
ADD(val):
-------------------------------------------------------------------------------

1. If heap size < K:
      insert val

2. Else if val > heap top:
      remove top
      insert val

3. Return heap top

-------------------------------------------------------------------------------
TIME COMPLEXITY:
-------------------------------------------------------------------------------

Constructor:
O(N logK)

Because:
Each insertion into heap takes logK.

-------------------------------------------------------------------------------

add(val):
O(logK)

Insertion/removal in heap takes logK.

-------------------------------------------------------------------------------
SPACE COMPLEXITY:
-------------------------------------------------------------------------------

O(K)

Because heap stores at most K elements.

===============================================================================
*/

public class _01_Kth_Largest_Element_in_A_Stream_Of_Running_Integers {

    /*
    ---------------------------------------------------------------------------
    Min Heap
    ---------------------------------------------------------------------------
    Java PriorityQueue by default works as a Min Heap.
    */
    private PriorityQueue<Integer> pq;

    /*
    ---------------------------------------------------------------------------
    Stores value of K
    ---------------------------------------------------------------------------
    */
    private int K;

    /*
    ---------------------------------------------------------------------------
    CONSTRUCTOR
    ---------------------------------------------------------------------------
    Initializes the object.
    */
    public _01_Kth_Largest_Element_in_A_Stream_Of_Running_Integers(
            int k,
            int[] nums
    ) {

        // Store K
        this.K = k;

        // Create Min Heap
        pq = new PriorityQueue<>();

        /*
        -----------------------------------------------------------------------
        Process all initial stream elements
        -----------------------------------------------------------------------
        */
        for (int num : nums) {

            /*
            ---------------------------------------------------------------
            If heap size is less than K
            directly insert element
            ---------------------------------------------------------------
            */
            if (pq.size() < K) {
                pq.offer(num);
            }

            /*
            ---------------------------------------------------------------
            If current number is greater than heap top
            then it deserves to be in top K elements
            ---------------------------------------------------------------
            */
            else if (num > pq.peek()) {

                // Remove smallest among top K
                pq.poll();

                // Insert current number
                pq.offer(num);
            }
        }
    }

    /*
    ---------------------------------------------------------------------------
    ADD METHOD
    ---------------------------------------------------------------------------
    Adds new element into stream
    Returns kth largest element
    */
    public int add(int val) {

        /*
        ---------------------------------------------------------------
        If heap size is smaller than K
        insert directly
        ---------------------------------------------------------------
        */
        if (pq.size() < K) {

            pq.offer(val);

            return pq.peek();
        }

        /*
        ---------------------------------------------------------------
        If current value is greater than smallest element
        in heap, then it should be included in top K
        ---------------------------------------------------------------
        */
        if (val > pq.peek()) {

            // Remove smallest
            pq.poll();

            // Insert new value
            pq.offer(val);
        }

        /*
        ---------------------------------------------------------------
        Heap top always stores kth largest element
        ---------------------------------------------------------------
        */
        return pq.peek();
    }

    /*
    ---------------------------------------------------------------------------
    MAIN METHOD
    ---------------------------------------------------------------------------
    */
    public static void main(String[] args) {

        int k = 3;

        int[] nums = {1, 2, 3, 4};

        /*
        -----------------------------------------------------------------------
        Create Object
        -----------------------------------------------------------------------
        */
        _01_Kth_Largest_Element_in_A_Stream_Of_Running_Integers obj =
                new _01_Kth_Largest_Element_in_A_Stream_Of_Running_Integers(
                        k,
                        nums
                );

        /*
        -----------------------------------------------------------------------
        Perform Operations
        -----------------------------------------------------------------------
        */
        System.out.println("After adding 5  -> " + obj.add(5));

        System.out.println("After adding 2  -> " + obj.add(2));

        System.out.println("After adding 7  -> " + obj.add(7));
    }
}