package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class _21_Count_Pair_Of_Nodes {

    // https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

    /*
     * ------------------------------------------------------------
     * Problem:
     * ------------------------------------------------------------
     * Given an undirected graph having n nodes numbered from 0 to n-1,
     * return the number of pairs of nodes that are unreachable from each other.
     *
     * Example:
     *
     * Component 1 -> {0,1,2} (size = 3)
     * Component 2 -> {3,4}   (size = 2)
     * Component 3 -> {5}     (size = 1)
     *
     * Unreachable Pairs
     * = 3*2 + 3*1 + 2*1
     * = 11
     *
     * Instead of calculating every combination,
     * we use:
     *
     * remaining = n
     *
     * answer += size * (remaining - size)
     * remaining -= size
     *
     * Time Complexity : O((N + E) * α(N))
     * Space Complexity: O(N)
     */

    // Parent Array
    static ArrayList<Integer> parent = new ArrayList<>();

    // Rank Array (Used for Union by Rank)
    static ArrayList<Integer> rank = new ArrayList<>();

    // ------------------------------------------------------------
    // Find Ultimate Parent (Path Compression)
    // ------------------------------------------------------------
    public static int find(int node) {

        // If node is the leader of its component
        if (parent.get(node) == node)
            return node;

        // Find the ultimate parent
        int ultimateParent = find(parent.get(node));

        // Path Compression
        parent.set(node, ultimateParent);

        return ultimateParent;
    }

    // ------------------------------------------------------------
    // Union By Rank
    // ------------------------------------------------------------
    public static void union(int u, int v) {

        // Find ultimate parents
        int up_u = find(u);
        int up_v = find(v);

        // Already belongs to same component
        if (up_u == up_v)
            return;

        // Attach smaller height tree
        // under larger height tree

        if (rank.get(up_u) > rank.get(up_v)) {

            parent.set(up_v, up_u);

        } else if (rank.get(up_v) > rank.get(up_u)) {

            parent.set(up_u, up_v);

        } else {

            // Same rank
            // Attach any one and increase its rank

            parent.set(up_v, up_u);
            rank.set(up_u, rank.get(up_u) + 1);
        }
    }

    public long countPairs(int n, int[][] edges) {

        // --------------------------------------------------------
        // Step 1 : Initialize DSU
        // --------------------------------------------------------

        parent.clear();
        rank.clear();

        for (int i = 0; i < n; i++) {

            parent.add(i);
            rank.add(0);
        }

        // --------------------------------------------------------
        // Step 2 : Merge all connected nodes
        // Each connected component will have one ultimate parent
        // --------------------------------------------------------

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            union(u, v);
        }

        // --------------------------------------------------------
        // Step 3 : Count size of every connected component
        //
        // Map:
        // Ultimate Parent -> Component Size
        //
        // Example:
        // 0 -> 3
        // 4 -> 2
        // 7 -> 1
        // --------------------------------------------------------

        HashMap<Integer, Integer> componentSize = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int ultimateParent = find(i);

            componentSize.put(
                    ultimateParent,
                    componentSize.getOrDefault(ultimateParent, 0) + 1);
        }

        // --------------------------------------------------------
        // Step 4 : Count unreachable pairs
        // --------------------------------------------------------

        /*
         * Example
         *
         * Component Sizes
         * ----------------
         * 3
         * 2
         * 1
         *
         * Remaining = 6
         *
         * First:
         * 3 × (6-3) = 9
         * Remaining = 3
         *
         * Second:
         * 2 × (3-2) = 2
         * Remaining = 1
         *
         * Third:
         * 1 × (1-1) = 0
         *
         * Answer = 11
         */

        long unreachablePairs = 0;

        int remainingNodes = n;

        for (int size : componentSize.values()) {

            // Current component forms unreachable pairs
            // with every remaining component.

            unreachablePairs += (long) size * (remainingNodes - size);

            // Remove this component from remaining nodes
            remainingNodes -= size;
        }

        return unreachablePairs;
    }
}