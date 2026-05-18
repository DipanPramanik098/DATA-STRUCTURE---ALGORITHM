package _015_Binary_Trees._01_Introduction_And_Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class _04_Level_Order {

    // Function for Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {

        // Final answer list
        List<List<Integer>> ans = new ArrayList<>();

        // If tree is empty
        if (root == null) {

            return ans;
        }

        // Queue for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();

        // Insert root node
        q.add(root);

        // Run until queue becomes empty
        while (!q.isEmpty()) {

            // Number of nodes
            // in current level
            int size = q.size();

            // List for current level
            List<Integer> level =
                    new ArrayList<>();

            // Process all nodes
            // of current level
            for (int i = 0; i < size; i++) {

                // Remove front node
                TreeNode node = q.poll();

                // Store node value
                level.add(node.data);

                // Insert left child
                if (node.left != null) {

                    q.add(node.left);
                }

                // Insert right child
                if (node.right != null) {

                    q.add(node.right);
                }
            }

            // Add current level
            // into final answer
            ans.add(level);
        }

        // Return final traversal
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

        // Creating tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        // Object of class
        _04_Level_Order solution =
                new _04_Level_Order();

        // Get level order traversal
        List<List<Integer>> result =
                solution.levelOrder(root);

        // Print traversal
        System.out.println(
                "Level Order Traversal:");

        for (List<Integer> level : result) {

            System.out.println(level);
        }
    }
}