package _016_Binary_Search_Trees._04_xTra;

public class _01_Range_Sum_IN_BST {

    /*
    =========================================================
                    Binary Tree Node Definition
    =========================================================

    Each node contains:
    1. data  -> value stored in node
    2. left  -> left child reference
    3. right -> right child reference

    BST Property:
    ----------------
    left subtree values  < root.data
    right subtree values > root.data
    =========================================================
    */
    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Solution {

        /*
        =========================================================
                        RANGE SUM IN BST
        =========================================================

        Problem:
        --------
        Given:
        1. Root of a BST
        2. low value
        3. high value

        Return:
        --------
        Sum of all node values lying in range [low, high]

        ---------------------------------------------------------

        Example:
        --------

                    5
                   / \
                  2   7
                 /   / \
                1   3   10

            low = 3
            high = 7

        Nodes inside range:
        -------------------
        3, 5, 7

        Sum:
        ----
        3 + 5 + 7 = 15

        =========================================================
                        INTUITION
        =========================================================

        Since it is a BST:

        1. Left subtree contains smaller values
        2. Right subtree contains larger values

        So we can OPTIMIZE traversal.

        ---------------------------------------------------------

        CASE 1:
        --------
        root.data < low

        Example:
        root = 2
        low  = 5

        Since all left subtree values are even smaller,
        they can NEVER be inside the range.

        So skip LEFT subtree completely.

        Move only RIGHT.

        ---------------------------------------------------------

        CASE 2:
        --------
        root.data > high

        Example:
        root = 15
        high = 10

        Since all right subtree values are even larger,
        they can NEVER be inside range.

        So skip RIGHT subtree completely.

        Move only LEFT.

        ---------------------------------------------------------

        CASE 3:
        --------
        root.data lies within range

        Include current node value.

        Then search BOTH subtrees.

        =========================================================
                        DRY RUN
        =========================================================

                        5
                       / \
                      2   7
                     /   / \
                    1   3   10

                low = 3
                high = 7

        ---------------------------------------------------------

        STEP 1:
        --------
        Current Node = 5

        5 lies inside range [3,7]

        Sum =
        5 + left subtree + right subtree

        ---------------------------------------------------------

        STEP 2:
        --------
        Move left to node = 2

        2 < low

        So skip LEFT subtree completely.

        Move only RIGHT.

        Right child = null

        Returns 0

        ---------------------------------------------------------

        STEP 3:
        --------
        Move right to node = 7

        7 lies inside range

        Sum =
        7 + left subtree + right subtree

        ---------------------------------------------------------

        STEP 4:
        --------
        Left child = 3

        3 lies inside range

        Return 3

        ---------------------------------------------------------

        STEP 5:
        --------
        Right child = 10

        10 > high

        Skip RIGHT subtree

        Move LEFT -> null

        Return 0

        ---------------------------------------------------------

        FINAL ANSWER:
        --------------
        5 + 0 + (7 + 3 + 0)

        = 15

        =========================================================
        */

        public int rangeSumBST(TreeNode root, int low, int high) {

            /*
            =====================================================
                            BASE CASE
            =====================================================

            If current node becomes null,
            there is nothing to add.

            Return 0.
            =====================================================
            */
            if (root == null) {
                return 0;
            }

            /*
            =====================================================
                CASE 1:
                Current node value is SMALLER than LOW
            =====================================================

            Example:
            root.data = 2
            low = 5

            Since BST property says:
            left subtree values < root.data

            Then all left subtree values are also < low.

            So NO NEED to explore left subtree.

            Move only RIGHT.
            =====================================================
            */
            if (root.data < low) {
                return rangeSumBST(root.right, low, high);
            }

            /*
            =====================================================
                CASE 2:
                Current node value is GREATER than HIGH
            =====================================================

            Example:
            root.data = 15
            high = 10

            Since BST property says:
            right subtree values > root.data

            Then all right subtree values are also > high.

            So NO NEED to explore right subtree.

            Move only LEFT.
            =====================================================
            */
            if (root.data > high) {
                return rangeSumBST(root.left, low, high);
            }

            /*
            =====================================================
                CASE 3:
                Current node lies INSIDE RANGE
            =====================================================

            Include:
            1. Current node value
            2. Left subtree sum
            3. Right subtree sum

            =====================================================
            */
            return root.data
                    + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
    }

    public static void main(String[] args) {

        /*
        =========================================================
                        CREATING BST
        =========================================================

                        5
                       / \
                      2   7
                     /   / \
                    1   3   10

        =========================================================
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(10);

        int low = 3;
        int high = 7;

        Solution obj = new Solution();

        int ans = obj.rangeSumBST(root, low, high);

        /*
        =========================================================
                            OUTPUT
        =========================================================
        */
        System.out.println("Range Sum = " + ans);
    }
}

/*
=============================================================
                    COMPLEXITY ANALYSIS
=============================================================

TIME COMPLEXITY:
----------------
Worst Case:
O(N)

Reason:
--------
In worst case we may visit every node once.

But due to BST optimization,
many unnecessary subtrees are skipped.

-------------------------------------------------------------

SPACE COMPLEXITY:
-----------------
O(H)

Where:
--------
H = Height of BST

Reason:
--------
Recursive function call stack.

-------------------------------------------------------------

Balanced BST:
--------------
Height = log N

Space Complexity = O(log N)

-------------------------------------------------------------

Skewed BST:
------------
Height = N

Space Complexity = O(N)

=============================================================
*/