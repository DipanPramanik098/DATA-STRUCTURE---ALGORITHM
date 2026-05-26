package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given:
1. Root of Binary Tree
2. Target node
3. Integer K

Return all nodes that are exactly K distance away
from target node.

Distance means:
Number of edges between nodes.

IMPORTANT:
Movement allowed in 3 directions:
1. Left child
2. Right child
3. Parent

Return answer in any order.

-----------------------------------------------------------
Example 1:

                3
              /   \
             5     1
            / \   / \
           6   2 0   8
              / \
             7   4

Target = 5
K = 2

Output:
[1, 7, 4]

Explanation:
Distance 1:
6, 2, 1

Distance 2:
7, 4, 1

-----------------------------------------------------------
Example 2:

Target = 5
K = 3

Output:
[0, 8]

===========================================================
INTUITION
===========================================================

Normal tree traversal only allows DOWN movement.

But here:
We also need UP movement.

Tree becomes like a GRAPH.

Need:
Node -> Parent connection

So solution has 2 phases:

Phase 1:
Create Parent Mapping

Example:
5 -> 3
6 -> 5
2 -> 5
7 -> 2

Phase 2:
Start BFS from target

Explore:
left
right
parent

Use visited set
otherwise infinite loop happens.

===========================================================
APPROACH
===========================================================

STEP 1:
Create parent map

Use BFS:
Store every node's parent

STEP 2:
Start BFS from target node

STEP 3:
Maintain visited set

STEP 4:
For every node:
Explore:
- left
- right
- parent

STEP 5:
When current distance == K
collect all nodes in queue

===========================================================
DRY RUN
===========================================================

Tree:

                1
              /   \
             2     3
            /     / \
           4     5   6

Target = 6
K = 2

--------------------------------
Parent Map:

2 -> 1
3 -> 1
4 -> 2
5 -> 3
6 -> 3

--------------------------------
Start BFS from 6

Queue:
[6]

Visited:
{6}

Distance = 0

--------------------------------
Distance = 1

From 6:
left = null
right = null
parent = 3

Queue:
[3]

Visited:
{6,3}

--------------------------------
Distance = 2

From 3:
left = 5
right = 6 (already visited)
parent = 1

Queue:
[5,1]

Distance reached K

Answer:
[5,1]

===========================================================
MCQ ANSWER
===========================================================

Correct Answer:
[1, 5]

(order can vary)

===========================================================
*/

public class _10_Print_Nodes_at_A_Distance_Of_k {

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
    public static List<Integer> distanceK(TreeNode root,
                                          TreeNode target,
                                          int k) {

        // Final answer
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        /*
         * STEP 1:
         * Create parent mapping
         */
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        /*
         * STEP 2:
         * BFS from target
         */
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            /*
             * If K reached
             */
            if (distance == k) {
                break;
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                /*
                 * LEFT child
                 */
                if (current.left != null &&
                        !visited.contains(current.left)) {

                    visited.add(current.left);
                    queue.offer(current.left);
                }

                /*
                 * RIGHT child
                 */
                if (current.right != null &&
                        !visited.contains(current.right)) {

                    visited.add(current.right);
                    queue.offer(current.right);
                }

                /*
                 * PARENT
                 */
                TreeNode parent = parentMap.get(current);

                if (parent != null &&
                        !visited.contains(parent)) {

                    visited.add(parent);
                    queue.offer(parent);
                }
            }

            distance++;
        }

        /*
         * Collect answer
         */
        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }

        return result;
    }

    /*
     * Create parent mapping
     */
    private static void markParents(TreeNode root,
                                    Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
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
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeNode target = root.right.right; // 6
        int k = 2;

        System.out.println(distanceK(root, target, k));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Parent mapping:
O(N)

BFS traversal:
O(N)

Total:
O(N)

===========================================================
SPACE COMPLEXITY
===========================================================

Parent Map:
O(N)

Visited Set:
O(N)

Queue:
O(N)

Total:
O(N)

===========================================================
*/