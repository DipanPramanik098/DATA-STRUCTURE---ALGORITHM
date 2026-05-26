package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given the root of a Binary Tree:

1. RIGHT VIEW:
Return nodes visible when looking from RIGHT side.

2. LEFT VIEW:
Return nodes visible when looking from LEFT side.

Return nodes from TOP to BOTTOM.

-----------------------------------------------------------
Example:

            1
          /   \
         2     3
          \      \
           5      4

Right View:
[1, 3, 4]

Left View:
[1, 2, 5]

===========================================================
INTUITION
===========================================================

At every level:
- Right View → first node seen from RIGHT
- Left View → first node seen from LEFT

Use DFS recursion.

For LEFT VIEW:
Visit:
Root -> Left -> Right

For RIGHT VIEW:
Visit:
Root -> Right -> Left

Logic:
If current level is visited first time,
store that node.

Condition:
if(result.size() == level)

Why?
Because:
Level 0 → first node
Level 1 → first node
Level 2 → first node

===========================================================
APPROACH
===========================================================

LEFT VIEW:
1. Create answer list
2. Recursive DFS
3. If level seen first time → store node
4. Visit LEFT first
5. Then RIGHT

RIGHT VIEW:
1. Create answer list
2. Recursive DFS
3. If level seen first time → store node
4. Visit RIGHT first
5. Then LEFT

===========================================================
DRY RUN (RIGHT VIEW)
===========================================================

Tree:

            5
          /   \
         1     2
        /     / \
       8     4   5
        \
         6

Call:
rightView(root)

Level 0:
Node = 5
Store 5

Level 1:
Go RIGHT → 2
Store 2

Level 2:
Go RIGHT → 5
Store 5

Level 3:
No right child
Go left branches

Node = 6
Store 6

Answer:
[5, 2, 5, 6]

===========================================================
MCQ ANSWER
===========================================================

Correct Answer:
[5, 2, 5, 6]

===========================================================
*/

public class _06_Right_And_Left_View_Of_bt {

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
     * RIGHT VIEW FUNCTION
     */
    public static List<Integer> rightView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        rightDFS(root, 0, ans);

        return ans;
    }

    /*
     * LEFT VIEW FUNCTION
     */
    public static List<Integer> leftView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        leftDFS(root, 0, ans);

        return ans;
    }

    /*
     * RIGHT DFS
     * Root -> Right -> Left
     */
    private static void rightDFS(TreeNode node, int level, List<Integer> ans) {

        // Base case
        if (node == null) {
            return;
        }

        /*
         * First node of this level
         */
        if (ans.size() == level) {
            ans.add(node.data);
        }

        // Visit right first
        rightDFS(node.right, level + 1, ans);

        // Then left
        rightDFS(node.left, level + 1, ans);
    }

    /*
     * LEFT DFS
     * Root -> Left -> Right
     */
    private static void leftDFS(TreeNode node, int level, List<Integer> ans) {

        // Base case
        if (node == null) {
            return;
        }

        /*
         * First node of this level
         */
        if (ans.size() == level) {
            ans.add(node.data);
        }

        // Visit left first
        leftDFS(node.left, level + 1, ans);

        // Then right
        leftDFS(node.right, level + 1, ans);
    }

    /*
     * MAIN METHOD
     */
    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                  \      \
                   5      4
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println("Right View: " + rightView(root));
        System.out.println("Left View : " + leftView(root));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Each node visited exactly once.

Total:
O(N)

Where:
N = Number of nodes

===========================================================
SPACE COMPLEXITY
===========================================================

Recursive stack depends on tree height.

O(H)

Best Case (Balanced Tree):
O(log N)

Worst Case (Skew Tree):
O(N)

===========================================================
*/