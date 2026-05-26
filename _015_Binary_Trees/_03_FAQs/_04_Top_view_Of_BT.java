package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given the root of a Binary Tree, return the Top View of the tree.

Top View means:
If we look at the binary tree from the top, only some nodes
will be visible.

A node is included in the top view if:
- It is the first node seen at its horizontal distance.

Horizontal Distance (HD):
- Root = 0
- Left child = HD - 1
- Right child = HD + 1

Return nodes from LEFTMOST to RIGHTMOST.

-----------------------------------------------------------
Example 1:

        1
      /   \
     2     3
    / \   / \
   4   5 6   7

Top View = [4, 2, 1, 3, 7]

Explanation:
HD values:
4 -> -2
2 -> -1
1 ->  0
3 -> +1
7 -> +2

-----------------------------------------------------------
Example 2:

Input:
        10
       /  \
      20   30
     / \   / \
    40 60 90 100

Output:
[40, 20, 10, 30, 100]

===========================================================
INTUITION
===========================================================

We need only the FIRST node at every vertical line.

Question:
How do we ensure first node is selected?

Answer:
Use BFS (Level Order Traversal)

Why BFS?
Because BFS visits nodes level by level from top to bottom.

So:
- First time we see a horizontal distance,
  that node is automatically the topmost node.

Need:
1. Queue → for BFS
2. TreeMap → to store HD -> Node Value

Why TreeMap?
Because TreeMap keeps keys sorted automatically.

Example:
HD values:
-2 -> 4
-1 -> 2
 0 -> 1
 1 -> 3
 2 -> 7

Output becomes naturally:
[4, 2, 1, 3, 7]

===========================================================
APPROACH
===========================================================

Step 1:
Create a TreeMap
Store:
Horizontal Distance -> Node Value

Step 2:
Create Queue for BFS

Store:
(Node, Horizontal Distance)

Step 3:
Insert root with HD = 0

Step 4:
Run BFS

For each node:
- Remove from queue
- If HD not already present in map:
    store node value

Then:
- Add left child with HD - 1
- Add right child with HD + 1

Step 5:
Traverse TreeMap values
Add into answer list

===========================================================
DRY RUN
===========================================================

Tree:

        5
       / \
      1   2
     /   / \
    8   4   5
     \
      6

Queue:
[(5,0)]

Map:
{}

--------------------------------
Take (5,0)

Map:
0 -> 5

Push:
(1,-1)
(2,+1)

Queue:
[(1,-1), (2,+1)]

--------------------------------
Take (1,-1)

Map:
-1 -> 1
 0 -> 5

Push:
(8,-2)

Queue:
[(2,+1), (8,-2)]

--------------------------------
Take (2,+1)

Map:
-1 -> 1
 0 -> 5
 1 -> 2

Push:
(4,0)
(5,2)

Queue:
[(8,-2), (4,0), (5,2)]

--------------------------------
Take (8,-2)

Map:
-2 -> 8
-1 -> 1
 0 -> 5
 1 -> 2

Push:
(6,-1)

Queue:
[(4,0), (5,2), (6,-1)]

--------------------------------
Take (4,0)

HD already exists
Ignore

--------------------------------
Take (5,2)

Map:
2 -> 5

--------------------------------
Take (6,-1)

HD already exists
Ignore

Final Map:
-2 -> 8
-1 -> 1
 0 -> 5
 1 -> 2
 2 -> 5

Answer:
[8, 1, 5, 2, 5]

===========================================================
*/

public class _04_Top_view_Of_BT {

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
     * Helper Pair class
     * Stores:
     * 1. TreeNode
     * 2. Horizontal Distance
     */
    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    /*
     * Function to return Top View
     */
    public static List<Integer> topView(TreeNode root) {

        // Final answer list
        List<Integer> ans = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) {
            return ans;
        }

        /*
         * TreeMap stores:
         * Horizontal Distance -> Node Value
         *
         * TreeMap keeps keys sorted automatically
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();

        /*
         * Queue for BFS traversal
         */
        Queue<Pair> queue = new LinkedList<>();

        // Start with root at HD = 0
        queue.offer(new Pair(root, 0));

        /*
         * BFS Traversal
         */
        while (!queue.isEmpty()) {

            // Remove front element
            Pair current = queue.poll();

            TreeNode node = current.node;
            int hd = current.hd;

            /*
             * Store only first node at each HD
             */
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            /*
             * Left child => HD - 1
             */
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            /*
             * Right child => HD + 1
             */
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        /*
         * Extract values in sorted HD order
         */
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;
    }

    /*
     * Main method for testing
     */
    public static void main(String[] args) {

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Top View: " + topView(root));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

BFS Traversal:
Each node visited exactly once
= O(N)

TreeMap insertion:
Each insertion takes O(log N)

For N nodes:
O(N × log N)

Final Time Complexity:
O(N log N)

===========================================================
SPACE COMPLEXITY
===========================================================

Queue:
Can store up to O(N)

TreeMap:
Can store up to O(N)

Final Space Complexity:
O(N)

===========================================================
*/