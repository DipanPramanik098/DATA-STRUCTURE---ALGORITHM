package _015_Binary_Trees._05_Traversal_In_Constant_Space;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given the root of a Binary Tree,
return the INORDER traversal.

Constraint:
Do it in O(1) extra space.

Normal inorder:

Left -> Root -> Right

Normally we use:
1. Recursion
OR
2. Stack

Both use extra space.

Need:
Constant extra space.

This is Morris Traversal.

-----------------------------------------------------------
Example:

            1
          /
         4
        / \
       4   2

Inorder:
[4, 4, 2, 1]

===========================================================
INTUITION
===========================================================

Problem:
In inorder traversal after finishing LEFT subtree,
how do we return back to ROOT
without recursion/stack?

Solution:
Create TEMPORARY THREADS.

Meaning:
Connect inorder predecessor back to current node.

--------------------------------

Inorder predecessor:
Rightmost node in left subtree.

Example:

            5
          /   \
         1     2
        / \
       8   6

Current = 5

Left subtree:
        1
       / \
      8   6

Rightmost node = 6

So:
6.right = 5

Temporary connection created.

Now after finishing left subtree,
we automatically come back to 5.

Later:
remove the thread.

===========================================================
CORE CASES
===========================================================

CASE 1:
No left child

Example:

    4
     \
      7

Visit directly:
4

Move right.

--------------------------------

CASE 2:
Left child exists
AND predecessor.right == null

Create thread:
predecessor.right = current

Move LEFT

--------------------------------

CASE 3:
Left child exists
AND predecessor.right == current

Means:
Left subtree already processed

Remove thread

Visit current

Move RIGHT

===========================================================
APPROACH
===========================================================

STEP 1:
Start current = root

STEP 2:
While current != null

IF no left:
- visit current
- move right

ELSE:
Find predecessor

IF predecessor.right == null:
- create thread
- move left

ELSE:
- remove thread
- visit current
- move right

===========================================================
DRY RUN
===========================================================

Tree:

            5
          /   \
         1     2
        /     / \
       8     4   5
        \
         6

Expected Inorder:
Left -> Root -> Right

[8, 6, 1, 5, 4, 2, 5]

--------------------------------
Current = 5

Left exists

Find predecessor:
6

Create:
6.right = 5

Move left

--------------------------------
Current = 1

Left exists

Find predecessor:
6

Create:
6.right = 1

Move left

--------------------------------
Current = 8

No left

Visit:
[8]

Move right → 6

--------------------------------
Current = 6

No left

Visit:
[8,6]

Move right → 1 (thread)

--------------------------------
Current = 1

Predecessor.right == current

Remove thread

Visit:
[8,6,1]

Move right

--------------------------------
Current = 5

Predecessor.right == current

Remove thread

Visit:
[8,6,1,5]

Move right → 2

--------------------------------
Visit 4
Visit 2
Visit 5

Final:
[8,6,1,5,4,2,5]

===========================================================
MCQ ANSWER
===========================================================

Correct Answer:

[8, 6, 1, 5, 4, 2, 5]

===========================================================
*/

public class _01_Morris_Inorder_Traversal {

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
     * Morris Inorder Traversal
     */
    public static List<Integer> morrisInorder(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();

        TreeNode current = root;

        while (current != null) {

            /*
             * CASE 1:
             * No left child
             */
            if (current.left == null) {

                inorder.add(current.data);

                current = current.right;
            }
            else {

                /*
                 * Find inorder predecessor
                 */
                TreeNode predecessor = current.left;

                while (predecessor.right != null &&
                       predecessor.right != current) {

                    predecessor = predecessor.right;
                }

                /*
                 * CASE 2:
                 * Create thread
                 */
                if (predecessor.right == null) {

                    predecessor.right = current;

                    current = current.left;
                }
                else {

                    /*
                     * CASE 3:
                     * Remove thread
                     */
                    predecessor.right = null;

                    inorder.add(current.data);

                    current = current.right;
                }
            }
        }

        return inorder;
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        /*
                    5
                  /   \
                 1     2
                /     / \
               8     4   5
                \
                 6
         */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(6);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(morrisInorder(root));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Each node visited at most 2 times:

1. Thread creation
2. Thread removal

Total:

O(N)

===========================================================
SPACE COMPLEXITY
===========================================================

No recursion
No stack
Only pointers used

O(1)

===========================================================
*/