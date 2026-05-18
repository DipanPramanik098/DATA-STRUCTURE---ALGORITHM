package _015_Binary_Trees._03_FAQs;

import java.util.*;

// Common Tree Node Class
class TreeNode {

    // Value of node
    int data;

    // Left child
    TreeNode left;

    // Right child
    TreeNode right;

    // Constructor
    TreeNode(int val) {

        data = val;

        left = null;

        right = null;
    }
}

public class _01_ZigZag {

    // Function for Zig Zag Traversal
    public List<List<Integer>> zigzagLevelOrder(
            TreeNode root) {

        // Final result list
        List<List<Integer>> result = new ArrayList<>();

        // Edge Case
        if (root == null) {

            return result;
        }

        // Queue for BFS Traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Insert root node
        queue.offer(root);

        // Direction flag
        boolean leftToRight = true;

        // BFS Traversal
        while (!queue.isEmpty()) {

            // Current level size
            int size = queue.size();

            // Store current level
            List<Integer> level = new ArrayList<>(
                    Collections.nCopies(
                            size,
                            0));

            // Traverse all nodes
            // of current level
            for (int i = 0; i < size; i++) {

                // Remove front node
                TreeNode node = queue.poll();

                // Decide index
                int index;

                if (leftToRight) {

                    index = i;
                } else {

                    index = size - 1 - i;
                }

                // Insert node value
                level.set(index, node.data);

                // Add left child
                if (node.left != null) {

                    queue.offer(node.left);
                }

                // Add right child
                if (node.right != null) {

                    queue.offer(node.right);
                }
            }

            // Add current level
            // into final result
            result.add(level);

            // Change direction
            leftToRight = !leftToRight;
        }

        // Return final answer
        return result;
    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        // Creating Binary Tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        root.right.right = new TreeNode(7);

        // Object Creation
        _01_ZigZag solution = new _01_ZigZag();

        // Get Zig Zag Traversal
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print Result
        System.out.println(
                "Zig Zag Traversal:");

        for (List<Integer> level : result) {

            System.out.println(level);
        }
    }
}