package _015_Binary_Trees._04_Construction_Problems;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given:

1. Postorder traversal
2. Inorder traversal

Construct the original Binary Tree.

Return root of the tree.

-----------------------------------------------------------
Traversal Meaning:

POSTORDER:
Left -> Right -> Root

INORDER:
Left -> Root -> Right

-----------------------------------------------------------
Example:

Postorder:
[9, 15, 7, 20, 3]

Inorder:
[9, 3, 15, 20, 7]

Constructed Tree:

            3
          /   \
         9     20
              /  \
             15   7

===========================================================
INTUITION
===========================================================

Postorder gives ROOT at LAST.

Example:

Postorder:
[9,15,7,20,3]

Last element:
3

So:
Root = 3

--------------------------------

Now use inorder:

[9,3,15,20,7]

Everything LEFT of 3:
Left subtree

[9]

Everything RIGHT of 3:
Right subtree

[15,20,7]

--------------------------------

Repeat recursively.

===========================================================
KEY IDEA
===========================================================

POSTORDER:
Root comes LAST

INORDER:
Splits LEFT and RIGHT subtree

Together:
Unique tree possible

===========================================================
APPROACH
===========================================================

STEP 1:
Store inorder indices in HashMap

Example:

9  -> 0
3  -> 1
15 -> 2
20 -> 3
7  -> 4

--------------------------------

STEP 2:
Take last postorder element as root

--------------------------------

STEP 3:
Find root position in inorder

--------------------------------

STEP 4:
Calculate left subtree size

leftSize = inRoot - inStart

--------------------------------

STEP 5:
Recursive construction

LEFT subtree:
postorder left part

RIGHT subtree:
postorder right part

===========================================================
DRY RUN
===========================================================

Postorder:
[6, 8, 1, 4, 7, 2, 5]

Inorder:
[8, 6, 1, 5, 4, 2, 7]

--------------------------------
Step 1:

Root = 5
(last postorder element)

Inorder split:

LEFT:
[8,6,1]

RIGHT:
[4,2,7]

--------------------------------
LEFT subtree

Postorder left:
[6,8,1]

Root = 1

Inorder split:

LEFT:
[8,6]

RIGHT:
[]

--------------------------------
LEFT subtree of 1

Postorder:
[6,8]

Root = 8

Inorder split:

LEFT:
[]

RIGHT:
[6]

So:
8.right = 6

--------------------------------
RIGHT subtree of 5

Postorder:
[4,7,2]

Root = 2

Inorder split:

LEFT:
[4]

RIGHT:
[7]

So:
2.left = 4
2.right = 7

--------------------------------

Final Tree:

                5
              /   \
             1     2
            /     / \
           8     4   7
            \
             6

===========================================================
MCQ ANSWER
===========================================================

Correct Answer:

[5, 1, 2, 8, null, 4, 7, null, 6]

===========================================================
*/

public class _03_Construct_Tree_From_post_and_Inorder {

    /*
     * Binary Tree Node
     */
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /*
     * Main function
     */
    public static TreeNode buildTree(int[] postorder, int[] inorder) {

        /*
         * Edge case
         */
        if (postorder.length != inorder.length) {
            return null;
        }

        /*
         * Store inorder indices
         */
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return construct(
                postorder,
                0,
                postorder.length - 1,
                inorder,
                0,
                inorder.length - 1,
                inorderMap
        );
    }

    /*
     * Recursive helper
     */
    private static TreeNode construct(
            int[] postorder,
            int postStart,
            int postEnd,
            int[] inorder,
            int inStart,
            int inEnd,
            Map<Integer, Integer> inorderMap
    ) {

        /*
         * Base case
         */
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        /*
         * Root from postorder
         */
        TreeNode root = new TreeNode(postorder[postEnd]);

        /*
         * Root index in inorder
         */
        int inRoot = inorderMap.get(root.data);

        /*
         * Left subtree size
         */
        int leftSize = inRoot - inStart;

        /*
         * Build left subtree
         */
        root.left = construct(
                postorder,
                postStart,
                postStart + leftSize - 1,
                inorder,
                inStart,
                inRoot - 1,
                inorderMap
        );

        /*
         * Build right subtree
         */
        root.right = construct(
                postorder,
                postStart + leftSize,
                postEnd - 1,
                inorder,
                inRoot + 1,
                inEnd,
                inorderMap
        );

        return root;
    }

    /*
     * Level order print
     */
    public static void printLevelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                System.out.print("null ");
                continue;
            }

            System.out.print(current.data + " ");

            queue.offer(current.left);
            queue.offer(current.right);
        }
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(postorder, inorder);

        printLevelOrder(root);
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

HashMap creation:
O(N)

Recursive construction:
Each node visited once

O(N)

Total:
O(N)

===========================================================
SPACE COMPLEXITY
===========================================================

HashMap:
O(N)

Recursive stack:
O(H)

Worst case:
O(N)

Balanced tree:
O(log N)

===========================================================
*/