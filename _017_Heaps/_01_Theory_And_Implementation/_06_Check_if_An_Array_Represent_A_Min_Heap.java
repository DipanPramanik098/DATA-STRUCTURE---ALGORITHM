package _017_Heaps._01_Theory_And_Implementation;

public class _06_Check_if_An_Array_Represent_A_Min_Heap {

    /*
    ================================================================================

                    CHECK IF AN ARRAY REPRESENTS A MIN HEAP

    ================================================================================

    PROBLEM:
    --------
    Given an array representation of a Complete Binary Tree,
    determine whether it satisfies the MIN-HEAP property or not.

    Return:
    -------
    true  -> if array represents a valid Min Heap
    false -> otherwise

    ------------------------------------------------------------------------------
    MIN HEAP PROPERTY:
    ------------------------------------------------------------------------------
    For every node:

            Parent <= Left Child
            Parent <= Right Child

    Meaning:
    --------
    Every parent node must contain a value smaller than or equal
    to its children.

    ------------------------------------------------------------------------------
    IMPORTANT POINT:
    ------------------------------------------------------------------------------
    The array is already guaranteed to represent a COMPLETE BINARY TREE.

    So we ONLY need to check the MIN HEAP PROPERTY.

    ================================================================================
    EXAMPLE 1
    ================================================================================

    Input:
    ------
    nums = [10, 20, 30, 21, 23]

    Tree Representation:

                    10
                  /    \
                20      30
               /  \
             21   23

    Checking:
    ----------
    10 <= 20 ✔
    10 <= 30 ✔
    20 <= 21 ✔
    20 <= 23 ✔

    Hence:
    -------
    Valid Min Heap

    Output:
    -------
    true


    ================================================================================
    EXAMPLE 2
    ================================================================================

    Input:
    ------
    nums = [10, 20, 30, 25, 15]

    Tree Representation:

                    10
                  /    \
                20      30
               /  \
             25   15

    Checking:
    ----------
    10 <= 20 ✔
    10 <= 30 ✔
    20 <= 25 ✔
    20 <= 15 ✘

    Since parent > child,
    Min Heap property breaks.

    Output:
    -------
    false


    ================================================================================
    INTUITION
    ================================================================================

    In a Min Heap:

            Parent is always smaller than children.

    So:
    ----
    We only need to verify this condition for every node.

    IMPORTANT OBSERVATION:
    ----------------------
    Leaf nodes never violate heap property because they have NO children.

    Therefore:
    ----------
    We only need to iterate over NON-LEAF nodes.

    ================================================================================
    ARRAY REPRESENTATION OF HEAP
    ================================================================================

    For a node at index i:

        Left Child  = 2*i + 1
        Right Child = 2*i + 2
        Parent      = (i - 1)/2

    ------------------------------------------------------------------------------
    NON-LEAF NODE RANGE
    ------------------------------------------------------------------------------
    For array of size n:

        Non-leaf nodes:
            0 to (n/2 - 1)

        Leaf nodes:
            n/2 to n-1

    WHY?
    ----
    Because leaf nodes do not have children.

    ================================================================================
    APPROACH
    ================================================================================

    STEP 1:
    --------
    Traverse all non-leaf nodes.

    STEP 2:
    --------
    For each node:
        Check left child
        Check right child

    STEP 3:
    --------
    If any child is smaller than parent:
            return false

    STEP 4:
    --------
    If all nodes satisfy heap property:
            return true

    ================================================================================
    DRY RUN
    ================================================================================

    nums = [10, 20, 30, 21, 23]

    n = 5

    Non-leaf nodes:
        0 to (5/2 - 1)
        0 to 1

    ------------------------------------------------
    i = 1
    ------------------------------------------------

    nums[1] = 20

    left child index:
        2*1 + 1 = 3
        nums[3] = 21

    right child index:
        2*1 + 2 = 4
        nums[4] = 23

    Checking:
        20 <= 21 ✔
        20 <= 23 ✔

    ------------------------------------------------
    i = 0
    ------------------------------------------------

    nums[0] = 10

    left child:
        nums[1] = 20

    right child:
        nums[2] = 30

    Checking:
        10 <= 20 ✔
        10 <= 30 ✔

    All conditions satisfied.

    Output:
        true

    ================================================================================
    TIME COMPLEXITY
    ================================================================================

    We iterate over approximately N/2 nodes.

    Therefore:

        TC = O(N)

    ================================================================================
    SPACE COMPLEXITY
    ================================================================================

    No extra space used.

        SC = O(1)

    ================================================================================
    */

    static class Solution {

        // Function to check whether array represents a Min Heap
        public boolean isHeap(int[] nums) {

            // Total number of elements
            int n = nums.length;

            /*
            Traverse only NON-LEAF nodes

            Non-leaf node range:
                0 to n/2 - 1
            */
            for (int i = n / 2 - 1; i >= 0; i--) {

                // Left child index
                int leftChild = 2 * i + 1;

                // Right child index
                int rightChild = 2 * i + 2;

                /*
                Check left child

                If left child is smaller than parent,
                Min Heap property breaks.
                */
                if (leftChild < n && nums[leftChild] < nums[i]) {
                    return false;
                }

                /*
                Check right child

                If right child is smaller than parent,
                Min Heap property breaks.
                */
                if (rightChild < n && nums[rightChild] < nums[i]) {
                    return false;
                }
            }

            // All nodes satisfy Min Heap property
            return true;
        }
    }

    /*
    ================================================================================
                                    MAIN METHOD
    ================================================================================
    */

    public static void main(String[] args) {

        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {10, 20, 30, 21, 23};

        System.out.println("Example 1:");
        printArray(nums1);

        boolean ans1 = sol.isHeap(nums1);

        System.out.println("Is Min Heap: " + ans1);

        System.out.println();

        // Example 2
        int[] nums2 = {10, 20, 30, 25, 15};

        System.out.println("Example 2:");
        printArray(nums2);

        boolean ans2 = sol.isHeap(nums2);

        System.out.println("Is Min Heap: " + ans2);
    }

    /*
    Helper method to print array
    */
    public static void printArray(int[] arr) {

        System.out.print("Array: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}