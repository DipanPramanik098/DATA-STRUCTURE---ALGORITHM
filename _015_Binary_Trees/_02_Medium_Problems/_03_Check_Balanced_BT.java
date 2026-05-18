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

public class _03_Check_Balanced_BT {

    // Function to check
    // whether tree is balanced
    public boolean isBalanced(TreeNode root) {

        // If function returns -1
        // tree is unbalanced
        return dfsHeight(root) != -1;
    }

    // Function to calculate height
    private int dfsHeight(TreeNode root) {

        // Base Case
        // Empty tree height = 0
        if (root == null) {

            return 0;
        }

        // Find left subtree height
        int leftHeight =
                dfsHeight(root.left);

        // If left subtree
        // is unbalanced
        if (leftHeight == -1) {

            return -1;
        }

        // Find right subtree height
        int rightHeight =
                dfsHeight(root.right);

        // If right subtree
        // is unbalanced
        if (rightHeight == -1) {

            return -1;
        }

        // Check balance condition
        if (Math.abs(leftHeight
                - rightHeight) > 1) {

            return -1;
        }

        // Return current node height
        return Math.max(leftHeight,
                rightHeight) + 1;
    }

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                 / \
                4   5
                     \
                      6
        */

        // Creating tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        root.left.right.right =
                new TreeNode(6);

        // Object of class
        _03_Check_Balanced_BT solution =
                new _03_Check_Balanced_BT();

        // Check balanced tree
        boolean result =
                solution.isBalanced(root);

        // Print result
        if (result) {

            System.out.println(
                    "Tree is Balanced");
        }
        else {

            System.out.println(
                    "Tree is Not Balanced");
        }
    }
}