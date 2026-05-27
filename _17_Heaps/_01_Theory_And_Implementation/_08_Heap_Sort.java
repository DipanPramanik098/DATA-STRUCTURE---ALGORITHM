package _17_Heaps._01_Theory_And_Implementation;

import java.util.Arrays;

/*
===============================================================================
                            HEAP SORT
===============================================================================

PROBLEM:
---------
Given an array of integers nums, sort the array in non-decreasing order
using Heap Sort algorithm.

A sorted array in non-decreasing order means:
arr[i] <= arr[i + 1]

Example:
---------
Input  : [7, 4, 1, 5, 3]
Output : [1, 3, 4, 5, 7]

===============================================================================
INTUITION:
===============================================================================

The main idea behind Heap Sort is:

1. Convert the array into a MAX-HEAP.
   - In a max-heap, the largest element is always at index 0.

2. Swap the largest element with the last element.
   - Now the last element is in its correct sorted position.

3. Reduce the heap size by 1.
   - Ignore the sorted part at the end.

4. Heapify the root again to restore max-heap property.

5. Repeat until array becomes sorted.

-------------------------------------------------------------------------------
WHY MAX-HEAP?
-------------------------------------------------------------------------------

Because we need ascending order.

Max-Heap always gives:
Largest Element -> Root

So:
- Put largest element at end
- Reduce heap size
- Repeat

Eventually array becomes sorted in ascending order.

===============================================================================
HEAP SORT FLOW:
===============================================================================

UNSORTED ARRAY
        ↓

BUILD MAX HEAP
        ↓

Largest element comes at root
        ↓

Swap root with last index
        ↓

Largest element fixed at correct position
        ↓

Heapify remaining array
        ↓

Repeat

===============================================================================
EXAMPLE:
===============================================================================

Input:
-------
[6, 2, 3, 1, 5]

STEP 1: Build Max Heap
----------------------

            6
          /   \
         5     3
        / \
       1   2

Array:
[6, 5, 3, 1, 2]

-------------------------------------------------------------------------------

STEP 2: Swap root with last
---------------------------

Swap 6 and 2

[2, 5, 3, 1, 6]

Now 6 is fixed.

Heapify remaining heap:

            5
          /   \
         2     3
        /
       1

Array:
[5, 2, 3, 1, 6]

-------------------------------------------------------------------------------

STEP 3: Swap root with last unsorted
------------------------------------

Swap 5 and 1

[1, 2, 3, 5, 6]

Heapify:

            3
          /   \
         2     1

Array:
[3, 2, 1, 5, 6]

-------------------------------------------------------------------------------

STEP 4:
-------

Swap 3 and 1

[1, 2, 3, 5, 6]

Heapify:

        2
       /
      1

Array:
[2, 1, 3, 5, 6]

-------------------------------------------------------------------------------

STEP 5:
-------

Swap 2 and 1

[1, 2, 3, 5, 6]

SORTED.

===============================================================================
IMPORTANT OBSERVATION:
===============================================================================

Heap Sort is:

1. IN-PLACE
   - No extra array required.

2. COMPARISON BASED

3. NOT STABLE
   - Relative order of equal elements may change.

4. GUARANTEED O(N logN)

===============================================================================
INDEX RELATIONS:
===============================================================================

For any node at index i:

Left Child  = 2*i + 1
Right Child = 2*i + 2
Parent      = (i - 1)/2

===============================================================================
TIME COMPLEXITY:
===============================================================================

BUILD MAX HEAP:
----------------
O(N)

SORTING:
---------
We perform heapify N times.

Each heapify takes:
O(logN)

Total:
O(N logN)

-------------------------------------------------------------------------------
FINAL TIME COMPLEXITY:
-------------------------------------------------------------------------------

Best Case    : O(N logN)
Average Case : O(N logN)
Worst Case   : O(N logN)

===============================================================================
SPACE COMPLEXITY:
===============================================================================

Recursive stack space:
O(logN)

No extra array used.

===============================================================================
ADVANTAGES:
===============================================================================

1. Guaranteed O(N logN)
2. In-place sorting
3. No extra memory needed
4. Efficient for large datasets

===============================================================================
DISADVANTAGES:
===============================================================================

1. Not stable
2. Cache performance weaker than Quick Sort
3. Recursive heapify adds stack overhead

===============================================================================
CODE:
===============================================================================
*/

public class _08_Heap_Sort {

    /*
    ===========================================================================
    HEAPIFY DOWN
    ===========================================================================

    PURPOSE:
    --------
    Restores max-heap property from current index downward.

    PARAMETERS:
    -----------
    arr  -> heap array
    last -> last valid index of heap
    ind  -> current node index

    LOGIC:
    ------
    1. Find largest among:
       - parent
       - left child
       - right child

    2. If parent is not largest:
       - swap
       - recursively heapify below

    ===========================================================================
    */
    private void heapifyDown(int[] arr, int last, int ind) {

        // Assume current node is largest
        int largestInd = ind;

        // Left child index
        int leftChildInd = 2 * ind + 1;

        // Right child index
        int rightChildInd = 2 * ind + 2;

        /*
        -----------------------------------------------------------------------
        Check left child
        -----------------------------------------------------------------------
        */
        if (leftChildInd <= last &&
                arr[leftChildInd] > arr[largestInd]) {

            largestInd = leftChildInd;
        }

        /*
        -----------------------------------------------------------------------
        Check right child
        -----------------------------------------------------------------------
        */
        if (rightChildInd <= last &&
                arr[rightChildInd] > arr[largestInd]) {

            largestInd = rightChildInd;
        }

        /*
        -----------------------------------------------------------------------
        If largest element is not current node
        -----------------------------------------------------------------------
        */
        if (largestInd != ind) {

            // Swap current node with largest child
            int temp = arr[ind];
            arr[ind] = arr[largestInd];
            arr[largestInd] = temp;

            // Heapify affected subtree
            heapifyDown(arr, last, largestInd);
        }
    }

    /*
    ===========================================================================
    BUILD MAX HEAP
    ===========================================================================

    PURPOSE:
    --------
    Converts normal array into max-heap.

    IMPORTANT:
    ----------
    Leaf nodes already satisfy heap property.

    So start from:
    n/2 - 1

    because:
    - all nodes after that are leaf nodes.

    ===========================================================================
    */
    private void buildMaxHeap(int[] nums) {

        int n = nums.length;

        /*
        -----------------------------------------------------------------------
        Start from last non-leaf node
        -----------------------------------------------------------------------
        */
        for (int i = n / 2 - 1; i >= 0; i--) {

            // Heapify each subtree
            heapifyDown(nums, n - 1, i);
        }
    }

    /*
    ===========================================================================
    HEAP SORT
    ===========================================================================

    STEPS:
    ------
    1. Build max heap
    2. Swap root with last
    3. Reduce heap size
    4. Heapify root
    5. Repeat

    ===========================================================================
    */
    public void heapSort(int[] nums) {

        /*
        -----------------------------------------------------------------------
        STEP 1:
        Build max heap
        -----------------------------------------------------------------------
        */
        buildMaxHeap(nums);

        /*
        -----------------------------------------------------------------------
        Last valid index of heap
        -----------------------------------------------------------------------
        */
        int last = nums.length - 1;

        /*
        -----------------------------------------------------------------------
        Continue until heap becomes empty
        -----------------------------------------------------------------------
        */
        while (last > 0) {

            /*
            -------------------------------------------------------------------
            Move largest element to correct position
            -------------------------------------------------------------------
            */
            int temp = nums[0];
            nums[0] = nums[last];
            nums[last] = temp;

            /*
            -------------------------------------------------------------------
            Reduce heap size
            -------------------------------------------------------------------
            */
            last--;

            /*
            -------------------------------------------------------------------
            Restore max heap property
            -------------------------------------------------------------------
            */
            heapifyDown(nums, last, 0);
        }
    }

    /*
    ===========================================================================
    MAIN METHOD
    ===========================================================================
    */
    public static void main(String[] args) {

        int[] nums = {6, 2, 3, 1, 5};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));

        // Create object
        _08_Heap_Sort obj = new _08_Heap_Sort();

        // Perform Heap Sort
        obj.heapSort(nums);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(nums));
    }
}