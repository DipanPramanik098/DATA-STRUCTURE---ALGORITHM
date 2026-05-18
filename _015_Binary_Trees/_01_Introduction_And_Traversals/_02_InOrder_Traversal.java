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

public class _02_InOrder_Traversal {

    // Recursive inorder traversal function
    private void recursiveInorder(TreeNode root,
                                  List<Integer> arr) {

        // Base Case
        // If node becomes null
        // stop recursion
        if (root == null) {
            return;
        }

        // Step 1:
        // Traverse left subtree
        recursiveInorder(root.left, arr);

        // Step 2:
        // Process current node
        arr.add(root.data);

        // Step 3:
        // Traverse right subtree
        recursiveInorder(root.right, arr);
    }

    // Function to start inorder traversal
    public List<Integer> inorder(TreeNode root) {

        // List to store answer
        List<Integer> arr = new ArrayList<>();

        // Call recursive function
        recursiveInorder(root, arr);

        // Return traversal result
        return arr;
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
        _02_InOrder_Traversal sol =
                new _02_InOrder_Traversal();

        // Get inorder traversal
        List<Integer> result = sol.inorder(root);

        // Print traversal
        System.out.print("Inorder Traversal: ");

        for (int val : result) {

            System.out.print(val + " ");
        }
    }
}