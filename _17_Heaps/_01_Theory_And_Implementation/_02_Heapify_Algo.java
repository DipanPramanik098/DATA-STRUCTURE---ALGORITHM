package _17_Heaps._01_Theory_And_Implementation;

public class _02_Heapify_Algo {

    /*
    =================================================================================================
                                        HEAPIFY ALGORITHM
    =================================================================================================

    PROBLEM STATEMENT
    ================================================================================================

    Given:
        1. A MIN-HEAP array
        2. An index ind
        3. A new value val

    Task:
        Replace nums[ind] with val
        and restore the MIN-HEAP PROPERTY using HEAPIFY.

    ------------------------------------------------------------------------------------------------
    EXAMPLE 1
    ------------------------------------------------------------------------------------------------

    Input:
        nums = [1, 4, 5, 5, 7, 6]
        ind  = 5
        val  = 2

    Step 1:
        Replace index 5 value with 2

        [1, 4, 5, 5, 7, 2]

    Step 2:
        Compare with parent

        Parent index:
            (5 - 1)/2 = 2

        Parent value:
            nums[2] = 5

        Since:
            2 < 5

        Swap them.

    Final Heap:
        [1, 4, 2, 5, 7, 5]


    ------------------------------------------------------------------------------------------------
    EXAMPLE 2
    ------------------------------------------------------------------------------------------------

    Input:
        nums = [2, 4, 3, 6, 5, 7, 8, 7]
        ind  = 0
        val  = 7

    Step 1:
        Replace root with 7

        [7, 4, 3, 6, 5, 7, 8, 7]

    Step 2:
        Compare with children

        Left Child  = 4
        Right Child = 3

        Smallest child = 3

        Swap 7 and 3

    Final Heap:
        [3, 4, 7, 6, 5, 7, 8, 7]


    =================================================================================================
                                            INTUITION
    =================================================================================================

    When a value is updated inside a MIN-HEAP,
    the heap property may get violated.

    There are TWO possible cases:

    ------------------------------------------------------------------------------------------------
    CASE 1:
    NEW VALUE IS SMALLER THAN OLD VALUE
    ------------------------------------------------------------------------------------------------

    Example:

        Old value = 10
        New value = 2

    Since:
        Smaller values belong near the ROOT in MIN-HEAP.

    So:
        The element should move UPWARD.

    This process is called:

            HEAPIFY UP
                    or
            BUBBLE UP


    ------------------------------------------------------------------------------------------------
    CASE 2:
    NEW VALUE IS GREATER THAN OLD VALUE
    ------------------------------------------------------------------------------------------------

    Example:

        Old value = 3
        New value = 20

    Since:
        Larger values belong LOWER in MIN-HEAP.

    So:
        The element should move DOWNWARD.

    This process is called:

            HEAPIFY DOWN
                    or
            BUBBLE DOWN


    =================================================================================================
                                        HEAPIFY-UP
    =================================================================================================

    DEFINITION
    ================================================================================================

    Heapify-Up moves a node upward until the MIN-HEAP property becomes valid.

    ------------------------------------------------------------------------------------------------
    WHEN USED?
    ------------------------------------------------------------------------------------------------

    Used when:
        Updated value is SMALLER than old value.

    ------------------------------------------------------------------------------------------------
    PROCESS
    ------------------------------------------------------------------------------------------------

    1. Compare current node with parent.
    2. If current node is smaller:
            swap them.
    3. Move upward.
    4. Continue until:
            heap property restored.


    ------------------------------------------------------------------------------------------------
    EXAMPLE
    ------------------------------------------------------------------------------------------------

    Heap:

                1
              /   \
             4     5
            / \   /
           5   7  6

    Array:
            [1, 4, 5, 5, 7, 6]

    Update:
            index 5 = 2

    New array:
            [1, 4, 5, 5, 7, 2]

    Tree:

                1
              /   \
             4     5
            / \   /
           5   7  2

    Parent of 2:
            index = (5-1)/2 = 2

    Parent value = 5

    Since:
            2 < 5

    Swap:

                1
              /   \
             4     2
            / \   /
           5   7  5

    Final Array:
            [1, 4, 2, 5, 7, 5]


    =================================================================================================
                                        HEAPIFY-DOWN
    =================================================================================================

    DEFINITION
    ================================================================================================

    Heapify-Down moves a node downward until the MIN-HEAP property becomes valid.

    ------------------------------------------------------------------------------------------------
    WHEN USED?
    ------------------------------------------------------------------------------------------------

    Used when:
        Updated value is GREATER than old value.

    ------------------------------------------------------------------------------------------------
    PROCESS
    ------------------------------------------------------------------------------------------------

    1. Compare current node with children.
    2. Find smallest child.
    3. If child is smaller:
            swap.
    4. Continue downward.


    ------------------------------------------------------------------------------------------------
    EXAMPLE
    ------------------------------------------------------------------------------------------------

    Initial Heap:

                2
              /   \
             4     3
            / \   / \
           6  5  7   8

    Array:
            [2,4,3,6,5,7,8]

    Update:
            index 0 = 7

    New Array:
            [7,4,3,6,5,7,8]

    Compare children:
            4 and 3

    Smallest = 3

    Swap:

                3
              /   \
             4     7
            / \   / \
           6  5  7   8

    Final Array:
            [3,4,7,6,5,7,8]


    =================================================================================================
                                        APPROACH
    =================================================================================================

    STEP 1:
    --------------------------------------------------------------------------------

    Replace nums[ind] with val.


    STEP 2:
    --------------------------------------------------------------------------------

    Check:

        Is val smaller than original value?

    If YES:
            Perform HEAPIFY-UP.

    Else:
            Perform HEAPIFY-DOWN.


    STEP 3:
    --------------------------------------------------------------------------------

    HEAPIFY-UP:
        Compare with parent.
        Swap if parent > current.


    STEP 4:
    --------------------------------------------------------------------------------

    HEAPIFY-DOWN:
        Compare with children.
        Swap with smallest child.


    STEP 5:
    --------------------------------------------------------------------------------

    Continue until:
        MIN-HEAP PROPERTY restored.


    =================================================================================================
                                            DRY RUN
    =================================================================================================

    INPUT:
    --------------------------------------------------------------------------------

        nums = [1,4,5,5,7,6]
        ind  = 5
        val  = 2


    STEP 1:
    --------------------------------------------------------------------------------

        Replace value.

        nums = [1,4,5,5,7,2]


    STEP 2:
    --------------------------------------------------------------------------------

        Parent Index:
                (5-1)/2 = 2

        Parent Value:
                nums[2] = 5

        Current Value:
                nums[5] = 2


    STEP 3:
    --------------------------------------------------------------------------------

        Since:
                2 < 5

        Swap.


    STEP 4:
    --------------------------------------------------------------------------------

        nums = [1,4,2,5,7,5]


    STEP 5:
    --------------------------------------------------------------------------------

        New parent index:
                (2-1)/2 = 0

        nums[0] = 1

        Since:
                1 < 2

        Stop.


    FINAL ANSWER:
    --------------------------------------------------------------------------------

        [1,4,2,5,7,5]


    =================================================================================================
                                            CODE
    =================================================================================================
    */

    static class Solution {

        /*
        =============================================================================================
                                        HEAPIFY DOWN
        =============================================================================================

        PURPOSE:
            Moves a node downward to restore MIN-HEAP property.

        USED WHEN:
            Updated value becomes GREATER.

        TIME COMPLEXITY:
            O(log N)
        */
        private void heapifyDown(int[] arr, int ind) {

            // Total number of elements
            int n = arr.length;

            // Assume current index is smallest
            int smallestIndex = ind;

            // Left child index
            int leftChildIndex = 2 * ind + 1;

            // Right child index
            int rightChildIndex = 2 * ind + 2;


            /*
            -----------------------------------------------------------------------------------------
            CHECK LEFT CHILD
            -----------------------------------------------------------------------------------------
            */

            // Check:
            // 1. Left child exists
            // 2. Left child is smaller
            if (leftChildIndex < n &&
                    arr[leftChildIndex] < arr[smallestIndex]) {

                smallestIndex = leftChildIndex;
            }


            /*
            -----------------------------------------------------------------------------------------
            CHECK RIGHT CHILD
            -----------------------------------------------------------------------------------------
            */

            // Check:
            // 1. Right child exists
            // 2. Right child is smaller
            if (rightChildIndex < n &&
                    arr[rightChildIndex] < arr[smallestIndex]) {

                smallestIndex = rightChildIndex;
            }


            /*
            -----------------------------------------------------------------------------------------
            IF SMALLER CHILD FOUND
            -----------------------------------------------------------------------------------------
            */

            if (smallestIndex != ind) {

                // Swap current node with smallest child
                int temp = arr[ind];
                arr[ind] = arr[smallestIndex];
                arr[smallestIndex] = temp;

                // Continue heapifying downward
                heapifyDown(arr, smallestIndex);
            }
        }


        /*
        =============================================================================================
                                        HEAPIFY UP
        =============================================================================================

        PURPOSE:
            Moves a node upward to restore MIN-HEAP property.

        USED WHEN:
            Updated value becomes SMALLER.

        TIME COMPLEXITY:
            O(log N)
        */
        private void heapifyUp(int[] arr, int ind) {

            // Parent index
            int parentIndex = (ind - 1) / 2;

            /*
            -----------------------------------------------------------------------------------------
            CHECK IF CURRENT NODE IS SMALLER THAN PARENT
            -----------------------------------------------------------------------------------------
            */

            if (ind > 0 && arr[ind] < arr[parentIndex]) {

                // Swap current node with parent
                int temp = arr[ind];
                arr[ind] = arr[parentIndex];
                arr[parentIndex] = temp;

                // Continue heapifying upward
                heapifyUp(arr, parentIndex);
            }
        }


        /*
        =============================================================================================
                                        MAIN HEAPIFY FUNCTION
        =============================================================================================

        PARAMETERS:
            nums -> Min Heap Array
            ind  -> Index to update
            val  -> New value

        WORK:
            Updates the value and restores heap property.
        */
        public void heapify(int[] nums, int ind, int val) {

            // Store old value
            int oldValue = nums[ind];


            /*
            -----------------------------------------------------------------------------------------
            CASE 1:
            NEW VALUE IS SMALLER
            -----------------------------------------------------------------------------------------
            */

            if (val < oldValue) {

                // Update value
                nums[ind] = val;

                // Move upward
                heapifyUp(nums, ind);
            }


            /*
            -----------------------------------------------------------------------------------------
            CASE 2:
            NEW VALUE IS GREATER OR EQUAL
            -----------------------------------------------------------------------------------------
            */

            else {

                // Update value
                nums[ind] = val;

                // Move downward
                heapifyDown(nums, ind);
            }
        }
    }


    /*
    =================================================================================================
                                            MAIN METHOD
    =================================================================================================
    */
    public static void main(String[] args) {

        // Min Heap Array
        int[] nums = {1, 4, 5, 5, 7, 6};

        // Index to update
        int ind = 5;

        // New value
        int val = 2;

        // Create Solution Object
        Solution sol = new Solution();


        /*
        ---------------------------------------------------------------------------------------------
        PRINT ORIGINAL ARRAY
        ---------------------------------------------------------------------------------------------
        */
        System.out.print("Original Heap : ");

        for (int num : nums) {
            System.out.print(num + " ");
        }


        /*
        ---------------------------------------------------------------------------------------------
        CALL HEAPIFY
        ---------------------------------------------------------------------------------------------
        */
        sol.heapify(nums, ind, val);


        /*
        ---------------------------------------------------------------------------------------------
        PRINT FINAL HEAP
        ---------------------------------------------------------------------------------------------
        */
        System.out.print("\nHeap After Heapify : ");

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


    /*
    =================================================================================================
                                    COMPLEXITY ANALYSIS
    =================================================================================================

    TIME COMPLEXITY
    ================================================================================================

    Heapify-Up:
            O(log N)

    Heapify-Down:
            O(log N)

    Because:
        In worst case,
        element travels from root to leaf
        or leaf to root.

        Height of Heap = log N


    ------------------------------------------------------------------------------------------------
    SPACE COMPLEXITY
    ------------------------------------------------------------------------------------------------

    Recursive Stack Space:
            O(log N)

    No extra data structure used.

    Array modified IN-PLACE.


    =================================================================================================
                                                END
    =================================================================================================
    */
}