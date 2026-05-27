package _17_Heaps._01_Theory_And_Implementation;

import java.util.Arrays;

/*
===========================================================
            BUILD HEAP FROM A GIVEN ARRAY
===========================================================

Problem:
Given an array of integers nums, convert it in-place into
a MIN-HEAP.

-----------------------------------------------------------
MIN-HEAP PROPERTY
-----------------------------------------------------------

For every node:
Parent <= Left Child
Parent <= Right Child

The smallest element is always present at the root.

-----------------------------------------------------------
EXAMPLE 1
-----------------------------------------------------------

Input:
nums = [6, 5, 2, 7, 1, 7]

Output:
[1, 5, 2, 7, 6, 7]

Explanation:

                6
              /   \
             5     2
            / \   /
           7   1 7

This is NOT a Min Heap because:
6 > 5
5 > 1

After heap construction:

                1
              /   \
             5     2
            / \   /
           7   6 7

Now:
1 <= 5,2
5 <= 7,6
2 <= 7

So it becomes a valid MIN HEAP.

-----------------------------------------------------------
EXAMPLE 2
-----------------------------------------------------------

Input:
nums = [2, 3, 4, 1, 7, 3, 9, 4, 6]

Output:
[1, 2, 3, 3, 7, 4, 9, 4, 6]

-----------------------------------------------------------
INTUITION
-----------------------------------------------------------

The main idea is:

1. Leaf nodes are already valid heaps
   because they have no children.

2. Only NON-LEAF nodes can violate
   the heap property.

3. So we start heapifying from the
   LAST NON-LEAF NODE and move upward.

-----------------------------------------------------------
IMPORTANT FORMULA
-----------------------------------------------------------

For array representation of heap:

Left Child  = 2*i + 1
Right Child = 2*i + 2

Last Non-Leaf Node:
= (n/2) - 1

-----------------------------------------------------------
WHY START FROM LAST NON-LEAF NODE?
-----------------------------------------------------------

Because:
- Leaf nodes already satisfy heap property.
- We only need to fix parents.

By heapifying bottom-up,
every subtree becomes a valid heap.

-----------------------------------------------------------
APPROACH
-----------------------------------------------------------

STEP 1:
Find the last non-leaf node.

STEP 2:
Traverse backward till root.

STEP 3:
For every node:
Perform HEAPIFY DOWN operation.

-----------------------------------------------------------
HEAPIFY DOWN
-----------------------------------------------------------

1. Compare current node with left child.
2. Compare current node with right child.
3. Find smallest among them.
4. Swap if required.
5. Continue recursively.

-----------------------------------------------------------
DRY RUN
-----------------------------------------------------------

Input:
nums = [6, 5, 2, 7, 1, 7]

Index Mapping:

Index:  0  1  2  3  4  5
Value: [6, 5, 2, 7, 1, 7]

n = 6

Last Non-Leaf Node:
(n/2)-1
= (6/2)-1
= 2

--------------------------------
i = 2
--------------------------------

Value = 2

Children:
Left = index 5 -> 7

2 < 7
Already valid.

Array:
[6, 5, 2, 7, 1, 7]

--------------------------------
i = 1
--------------------------------

Value = 5

Children:
7 and 1

Smallest = 1

Swap 5 and 1

Array:
[6, 1, 2, 7, 5, 7]

--------------------------------
i = 0
--------------------------------

Value = 6

Children:
1 and 2

Smallest = 1

Swap 6 and 1

Array:
[1, 6, 2, 7, 5, 7]

Now heapify index 1:

Children:
7 and 5

Smallest = 5

Swap 6 and 5

Final Array:
[1, 5, 2, 7, 6, 7]

-----------------------------------------------------------
TIME COMPLEXITY
-----------------------------------------------------------

Time Complexity = O(N)

Why NOT O(N log N)?

Because:
- Lower levels require very little work.
- Only few nodes near top require more work.

Thus total work becomes linear.

-----------------------------------------------------------
SPACE COMPLEXITY
-----------------------------------------------------------

Recursive Version:
O(log N)

because recursion stack height equals heap height.

===========================================================
*/

public class _03_Build_Heap_From_A_Given_Array {

    /*
    ===========================================================
                    HEAPIFY DOWN FUNCTION
    ===========================================================

    Purpose:
    Fix heap property for subtree rooted at index ind.

    Steps:
    1. Find smallest among:
       - current node
       - left child
       - right child

    2. If smallest is not current node:
       swap

    3. Recursively heapify affected subtree.
    ===========================================================
    */
    private void heapifyDown(int[] arr, int ind) {

        // Total number of elements
        int n = arr.length;

        // Assume current index is smallest
        int smallestInd = ind;

        // Left child index
        int leftChildInd = 2 * ind + 1;

        // Right child index
        int rightChildInd = 2 * ind + 2;

        /*
        -------------------------------------------------------
        CHECK LEFT CHILD
        -------------------------------------------------------
        */
        if (leftChildInd < n &&
                arr[leftChildInd] < arr[smallestInd]) {

            smallestInd = leftChildInd;
        }

        /*
        -------------------------------------------------------
        CHECK RIGHT CHILD
        -------------------------------------------------------
        */
        if (rightChildInd < n &&
                arr[rightChildInd] < arr[smallestInd]) {

            smallestInd = rightChildInd;
        }

        /*
        -------------------------------------------------------
        IF CURRENT NODE IS NOT SMALLEST
        THEN SWAP
        -------------------------------------------------------
        */
        if (smallestInd != ind) {

            int temp = arr[ind];
            arr[ind] = arr[smallestInd];
            arr[smallestInd] = temp;

            /*
            ---------------------------------------------------
            HEAPIFY LOWER SUBTREE
            ---------------------------------------------------
            */
            heapifyDown(arr, smallestInd);
        }
    }

    /*
    ===========================================================
                BUILD MIN HEAP FUNCTION
    ===========================================================

    Converts given array into MIN HEAP.

    Steps:
    1. Start from last non-leaf node.
    2. Heapify every node downward.
    ===========================================================
    */
    public void buildMinHeap(int[] nums) {

        int n = nums.length;

        /*
        -------------------------------------------------------
        LAST NON-LEAF NODE
        -------------------------------------------------------

        Formula:
        (n/2) - 1
        */
        int lastNonLeaf = (n / 2) - 1;

        /*
        -------------------------------------------------------
        TRAVERSE BACKWARD
        -------------------------------------------------------
        */
        for (int i = lastNonLeaf; i >= 0; i--) {

            /*
            ---------------------------------------------------
            FIX SUBTREE ROOTED AT INDEX i
            ---------------------------------------------------
            */
            heapifyDown(nums, i);
        }
    }

    /*
    ===========================================================
                        MAIN METHOD
    ===========================================================
    */
    public static void main(String[] args) {

        /*
        -------------------------------------------------------
        INPUT ARRAY
        -------------------------------------------------------
        */
        int[] nums = {6, 5, 2, 7, 1, 7};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));

        /*
        -------------------------------------------------------
        CREATE OBJECT
        -------------------------------------------------------
        */
        _03_Build_Heap_From_A_Given_Array obj =
                new _03_Build_Heap_From_A_Given_Array();

        /*
        -------------------------------------------------------
        BUILD MIN HEAP
        -------------------------------------------------------
        */
        obj.buildMinHeap(nums);

        /*
        -------------------------------------------------------
        OUTPUT
        -------------------------------------------------------
        */
        System.out.println("\nMin Heap Array:");
        System.out.println(Arrays.toString(nums));
    }
}