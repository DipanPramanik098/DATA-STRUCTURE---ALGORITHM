package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given the root of a Binary Tree,
return ALL root-to-leaf paths.

Root-to-leaf path means:
A path starting from root and ending at a leaf node.

Leaf Node:
A node having NO left child and NO right child.

Return all paths.

-----------------------------------------------------------
Example 1:

            1
          /   \
         2     3
          \      \
           5      4

Output:
[
 [1, 2, 5],
 [1, 3, 4]
]

-----------------------------------------------------------
Example 2:

            1
          /   \
         2     3
        / \
       4   5

Output:
[
 [1, 2, 4],
 [1, 2, 5],
 [1, 3]
]

===========================================================
INTUITION
===========================================================

We need ALL paths.

This means:
Explore every possible branch.

Best approach:
DFS + Backtracking

Why DFS?

Because DFS naturally goes:
Root → Left → Left → ... until leaf

At every node:
Add current node to path.

If leaf node:
Store current path.

Then BACKTRACK:
Remove current node
so other paths can be explored.

Example:

Path:
[1]

Go left:
[1,2]

Go left:
[1,2,4]

Leaf found:
Save it

Backtrack:
[1,2]

Go right:
[1,2,5]

Leaf found:
Save it

===========================================================
APPROACH
===========================================================

Step 1:
Create answer list
to store all paths

Step 2:
Create temporary current path list

Step 3:
Run DFS

Inside DFS:
- Add current node to path

If leaf:
- Copy path into answer list

Else:
- DFS left
- DFS right

Step 4:
Backtrack
Remove last node

===========================================================
DRY RUN
===========================================================

Tree:

            1
          /   \
         2     3
        /     / \
       4     5   6
        \
         7

Start:
path = []

Visit 1:
path = [1]

Go left:
Visit 2
path = [1,2]

Go left:
Visit 4
path = [1,2,4]

Go right:
Visit 7
path = [1,2,4,7]

Leaf found
Store:
[[1,2,4,7]]

Backtrack:
path = [1,2,4]

Backtrack:
path = [1,2]

Backtrack:
path = [1]

Go right:
Visit 3
path = [1,3]

Go left:
Visit 5
path = [1,3,5]

Leaf found
Store:
[
 [1,2,4,7],
 [1,3,5]
]

Backtrack

Go right:
Visit 6
path = [1,3,6]

Leaf found

Final:
[
 [1,2,4,7],
 [1,3,5],
 [1,3,6]
]

===========================================================
MCQ ANSWER
===========================================================

Correct Answer:

[
 [1,2,4,7],
 [1,3,5],
 [1,3,6]
]

===========================================================
*/

public class _07_Print_Root_To_Leaf_Path {

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
    public static List<List<Integer>> rootToLeafPaths(TreeNode root) {

        // Stores all paths
        List<List<Integer>> allPaths = new ArrayList<>();

        // Temporary path
        List<Integer> currentPath = new ArrayList<>();

        // Start DFS
        dfs(root, currentPath, allPaths);

        return allPaths;
    }

    /*
     * DFS + Backtracking
     */
    private static void dfs(TreeNode node,
                            List<Integer> currentPath,
                            List<List<Integer>> allPaths) {

        // Base case
        if (node == null) {
            return;
        }

        /*
         * Add current node
         */
        currentPath.add(node.data);

        /*
         * Leaf node
         */
        if (node.left == null && node.right == null) {

            /*
             * Store copy of path
             */
            allPaths.add(new ArrayList<>(currentPath));
        }
        else {

            /*
             * Explore left subtree
             */
            dfs(node.left, currentPath, allPaths);

            /*
             * Explore right subtree
             */
            dfs(node.right, currentPath, allPaths);
        }

        /*
         * Backtracking
         * Remove current node
         */
        currentPath.remove(currentPath.size() - 1);
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                /     / \
               4     5   6
                \
                 7
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(rootToLeafPaths(root));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Each node visited once:
O(N)

Copying paths:
In worst case total copying can be O(N)

Final:
O(N)

===========================================================
SPACE COMPLEXITY
===========================================================

Recursive stack:
O(H)

Path storage:
O(H)

Answer storage:
O(N)

Worst Case:
O(N)

===========================================================
*/