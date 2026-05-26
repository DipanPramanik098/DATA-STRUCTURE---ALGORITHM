package _015_Binary_Trees._04_Construction_Problems;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given:

1. Preorder traversal
2. Inorder traversal

Construct the original Binary Tree.

Return root of the constructed tree.

-----------------------------------------------------------
Traversal Meaning:

PREORDER:
Root -> Left -> Right

INORDER:
Left -> Root -> Right

-----------------------------------------------------------
Example 1:

Preorder:
[3, 9, 20, 15, 7]

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

Preorder gives ROOT first.

Example:
[3, 9, 20, 15, 7]

First element:
3

So root = 3

--------------------------------

Now use inorder:

[9, 3, 15, 20, 7]

Everything LEFT of 3:
Left subtree

[9]

Everything RIGHT of 3:
Right subtree

[15, 20, 7]

--------------------------------

Repeat same logic recursively.

===========================================================
KEY IDEA
===========================================================

PREORDER:
Root comes FIRST

INORDER:
Splits LEFT and RIGHT subtree

Together:
Unique tree possible

===========================================================
APPROACH
===========================================================

STEP 1:
Store inorder indices in HashMap

Why?
To find root position quickly in O(1)

Example:

9  -> 0
3  -> 1
15 -> 2
20 -> 3
7  -> 4

--------------------------------

STEP 2:
Take current preorder start
as root

--------------------------------

STEP 3:
Find root in inorder

This divides:

LEFT subtree
RIGHT subtree

--------------------------------

STEP 4:
Calculate left subtree size

leftSize = inRootIndex - inStart

--------------------------------

STEP 5:
Recursive construction

LEFT:

Preorder:
next elements after root

Inorder:
left part

RIGHT:

Remaining preorder

Remaining inorder

===========================================================
DRY RUN
===========================================================

Preorder:
[5, 1, 8, 6, 2, 4, 7]

Inorder:
[8, 6, 1, 5, 4, 2, 7]

--------------------------------
Step 1:

Root = 5

Inorder split:

LEFT:
[8,6,1]

RIGHT:
[4,2,7]

--------------------------------
LEFT subtree

Preorder next root = 1

Inorder split at 1:

LEFT:
[8,6]

RIGHT:
[]

--------------------------------
LEFT subtree of 1

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

public class _02_Construct_A_BT_From_preorder_And_Inorder {

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
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        /*
         * Store inorder indices
         */
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return construct(
                preorder,
                0,
                preorder.length - 1,
                inorder,
                0,
                inorder.length - 1,
                inorderMap);
    }

    /*
     * Recursive helper
     */
    private static TreeNode construct(
            int[] preorder,
            int preStart,
            int preEnd,
            int[] inorder,
            int inStart,
            int inEnd,
            Map<Integer, Integer> inorderMap) {

        /*
         * Base case
         */
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        /*
         * Root from preorder
         */
        TreeNode root = new TreeNode(preorder[preStart]);

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
                preorder,
                preStart + 1,
                preStart + leftSize,
                inorder,
                inStart,
                inRoot - 1,
                inorderMap);

        /*
         * Build right subtree
         */
        root.right = construct(
                preorder,
                preStart + leftSize + 1,
                preEnd,
                inorder,
                inRoot + 1,
                inEnd,
                inorderMap);

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

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = buildTree(preorder, inorder);

        printLevelOrder(root);
    }
}

/*
 * ===========================================================
 * TIME COMPLEXITY
 * ===========================================================
 * 
 * HashMap creation:
 * O(N)
 * 
 * Recursive construction:
 * Each node visited once
 * 
 * O(N)
 * 
 * Total:
 * O(N)
 * 
 * ===========================================================
 * SPACE COMPLEXITY
 * ===========================================================
 * 
 * HashMap:
 * O(N)
 * 
 * Recursive stack:
 * O(H)
 * 
 * Worst case:
 * O(N)
 * 
 * Balanced tree:
 * O(log N)
 * 
 * ===========================================================
 */