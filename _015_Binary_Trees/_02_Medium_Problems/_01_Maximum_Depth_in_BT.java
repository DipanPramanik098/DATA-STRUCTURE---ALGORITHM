package _015_Binary_Trees._02_Medium_Problems;

// Tree Node Class
class TreeNode {

    // Value of node
    int val;

    // Left child reference
    TreeNode left;

    // Right child reference
    TreeNode right;

    // Constructor
    TreeNode(int x) {

        val = x;

        left = null;

        right = null;
    }
}

public class _01_Maximum_Depth_in_BT {

    // Function to find maximum depth
    public int maxDepth(TreeNode root) {

        // Base Case
        // If tree is empty
        if (root == null) {

            return 0;
        }

        // Recursively find
        // left subtree depth
        int left =
                maxDepth(root.left);

        // Recursively find
        // right subtree depth
        int right =
                maxDepth(root.right);

        // Return current depth
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        /*
                   1
                  / \
                 2   3
                    /
                   6
        */

        // Creating tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.right.left = new TreeNode(6);

        // Object of class
        _01_Maximum_Depth_in_BT solution =
                new _01_Maximum_Depth_in_BT();

        // Find maximum depth
        int depth =
                solution.maxDepth(root);

        // Print answer
        System.out.println(
                "Maximum Depth: " + depth);
    }
}