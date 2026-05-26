package _015_Binary_Trees._03_FAQs;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class _02_Boundary_Traversal {

    // Check if node is leaf
    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    // Add Left Boundary
    public static void addLeftBoundary(TreeNode root,
                                       List<Integer> res) {

        TreeNode curr = root.left;

        while (curr != null) {

            if (!isLeaf(curr)) {
                res.add(curr.data);
            }

            // Prefer left child
            if (curr.left != null) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
    }

    // Add Leaf Nodes
    public static void addLeaves(TreeNode root,
                                 List<Integer> res) {

        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    // Add Right Boundary
    public static void addRightBoundary(TreeNode root,
                                        List<Integer> res) {

        TreeNode curr = root.right;

        Stack<Integer> stack = new Stack<>();

        while (curr != null) {

            if (!isLeaf(curr)) {
                stack.push(curr.data);
            }

            // Prefer right child
            if (curr.right != null) {
                curr = curr.right;
            }
            else {
                curr = curr.left;
            }
        }

        // Reverse order
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    // Main Boundary Traversal Function
    public static List<Integer> boundaryTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // Add root if not leaf
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        // Left Boundary
        addLeftBoundary(root, res);

        // Leaf Nodes
        addLeaves(root, res);

        // Right Boundary
        addRightBoundary(root, res);

        return res;
    }

    public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
                / \
               8   9
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        List<Integer> ans = boundaryTraversal(root);

        System.out.println(ans);
    }
}