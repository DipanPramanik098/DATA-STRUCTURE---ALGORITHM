package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given the root of a Binary Tree and two nodes p and q,
find the Lowest Common Ancestor (LCA).

Lowest Common Ancestor means:
The LOWEST node in the tree that has both p and q
as descendants.

Note:
A node can be its own descendant.

-----------------------------------------------------------
Example 1:

                3
              /   \
             5     1
            / \   / \
           6   2 0   8
              / \
             7   4

p = 5
q = 1

Output:
3

Explanation:
5 is in left subtree
1 is in right subtree

So common ancestor = 3

-----------------------------------------------------------
Example 2:

Same tree

p = 5
q = 4

Output:
5

Explanation:
5 itself is ancestor of 4

===========================================================
INTUITION
===========================================================

For every node, 3 possibilities:

1. p and q both in LEFT subtree
   → LCA exists in LEFT

2. p and q both in RIGHT subtree
   → LCA exists in RIGHT

3. One in LEFT, one in RIGHT
   → Current node is LCA

Special case:
If current node is p or q,
return it immediately.

===========================================================
APPROACH
===========================================================

Step 1:
If root is null → return null

Step 2:
If root == p OR root == q
return root

Step 3:
Search in left subtree

Step 4:
Search in right subtree

Step 5:
Analyze result

Case 1:
left == null
return right

Case 2:
right == null
return left

Case 3:
both non-null
return root

===========================================================
DRY RUN
===========================================================

Tree:

                7
              /   \
             1     2
            / \   / \
           8  10 4   5
            \
             6

Find:
p = 6
q = 10

--------------------------------
Start at 7

Search left:
Go to 1

Search left:
Go to 8

Search right:
Go to 6

Found p
Return 6

Back to 8:
left = null
right = 6

Return 6

Back to 1:
Search right:
Go to 10

Found q
Return 10

At node 1:
left = 6
right = 10

Both non-null
Return 1

Back to 7:
right subtree returns null

Return 1

Final Answer:
1

===========================================================
MCQ ANSWER
===========================================================

Correct Answer:
1

===========================================================
*/

public class _08_LCA_of_BT {

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
     * LCA Function
     */
    public static TreeNode lowestCommonAncestor(TreeNode root,
                                                TreeNode p,
                                                TreeNode q) {

        /*
         * Base Case 1:
         * Tree ended
         */
        if (root == null) {
            return null;
        }

        /*
         * Base Case 2:
         * Found p or q
         */
        if (root == p || root == q) {
            return root;
        }

        /*
         * Search in left subtree
         */
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        /*
         * Search in right subtree
         */
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /*
         * Case 1:
         * p and q both in right subtree
         */
        if (left == null) {
            return right;
        }

        /*
         * Case 2:
         * p and q both in left subtree
         */
        if (right == null) {
            return left;
        }

        /*
         * Case 3:
         * One in left, one in right
         */
        return root;
    }

    /*
     * Main Method
     */
    public static void main(String[] args) {

        /*
                    7
                  /   \
                 1     2
                / \   / \
               8  10 4   5
                \
                 6
         */

        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(10);

        root.left.left.right = new TreeNode(6);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode p = root.left.left.right;   // 6
        TreeNode q = root.left.right;        // 10

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("LCA: " + lca.data);
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Each node visited once.

O(N)

Where:
N = Number of nodes

===========================================================
SPACE COMPLEXITY
===========================================================

Recursive stack depends on height.

O(H)

Best Case (Balanced Tree):
O(log N)

Worst Case (Skew Tree):
O(N)

===========================================================
*/