package _017_Heaps._01_Theory_And_Implementation;

import java.util.Arrays;

public class _07_Convert_Min_Heap_To_Max_Heap {

    /*
    ================================================================================

                    CONVERT MIN HEAP TO MAX HEAP

    ================================================================================

    PROBLEM:
    --------
    Given an array representation of a MIN HEAP,
    convert it into a MAX HEAP.

    Return the modified array.

    ================================================================================
    WHAT IS A MIN HEAP?
    ================================================================================

    A Min Heap is a Complete Binary Tree where:

            Parent <= Children

    Smallest element is always at the ROOT.

    Example:

                    10
                  /    \
                20      30
               /  \
             21   23

    Array Representation:
    ---------------------
    [10, 20, 30, 21, 23]

    ================================================================================
    WHAT IS A MAX HEAP?
    ================================================================================

    A Max Heap is a Complete Binary Tree where:

            Parent >= Children

    Largest element is always at the ROOT.

    Example:

                    30
                  /    \
                21      23
               /  \
             10   20

    Array Representation:
    ---------------------
    [30, 21, 23, 10, 20]

    ================================================================================
    IMPORTANT OBSERVATION
    ================================================================================

    The given array ALREADY represents a COMPLETE BINARY TREE.

    So:
    ----
    We DO NOT need to change the structure.

    We ONLY need to fix the HEAP PROPERTY.

    ------------------------------------------------------------------------------
    MIN HEAP:
    ------------------------------------------------------------------------------
        Parent is SMALLER than children.

    ------------------------------------------------------------------------------
    MAX HEAP:
    ------------------------------------------------------------------------------
        Parent is GREATER than children.

    ================================================================================
    INTUITION
    ================================================================================

    Leaf nodes already satisfy Max Heap property because
    they do not have children.

    Therefore:
    ----------
    Start from the LAST NON-LEAF NODE
    and heapify every node DOWNWARDS.

    Eventually:
    -----------
    Entire tree becomes a MAX HEAP.

    ================================================================================
    ARRAY REPRESENTATION OF HEAP
    ================================================================================

    For a node at index i:

        Left Child  = 2*i + 1
        Right Child = 2*i + 2
        Parent      = (i - 1)/2

    ================================================================================
    LAST NON-LEAF NODE
    ================================================================================

    Formula:

            (n / 2) - 1

    Why?
    ----
    Nodes after this index are leaf nodes.

    ================================================================================
    APPROACH
    ================================================================================

    STEP 1:
    --------
    Start from the last non-leaf node.

    STEP 2:
    --------
    Apply Max Heapify on every node.

    STEP 3:
    --------
    During heapify:
        - Compare parent with children
        - Find largest among them
        - Swap if needed
        - Continue recursively

    STEP 4:
    --------
    After all heapify operations,
    array becomes a valid MAX HEAP.

    ================================================================================
    DRY RUN
    ================================================================================

    nums = [10, 20, 30, 21, 23]

    Tree:

                    10
                  /    \
                20      30
               /  \
             21   23

    ------------------------------------------------------------------------------
    n = 5

    Last Non-Leaf Node:
        n/2 - 1
        5/2 - 1
        2 - 1
        1

    Start from i = 1
    ------------------------------------------------------------------------------

    Node = 20

    Children:
        21 and 23

    Largest = 23

    Swap:
        [10, 23, 30, 21, 20]

    ------------------------------------------------------------------------------
    i = 0
    ------------------------------------------------------------------------------

    Node = 10

    Children:
        23 and 30

    Largest = 30

    Swap:
        [30, 23, 10, 21, 20]

    Heapify subtree rooted at index 2

    Final Max Heap:
        [30, 23, 10, 21, 20]

    ================================================================================
    TIME COMPLEXITY
    ================================================================================

    Heapify operation:
        O(log N)

    But Bottom-Up Heap Construction overall:
        O(N)

    Therefore:

        Time Complexity = O(N)

    ================================================================================
    SPACE COMPLEXITY
    ================================================================================

    Recursive stack space:
        O(log N)

    ================================================================================
    */

    static class Solution {

        /*
        =============================================================================
                            HEAPIFY DOWN FOR MAX HEAP
        =============================================================================

        PURPOSE:
        --------
        Fix the subtree rooted at index 'ind'
        so that it follows MAX HEAP property.

        MAX HEAP PROPERTY:
            Parent >= Children
        */
        private void heapifyDown(int[] arr, int ind) {

            // Total number of elements
            int n = arr.length;

            // Assume current node is largest
            int largestInd = ind;

            // Left child index
            int leftChildInd = 2 * ind + 1;

            // Right child index
            int rightChildInd = 2 * ind + 2;

            /*
            Check if left child exists
            and is larger than current largest
            */
            if (leftChildInd < n &&
                    arr[leftChildInd] > arr[largestInd]) {

                largestInd = leftChildInd;
            }

            /*
            Check if right child exists
            and is larger than current largest
            */
            if (rightChildInd < n &&
                    arr[rightChildInd] > arr[largestInd]) {

                largestInd = rightChildInd;
            }

            /*
            If largest index changes,
            swap parent with largest child
            */
            if (largestInd != ind) {

                // Swap
                int temp = arr[ind];
                arr[ind] = arr[largestInd];
                arr[largestInd] = temp;

                /*
                Heapify affected subtree recursively
                */
                heapifyDown(arr, largestInd);
            }
        }

        /*
        =============================================================================
                        CONVERT MIN HEAP TO MAX HEAP
        =============================================================================
        */
        public int[] minToMaxHeap(int[] nums) {

            int n = nums.length;

            /*
            Start from LAST NON-LEAF NODE
            and heapify every node.
            */
            for (int i = n / 2 - 1; i >= 0; i--) {

                heapifyDown(nums, i);
            }

            return nums;
        }
    }

    /*
    ================================================================================
                                    MAIN METHOD
    ================================================================================
    */

    public static void main(String[] args) {

        Solution sol = new Solution();

        /*
        ------------------------------------------------------------------------
        EXAMPLE 1
        ------------------------------------------------------------------------
        */

        int[] nums1 = {10, 20, 30, 21, 23};

        System.out.println("Original Min Heap:");
        System.out.println(Arrays.toString(nums1));

        sol.minToMaxHeap(nums1);

        System.out.println("Converted Max Heap:");
        System.out.println(Arrays.toString(nums1));

        /*
        ------------------------------------------------------------------------
        EXAMPLE 2
        ------------------------------------------------------------------------
        */

        int[] nums2 = {-5, -4, -3, -2, -1};

        System.out.println("\nOriginal Min Heap:");
        System.out.println(Arrays.toString(nums2));

        sol.minToMaxHeap(nums2);

        System.out.println("Converted Max Heap:");
        System.out.println(Arrays.toString(nums2));
    }
}