package _015_Binary_Trees._04_Construction_Problems;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Design:

1. Serialize Binary Tree
2. Deserialize Binary Tree

Serialize:
Convert tree into string

Deserialize:
Convert string back into original tree

Condition:
Tree after deserialization must be EXACTLY same.

-----------------------------------------------------------
Example:

Tree:

            2
          /   \
         1     3

Serialized:
2,1,3,#,#,#,#,

Deserialize:
Same tree restored

===========================================================
INTUITION
===========================================================

Need to preserve full tree structure.

Problem:
If we store only values:

Example:

Tree A:
    1
   /
  2

Tree B:
    1
     \
      2

Both may look same if null positions ignored.

So:
NULL nodes must also be stored.

Use:
"#" for null

--------------------------------

Traversal choice?

Best:
LEVEL ORDER (BFS)

Why?

Because structure preserved naturally.

Example:

            7
          /   \
         3     15
              /  \
             9   20

Serialized:

7,3,15,#,#,9,20,#,#,#,#

===========================================================
APPROACH
===========================================================

SERIALIZE:

STEP 1:
Create StringBuilder

STEP 2:
Use queue for BFS

STEP 3:
For every node:

If null:
append "#"

Else:
append value
push left child
push right child

--------------------------------

DESERIALIZE:

STEP 1:
Split string by comma

STEP 2:
Create root

STEP 3:
Use queue

STEP 4:
For each node:
read next value

If not "#":
create left child

Read next value:
create right child

Continue until done

===========================================================
DRY RUN
===========================================================

Tree:

            10
          /    \
         20     30
        / \     /
       40 50   60

--------------------------------
SERIALIZE

Queue:
[10]

Output:
10,

--------------------------------
Process 10

Add:
20
30

Output:
10,20,30,

--------------------------------
Process 20

Add:
40
50

Output:
10,20,30,40,50,

--------------------------------
Process 30

Add:
60
#

Output:
10,20,30,40,50,60,#,

--------------------------------
Continue nulls

Final:
10,20,30,40,50,60,#,#,#,#,#,#,#,

--------------------------------
DESERIALIZE

Read:
10 -> root

Read:
20 -> left
30 -> right

Read:
40 -> left of 20
50 -> right of 20

Read:
60 -> left of 30

Tree restored

===========================================================
MCQ ANSWER
===========================================================

Input:
[10,20,30,40,50,60]

Correct Answer:
[10, 20, 30, 40, 50, 60]

===========================================================
*/

public class _04_Serialize_And_Deserialize_BT {

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
     * SERIALIZE
     */
    public static String serialize(TreeNode root) {

        /*
         * Empty tree
         */
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            /*
             * Null node
             */
            if (current == null) {
                sb.append("#,");
                continue;
            }

            /*
             * Normal node
             */
            sb.append(current.data).append(",");

            queue.offer(current.left);
            queue.offer(current.right);
        }

        return sb.toString();
    }

    /*
     * DESERIALIZE
     */
    public static TreeNode deserialize(String data) {

        /*
         * Empty string
         */
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");

        /*
         * Root
         */
        TreeNode root = new TreeNode(
                Integer.parseInt(values[0])
        );

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            /*
             * Left child
             */
            if (!values[index].equals("#")) {

                TreeNode leftNode = new TreeNode(
                        Integer.parseInt(values[index])
                );

                current.left = leftNode;
                queue.offer(leftNode);
            }

            index++;

            /*
             * Right child
             */
            if (!values[index].equals("#")) {

                TreeNode rightNode = new TreeNode(
                        Integer.parseInt(values[index])
                );

                current.right = rightNode;
                queue.offer(rightNode);
            }

            index++;
        }

        return root;
    }

    /*
     * Level order print
     */
    public static void printLevelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                System.out.print("null ");
                continue;
            }

            System.out.print(current.data + " ");

            if (current.left != null || current.right != null) {
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        /*
                    10
                  /    \
                 20     30
                / \     /
               40 50   60
         */

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

        root.right.left = new TreeNode(60);

        /*
         * Serialize
         */
        String serialized = serialize(root);

        System.out.println("Serialized:");
        System.out.println(serialized);

        /*
         * Deserialize
         */
        TreeNode restored = deserialize(serialized);

        System.out.println("Restored Tree:");
        printLevelOrder(restored);
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Serialize:
Visit every node once

O(N)

Deserialize:
Create every node once

O(N)

===========================================================
SPACE COMPLEXITY
===========================================================

Queue:
O(N)

String storage:
O(N)

Total:
O(N)

===========================================================
*/