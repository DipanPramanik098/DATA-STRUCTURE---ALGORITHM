package _015_Binary_Trees._03_FAQs;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given:
1. Root of Binary Tree
2. Target node value

Fire starts from target node.

In 1 second, fire spreads to:
- Left child
- Right child
- Parent

Find minimum time needed to burn entire tree.

-----------------------------------------------------------
Example 1:

                1
              /   \
             2     3
            /     / \
           4     5   6
            \
             7

Target = 1

Second 0:
[1]

Second 1:
[2,3]

Second 2:
[4,5,6]

Second 3:
[7]

Answer:
3

-----------------------------------------------------------
Example 2:

                1
              /   \
             2     3
              \      \
               5      4

Target = 4

Second 0:
[4]

Second 1:
[3]

Second 2:
[1]

Second 3:
[2]

Second 4:
[5]

Answer:
4

===========================================================
INTUITION
===========================================================

Normal tree traversal only goes DOWN.

But fire spreads:
DOWN + UP

So tree behaves like a GRAPH.

Need:
Node connections in all directions.

Children already available:
left / right

Need:
Parent mapping

Then:
Run BFS from target.

Each BFS level = 1 second

Maximum BFS depth = total burn time

===========================================================
APPROACH
===========================================================

STEP 1:
Create parent mapping

Also find target node

STEP 2:
Start BFS from target node

STEP 3:
Visit:
- left
- right
- parent

STEP 4:
Use visited set
to avoid infinite looping

STEP 5:
Each BFS level = 1 second

Return total seconds

===========================================================
DRY RUN
===========================================================

Tree:

                1
              /   \
             2     3
            / \   / \
           6   5 8   4

Target = 4

--------------------------------
Parent Mapping:

2 -> 1
3 -> 1
6 -> 2
5 -> 2
8 -> 3
4 -> 3

--------------------------------
Start fire from 4

Time = 0

Burned:
[4]

--------------------------------
Time = 1

From 4:
parent = 3

Burned:
[3]

--------------------------------
Time = 2

From 3:
left = 8
parent = 1

Burned:
[8,1]

--------------------------------
Time = 3

From 1:
left = 2

Burned:
[2]

--------------------------------
Time = 4

From 2:
left = 6
right = 5

Burned:
[6,5]

Tree fully burned.

Answer:
4

===========================================================
MCQ ANSWER
===========================================================

Input:
root = [1,2,3,6,5,8,4]
target = 4

Correct Answer:
4

===========================================================
*/

public class _11_Minimum_time_taken_to_burn_the_BT_from_A_Given_Node {

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
    public static int minTimeToBurn(TreeNode root, int targetValue) {

        if (root == null) {
            return 0;
        }

        /*
         * Parent mapping
         */
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        /*
         * Find target node
         */
        TreeNode targetNode = mapParentsAndFindTarget(
                root,
                parentMap,
                targetValue
        );

        /*
         * Burn tree
         */
        return burnTree(targetNode, parentMap);
    }

    /*
     * Create parent mapping + find target
     */
    private static TreeNode mapParentsAndFindTarget(
            TreeNode root,
            Map<TreeNode, TreeNode> parentMap,
            int targetValue
    ) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode target = null;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current.data == targetValue) {
                target = current;
            }

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }

        return target;
    }

    /*
     * BFS burning simulation
     */
    private static int burnTree(TreeNode target,
                                Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int time = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            boolean burnedNewNode = false;

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                /*
                 * LEFT child
                 */
                if (current.left != null &&
                        !visited.contains(current.left)) {

                    visited.add(current.left);
                    queue.offer(current.left);
                    burnedNewNode = true;
                }

                /*
                 * RIGHT child
                 */
                if (current.right != null &&
                        !visited.contains(current.right)) {

                    visited.add(current.right);
                    queue.offer(current.right);
                    burnedNewNode = true;
                }

                /*
                 * PARENT
                 */
                TreeNode parent = parentMap.get(current);

                if (parent != null &&
                        !visited.contains(parent)) {

                    visited.add(parent);
                    queue.offer(parent);
                    burnedNewNode = true;
                }
            }

            /*
             * Increase time only if fire spread
             */
            if (burnedNewNode) {
                time++;
            }
        }

        return time;
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \   / \
               6   5 8   4
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(4);

        int target = 4;

        System.out.println(minTimeToBurn(root, target));
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Parent Mapping:
O(N)

Burn BFS:
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