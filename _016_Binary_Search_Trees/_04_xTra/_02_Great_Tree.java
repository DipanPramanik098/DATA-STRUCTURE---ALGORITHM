package _016_Binary_Search_Trees._04_xTra;

public class _02_Great_Tree {

    /*
    =========================================================
                    Binary Tree Node Definition
    =========================================================

    Each node contains:
    1. data  -> value stored in node
    2. left  -> reference to left child
    3. right -> reference to right child

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
                        GLOBAL SUM VARIABLE
        =========================================================

        This variable stores cumulative sum of
        previously visited GREATER nodes.

        Since we traverse:
        Right -> Root -> Left

        We always visit larger nodes first.

        =========================================================
        */

        int sum = 0;

        /*
        =========================================================
                        GREAT TREE PROBLEM
        =========================================================

        Problem:
        --------
        Convert BST into Great Tree such that:

        Every node value becomes:

        node.data +
        sum of all nodes greater than it

        ---------------------------------------------------------

        Example:

                    5
                   / \
                  1   7
                     / \
                    6   10

        ---------------------------------------------------------

        New Values:
        ------------

        Node 10:
        ----------
        No greater node exists

        New value = 10

        ---------------------------------------------------------

        Node 7:
        --------
        Greater nodes = 10

        New value = 7 + 10 = 17

        ---------------------------------------------------------

        Node 6:
        --------
        Greater nodes = 7, 10

        New value = 6 + 7 + 10 = 23

        ---------------------------------------------------------

        Node 5:
        --------
        Greater nodes = 6, 7, 10

        New value = 5 + 6 + 7 + 10 = 28

        ---------------------------------------------------------

        Node 1:
        --------
        Greater nodes = 5, 6, 7, 10

        New value = 1 + 5 + 6 + 7 + 10 = 29

        =========================================================
                        INTUITION
        =========================================================

        In BST:
        -------
        Larger values exist on RIGHT side.

        So if we traverse BST in:

        Right -> Root -> Left

        Then we visit nodes in DESCENDING order.

        ---------------------------------------------------------

        While traversing:

        1. Keep running sum of visited nodes
        2. Add current node value to sum
        3. Replace node value with updated sum

        This automatically converts BST into Great Tree.

        =========================================================
                        WHY REVERSE INORDER?
        =========================================================

        Normal Inorder:
        ----------------
        Left -> Root -> Right

        Gives ascending order.

        ---------------------------------------------------------

        Reverse Inorder:
        -----------------
        Right -> Root -> Left

        Gives descending order.

        Example:
        ---------

                    5
                   / \
                  2   8

        Reverse inorder:
        ----------------
        8 -> 5 -> 2

        So larger values are processed first.

        =========================================================
                        DRY RUN
        =========================================================

                    5
                   / \
                  1   7
                     / \
                    6   10

        ---------------------------------------------------------

        Initial sum = 0

        ---------------------------------------------------------

        STEP 1:
        --------
        Move to RIGHTMOST node = 10

        sum = sum + 10
            = 0 + 10
            = 10

        node.data = 10

        ---------------------------------------------------------

        STEP 2:
        --------
        Move to node = 7

        sum = 10 + 7
            = 17

        node.data = 17

        ---------------------------------------------------------

        STEP 3:
        --------
        Move to node = 6

        sum = 17 + 6
            = 23

        node.data = 23

        ---------------------------------------------------------

        STEP 4:
        --------
        Move to node = 5

        sum = 23 + 5
            = 28

        node.data = 28

        ---------------------------------------------------------

        STEP 5:
        --------
        Move to node = 1

        sum = 28 + 1
            = 29

        node.data = 29

        ---------------------------------------------------------

        FINAL TREE:
        ------------

                    28
                   /  \
                 29    17
                       / \
                     23   10

        =========================================================
        */

        public TreeNode bstToGt(TreeNode root) {

            /*
            =====================================================
                            BASE CASE
            =====================================================

            If node becomes null,
            simply return null.

            =====================================================
            */
            if (root == null) {
                return null;
            }

            /*
            =====================================================
                    STEP 1:
                    Traverse RIGHT subtree first
            =====================================================

            Because larger elements exist on right side.

            =====================================================
            */
            bstToGt(root.right);

            /*
            =====================================================
                    STEP 2:
                    Update running sum
            =====================================================

            Current node should become:

            current value +
            sum of all greater values

            =====================================================
            */
            sum += root.data;

            /*
            =====================================================
                    STEP 3:
                    Replace current node value
            =====================================================
            */
            root.data = sum;

            /*
            =====================================================
                    STEP 4:
                    Traverse LEFT subtree
            =====================================================

            Left subtree contains smaller values.

            =====================================================
            */
            bstToGt(root.left);

            /*
            =====================================================
                    STEP 5:
                    Return modified root
            =====================================================
            */
            return root;
        }
    }

    /*
    =========================================================
                    INORDER PRINT FUNCTION
    =========================================================

    Used to display tree values.

    =========================================================
    */

    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
        =========================================================
                        ORIGINAL BST
        =========================================================

                    5
                   / \
                  1   7
                     / \
                    6   10

        =========================================================
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);

        root.right = new TreeNode(7);

        root.right.left = new TreeNode(6);

        root.right.right = new TreeNode(10);

        /*
        =========================================================
                    BEFORE CONVERSION
        =========================================================
        */

        System.out.println("Original BST (Inorder): ");
        inorder(root);

        System.out.println();

        /*
        =========================================================
                    CONVERT TO GREAT TREE
        =========================================================
        */

        Solution obj = new Solution();

        obj.bstToGt(root);

        /*
        =========================================================
                    AFTER CONVERSION
        =========================================================
        */

        System.out.println("Great Tree (Inorder): ");
        inorder(root);
    }
}

/*
=============================================================
                    COMPLEXITY ANALYSIS
=============================================================

TIME COMPLEXITY:
----------------
O(N)

Reason:
--------
Each node is visited exactly once.

-------------------------------------------------------------

SPACE COMPLEXITY:
-----------------
O(H)

Where:
--------
H = Height of BST

Reason:
--------
Recursive call stack space.

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