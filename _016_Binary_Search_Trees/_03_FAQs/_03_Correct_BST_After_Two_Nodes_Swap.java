package _016_Binary_Search_Trees._03_FAQs;

public class _03_Correct_BST_After_Two_Nodes_Swap {

    /*
    =================================================================================================
                                    CORRECT BST AFTER TWO NODES SWAP
    =================================================================================================

    PROBLEM STATEMENT
    -------------------------------------------------------------------------------------------------
    Given the root of a Binary Search Tree (BST), exactly two nodes are swapped by mistake.

    We need to recover the BST WITHOUT changing the structure of the tree.
    Only the node VALUES should be corrected.

    -------------------------------------------------------------------------------------------------
    WHAT IS A BST?
    -------------------------------------------------------------------------------------------------

    In a BST:

        Left Subtree  <  Root Node
        Right Subtree >  Root Node

    Also:

        Inorder Traversal of BST = Sorted Order

    Example:

                    4
                  /   \
                 2     6
                / \   / \
               1  3  5   7

    Inorder Traversal:

        1 2 3 4 5 6 7

    Sorted Order -> Valid BST


    =================================================================================================
                                        EXAMPLE 1
    =================================================================================================

    Input:

                    1
                   /
                  3
                   \
                    2

    Here 1 and 3 are swapped.

    Inorder Traversal:

        3 2 1

    This is NOT sorted.

    Correct BST should be:

                    3
                   /
                  1
                   \
                    2


    =================================================================================================
                                        EXAMPLE 2
    =================================================================================================

    Input:

                    3
                   / \
                  1   4
                     /
                    2

    Inorder Traversal:

        1 3 2 4

    Here order is broken because:

        3 > 2

    Nodes 3 and 2 are swapped.

    Correct BST:

                    2
                   / \
                  1   4
                     /
                    3


    =================================================================================================
                                        INTUITION
    =================================================================================================

    VERY IMPORTANT OBSERVATION:

        Inorder Traversal of BST should ALWAYS be sorted.

    If two nodes are swapped:

        Sorted order gets violated.

    Example:

        Correct inorder:
            1 2 3 4 5 6 7

        After swapping 3 and 6:
            1 2 6 4 5 3 7

    Violations:

        6 > 4
        5 > 3

    These violations help us identify swapped nodes.


    -------------------------------------------------------------------------------------------------
    TWO CASES OF SWAPPING
    -------------------------------------------------------------------------------------------------

    CASE 1 -> Adjacent Nodes Swapped

        Example:
            1 3 2 4

        Only ONE violation exists.

        Swapped Nodes:
            3 and 2


    CASE 2 -> Non Adjacent Nodes Swapped

        Example:
            1 5 3 4 2 6

        TWO violations exist.

        Violations:
            5 > 3
            4 > 2

        Swapped Nodes:
            5 and 2


    =================================================================================================
                                        APPROACH
    =================================================================================================

    We use inorder traversal.

    During traversal:

        prev = previously visited node

    If:

        prev.data > current.data

    then BST property is violated.


    -------------------------------------------------------------------------------------------------
    POINTERS USED
    -------------------------------------------------------------------------------------------------

    1. first
       -> First incorrect node

    2. middle
       -> Middle node when first violation occurs

    3. last
       -> Second incorrect node when second violation occurs

    4. prev
       -> Previous node during inorder traversal


    -------------------------------------------------------------------------------------------------
    HOW DETECTION WORKS
    -------------------------------------------------------------------------------------------------

    FIRST VIOLATION:

        prev.data > current.data

        first  = prev
        middle = current

    SECOND VIOLATION:

        prev.data > current.data

        last = current


    -------------------------------------------------------------------------------------------------
    FINAL SWAP
    -------------------------------------------------------------------------------------------------

    CASE 1:
        first and last exist
        -> swap(first, last)

    CASE 2:
        only first and middle exist
        -> swap(first, middle)


    =================================================================================================
                                        DRY RUN
    =================================================================================================

    Tree:

                    3
                   / \
                  1   4
                     /
                    2

    Inorder:

        1 3 2 4

    Step-by-step:

    Visit 1
        prev = 1

    Visit 3
        prev = 3

    Visit 2
        prev.data > current.data
        3 > 2 -> VIOLATION

        first  = 3
        middle = 2

    Visit 4
        no issue

    Since only one violation:
        swap(first, middle)

    Swap:
        3 <-> 2

    Correct BST obtained.


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
                                        SOLUTION CLASS
    =================================================================================================
    */

    static class Solution {

        /*
        first  -> first incorrect node
        middle -> adjacent swapped node
        last   -> second incorrect node
        prev   -> previous node in inorder traversal
        */

        private TreeNode first = null;
        private TreeNode middle = null;
        private TreeNode last = null;
        private TreeNode prev = null;


        /*
        =============================================================================================
                                        MAIN FUNCTION
        =============================================================================================

        This function fixes the BST.

        STEPS:
        1. Perform inorder traversal
        2. Detect incorrect nodes
        3. Swap appropriate nodes
        */

        public void recoverTree(TreeNode root) {

            // Step 1: Detect swapped nodes
            inorder(root);

            /*
            CASE 1:
            Non-adjacent nodes swapped

            Example:
                1 5 3 4 2 6

            Swap first and last
            */
            if (first != null && last != null) {

                int temp = first.data;
                first.data = last.data;
                last.data = temp;
            }

            /*
            CASE 2:
            Adjacent nodes swapped

            Example:
                1 3 2 4

            Swap first and middle
            */
            else if (first != null && middle != null) {

                int temp = first.data;
                first.data = middle.data;
                middle.data = temp;
            }
        }


        /*
        =============================================================================================
                                    INORDER TRAVERSAL
        =============================================================================================

        Inorder Traversal:

            Left -> Root -> Right

        For BST:
            Gives sorted order.

        If prev.data > current.data
            -> violation found
        */

        private void inorder(TreeNode node) {

            // Base Case
            if (node == null) {
                return;
            }

            // Traverse left subtree
            inorder(node.left);

            /*
            Detect violation

            Correct inorder should be increasing.

            If previous node is greater than current node:
                BST property broken
            */
            if (prev != null && prev.data > node.data) {

                /*
                First violation
                */
                if (first == null) {

                    first = prev;
                    middle = node;
                }

                /*
                Second violation
                */
                else {

                    last = node;
                }
            }

            // Update prev node
            prev = node;

            // Traverse right subtree
            inorder(node.right);
        }
    }


    /*
    =================================================================================================
                                        INORDER PRINT
    =================================================================================================

    Helper function to print inorder traversal.
    */

    public static void inorderPrint(TreeNode root) {

        if (root == null) {
            return;
        }

        inorderPrint(root.left);

        System.out.print(root.data + " ");

        inorderPrint(root.right);
    }


    /*
    =================================================================================================
                                            MAIN METHOD
    =================================================================================================
    */

    public static void main(String[] args) {

        /*
        Constructing Incorrect BST

                    3
                   / \
                  1   4
                     /
                    2

        Nodes 2 and 3 are swapped.
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);

        root.right = new TreeNode(4);

        root.right.left = new TreeNode(2);


        System.out.println("Inorder Before Recovery:");

        inorderPrint(root);

        System.out.println();


        // Create solution object
        Solution sol = new Solution();

        // Recover BST
        sol.recoverTree(root);


        System.out.println("\nInorder After Recovery:");

        inorderPrint(root);
    }


    /*
    =================================================================================================
                                        COMPLEXITY ANALYSIS
    =================================================================================================

    TIME COMPLEXITY
    -------------------------------------------------------------------------------------------------

    O(N)

    Reason:
    We visit every node exactly once during inorder traversal.

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
        Balanced BST
        H = logN

    WORST CASE:
        Skewed Tree
        H = N


    =================================================================================================
                                        KEY LEARNING
    =================================================================================================

    1. Inorder traversal of BST is always sorted.

    2. Swapped nodes break sorted order.

    3. We detect violations using:
            prev.data > current.data

    4. Two possible cases:
            Adjacent swap
            Non-adjacent swap

    5. Only node values are swapped.
       Tree structure remains unchanged.

    =================================================================================================
    */
}