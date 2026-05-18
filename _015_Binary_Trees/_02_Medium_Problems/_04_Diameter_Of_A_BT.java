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

public class _04_Diameter_Of_A_BT {

    // Function to find diameter
    public int diameterOfBinaryTree(TreeNode root) {

        // Array used as reference variable
        int[] diameter = new int[1];

        diameter[0] = 0;

        // Calculate height
        // and update diameter
        height(root, diameter);

        // Return final diameter
        return diameter[0];
    }

    // Function to calculate height
    private int height(TreeNode node,
                       int[] diameter) {

        // Base Case
        if (node == null) {

            return 0;
        }

        // Calculate left subtree height
        int leftHeight =
                height(node.left, diameter);

        // Calculate right subtree height
        int rightHeight =
                height(node.right, diameter);

        // Update diameter
        diameter[0] = Math.max(
                diameter[0],
                leftHeight + rightHeight
        );

        // Return current height
        return 1 + Math.max(
                leftHeight,
                rightHeight
        );
    }

    public static void main(String[] args) {

        /*
                   1
                  / \
                 2   3
                / \
               4   5
        */

        // Creating tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        // Object of class
        _04_Diameter_Of_A_BT solution =
                new _04_Diameter_Of_A_BT();

        // Find diameter
        int result =
                solution.diameterOfBinaryTree(root);

        // Print result
        System.out.println(
                "Diameter of Tree: "
                        + result);
    }
}