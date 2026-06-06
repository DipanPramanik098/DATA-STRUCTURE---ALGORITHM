package _018_Graphs._03_Cycles;

import java.util.*;

/*
===============================================================================
                            BIPARTITE GRAPH
===============================================================================

PROBLEM STATEMENT
-------------------------------------------------------------------------------

Given an UNDIRECTED graph with V vertices.

The graph is represented using edges[][] where:

edges[i] = [u, v]

represents an undirected edge between u and v.

Determine whether the graph is Bipartite or not.

Return:

true  -> Graph is Bipartite
false -> Graph is Not Bipartite

===============================================================================
WHAT IS A BIPARTITE GRAPH?
===============================================================================

A graph is Bipartite if:

Its vertices can be divided into TWO SETS

Set A
Set B

such that:

Every edge connects a node from Set A
to a node from Set B.

No edge should connect two nodes
belonging to the same set.

-------------------------------------------------------------------------------

Example:

    0 ----- 1
    |       |
    |       |
    3 ----- 2

Set A = {0, 2}
Set B = {1, 3}

Every edge goes across sets.

Therefore Bipartite.

===============================================================================
ANOTHER DEFINITION
===============================================================================

A graph is Bipartite

⇔

It can be colored using only TWO COLORS

such that:

No adjacent nodes have same color.

-------------------------------------------------------------------------------

Color 0 = Red
Color 1 = Blue

Example:

      0(R)
      / \
     /   \
  1(B)  3(B)
     \ /
      2(R)

Valid Coloring

Hence Bipartite.

===============================================================================
IMPORTANT OBSERVATION
===============================================================================

A graph is NOT Bipartite if it contains
an ODD LENGTH CYCLE.

-------------------------------------------------------------------------------

Odd Cycle Example:

      0
     / \
    /   \
   1-----2

Cycle Length = 3

Try Coloring:

0 -> Red

1 -> Blue
2 -> Blue

Edge:

1 ----- 2

Both Blue

Violation occurs.

Therefore NOT Bipartite.

===============================================================================
EVEN CYCLE
===============================================================================

      0
     / \
    /   \
   3     1
    \   /
     \ /
      2

Cycle Length = 4

Coloring:

0 -> Red
1 -> Blue
2 -> Red
3 -> Blue

Valid

Hence Bipartite.

===============================================================================
PRACTICE QUESTION
===============================================================================

Input:

V = 5

Edges:

[
 [0,1],
 [0,3],
 [1,2],
 [2,4],
 [4,3]
]

Graph:

0 ----- 1
|       |
|       |
3 ----- 4
 \     /
  \   /
    2

Cycle:

0 → 1 → 2 → 4 → 3 → 0

Length = 5

Odd Cycle

Output:

False

Correct Answer:
Option 2

===============================================================================
INTUITION
===============================================================================

Instead of directly finding odd cycles,

we try to color the graph using two colors.

-------------------------------------------------------------------------------

If alternate coloring is possible:

Graph is Bipartite.

-------------------------------------------------------------------------------

If at any point:

Adjacent nodes get same color

Graph is NOT Bipartite.

===============================================================================
APPROACH (BFS)
===============================================================================

STEP 1
-------------------------------------------------------------------------------

Create color[] array.

Initially:

color[i] = -1

Meaning:

Node is uncolored.

-------------------------------------------------------------------------------

STEP 2
-------------------------------------------------------------------------------

Pick an uncolored node.

Assign color 0.

Push into queue.

-------------------------------------------------------------------------------

STEP 3
-------------------------------------------------------------------------------

Perform BFS.

For every neighbor:

Case 1:

Neighbor not colored

Assign opposite color.

-------------------------------------------------------------------------------

Case 2:

Neighbor already colored

If neighbor color equals current color

Return false.

===============================================================================
DRY RUN (BFS)
===============================================================================

Graph:

0 ----- 1
|       |
|       |
3 ----- 2

-------------------------------------------------------------------------------

Initial:

color = [-1,-1,-1,-1]

Assign:

0 -> Red (0)

color = [0,-1,-1,-1]

Queue:

[0]

-------------------------------------------------------------------------------

Pop 0

Neighbors:

1,3

Assign Blue

color = [0,1,-1,1]

Queue:

[1,3]

-------------------------------------------------------------------------------

Pop 1

Neighbor:

2

Assign Red

color = [0,1,0,1]

Queue:

[3,2]

-------------------------------------------------------------------------------

Pop 3

Neighbor:

2 already Red

No conflict

-------------------------------------------------------------------------------

Graph successfully colored.

Return true.

===============================================================================
BFS SOLUTION
===============================================================================
*/

public class _02_Bipartite_Graph {

    /*
     * BFS Traversal for one component.
     */
    private boolean bfs(int start,
                        List<Integer>[] adj,
                        int[] color) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        color[start] = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbor : adj[node]) {

                // Not colored yet
                if (color[neighbor] == -1) {

                    color[neighbor] =
                            1 - color[node];

                    queue.offer(neighbor);
                }

                // Same color conflict
                else if (color[neighbor]
                        == color[node]) {

                    return false;
                }
            }
        }

        return true;
    }

    /*
     * BFS Bipartite Check
     */
    public boolean isBipartiteBFS(
            int V,
            List<List<Integer>> edges) {

        List<Integer>[] adj =
                buildGraph(V, edges);

        int[] color = new int[V];

        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {

            if (color[i] == -1) {

                if (!bfs(i, adj, color)) {

                    return false;
                }
            }
        }

        return true;
    }

    /*
    ===============================================================================
                               DFS APPROACH
    ===============================================================================
    
    IDEA:
    
    Recursively color nodes.
    
    If neighbor already has same color,
    graph is not bipartite.
    ===============================================================================
    */

    private boolean dfs(int node,
                        int currentColor,
                        List<Integer>[] adj,
                        int[] color) {

        color[node] = currentColor;

        for (int neighbor : adj[node]) {

            // Uncolored node
            if (color[neighbor] == -1) {

                if (!dfs(
                        neighbor,
                        1 - currentColor,
                        adj,
                        color)) {

                    return false;
                }
            }

            // Same color conflict
            else if (color[neighbor]
                    == currentColor) {

                return false;
            }
        }

        return true;
    }

    /*
     * DFS Bipartite Check
     */
    public boolean isBipartiteDFS(
            int V,
            List<List<Integer>> edges) {

        List<Integer>[] adj =
                buildGraph(V, edges);

        int[] color = new int[V];

        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {

            if (color[i] == -1) {

                if (!dfs(
                        i,
                        0,
                        adj,
                        color)) {

                    return false;
                }
            }
        }

        return true;
    }

    /*
     * Build adjacency list from edge list.
     */
    private List<Integer>[] buildGraph(
            int V,
            List<List<Integer>> edges) {

        List<Integer>[] adj =
                new ArrayList[V];

        for (int i = 0; i < V; i++) {

            adj[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {

            int u = edge.get(0);
            int v = edge.get(1);

            adj[u].add(v);
            adj[v].add(u);
        }

        return adj;
    }

    public static void main(String[] args) {

        int V = 4;

        List<List<Integer>> edges =
                new ArrayList<>();

        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 3));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 3));

        _02_Bipartite_Graph obj =
                new _02_Bipartite_Graph();

        System.out.println(
                "Using BFS : "
                        + obj.isBipartiteBFS(V, edges)
        );

        System.out.println(
                "Using DFS : "
                        + obj.isBipartiteDFS(V, edges)
        );
    }
}

/*
===============================================================================
WHY BIPARTITE = TWO COLORING?
===============================================================================

Set A = Red

Set B = Blue

If graph can be colored with only two colors
without conflict,

then every edge automatically connects

Red ↔ Blue

which satisfies Bipartite definition.

===============================================================================
WHY ODD CYCLE FAILS?
===============================================================================

Triangle:

0
|\
| \
|  \
1---2

Color:

0 -> Red

1 -> Blue

2 -> Blue

Edge:

1 -> 2

Same color conflict.

Hence NOT Bipartite.

-------------------------------------------------------------------------------

Therefore:

Odd Cycle
⇒ Not Bipartite

===============================================================================
TIME COMPLEXITY
===============================================================================

Building Graph:

O(E)

-------------------------------------------------------------------------------

BFS Traversal:

O(V + E)

-------------------------------------------------------------------------------

DFS Traversal:

O(V + E)

-------------------------------------------------------------------------------

Overall:

O(V + E)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Adjacency List:

O(V + E)

-------------------------------------------------------------------------------

Color Array:

O(V)

-------------------------------------------------------------------------------

BFS Queue:

O(V)

OR

DFS Recursion Stack:

O(V)

-------------------------------------------------------------------------------

Overall:

O(V + E)

===============================================================================
INTERVIEW QUESTIONS
===============================================================================

Q1. What is Bipartite Graph?

A graph that can be divided into two sets such that
no adjacent vertices belong to same set.

-------------------------------------------------------------------------------

Q2. Another way to define Bipartite?

A graph that can be colored using two colors.

-------------------------------------------------------------------------------

Q3. Which cycle makes graph non-bipartite?

Odd Length Cycle.

-------------------------------------------------------------------------------

Q4. Is every tree bipartite?

Yes.

Because trees contain no cycles.

-------------------------------------------------------------------------------

Q5. Why start from every node?

Graph may have multiple disconnected components.

-------------------------------------------------------------------------------

Q6. Color Array Values?

-1 → Uncolored
 0 → Color A
 1 → Color B

===============================================================================
INTERVIEW ONE-LINER
===============================================================================

"A graph is bipartite if it can be colored using two colors such
that no adjacent nodes share the same color; if a coloring conflict
occurs, the graph is not bipartite."

===============================================================================
*/