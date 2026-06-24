package _018_Graphs;

import java.util.ArrayList;

public class _20_Number_Of_Operation_To_Make_Networl_Connected {

    /*
     * LeetCode 1319
     * Number of Operations to Make Network Connected
     *
     * Problem:
     * --------
     * We have n computers numbered from 0 to n-1.
     *
     * connections[i] = [u, v]
     * means computer u is connected to computer v.
     *
     * In one operation, we can remove an existing cable
     * and connect it between any two disconnected computers.
     *
     * Return the minimum number of operations required
     * to connect all computers.
     *
     * If it is impossible, return -1.
     *
     * --------------------------------------------------
     * DSU Idea:
     * --------------------------------------------------
     *
     * To connect n nodes, we need at least (n - 1) edges.
     *
     * If total edges < n - 1
     * => Impossible
     *
     * Otherwise:
     *
     * Count the number of connected components.
     *
     * If there are k components,
     * we need (k - 1) cables to connect them.
     *
     * Answer = Components - 1
     */

    // Parent Array
    static ArrayList<Integer> parent = new ArrayList<>();

    // Rank Array
    static ArrayList<Integer> rank = new ArrayList<>();


    /*
     * FIND OPERATION
     *
     * Returns Ultimate Parent
     *
     * Path Compression:
     * Makes future find operations faster.
     */
    public static int find(int node) {

        if (parent.get(node) == node) {
            return node;
        }

        int ultimateParent = find(parent.get(node));

        parent.set(node, ultimateParent);

        return parent.get(node);
    }


    /*
     * UNION BY RANK
     *
     * Connect two components.
     */
    public static void union(int u, int v) {

        int up_u = find(u);
        int up_v = find(v);

        if (up_u == up_v) {
            return;
        }

        if (rank.get(up_u) > rank.get(up_v)) {

            parent.set(up_v, up_u);

        } else if (rank.get(up_v) > rank.get(up_u)) {

            parent.set(up_u, up_v);

        } else {

            parent.set(up_v, up_u);

            rank.set(up_u, rank.get(up_u) + 1);
        }
    }


    /*
     * Main Logic
     */
    public static int makeConnected(int n, int[][] connections) {

        // Total number of edges
        int edges = connections.length;

        /*
         * Minimum edges required to connect
         * n nodes = n - 1
         */
        if (edges < n - 1) {
            return -1;
        }

        // Initialize DSU
        parent.clear();
        rank.clear();

        for (int i = 0; i < n; i++) {

            parent.add(i);
            rank.add(0);
        }

        /*
         * Initially every node is
         * its own component.
         */
        int components = n;

        /*
         * Process all edges
         */
        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            /*
             * If both nodes belong to
             * different components,
             * merge them.
             */
            if (find(u) != find(v)) {

                union(u, v);

                components--;
            }
        }

        /*
         * If components = k
         *
         * Required operations = k - 1
         */
        return components - 1;
    }


    public static void main(String[] args) {

        /*
         * Example 1
         *
         * n = 4
         *
         * 0 ----- 1
         * |       |
         * |       |
         * 2
         *
         * 3 is disconnected
         */

        int n1 = 4;

        int[][] connections1 = {
                {0, 1},
                {0, 2},
                {1, 2}
        };

        System.out.println(
                "Example 1 Answer : "
                        + makeConnected(n1, connections1)
        );


        /*
         * Example 2
         */

        int n2 = 6;

        int[][] connections2 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        System.out.println(
                "Example 2 Answer : "
                        + makeConnected(n2, connections2)
        );


        /*
         * Example 3
         *
         * Not enough edges
         */

        int n3 = 6;

        int[][] connections3 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2}
        };

        System.out.println(
                "Example 3 Answer : "
                        + makeConnected(n3, connections3)
        );
    }
}