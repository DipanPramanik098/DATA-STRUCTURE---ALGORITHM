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

public class _03_Vertical_order_traversal {

    // Tuple Class
    static class Tuple {

        TreeNode node;
        int x; // Column
        int y; // Level

        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    // Vertical Traversal Function
    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // column -> row -> nodes
        TreeMap<Integer,
                TreeMap<Integer,
                PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();

        // root at (0,0)
        queue.offer(new Tuple(root, 0, 0));

        // BFS
        while (!queue.isEmpty()) {

            Tuple tuple = queue.poll();

            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            // Create structures if absent
            map.putIfAbsent(x, new TreeMap<>());

            map.get(x).putIfAbsent(y,
                    new PriorityQueue<>());

            // Add node value
            map.get(x).get(y).offer(node.data);

            // Left Child
            if (node.left != null) {

                queue.offer(
                        new Tuple(
                                node.left,
                                x - 1,
                                y + 1
                        )
                );
            }

            // Right Child
            if (node.right != null) {

                queue.offer(
                        new Tuple(
                                node.right,
                                x + 1,
                                y + 1
                        )
                );
            }
        }

        // Build Final Result
        for (TreeMap<Integer,
                PriorityQueue<Integer>> yMap
                : map.values()) {

            List<Integer> column =
                    new ArrayList<>();

            for (PriorityQueue<Integer> pq
                    : yMap.values()) {

                while (!pq.isEmpty()) {

                    column.add(pq.poll());
                }
            }

            result.add(column);
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                   1
                 /   \
                2     3
               / \   / \
              4   5 6   7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans =
                verticalTraversal(root);

        System.out.println(ans);
    }
}