package _016_Binary_Search_Trees._01_Theory_And_Basics;

public class _02_Search_In_A_BST {

    /*
    =================================================================================================
                                        SEARCH IN A BST
    =================================================================================================

    PROBLEM STATEMENT
    -------------------------------------------------------------------------------------------------

    Given the root node of a Binary Search Tree (BST) and an integer value val,
    search for the node whose value is equal to val.

    Return:
    -------------------------
    1. The subtree rooted at that node if the value exists.
    2. NULL if the value does not exist in the BST.

    =================================================================================================
                                        EXAMPLE 1
    =================================================================================================

    Input:
    -------------------------

                    4
                  /   \
                 2     7
                / \
               1   3

    val = 2

    Output:
    -------------------------

                    2
                  /   \
                 1     3

    Explanation:
    -------------------------
    Node with value 2 is found.

    Therefore, return the subtree rooted at node 2.

    =================================================================================================
                                        EXAMPLE 2
    =================================================================================================

    Input:
    -------------------------

                    4
                  /   \
                 2     7
                / \
               1   3

    val = 5

    Output:
    -------------------------

                    NULL

    Explanation:
    -------------------------
    Value 5 does not exist in BST.

    =================================================================================================
                                        PRACTICE QUESTION
    =================================================================================================

    Input:
    -------------------------

                        10
                       /  \
                      2    12
                     / \
                    1   4
                       /
                      3

    val = 2

    Output:
    -------------------------

                        2
                       / \
                      1   4
                         /
                        3

    Correct Answer:
    -------------------------

            [2, 1, 4, null, null, 3]

    =================================================================================================
                                            INTUITION
    =================================================================================================

    The main advantage of BST is its ordered structure.

    BST Property:
    -------------------------

            Left Subtree < Node < Right Subtree

    This property helps us eliminate half of the tree during searching.

    -------------------------------------------------------------------------------------------------

    CASE 1:
    -------------------------
    If current node value == target value

    Then:
    -------------------------
    We found the node.

    -------------------------------------------------------------------------------------------------

    CASE 2:
    -------------------------
    If target value > current node value

    Then:
    -------------------------
    Move to right subtree.

    Reason:
    -------------------------
    All smaller values exist on left side.

    -------------------------------------------------------------------------------------------------

    CASE 3:
    -------------------------
    If target value < current node value

    Then:
    -------------------------
    Move to left subtree.

    Reason:
    -------------------------
    All larger values exist on right side.

    =================================================================================================
                                            APPROACH
    =================================================================================================

    STEP 1:
    -------------------------
    Start traversal from root node.

    -------------------------------------------------------------------------------------------------

    STEP 2:
    -------------------------
    Continue traversal while:
    1. root != null
    2. root value != target value

    -------------------------------------------------------------------------------------------------

    STEP 3:
    -------------------------
    Compare current node value with target value.

    If:
    -------------------------
    root.data > val

    Move Left:
    -------------------------
    root = root.left

    Else:
    -------------------------
    Move Right:
    -------------------------
    root = root.right

    -------------------------------------------------------------------------------------------------

    STEP 4:
    -------------------------
    If root becomes NULL:
    -------------------------
    Value does not exist.

    Otherwise:
    -------------------------
    Return root node.

    =================================================================================================
                                            DRY RUN
    =================================================================================================

    Tree:
    -------------------------

                            4
                          /   \
                         2     7
                        / \
                       1   3

    Search Value:
    -------------------------
    val = 3

    -------------------------------------------------------------------------------------------------

    ITERATION 1:
    -------------------------

    Current Node = 4

    Compare:
    -------------------------
    3 < 4

    Move Left.

    -------------------------------------------------------------------------------------------------

    ITERATION 2:
    -------------------------

    Current Node = 2

    Compare:
    -------------------------
    3 > 2

    Move Right.

    -------------------------------------------------------------------------------------------------

    ITERATION 3:
    -------------------------

    Current Node = 3

    Compare:
    -------------------------
    3 == 3

    Node Found.

    Return node 3.

    =================================================================================================
                                            VISUAL FLOW
    =================================================================================================

                            4
                          /
                         2
                          \
                           3

    Search Path:
    -------------------------

            4 -> 2 -> 3

    =================================================================================================
                                            JAVA CODE
    =================================================================================================
    */

    // Definition for Binary Tree Node
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

        public TreeNode searchBST(TreeNode root, int val) {

            /*
            Traverse the tree until:
            1. Node becomes NULL
            OR
            2. Target value is found
            */

            while (root != null && root.data != val) {

                /*
                If current node value is greater than target,
                move to left subtree.
                */

                if (root.data > val) {
                    root = root.left;
                }

                /*
                Otherwise move to right subtree.
                */

                else {
                    root = root.right;
                }
            }

            /*
            Return:
            1. Matching node if found
            2. NULL otherwise
            */

            return root;
        }
    }

    /*
    =================================================================================================
                                            MAIN METHOD
    =================================================================================================
    */

    public static void main(String[] args) {

        /*
                        4
                      /   \
                     2     7
                    / \
                   1   3
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution sol = new Solution();

        TreeNode result = sol.searchBST(root, 2);

        /*
        If node exists, print its value.
        Otherwise print node not found.
        */

        if (result != null) {
            System.out.println("Node Found: " + result.data);
        }

        else {
            System.out.println("Node Not Found");
        }
    }

    /*
    =================================================================================================
                                        COMPLEXITY ANALYSIS
    =================================================================================================

    TIME COMPLEXITY
    -------------------------------------------------------------------------------------------------

    BEST / AVERAGE CASE:
    -------------------------
    O(log N)

    Reason:
    -------------------------
    In balanced BST,
    half of the tree gets eliminated at every step.

    Example:
    -------------------------

            N -> N/2 -> N/4 -> N/8 ...

    -------------------------------------------------------------------------------------------------

    WORST CASE:
    -------------------------
    O(N)

    Happens when:
    -------------------------
    BST becomes skewed.

    Example:
    -------------------------

            10
              \
               20
                 \
                  30
                    \
                     40

    Searching becomes similar to Linked List traversal.

    =================================================================================================
                                        SPACE COMPLEXITY
    =================================================================================================

    Space Complexity:
    -------------------------
    O(1)

    Reason:
    -------------------------
    Iterative approach is used.

    No recursion stack or extra data structure is required.

    =================================================================================================
                                            KEY POINTS
    =================================================================================================

    1. BST searching is faster because of ordering property.

    2. At every step, one subtree gets ignored.

    3. Balanced BST provides O(log N) searching.

    4. Worst case occurs in skewed BST.

    5. Iterative solution is memory efficient.

    =================================================================================================
    */

}