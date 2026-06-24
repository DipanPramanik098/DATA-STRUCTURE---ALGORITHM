package _018_Graphs;

import java.util.ArrayList;

/*
 * Detect Cycle in an Undirected Graph using
 * Disjoint Set Union (DSU) / Union Find
 *
 * Time Complexity  : O(E * α(V))
 * Space Complexity : O(V)
 *
 * α(V) = Inverse Ackermann Function
 * (Almost Constant Time)
 */
public class _18_Detect_Cycle_Using_DSU {

    // Parent Array
    static ArrayList<Integer> parent = new ArrayList<>();

    // Rank Array
    static ArrayList<Integer> rank = new ArrayList<>();


    /*
     * FIND OPERATION
     *
     * Returns the Ultimate Parent (Representative)
     *
     * Path Compression:
     * While returning, update the parent directly
     * to the ultimate parent.
     */
    public static int find(int node) {

        // Base Case
        if (parent.get(node) == node) {
            return node;
        }

        // Path Compression
        int ultimateParent = find(parent.get(node));

        parent.set(node, ultimateParent);

        return parent.get(node);
    }


    /*
     * UNION BY RANK
     *
     * Connect two components efficiently.
     */
    public static void union(int u, int v) {

        int up_u = find(u);
        int up_v = find(v);

        // Already in same component
        if (up_u == up_v) {
            return;
        }

        // Attach smaller rank tree
        // under larger rank tree

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
     * Detect Cycle Using DSU
     */
    public static boolean detectCycle(int V,
                                      ArrayList<ArrayList<Integer>> adj) {

        // Initialize DSU

        parent.clear();
        rank.clear();

        for (int i = 0; i < V; i++) {

            parent.add(i);
            rank.add(0);
        }

        /*
         * Traverse every edge
         *
         * Since graph is undirected,
         * process each edge only once.
         *
         * Example:
         * 0 - 1
         *
         * Adj List:
         * 0 -> 1
         * 1 -> 0
         *
         * Using (u < v) prevents
         * duplicate processing.
         */
        for (int u = 0; u < V; u++) {

            for (int v : adj.get(u)) {

                if (u < v) {

                    int up_u = find(u);
                    int up_v = find(v);

                    /*
                     * If both vertices belong
                     * to same component,
                     * adding this edge creates
                     * a cycle.
                     */
                    if (up_u == up_v) {
                        return true;
                    }

                    union(u, v);
                }
            }
        }

        return false;
    }


    /*
     * Add Edge (Undirected Graph)
     */
    public static void addEdge(
            ArrayList<ArrayList<Integer>> adj,
            int u,
            int v) {

        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        /*
         * Graph:
         *
         * 0 ----- 1
         * |       |
         * |       |
         * 3 ----- 2
         *
         * Cycle Exists
         */

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        if (detectCycle(V, adj)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Found");
        }
    }
}