package _015_Binary_Trees._01_Introduction_And_Traversals;

import java.util.ArrayList;
import java.util.List;

// Tree Node Class
class TreeNode {

    // Data of node
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

public class _03_PreOrder {

    // Helper function for preorder traversal
    private void preorderTraversal(TreeNode node,
                                   List<Integer> ans) {

        // Base Case
        // If node becomes null
        // stop recursion
        if (node == null) {
            return;
        }

        // Step 1:
        // Visit current node
        ans.add(node.data);

        // Step 2:
        // Traverse left subtree
        preorderTraversal(node.left, ans);

        // Step 3:
        // Traverse right subtree
        preorderTraversal(node.right, ans);
    }

    // Function to start preorder traversal
    public List<Integer> preorder(TreeNode root) {

        // List to store answer
        List<Integer> ans = new ArrayList<>();

        // Call recursive helper function
        preorderTraversal(root, ans);

        // Return traversal result
        return ans;
    }

    public static void main(String[] args) {

        /*
                  1
                 / \
                2   3
               / \
              4   5
        */

        // Creating binary tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        // Object of class
        _03_PreOrder solution =
                new _03_PreOrder();

        // Get preorder traversal
        List<Integer> result =
                solution.preorder(root);

        // Print traversal
        System.out.print("Preorder Traversal: ");

        for (int val : result) {

            System.out.print(val + " ");
        }
    }
}