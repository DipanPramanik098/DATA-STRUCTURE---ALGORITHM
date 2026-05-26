package _015_Binary_Trees._06_Contest;

import java.util.*;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Mocha and his friend live in different cities.

Cities are arranged as a Binary Tree rooted at node 1.

For every query:
(x, y)

Both start travelling upward toward root.

They stop when they meet for the FIRST time.

That meeting point is the Lowest Common Ancestor (LCA).

-----------------------------------------------------------

Fuel rule:

Each visited city requires fuel refill.

Initial refill cost:
cost[i]

After one use:
cost[i] = floor(cost[i] / 2)

Need:
Total money spent at every city after all queries.

===========================================================
EXAMPLE
===========================================================

Query:
(4, 7)

Tree:

                1
              /   \
             2     3
            / \   / \
           4   5 6   7

Path:

4 -> 2 -> 1 <- 3 <- 7

Visited:
4,2,1,3,7

===========================================================
INTUITION
===========================================================

Brute force:

For every query:
- move x to root
- move y to root
- find meeting point
- process costs

Too slow.

-----------------------------------------------------------

Better:

Use LCA.

Because meeting point = LCA(x,y)

Need fast LCA.

Use:

BINARY LIFTING

===========================================================
WHY BINARY LIFTING?
===========================================================

Normal LCA:
O(height)

Binary Lifting:
O(log N)

Idea:

Store ancestors:

up[node][0] = parent
up[node][1] = 2nd ancestor
up[node][2] = 4th ancestor
up[node][3] = 8th ancestor

etc.

===========================================================
APPROACH
===========================================================

STEP 1:
Convert tree into adjacency list

STEP 2:
DFS preprocessing

Store:
depth[node]
up[node][j]

STEP 3:
Build binary lifting table

STEP 4:
For each query:

Find:
LCA(x,y)

Traverse:
x -> LCA
y -> LCA

At each node:
answer[node] += current cost
cost[node] /= 2

Process LCA once only.

===========================================================
DRY RUN
===========================================================

Query:
(4,7)

LCA = 1

Traverse x:

4:
pay 4
new cost=2

2:
pay 2
new cost=1

Traverse y:

7:
pay 7
new cost=3

3:
pay 3
new cost=1

LCA:

1:
pay 1
new cost=0

===========================================================
*/
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

public class _01_Minimum_Travel_Cost {

    /*
     * Maximum binary lifting depth
     */
    static final int LOG = 17;

    /*
     * Ancestor table
     */
    int[][] up;

    /*
     * Node depth
     */
    int[] depth;

    /*
     * Graph
     */
    List<List<Integer>> adj;

    /*
     * DFS preprocessing
     */
    private void dfs(int node, int parent) {

        up[node][0] = parent;

        for (int child : adj.get(node)) {

            if (child == parent) {
                continue;
            }

            depth[child] = depth[node] + 1;

            dfs(child, node);
        }
    }

    /*
     * LCA using binary lifting
     */
    private int lca(int x, int y) {

        /*
         * Make x deeper
         */
        if (depth[x] < depth[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        /*
         * Lift x upward
         */
        for (int j = LOG; j >= 0; j--) {

            if (up[x][j] != -1 &&
                    depth[x] - (1 << j) >= depth[y]) {

                x = up[x][j];
            }
        }

        /*
         * Same node
         */
        if (x == y) {
            return x;
        }

        /*
         * Lift both
         */
        for (int j = LOG; j >= 0; j--) {

            if (up[x][j] != -1 &&
                    up[x][j] != up[y][j]) {

                x = up[x][j];
                y = up[y][j];
            }
        }

        return up[x][0];
    }

    /*
     * Main function
     */
    public int[] travelCost(int[] cost, int[][] queries, TreeNode root) {

        int n = cost.length;

        /*
         * Adjacency list
         */
        adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        /*
         * Build graph from tree
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current.left != null) {

                adj.get(current.data)
                        .add(current.left.data);

                adj.get(current.left.data)
                        .add(current.data);

                queue.offer(current.left);
            }

            if (current.right != null) {

                adj.get(current.data)
                        .add(current.right.data);

                adj.get(current.right.data)
                        .add(current.data);

                queue.offer(current.right);
            }
        }

        /*
         * Binary lifting table
         */
        up = new int[n + 1][LOG + 1];
        depth = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(up[i], -1);
        }

        /*
         * DFS
         */
        dfs(1, -1);

        /*
         * Build jump table
         */
        for (int j = 1; j <= LOG; j++) {

            for (int i = 1; i <= n; i++) {

                if (up[i][j - 1] != -1) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }

        /*
         * Final answer
         */
        long[] spent = new long[n + 1];

        /*
         * 1-based copy of costs
         */
        int[] fuel = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            fuel[i] = cost[i - 1];
        }

        /*
         * Process queries
         */
        for (int[] query : queries) {

            int x = query[0];
            int y = query[1];

            int meet = lca(x, y);

            /*
             * x -> LCA
             */
            while (x != meet) {

                spent[x] += fuel[x];

                fuel[x] /= 2;

                x = up[x][0];
            }

            /*
             * y -> LCA
             */
            while (y != meet) {

                spent[y] += fuel[y];

                fuel[y] /= 2;

                y = up[y][0];
            }

            /*
             * LCA once
             */
            spent[meet] += fuel[meet];

            fuel[meet] /= 2;
        }

        /*
         * Convert answer
         */
        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {
            result[i - 1] = (int) spent[i];
        }

        return result;
    }
}

/*
 * ===========================================================
 * TIME COMPLEXITY
 * ===========================================================
 * 
 * Tree preprocessing:
 * O(N log N)
 * 
 * Each query:
 * 
 * LCA:
 * O(log N)
 * 
 * Path traversal:
 * O(H)
 * 
 * Total:
 * 
 * O(N log N + Q(log N + H))
 * 
 * Worst:
 * O(NQ)
 * 
 * ===========================================================
 * SPACE COMPLEXITY
 * ===========================================================
 * 
 * Adjacency list:
 * O(N)
 * 
 * Binary lifting:
 * O(N log N)
 * 
 * Depth:
 * O(N)
 * 
 * Total:
 * O(N log N)
 * 
 * ===========================================================
 */