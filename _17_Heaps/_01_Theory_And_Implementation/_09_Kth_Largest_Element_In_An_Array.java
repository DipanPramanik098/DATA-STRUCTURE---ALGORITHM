package _17_Heaps._01_Theory_And_Implementation;

import java.util.Random;

/*
===============================================================================
                    K-th LARGEST ELEMENT IN AN ARRAY
===============================================================================

PROBLEM:
---------
Given an integer array nums and an integer k,
return the K-th largest element in the array.

-------------------------------------------------------------------------------
EXAMPLE 1:
-------------------------------------------------------------------------------

Input:
nums = [1, 2, 3, 4, 5]
k = 2

Sorted in descending order:
[5, 4, 3, 2, 1]

2nd largest = 4

Output:
4

-------------------------------------------------------------------------------
EXAMPLE 2:
-------------------------------------------------------------------------------

Input:
nums = [-5, 4, 1, 2, -3]
k = 5

Descending order:
[4, 2, 1, -3, -5]

5th largest = -5

Output:
-5

===============================================================================
INTUITION:
===============================================================================

A brute-force approach would be:

1. Sort the array
2. Return nums[n-k]

But sorting takes:
O(N logN)

Can we do better?

YES.

We can use:
QUICK SELECT ALGORITHM

-------------------------------------------------------------------------------
IMPORTANT IDEA:
-------------------------------------------------------------------------------

Quick Select is based on:
QUICK SORT PARTITION LOGIC

In Quick Sort:
---------------
After partitioning:

LEFT SIDE  -> Larger elements
PIVOT      -> Correct position
RIGHT SIDE -> Smaller elements

If pivot lands at index:
k - 1

Then:
Pivot itself is the K-th largest element.

===============================================================================
QUICK SELECT CONCEPT:
===============================================================================

Suppose:

nums = [11, 9, 8, 7, 3, 1]
k = 4

Descending order:
[11, 9, 8, 7, 3, 1]

4th largest = 7

-------------------------------------------------------------------------------
PARTITION IDEA:
-------------------------------------------------------------------------------

Choose pivot.

Move:
- Bigger elements to LEFT
- Smaller elements to RIGHT

After partition:
pivot reaches its correct position.

If:
pivotIndex == k-1
→ Found answer

Else:
Search only one side.

This reduces search space efficiently.

===============================================================================
WHY RANDOM PIVOT?
===============================================================================

If we always choose:
- first element
OR
- last element

Then sorted arrays may produce:
O(N²)

Random pivot helps avoid worst-case frequently.

Average complexity becomes:
O(N)

===============================================================================
DRY RUN:
===============================================================================

nums = [11, 9, 8, 7, 3, 1]
k = 4

Need:
4th largest

-------------------------------------------------------------------------------
STEP 1:
-------------------------------------------------------------------------------

Choose random pivot = 8

Partition:

[11, 9 | 8 | 7, 3, 1]

Pivot index = 2

We need index:
k - 1 = 3

Since:
2 < 3

Search RIGHT SIDE

-------------------------------------------------------------------------------
STEP 2:
-------------------------------------------------------------------------------

Search:
[7, 3, 1]

Choose pivot = 7

Partition:
[11, 9, 8 | 7 | 3, 1]

Pivot index = 3

Now:
pivotIndex == k - 1

Answer = 7

===============================================================================
PARTITION LOGIC:
===============================================================================

Goal:
------
Place pivot at correct index.

Rules:
------
1. Elements GREATER than pivot go LEFT
2. Elements SMALLER go RIGHT

After partition:
Pivot becomes correctly placed.

===============================================================================
TIME COMPLEXITY:
===============================================================================

AVERAGE CASE:
--------------
O(N)

Because search space reduces significantly after each partition.

Mathematically:

N + N/2 + N/4 + ...

= 2N
= O(N)

-------------------------------------------------------------------------------
WORST CASE:
-------------------------------------------------------------------------------

O(N²)

Occurs when pivot becomes smallest/largest repeatedly.

Random pivot minimizes this possibility.

===============================================================================
SPACE COMPLEXITY:
===============================================================================

O(1)

Because:
- In-place partitioning
- No extra array used

===============================================================================
ADVANTAGES:
===============================================================================

1. Faster than sorting for K-th element
2. Average O(N)
3. In-place algorithm
4. Very efficient for large arrays

===============================================================================
DISADVANTAGES:
===============================================================================

1. Worst case O(N²)
2. Array gets modified
3. Not stable

===============================================================================
CODE:
===============================================================================
*/

public class _09_Kth_Largest_Element_In_An_Array {

    /*
    ===========================================================================
    RANDOM OBJECT
    ===========================================================================

    Used for choosing random pivot index.
    */
    private Random rand = new Random();

    /*
    ===========================================================================
    RANDOM INDEX FUNCTION
    ===========================================================================

    PURPOSE:
    --------
    Returns random index between left and right.

    WHY?
    ----
    Random pivot reduces chance of worst-case complexity.
    ===========================================================================
    */
    private int randomIndex(int left, int right) {

        // Length of current subarray
        int len = right - left + 1;

        // Random index
        return rand.nextInt(len) + left;
    }

    /*
    ===========================================================================
    PARTITION FUNCTION
    ===========================================================================

    PURPOSE:
    --------
    Places pivot element at its correct position.

    RULE:
    -----
    Elements GREATER than pivot go LEFT.

    RETURNS:
    --------
    Final index of pivot.

    ===========================================================================
    */
    private int partitionAndReturnIndex(int[] nums,
                                        int pivotIndex,
                                        int left,
                                        int right) {

        // Store pivot value
        int pivot = nums[pivotIndex];

        /*
        -----------------------------------------------------------------------
        Move pivot to beginning
        -----------------------------------------------------------------------
        */
        int temp = nums[left];
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        /*
        -----------------------------------------------------------------------
        Index for larger elements section
        -----------------------------------------------------------------------
        */
        int ind = left + 1;

        /*
        -----------------------------------------------------------------------
        Traverse remaining array
        -----------------------------------------------------------------------
        */
        for (int i = left + 1; i <= right; i++) {

            /*
            -------------------------------------------------------------------
            If current element is GREATER than pivot
            -------------------------------------------------------------------
            */
            if (nums[i] > pivot) {

                // Swap into left section
                temp = nums[ind];
                nums[ind] = nums[i];
                nums[i] = temp;

                // Expand left section
                ind++;
            }
        }

        /*
        -----------------------------------------------------------------------
        Place pivot at correct index
        -----------------------------------------------------------------------
        */
        temp = nums[left];
        nums[left] = nums[ind - 1];
        nums[ind - 1] = temp;

        /*
        -----------------------------------------------------------------------
        Return pivot final index
        -----------------------------------------------------------------------
        */
        return ind - 1;
    }

    /*
    ===========================================================================
    MAIN FUNCTION
    ===========================================================================

    PURPOSE:
    --------
    Finds K-th largest element using Quick Select.

    ===========================================================================
    */
    public int kthLargestElement(int[] nums, int k) {

        /*
        -----------------------------------------------------------------------
        Invalid case
        -----------------------------------------------------------------------
        */
        if (k > nums.length) {
            return -1;
        }

        /*
        -----------------------------------------------------------------------
        Search boundaries
        -----------------------------------------------------------------------
        */
        int left = 0;
        int right = nums.length - 1;

        /*
        -----------------------------------------------------------------------
        Continue until answer found
        -----------------------------------------------------------------------
        */
        while (true) {

            /*
            -------------------------------------------------------------------
            STEP 1:
            Choose random pivot
            -------------------------------------------------------------------
            */
            int pivotIndex = randomIndex(left, right);

            /*
            -------------------------------------------------------------------
            STEP 2:
            Partition array
            -------------------------------------------------------------------
            */
            pivotIndex = partitionAndReturnIndex(
                    nums,
                    pivotIndex,
                    left,
                    right
            );

            /*
            -------------------------------------------------------------------
            STEP 3:
            Check pivot position
            -------------------------------------------------------------------
            */

            // Found K-th largest
            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            }

            /*
            -------------------------------------------------------------------
            Search LEFT side
            -------------------------------------------------------------------
            */
            else if (pivotIndex > k - 1) {
                right = pivotIndex - 1;
            }

            /*
            -------------------------------------------------------------------
            Search RIGHT side
            -------------------------------------------------------------------
            */
            else {
                left = pivotIndex + 1;
            }
        }
    }

    /*
    ===========================================================================
    MAIN METHOD
    ===========================================================================
    */
    public static void main(String[] args) {

        int[] nums = {11, 9, 8, 7, 3, 1};

        int k = 4;

        System.out.print("Array: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\nK = " + k);

        // Create object
        _09_Kth_Largest_Element_In_An_Array obj =
                new _09_Kth_Largest_Element_In_An_Array();

        // Find answer
        int ans = obj.kthLargestElement(nums, k);

        System.out.println("\nK-th Largest Element = " + ans);
    }
}