package _015_Binary_Trees._06_Contest;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given a Binary Tree rooted at node 1.

Each node has a value:

value[i - 1]

Need to calculate greatness of every node.

Formula:

Greatness(i) =

value[i] * 1
+ value[parent(i)] * 2
+ value[grandparent(i)] * 3
+ ...

until root.

Return:
Maximum greatness in the entire tree.

-----------------------------------------------------------
Example:

Tree:

                1
              /   \
             2     3
            /
           4

Values:

[1, 2, 3, 4]

Greatness of node 4:

4×1 + 2×2 + 1×3

= 4 + 4 + 3

= 11

===========================================================
INTUITION
===========================================================

Brute force:

For every node:
travel upward to root
calculate weighted sum

Too slow.

Worst:

O(N²)

-----------------------------------------------------------

Observe pattern:

Node greatness:

current*1
+ parent*2
+ grandparent*3

Can be rewritten using prefix accumulation.

Example:

At parent:

greatness = G

For child:

All previous weights increase by 1
and child adds value*1

So maintain:

1. Prefix sum of values
2. Current greatness

===========================================================
MATH IDEA
===========================================================

Suppose:

Current node greatness = G
Sum of path values = S

Move to child with value X

New greatness:

= X*1 + current*2 + ancestors shifted

This becomes:

New greatness = G + S + X

So:

sum += X
greatness += sum

===========================================================
APPROACH
===========================================================

DFS traversal

At each node:

STEP 1:
Add current node value to prefix sum

STEP 2:
Update greatness

currentGreatness += prefixSum

STEP 3:
Update global maximum

STEP 4:
DFS left
DFS right

===========================================================
DRY RUN
===========================================================

Values:

[1,2,3,4,5]

Tree:

            1
          /   \
         2     3
        /     /
       4     5

--------------------------------

Node 1:

sum = 1

greatness = 1

max = 1

--------------------------------

Node 2:

sum = 1+2 = 3

greatness = 1+3 = 4

Formula:
2×1 + 1×2 = 4

--------------------------------

Node 4:

sum = 3+4 = 7

greatness = 4+7 = 11

Formula:
4×1 + 2×2 + 1×3 = 11

--------------------------------

Node 3:

sum = 1+3 = 4

greatness = 1+4 = 5

--------------------------------

Node 5:

sum = 4+5 = 9

greatness = 5+9 = 14

Formula:
5×1 + 3×2 + 1×3 = 14

Maximum:

14

===========================================================
*/
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}
public class _03_Tree_Greatness {

    /*
     * Maximum greatness found
     */
    private long maxGreatness = Long.MIN_VALUE;

    /*
     * Main function
     */
    public int treeGreatness(int[] value, TreeNode root) {

        dfs(root, value, 0L, 0L);

        return (int) maxGreatness;
    }

    /*
     * DFS traversal
     */
    private void dfs(
            TreeNode node,
            int[] value,
            long currentGreatness,
            long prefixSum
    ) {

        /*
         * Base case
         */
        if (node == null) {
            return;
        }

        /*
         * Current node value
         */
        long nodeValue = value[node.data - 1];

        /*
         * Update prefix sum
         */
        prefixSum += nodeValue;

        /*
         * Update greatness
         */
        currentGreatness += prefixSum;

        /*
         * Update maximum
         */
        maxGreatness =
                Math.max(maxGreatness, currentGreatness);

        /*
         * DFS left subtree
         */
        dfs(
                node.left,
                value,
                currentGreatness,
                prefixSum
        );

        /*
         * DFS right subtree
         */
        dfs(
                node.right,
                value,
                currentGreatness,
                prefixSum
        );
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Each node visited exactly once.

O(N)

===========================================================
SPACE COMPLEXITY
===========================================================

Recursive stack:

Worst case (skew tree):
O(N)

Balanced tree:
O(log N)

===========================================================
*/