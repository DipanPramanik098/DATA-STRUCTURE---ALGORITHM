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

public class _06_Check_Symmetrical_BT {

    // Function to check
    // whether tree is symmetric
    public boolean isSymmetric(TreeNode root) {

        // Empty tree is symmetric
        if (root == null) {

            return true;
        }

        // Compare left and right subtree
        return symmetry(
                root.left,
                root.right
        );
    }

    // Recursive mirror checking function
    private boolean symmetry(
            TreeNode left,
            TreeNode right
    ) {

        // Both nodes are null
        if (left == null
                && right == null) {

            return true;
        }

        // One node is null
        if (left == null
                || right == null) {

            return false;
        }

        // Values are different
        if (left.data != right.data) {

            return false;
        }

        // Recursively compare mirror nodes
        return symmetry(
                left.left,
                right.right
        )
        &&
        symmetry(
                left.right,
                right.left
        );
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     2
                / \   / \
               3   4 4   3
        */

        // Creating tree
        TreeNode root =
                new TreeNode(1);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(2);

        root.left.left =
                new TreeNode(3);

        root.left.right =
                new TreeNode(4);

        root.right.left =
                new TreeNode(4);

        root.right.right =
                new TreeNode(3);

        // Object of class
        _06_Check_Symmetrical_BT solution =
                new _06_Check_Symmetrical_BT();

        // Check symmetry
        boolean result =
                solution.isSymmetric(root);

        // Print result
        if (result) {

            System.out.println(
                    "Tree is Symmetric"
            );
        }
        else {

            System.out.println(
                    "Tree is Not Symmetric"
            );
        }
    }
}