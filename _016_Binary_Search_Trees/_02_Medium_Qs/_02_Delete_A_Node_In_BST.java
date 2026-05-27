package _016_Binary_Search_Trees._02_Medium_Qs;

public class _02_Delete_A_Node_In_BST {

    /*
    =================================================================================================
                                    DELETE A NODE IN BST
    =================================================================================================

    PROBLEM STATEMENT
    -------------------------------------------------------------------------------------------------

    Given:
    -------------------------
    1. Root node of a Binary Search Tree (BST)
    2. A key value

    Task:
    -------------------------
    Delete the node having the given key value from the BST.

    Return:
    -------------------------
    Updated BST root after deletion.

    -------------------------------------------------------------------------------------------------

    NOTE:
    -------------------------
    Multiple correct BST structures may exist after deletion.

    =================================================================================================
                                            EXAMPLE 1
    =================================================================================================

    Input:
    -------------------------

                            5
                          /   \
                         3     6
                        / \     \
                       2   4     7

    key = 3

    -------------------------------------------------------------------------------------------------

    Output:
    -------------------------

                            5
                          /   \
                         4     6
                        /       \
                       2         7

    Explanation:
    -------------------------
    Node 3 is deleted.

    Since node 3 has two children:
    -------------------------
    1. Find inorder successor
    2. Rearrange tree properly

    =================================================================================================
                                            EXAMPLE 2
    =================================================================================================

    Input:
    -------------------------

                            5
                          /   \
                         3     6
                        / \     \
                       2   4     7

    key = 0

    -------------------------------------------------------------------------------------------------

    Output:
    -------------------------

                            5
                          /   \
                         3     6
                        / \     \
                       2   4     7

    Explanation:
    -------------------------
    Node 0 does not exist.

    BST remains unchanged.

    =================================================================================================
                                        PRACTICE QUESTION
    =================================================================================================

    Input:
    -------------------------

                            5
                          /   \
                         3     6
                        / \     \
                       2   4     7

    key = 5

    -------------------------------------------------------------------------------------------------

    Possible Outputs:
    -------------------------

            [6, 3, 7, 2, 4]

            [4, 3, 6, 2, null, null, 7]

            [3, 2, 6, null, null, 4, 7]

    Correct Answer:
    -------------------------

            All of the above

    Explanation:
    -------------------------
    Multiple valid BSTs can exist after deletion.

    =================================================================================================
                                            INTUITION
    =================================================================================================

    Deleting a node in BST is more complex than insertion.

    Why?
    -------------------------
    Because BST ordering property must remain valid.

    -------------------------------------------------------------------------------------------------

    There are 3 deletion cases.

    =================================================================================================
                                    CASE 1 : LEAF NODE
    =================================================================================================

    Node has NO children.

    Example:
    -------------------------

                            5
                           /
                          3

    Delete 3.

    Result:
    -------------------------

                            5

    Simply remove node.

    =================================================================================================
                                CASE 2 : NODE WITH ONE CHILD
    =================================================================================================

    Example:
    -------------------------

                            5
                           /
                          3
                         /
                        2

    Delete 3.

    Result:
    -------------------------

                            5
                           /
                          2

    Replace node with its child.

    =================================================================================================
                            CASE 3 : NODE WITH TWO CHILDREN
    =================================================================================================

    Example:
    -------------------------

                            5
                          /   \
                         3     6
                        / \
                       2   4

    Delete 3.

    -------------------------------------------------------------------------------------------------

    Problem:
    -------------------------
    Cannot directly remove node.

    Need replacement that maintains BST property.

    -------------------------------------------------------------------------------------------------

    Solution:
    -------------------------
    Use Inorder Successor.

    Inorder Successor:
    -------------------------
    Smallest node in right subtree.

    =================================================================================================
                                            APPROACH
    =================================================================================================

    STEP 1:
    -------------------------
    Search for node to delete.

    -------------------------------------------------------------------------------------------------

    STEP 2:
    -------------------------
    Handle 3 deletion cases.

    -------------------------------------------------------------------------------------------------

    CASE A:
    -------------------------
    No left child

    Return right child.

    -------------------------------------------------------------------------------------------------

    CASE B:
    -------------------------
    No right child

    Return left child.

    -------------------------------------------------------------------------------------------------

    CASE C:
    -------------------------
    Both children exist.

    -------------------------------------------------------------------------------------------------

    STEPS:
    -------------------------

    1. Save left subtree.

    2. Move to right subtree.

    3. Find leftmost node in right subtree.

    4. Attach left subtree there.

    5. Return right subtree.

    =================================================================================================
                                            DRY RUN
    =================================================================================================

    BST:
    -------------------------

                            5
                          /   \
                         3     6
                        / \     \
                       2   4     7

    Delete key = 3

    =================================================================================================
                                    STEP-BY-STEP EXECUTION
    =================================================================================================

    Current Node = 5

    Compare:
    -------------------------
    3 < 5

    Move LEFT.

    -------------------------------------------------------------------------------------------------

    Current Node = 3

    Node Found.

    -------------------------------------------------------------------------------------------------

    Node 3 has:
    -------------------------
    LEFT child = 2
    RIGHT child = 4

    Therefore:
    -------------------------
    Case 3 (Two Children)

    -------------------------------------------------------------------------------------------------

    Find leftmost node in right subtree.

    Right subtree:
    -------------------------

                            4

    Leftmost node = 4

    -------------------------------------------------------------------------------------------------

    Attach left subtree (2) to left of 4.

    Final Tree:
    -------------------------

                            5
                          /   \
                         4     6
                        /       \
                       2         7

    =================================================================================================
                                            VISUAL FLOW
    =================================================================================================

    Delete:
    -------------------------
            3

    Right Subtree:
    -------------------------
            4

    Attach:
    -------------------------
            2 -> left of 4

    =================================================================================================
                                            JAVA CODE
    =================================================================================================
    */

    // Definition for BST Node
    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {

            data = val;
            left = null;
            right = null;
        }
    }

    static class Solution {

        /*
        =============================================================================================
                                    CONNECTOR FUNCTION
        =============================================================================================

        This function reconnects subtrees after deletion.
        */

        private TreeNode connector(TreeNode root) {

            /*
            CASE 1:
            No left child.

            Return right subtree.
            */

            if (root.left == null) {
                return root.right;
            }

            /*
            CASE 2:
            No right child.

            Return left subtree.
            */

            if (root.right == null) {
                return root.left;
            }

            /*
            CASE 3:
            Node has both children.
            */

            TreeNode leftChild = root.left;

            TreeNode leftmostChildInRightSubtree = root.right;

            /*
            Find leftmost node in right subtree.
            */

            while (leftmostChildInRightSubtree.left != null) {

                leftmostChildInRightSubtree =
                        leftmostChildInRightSubtree.left;
            }

            /*
            Attach left subtree to leftmost node.
            */

            leftmostChildInRightSubtree.left = leftChild;

            /*
            Return right subtree as new subtree root.
            */

            return root.right;
        }

        /*
        =============================================================================================
                                        DELETE FUNCTION
        =============================================================================================
        */

        public TreeNode deleteNode(TreeNode root, int key) {

            /*
            Empty tree.
            */

            if (root == null) {
                return null;
            }

            /*
            If root itself is target node.
            */

            if (root.data == key) {

                return connector(root);
            }

            /*
            Start traversal.
            */

            TreeNode node = root;

            while (node != null) {

                /*
                Move LEFT.
                */

                if (node.data > key) {

                    /*
                    Target found in left child.
                    */

                    if (node.left != null &&
                            node.left.data == key) {

                        node.left = connector(node.left);

                        break;
                    }

                    else {
                        node = node.left;
                    }
                }

                /*
                Move RIGHT.
                */

                else {

                    /*
                    Target found in right child.
                    */

                    if (node.right != null &&
                            node.right.data == key) {

                        node.right = connector(node.right);

                        break;
                    }

                    else {
                        node = node.right;
                    }
                }
            }

            /*
            Return updated BST.
            */

            return root;
        }
    }

    /*
    =================================================================================================
                                    INORDER TRAVERSAL
    =================================================================================================

    Used to verify BST.

    Inorder traversal of BST:
    -------------------------
    Always produces sorted order.
    */

    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    /*
    =================================================================================================
                                            MAIN METHOD
    =================================================================================================
    */

    public static void main(String[] args) {

        /*
                                5
                              /   \
                             3     6
                            / \     \
                           2   4     7
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        Solution sol = new Solution();

        int key = 3;

        /*
        Delete node.
        */

        root = sol.deleteNode(root, key);

        /*
        Print inorder traversal.
        */

        System.out.println("BST After Deletion:");

        inorder(root);
    }

    /*
    =================================================================================================
                                        COMPLEXITY ANALYSIS
    =================================================================================================

    TIME COMPLEXITY
    -------------------------------------------------------------------------------------------------

    Time Complexity:
    -------------------------
    O(H)

    where:
    -------------------------
    H = Height of BST

    -------------------------------------------------------------------------------------------------

    Reason:
    -------------------------
    We traverse tree only along one path.

    -------------------------------------------------------------------------------------------------

    BALANCED BST:
    -------------------------
    Height = log N

    Therefore:
    -------------------------
    O(log N)

    -------------------------------------------------------------------------------------------------

    WORST CASE:
    -------------------------
    Skewed BST

    Example:
    -------------------------

                10
                  \
                   20
                     \
                      30
                        \
                         40

    Height becomes:
    -------------------------
    O(N)

    =================================================================================================
                                        SPACE COMPLEXITY
    =================================================================================================

    Space Complexity:
    -------------------------
    O(1)

    Reason:
    -------------------------
    No recursion stack used.

    Only constant extra variables used.

    =================================================================================================
                                            KEY POINTS
    =================================================================================================

    1. BST deletion has 3 cases.

    2. Leaf node:
       Simply remove.

    3. One child:
       Replace node with child.

    4. Two children:
       Use inorder successor.

    5. BST property must remain preserved.

    6. Inorder traversal after deletion remains sorted.

    =================================================================================================
    */

}