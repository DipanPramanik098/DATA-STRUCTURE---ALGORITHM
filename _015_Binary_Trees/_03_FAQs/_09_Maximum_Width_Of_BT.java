package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given the root of a Binary Tree,
find the MAXIMUM WIDTH of the tree.

Width means:
Distance between leftmost and rightmost non-null nodes
at any level, INCLUDING imaginary null nodes between them
(as if the tree were a complete binary tree).

Return the maximum width among all levels.

-----------------------------------------------------------
Example 1:

            1
          /   \
         3     2
        / \     \
       5   3     9

Level 0:
[1]
Width = 1

Level 1:
[3,2]
Width = 2

Level 2:
[5,3,null,9]
Width = 4

Answer:
4

-----------------------------------------------------------
Example 2:

            1
          /   \
         3     2
        /       \
       5         9
      /           \
     6             7

Last Level:
[6,null,null,null,null,null,7]

Width = 7

===========================================================
INTUITION
===========================================================

Normal level order traversal counts only real nodes.

But here:
Null gaps also matter.

So we assign INDEX positions like complete binary tree.

Formula:

Root = 0

Left child:
2 * index + 1

Right child:
2 * index + 2

Example:

        1(0)
       /    \
    2(1)    3(2)
    /          \
  4(3)         8(6)

Width:
6 - 3 + 1 = 4

Need:
1. BFS traversal
2. Queue storing:
   (Node, Index)

===========================================================
APPROACH
===========================================================

Step 1:
If tree empty → return 0

Step 2:
Create queue storing:
(Node, index)

Step 3:
Insert root with index 0

Step 4:
For every level:
- Note first index
- Note last index
- Width = last - first + 1
- Update answer

Step 5:
For child nodes:
Left = 2*i + 1
Right = 2*i + 2

Optimization:
Subtract minimum index of current level
to avoid integer overflow.

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

--------------------------------
Level 0:

Queue:
[(5,0)]

first = 0
last = 0

Width:
1

--------------------------------
Level 1:

Queue:
[(1,1), (2,2)]

first = 0
last = 1

Width:
2

--------------------------------
Level 2:

Queue:
[(8,1), (4,3), (5,4)]

first = 0
last = 3

Width:
4

--------------------------------
Level 3:

Queue:
[(6,2)]

Width:
1

Maximum:
4

===========================================================
MCQ ANSWER
===========================================================

Correct Answer:
4

===========================================================
*/

public class _09_Maximum_Width_Of_BT {

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
     * Pair class
     * Stores node + index
     */
    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    /*
     * Function to find maximum width
     */
    public static int widthOfBinaryTree(TreeNode root) {

        // Empty tree
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;

        /*
         * Queue for BFS
         */
        Queue<Pair> queue = new LinkedList<>();

        // Root index = 0
        queue.offer(new Pair(root, 0));

        /*
         * Level order traversal
         */
        while (!queue.isEmpty()) {

            int size = queue.size();

            /*
             * Minimum index at current level
             * Used to avoid overflow
             */
            int minIndex = queue.peek().index;

            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {

                Pair current = queue.poll();

                /*
                 * Normalize index
                 */
                int currentIndex = current.index - minIndex;

                TreeNode node = current.node;

                // First node
                if (i == 0) {
                    first = currentIndex;
                }

                // Last node
                if (i == size - 1) {
                    last = currentIndex;
                }

                /*
                 * Left child
                 */
                if (node.left != null) {
                    queue.offer(new Pair(
                            node.left,
                            currentIndex * 2 + 1
                    ));
                }

                /*
                 * Right child
                 */
                if (node.right != null) {
                    queue.offer(new Pair(
                            node.right,
                            currentIndex * 2 + 2
                    ));
                }
            }

            /*
             * Width formula
             */
            int width = last - first + 1;

            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        /*
                    1
                  /   \
                 3     2
                / \     \
               5   3     9
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        System.out.println("Maximum Width: " + widthOfBinaryTree(root));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Each node visited exactly once.

O(N)

Where:
N = Number of nodes

===========================================================
SPACE COMPLEXITY
===========================================================

Queue stores nodes level by level.

Worst Case:
O(N)

===========================================================
*/