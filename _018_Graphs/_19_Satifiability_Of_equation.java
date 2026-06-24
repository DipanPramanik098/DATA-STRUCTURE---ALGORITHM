package _018_Graphs;

import java.util.ArrayList;

public class _19_Satifiability_Of_equation {

    /*
     * LeetCode 990:
     * Satisfiability of Equality Equations
     *
     * We are given equations like:
     *
     * a==b
     * b==c
     * a!=c
     *
     * We need to determine whether all equations
     * can be satisfied simultaneously.
     *
     * Approach:
     * ----------
     * Use Disjoint Set Union (DSU)
     *
     * Step 1:
     * Process all "==" equations and connect them.
     *
     * Step 2:
     * Process all "!=" equations.
     * If two variables belong to the same set,
     * then contradiction exists.
     *
     * Return false.
     */

    // Parent Array
    static ArrayList<Integer> parent = new ArrayList<>();

    // Rank Array
    static ArrayList<Integer> rank = new ArrayList<>();


    /*
     * FIND OPERATION
     *
     * Returns ultimate parent of a node.
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
     * Connects two components.
     */
    public static void union(int u, int v) {

        int up_u = find(u);
        int up_v = find(v);

        // Already connected
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
     * Main Function
     */
    public static boolean equationsPossible(String[] equations) {

        // There are only 26 lowercase letters

        parent.clear();
        rank.clear();

        for (int i = 0; i < 26; i++) {
            parent.add(i);
            rank.add(0);
        }

        /*
         * STEP 1:
         * Process all equality equations.
         *
         * Example:
         * a==b
         * b==c
         *
         * Connect them in DSU.
         */
        for (String eq : equations) {

            if (eq.charAt(1) == '=') {

                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                union(u, v);
            }
        }

        /*
         * STEP 2:
         * Check all inequality equations.
         *
         * Example:
         * a!=c
         *
         * If both belong to same component,
         * contradiction exists.
         */
        for (String eq : equations) {

            if (eq.charAt(1) == '!') {

                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                if (find(u) == find(v)) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {

        /*
         * Example 1
         *
         * a==b
         * b==c
         * a!=c
         *
         * Contradiction
         */

        String[] equations1 = {
                "a==b",
                "b==c",
                "a!=c"
        };

        System.out.println(
                "Example 1 : " +
                equationsPossible(equations1)
        );


        /*
         * Example 2
         *
         * a==b
         * b!=c
         * c==d
         *
         * Possible
         */

        String[] equations2 = {
                "a==b",
                "b!=c",
                "c==d"
        };

        System.out.println(
                "Example 2 : " +
                equationsPossible(equations2)
        );


        /*
         * Example 3
         *
         * a==b
         * b==c
         * c==d
         * a!=d
         *
         * Contradiction
         */

        String[] equations3 = {
                "a==b",
                "b==c",
                "c==d",
                "a!=d"
        };

        System.out.println(
                "Example 3 : " +
                equationsPossible(equations3)
        );
    }
}