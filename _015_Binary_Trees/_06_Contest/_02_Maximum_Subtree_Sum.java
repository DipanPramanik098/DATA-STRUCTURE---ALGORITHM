package _015_Binary_Trees._06_Contest;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given a Binary Tree.

Each node has a value attached from array nums.

Rule:
ith node value = nums[i - 1]

Need to find:

1. Node having maximum subtree sum
2. Maximum subtree sum

Return:
[nodeNumber, maxSum]

-----------------------------------------------------------
Example 1:

nums = [1, 2, 3, 4, 5, 6]

Tree:

            1
          /   \
         2     3
          \   / \
           4 5   6

Subtree sums:

Node 6:
6

Node 5:
5

Node 4:
4

Node 3:
3 + 5 + 6 = 14

Node 2:
2 + 4 = 6

Node 1:
1 + 2 + 3 + 4 + 5 + 6 = 21

Answer:
[1, 21]

===========================================================
INTUITION
===========================================================

Subtree sum means:

Current node
+ left subtree sum
+ right subtree sum

Formula:

subtreeSum =
leftSum + rightSum + nodeValue

-----------------------------------------------------------

To calculate parent sum,
children sums must already be known.

So traversal should be:

POSTORDER

Because:

Left -> Right -> Root

===========================================================
APPROACH
===========================================================

STEP 1:
Use DFS postorder traversal

STEP 2:
For each node:

Find:
left subtree sum

Find:
right subtree sum

STEP 3:
Get current node value:

nums[node.data - 1]

Because nodes are 1-based.

STEP 4:
Calculate:

total =
left + right + current value

STEP 5:
Update maximum:

if total > maxSum

===========================================================
DRY RUN
===========================================================

nums:

[1, -4, 3, -2, 5, 6]

Tree:

            1
          /   \
         2     3
          \   / \
          4  5   6

--------------------------------

Node 4:

value = -2

sum = -2

max = -2

--------------------------------

Node 2:

value = -4

sum = -4 + (-2)

= -6

--------------------------------

Node 5:

sum = 5

--------------------------------

Node 6:

sum = 6

--------------------------------

Node 3:

sum =
3 + 5 + 6

= 14

max = 14

--------------------------------

Node 1:

sum =
1 + (-6) + 14

= 9

Final:

Node = 3
Sum = 14

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

public class _02_Maximum_Subtree_Sum {

    /*
     * Maximum subtree sum
     */
    private int maxSum = Integer.MIN_VALUE;

    /*
     * Node with maximum subtree sum
     */
    private int maxNode = -1;

    /*
     * Main function
     */
    public int[] maxSubtreeSum(TreeNode root, int[] nums) {

        dfs(root, nums);

        return new int[]{maxNode, maxSum};
    }

    /*
     * Postorder DFS
     */
    private int dfs(TreeNode node, int[] nums) {

        /*
         * Base case
         */
        if (node == null) {
            return 0;
        }

        /*
         * Left subtree sum
         */
        int leftSum = dfs(node.left, nums);

        /*
         * Right subtree sum
         */
        int rightSum = dfs(node.right, nums);

        /*
         * Current node value
         */
        int currentValue = nums[node.data - 1];

        /*
         * Current subtree sum
         */
        int totalSum =
                leftSum +
                rightSum +
                currentValue;

        /*
         * Update answer
         */
        if (totalSum > maxSum) {
            maxSum = totalSum;
            maxNode = node.data;
        }

        return totalSum;
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Each node visited once.

O(N)

===========================================================
SPACE COMPLEXITY
===========================================================

Recursive stack space:

Worst case (skew tree):
O(N)

Balanced tree:
O(log N)

===========================================================
*/