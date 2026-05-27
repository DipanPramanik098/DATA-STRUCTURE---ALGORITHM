package _016_Binary_Search_Trees._03_FAQs;

public class _04_Largest_BST_in_a_BT {

    /*
    =================================================================================================
                                    LARGEST BST IN A BINARY TREE
    =================================================================================================

    PROBLEM STATEMENT
    -------------------------------------------------------------------------------------------------

    Given a Binary Tree, find the size of the largest subtree that is also a
    Binary Search Tree (BST).

    Return the number of nodes present in the largest BST.

    -------------------------------------------------------------------------------------------------
    WHAT IS A BST?
    -------------------------------------------------------------------------------------------------

    A Binary Search Tree follows:

        Left Subtree  < Root
        Right Subtree > Root

    AND

        Both left and right subtrees must also be BSTs.


    =================================================================================================
                                            EXAMPLE 1
    =================================================================================================

    Input:

                    2
                   / \
                  1   3

    This entire tree is a BST.

    Total Nodes = 3

    Output:
        3


    =================================================================================================
                                            EXAMPLE 2
    =================================================================================================

    Input:

                        10
                       /  \
                      5    15
                     / \     \
                    1   8     7

    Observe carefully:

        Node 15 has right child 7

        But:
            7 < 15

        This violates BST property.

    Therefore:

        Entire tree is NOT BST.

    Largest BST Subtree:

                    5
                   / \
                  1   8

    Size = 3

    Output:
        3


    =================================================================================================
                                            IMPORTANT IDEA
    =================================================================================================

    We need to check EVERY subtree.

    For every node we ask:

        "Can this node become root of a BST?"

    To answer this efficiently,
    we need information from left and right subtree.

    For every subtree we need:

        1. Minimum value in subtree
        2. Maximum value in subtree
        3. Size of largest BST
        4. Whether subtree is BST or not


    =================================================================================================
                                            INTUITION
    =================================================================================================

    We use POSTORDER traversal:

        Left -> Right -> Root

    WHY?

    Because before deciding whether current node forms a BST,
    we first need information from:

        left subtree
        right subtree

    So we process children first.


    -------------------------------------------------------------------------------------------------
    CONDITION FOR CURRENT TREE TO BE BST
    -------------------------------------------------------------------------------------------------

    Current subtree is BST if:

        left.maxNode < current.data < right.minNode

    If true:

        Current subtree is valid BST.

    Else:

        Current subtree is NOT BST.


    =================================================================================================
                                            APPROACH
    =================================================================================================

    We create a helper class called NodeValue.

    It stores:

        minNode -> minimum value in subtree
        maxNode -> maximum value in subtree
        maxSize -> size of largest BST


    -------------------------------------------------------------------------------------------------
    FOR EVERY NODE
    -------------------------------------------------------------------------------------------------

    STEP 1:
        Recursively get left subtree information.

    STEP 2:
        Recursively get right subtree information.

    STEP 3:
        Check BST condition:

            left.maxNode < node.data < right.minNode

    STEP 4:
        If valid BST:

            size =
                left.maxSize +
                right.maxSize +
                1

    STEP 5:
        If NOT BST:

            Return invalid range:
                min = Integer.MIN_VALUE
                max = Integer.MAX_VALUE

            This ensures parent also becomes invalid.


    =================================================================================================
                                            DRY RUN
    =================================================================================================

    TREE:

                        10
                       /  \
                      5    15
                     / \     \
                    1   8     7

    -------------------------------------------------------------------------------------------------
    NODE 1
    -------------------------------------------------------------------------------------------------

    Valid BST

    Returns:

        min = 1
        max = 1
        size = 1


    -------------------------------------------------------------------------------------------------
    NODE 8
    -------------------------------------------------------------------------------------------------

    Valid BST

    Returns:

        min = 8
        max = 8
        size = 1


    -------------------------------------------------------------------------------------------------
    NODE 5
    -------------------------------------------------------------------------------------------------

    Check:

        left.max = 1
        right.min = 8

        1 < 5 < 8 -> TRUE

    Valid BST

    Returns:

        min = 1
        max = 8
        size = 3


    -------------------------------------------------------------------------------------------------
    NODE 15
    -------------------------------------------------------------------------------------------------

    Right child = 7

    Check:

        15 < 7 -> FALSE

    NOT BST

    Returns invalid range.


    -------------------------------------------------------------------------------------------------
    NODE 10
    -------------------------------------------------------------------------------------------------

    Right subtree invalid.

    Entire tree NOT BST.

    Largest BST size remains:

        3


    =================================================================================================
                                            TREE NODE CLASS
    =================================================================================================
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


    /*
    =================================================================================================
                                    HELPER CLASS : NODE VALUE
    =================================================================================================

    Stores information about subtree.

    minNode -> minimum value in subtree
    maxNode -> maximum value in subtree
    maxSize -> size of largest BST
    */

    static class NodeValue {

        int minNode;
        int maxNode;
        int maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {

            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }


    /*
    =================================================================================================
                                            SOLUTION CLASS
    =================================================================================================
    */

    static class Solution {

        /*
        =============================================================================================
                                    HELPER FUNCTION
        =============================================================================================

        This function returns NodeValue object for every subtree.

        POSTORDER TRAVERSAL:
            Left -> Right -> Root
        */

        private NodeValue largestBSTSubtreeHelper(TreeNode node) {

            /*
            =========================================================================================
                                            BASE CASE
            =========================================================================================

            Null subtree is considered valid BST.

            Why?

            Because it helps simplify comparisons.

            Return:

                min = +infinity
                max = -infinity
                size = 0
            */

            if (node == null) {

                return new NodeValue(
                        Integer.MAX_VALUE,
                        Integer.MIN_VALUE,
                        0
                );
            }


            /*
            =========================================================================================
                                    GET LEFT SUBTREE INFO
            =========================================================================================
            */

            NodeValue left = largestBSTSubtreeHelper(node.left);


            /*
            =========================================================================================
                                    GET RIGHT SUBTREE INFO
            =========================================================================================
            */

            NodeValue right = largestBSTSubtreeHelper(node.right);


            /*
            =========================================================================================
                                    CHECK BST CONDITION
            =========================================================================================

            Current subtree is BST if:

                left.maxNode < node.data < right.minNode
            */

            if (left.maxNode < node.data &&
                    node.data < right.minNode) {

                /*
                Current subtree is VALID BST
                */

                return new NodeValue(

                        // Minimum value in subtree
                        Math.min(node.data, left.minNode),

                        // Maximum value in subtree
                        Math.max(node.data, right.maxNode),

                        // Total size of BST
                        left.maxSize + right.maxSize + 1
                );
            }


            /*
            =========================================================================================
                                    CURRENT TREE IS NOT BST
            =========================================================================================

            Return invalid range so parent also becomes invalid.

            Carry forward largest BST size found so far.
            */

            return new NodeValue(

                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE,

                    Math.max(left.maxSize, right.maxSize)
            );
        }


        /*
        =============================================================================================
                                        MAIN FUNCTION
        =============================================================================================

        Returns size of largest BST subtree.
        */

        public int largestBST(TreeNode root) {

            return largestBSTSubtreeHelper(root).maxSize;
        }
    }


    /*
    =================================================================================================
                                            MAIN METHOD
    =================================================================================================
    */

    public static void main(String[] args) {

        /*
                                Construct Binary Tree

                                        10
                                       /  \
                                      5    15
                                     / \     \
                                    1   8     7

            Largest BST:

                        5
                       / \
                      1   8

            Size = 3
        */

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);

        root.right.right = new TreeNode(7);


        // Create Solution object
        Solution sol = new Solution();

        // Find largest BST size
        int ans = sol.largestBST(root);

        System.out.println("Largest BST Size : " + ans);
    }


    /*
    =================================================================================================
                                        COMPLEXITY ANALYSIS
    =================================================================================================

    TIME COMPLEXITY
    -------------------------------------------------------------------------------------------------

    O(N)

    Reason:
        Every node is visited exactly once.

    Where:
        N = Number of nodes


    -------------------------------------------------------------------------------------------------
    SPACE COMPLEXITY
    -------------------------------------------------------------------------------------------------

    O(H)

    Reason:
        Recursive stack space.

    Where:
        H = Height of tree

    BEST CASE:
        Balanced Tree
        H = logN

    WORST CASE:
        Skewed Tree
        H = N


    -------------------------------------------------------------------------------------------------
    NOTE
    -------------------------------------------------------------------------------------------------

    Some explanations mention O(N) auxiliary space because a NodeValue object
    is created for each recursive call.

    But practically:

        Extra recursive stack space = O(H)

    =================================================================================================
                                            KEY LEARNINGS
    =================================================================================================

    1. Inorder traversal of BST is sorted.

    2. Largest BST can exist inside non-BST binary tree.

    3. Postorder traversal is useful when parent depends on children.

    4. For every subtree we maintain:
            min
            max
            size

    5. BST condition:
            left.max < root < right.min

    6. Bottom-up recursion makes solution efficient.

    =================================================================================================
    */
}