package _015_Binary_Trees._05_Traversal_In_Constant_Space;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given root of a Binary Tree,
return PREORDER traversal.

PREORDER:

Root -> Left -> Right

Constraint:
Use O(1) extra space.

No recursion
No stack

Use Morris Traversal.

-----------------------------------------------------------
Example:

            1
           /
          4
         /
        4
       /
      2

Preorder:
[1,4,4,2]

===========================================================
INTUITION
===========================================================

Normal preorder:

Visit root FIRST
Then left subtree
Then right subtree

Problem:
Without recursion/stack,
how do we return back?

Solution:
Temporary THREADS.

Same Morris idea.

Difference:

INORDER:
Visit AFTER coming back

PREORDER:
Visit BEFORE going left

That is the only change.

===========================================================
CORE IDEA
===========================================================

Find inorder predecessor:
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

Rightmost = 6

Create:
6.right = 5

Temporary return path created.

===========================================================
CASES
===========================================================

CASE 1:
No left child

Visit current
Move right

--------------------------------

CASE 2:
Left exists
AND predecessor.right == null

Create thread
VISIT current
Move left

--------------------------------

CASE 3:
Left exists
AND predecessor.right == current

Remove thread
Move right

===========================================================
APPROACH
===========================================================

STEP 1:
current = root

STEP 2:
while current != null

IF no left:
- visit current
- move right

ELSE:
find predecessor

IF predecessor.right == null:
- create thread
- visit current
- move left

ELSE:
- remove thread
- move right

===========================================================
DRY RUN
===========================================================

Tree:

            1
          /   \
         4     2
        /       \
       9         6

Expected preorder:
Root -> Left -> Right

[1,4,9,2,6]

--------------------------------
Current = 1

Left exists

Find predecessor = 4

Create:
4.right = 1

VISIT:
[1]

Move left

--------------------------------
Current = 4

Left exists

Find predecessor = 9

Create:
9.right = 4

VISIT:
[1,4]

Move left

--------------------------------
Current = 9

No left

VISIT:
[1,4,9]

Move right -> thread back

--------------------------------
Current = 4

Thread exists

Remove thread

Move right -> back to 1

--------------------------------
Current = 1

Thread exists

Remove thread

Move right -> 2

VISIT:
[1,4,9,2]

Move right -> 6

VISIT:
[1,4,9,2,6]

===========================================================
MCQ ANSWER
===========================================================

Input:
root = [1,4,2,9,null,null,6]

Correct Answer:

[1, 4, 9, 2, 6]

===========================================================
*/

public class _02_Morris_PreOrder_Traversal {

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
     * Morris Preorder Traversal
     */
    public static List<Integer> morrisPreorder(TreeNode root) {

        List<Integer> preorder = new ArrayList<>();

        TreeNode current = root;

        while (current != null) {

            /*
             * CASE 1:
             * No left child
             */
            if (current.left == null) {

                preorder.add(current.data);

                current = current.right;
            }
            else {

                /*
                 * Find predecessor
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

                    preorder.add(current.data);

                    predecessor.right = current;

                    current = current.left;
                }
                else {

                    /*
                     * CASE 3:
                     * Remove thread
                     */
                    predecessor.right = null;

                    current = current.right;
                }
            }
        }

        return preorder;
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        /*
                    1
                  /   \
                 4     2
                /       \
               9         6
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(4);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(9);

        root.right.right = new TreeNode(6);

        System.out.println(morrisPreorder(root));
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
Only pointer variables used

O(1)

===========================================================
*/