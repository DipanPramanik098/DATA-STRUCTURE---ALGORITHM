package _015_Binary_Trees._02_Medium_Problems;

// Tree Node Class
class TreeNode {

    // Value of node
    int data;

    // Left child reference
    TreeNode left;

    // Right child reference
    TreeNode right;

    // Constructor
    TreeNode(int val) {

        data = val;

        left = null;

        right = null;
    }
}

public class _02_Check_Identical {

    // Function to check
    // whether trees are identical
    public boolean isSameTree(TreeNode p,
                              TreeNode q) {

        // Case 1:
        // Both nodes are null
        if (p == null && q == null) {

            return true;
        }

        // Case 2:
        // One node is null
        if (p == null || q == null) {

            return false;
        }

        // Case 3:
        // Values are different
        if (p.data != q.data) {

            return false;
        }

        // Case 4:
        // Recursively compare
        // left and right subtrees
        return isSameTree(p.left, q.left)
                &&
               isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        /*
                  Tree 1
                     1
                    / \
                   2   3

                  Tree 2
                     1
                    / \
                   2   3
        */

        // Creating first tree
        TreeNode tree1 = new TreeNode(1);

        tree1.left = new TreeNode(2);

        tree1.right = new TreeNode(3);

        // Creating second tree
        TreeNode tree2 = new TreeNode(1);

        tree2.left = new TreeNode(2);

        tree2.right = new TreeNode(3);

        // Object of class
        _02_Check_Identical solution =
                new _02_Check_Identical();

        // Check trees
        boolean result =
                solution.isSameTree(tree1, tree2);

        // Print answer
        System.out.println(
                "Are Trees Identical? "
                        + result);
    }
}