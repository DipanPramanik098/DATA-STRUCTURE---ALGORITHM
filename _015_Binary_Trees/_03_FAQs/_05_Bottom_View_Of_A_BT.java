package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given the root of a Binary Tree, return the Bottom View
of the Binary Tree.

Bottom View means:
If we look at the tree from the bottom, only the lowest
visible nodes will appear.

Rule:
If multiple nodes exist at the same horizontal distance,
the node appearing later in level order traversal (BFS)
will be considered.

Horizontal Distance (HD):
Root = 0
Left Child = HD - 1
Right Child = HD + 1

Return result from LEFTMOST to RIGHTMOST.

-----------------------------------------------------------
Example 1:

            20
          /    \
         8      22
        / \       \
       5   3       25
          / \
         10 14

Output:
[5, 10, 3, 14, 25]

-----------------------------------------------------------
Example 2:

            20
          /    \
         8      22
        / \    /  \
       5   3  4   25
          / \
         10 14

Output:
[5, 10, 4, 14, 25]

===========================================================
INTUITION
===========================================================

Top View:
Store first node at each HD.

Bottom View:
Store LAST node at each HD.

Why?

Because bottom-most node hides all nodes above it.

How to get last node?

Use BFS (Level Order Traversal).

BFS visits nodes level by level.
If we keep replacing the value at each HD,
the final stored node will be the bottom visible node.

Need:
1. Queue → BFS traversal
2. TreeMap → HD -> Node value

TreeMap keeps HD sorted automatically.

===========================================================
APPROACH
===========================================================

Step 1:
Create answer list.

Step 2:
If tree is empty, return empty list.

Step 3:
Create TreeMap:
HD -> Node value

Step 4:
Create Queue:
Store (Node, HD)

Step 5:
Insert root with HD = 0

Step 6:
Run BFS:
- Remove node
- Update map with current node
  (overwrite old value)

- Add left child with HD - 1
- Add right child with HD + 1

Step 7:
Traverse TreeMap values
Store into answer list

===========================================================
DRY RUN
===========================================================

Tree:

         10
        /  \
      20    30
     / \
   40   60

Queue:
[(10,0)]

Map:
{}

--------------------------------
Take (10,0)

Map:
0 -> 10

Push:
(20,-1)
(30,+1)

Queue:
[(20,-1), (30,+1)]

--------------------------------
Take (20,-1)

Map:
-1 -> 20
 0 -> 10

Push:
(40,-2)
(60,0)

Queue:
[(30,+1), (40,-2), (60,0)]

--------------------------------
Take (30,+1)

Map:
-1 -> 20
 0 -> 10
 1 -> 30

--------------------------------
Take (40,-2)

Map:
-2 -> 40
-1 -> 20
 0 -> 10
 1 -> 30

--------------------------------
Take (60,0)

Overwrite HD = 0

Map:
-2 -> 40
-1 -> 20
 0 -> 60
 1 -> 30

Final Answer:
[40, 20, 60, 30]

===========================================================
MCQ ANSWER
===========================================================

Correct Answer:
[40, 20, 60, 30]

===========================================================
*/

public class _05_Bottom_View_Of_A_BT {

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
     * Stores node + horizontal distance
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
     * Function to return Bottom View
     */
    public static List<Integer> bottomView(TreeNode root) {

        // Final answer
        List<Integer> ans = new ArrayList<>();

        // Edge case
        if (root == null) {
            return ans;
        }

        /*
         * TreeMap:
         * HD -> Node value
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();

        /*
         * Queue for BFS
         */
        Queue<Pair> queue = new LinkedList<>();

        // Root starts at HD = 0
        queue.offer(new Pair(root, 0));

        /*
         * BFS traversal
         */
        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            TreeNode node = current.node;
            int hd = current.hd;

            /*
             * Always overwrite
             * because bottom-most node needed
             */
            map.put(hd, node.data);

            /*
             * Left child
             */
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            /*
             * Right child
             */
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        /*
         * Extract sorted values
         */
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        /*
                10
               /  \
             20    30
            /  \
          40    60
         */

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);

        System.out.println("Bottom View: " + bottomView(root));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

BFS Traversal:
Each node visited once
= O(N)

TreeMap insertion:
Each insertion = O(log N)

Total:
O(N × log N)

Final Time Complexity:
O(N log N)

===========================================================
SPACE COMPLEXITY
===========================================================

Queue:
O(N)

TreeMap:
O(N)

Total:
O(N)

===========================================================
*/