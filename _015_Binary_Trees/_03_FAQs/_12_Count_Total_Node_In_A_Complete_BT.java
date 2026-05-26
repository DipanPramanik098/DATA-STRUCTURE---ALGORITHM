package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given the root of a COMPLETE Binary Tree,
count total number of nodes.

Complete Binary Tree means:

1. Every level completely filled
   except possibly last level

2. Last level nodes filled
   from LEFT to RIGHT

Need optimized solution.

-----------------------------------------------------------
Example 1:

            1
          /   \
         2     3
        / \   /
       4   5 6

Output:
6

-----------------------------------------------------------
Example 2:

            1
          /   \
         2     3
        / \   / \
       4   5 6   7
      / \
     8   9

Output:
9

===========================================================
INTUITION
===========================================================

Normal counting:
Visit every node

Time:
O(N)

But tree is COMPLETE.

Special property:
If left height == right height

Then tree is PERFECT.

Perfect Binary Tree formula:

Nodes = 2^h - 1

Can calculate directly.

Example:

            1
          /   \
         2     3
        / \   / \
       4   5 6   7

Height = 3

Nodes:
2^3 - 1 = 7

If heights differ:
Tree is incomplete at last level

Then recursively count.

===========================================================
APPROACH
===========================================================

STEP 1:
Find left height

Keep moving:
node = node.left

STEP 2:
Find right height

Keep moving:
node = node.right

STEP 3:
Compare

If equal:
return 2^height - 1

Else:
return
1 + left subtree count + right subtree count

===========================================================
DRY RUN
===========================================================

Tree:

            1
          /   \
         2     3
        / \   /
       4   5 6

--------------------------------
At root:

Left height:
1 → 2 → 4
height = 3

Right height:
1 → 3
height = 2

Not equal

So:
1 + count(left) + count(right)

--------------------------------
Left subtree:

            2
          /   \
         4     5

Left height = 2
Right height = 2

Equal

Nodes:
2^2 - 1 = 3

--------------------------------
Right subtree:

        3
       /
      6

Left height = 2
Right height = 1

Not equal

1 + count(6) + count(null)

count(6):
perfect tree
= 1

Total:
2

--------------------------------
Final:

1 + 3 + 2 = 6

===========================================================
MCQ ANSWER
===========================================================

Input:
[1,2,3]

Tree:

      1
     / \
    2   3

Perfect tree
Height = 2

Nodes:
2^2 - 1 = 3

Correct Answer:
3

===========================================================
*/

public class _12_Count_Total_Node_In_A_Complete_BT {

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
    public static int countNodes(TreeNode root) {

        /*
         * Base case
         */
        if (root == null) {
            return 0;
        }

        /*
         * Find heights
         */
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        /*
         * Perfect tree
         */
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        /*
         * Incomplete tree
         */
        return 1
                + countNodes(root.left)
                + countNodes(root.right);
    }

    /*
     * Find left height
     */
    private static int findLeftHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    /*
     * Find right height
     */
    private static int findRightHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.right;
        }

        return height;
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \   /
               4   5 6
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        System.out.println("Total Nodes: " + countNodes(root));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Height calculation:
O(log N)

Recursive calls:
O(log N)

Total:
O(log² N)

===========================================================
SPACE COMPLEXITY
===========================================================

Recursive stack depth:
O(log N)

===========================================================
*/