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

public class _05_Maximum_Path_Sum {

    // Function to calculate maximum path sum
    public int maxPathSum(TreeNode root) {

        // Stores global maximum answer
        int[] maxi = {
                Integer.MIN_VALUE
        };

        // Start recursion
        findMaxPathSum(root, maxi);

        // Return answer
        return maxi[0];
    }

    // Recursive helper function
    private int findMaxPathSum(
            TreeNode root,
            int[] maxi) {

        // Base Case
        if (root == null) {

            return 0;
        }

        // Find left subtree maximum
        // Ignore negative paths
        int leftMaxPath = Math.max(
                0,
                findMaxPathSum(
                        root.left,
                        maxi));

        // Find right subtree maximum
        int rightMaxPath = Math.max(
                0,
                findMaxPathSum(
                        root.right,
                        maxi));

        // Current maximum path
        int currentPath = leftMaxPath
                + rightMaxPath
                + root.data;

        // Update global maximum
        maxi[0] = Math.max(
                maxi[0],
                currentPath);

        // Return one branch upward
        return root.data
                + Math.max(
                        leftMaxPath,
                        rightMaxPath);
    }

    public static void main(String[] args) {

        /*
         * -10
         * / \
         * 9 20
         * / \
         * 15 7
         */

        // Creating tree
        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);

        root.right.right = new TreeNode(7);

        // Object of class
        _05_Maximum_Path_Sum solution = new _05_Maximum_Path_Sum();

        // Find maximum path sum
        int result = solution.maxPathSum(root);

        // Print result
        System.out.println(
                "Maximum Path Sum: "
                        + result);
    }
}