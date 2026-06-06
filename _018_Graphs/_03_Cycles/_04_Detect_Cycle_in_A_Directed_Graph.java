package _018_Graphs._03_Cycles;

import java.util.*;

/*
===============================================================================
                    DETECT CYCLE IN A DIRECTED GRAPH
===============================================================================

PROBLEM STATEMENT
-------------------------------------------------------------------------------

Given a Directed Graph with V vertices numbered from:

0 to V-1

and adjacency list adj[].

Determine whether the graph contains a cycle.

Return:

true  -> Cycle Exists
false -> No Cycle Exists

===============================================================================
WHAT IS A DIRECTED CYCLE?
===============================================================================

A directed cycle exists when we can start from a node
and come back to the same node following edge directions.

Example:

0 → 1 → 2
↑       ↓
└───────┘

Cycle:

0 → 1 → 2 → 0

===============================================================================
EXAMPLE 1
===============================================================================

Input:

V = 6

0 → 1
    ↓
    2 → 3 → 4
    ↑       ↓
    └───────┘

1 → 5

Output:

true

Explanation:

Cycle exists:

1 → 2 → 3 → 4 → 1

===============================================================================
EXAMPLE 2
===============================================================================

Input:

V = 4

0 → 1
↓
2

3 → 0
|
↓
2

Output:

false

Explanation:

No directed cycle exists.

===============================================================================
PRACTICE QUESTION
===============================================================================

Input:

0 → 1 → 2
↑       ↓
└───────┘

Adj:

[
 [1],
 [2],
 [0]
]

Output:

true

Correct Answer:
Option 1

===============================================================================
INTUITION (DFS APPROACH)
===============================================================================

In Undirected Graph:

visited neighbor
AND
neighbor != parent

=> Cycle

-------------------------------------------------------------------------------

But in Directed Graph this logic fails.

Example:

0 → 1
↓
2 → 1

Node 1 can be visited from two paths.

This does NOT mean cycle.

===============================================================================
KEY OBSERVATION
===============================================================================

Cycle exists when:

During DFS,

we revisit a node that is already
present in the CURRENT DFS PATH.

-------------------------------------------------------------------------------

Example:

0 → 1 → 2
↑       ↓
└───────┘

DFS Path:

0 → 1 → 2

From 2 we again reach 0.

0 already exists in current path.

Cycle Found.

===============================================================================
WHAT IS PATH VISITED ARRAY?
===============================================================================

visited[]

Tells whether node has ever been visited.

-------------------------------------------------------------------------------

pathVisited[]

Tells whether node belongs to current DFS path.

-------------------------------------------------------------------------------

Example:

DFS Path:

0 → 1 → 2

visited:

[true,true,true]

pathVisited:

[true,true,true]

-------------------------------------------------------------------------------

After returning from 2:

pathVisited[2] = false

After returning from 1:

pathVisited[1] = false

===============================================================================
DFS APPROACH
===============================================================================

STEP 1

Create:

visited[]
pathVisited[]

-------------------------------------------------------------------------------

STEP 2

Start DFS.

Mark:

visited[node] = true
pathVisited[node] = true

-------------------------------------------------------------------------------

STEP 3

Traverse neighbors.

Case 1:

Neighbor already exists in pathVisited

=> Cycle Found

-------------------------------------------------------------------------------

Case 2:

Neighbor not visited

=> DFS(neighbor)

-------------------------------------------------------------------------------

STEP 4

Backtrack

pathVisited[node] = false

-------------------------------------------------------------------------------

STEP 5

If any component contains cycle

Return true

Else return false

===============================================================================
DRY RUN
===============================================================================

Graph:

0 → 1 → 2
↑       ↓
└───────┘

-------------------------------------------------------------------------------

DFS(0)

visited:

[T,F,F]

path:

[T,F,F]

-------------------------------------------------------------------------------

DFS(1)

visited:

[T,T,F]

path:

[T,T,F]

-------------------------------------------------------------------------------

DFS(2)

visited:

[T,T,T]

path:

[T,T,T]

-------------------------------------------------------------------------------

Neighbor = 0

pathVisited[0] = true

Cycle Found

Return true

===============================================================================
DFS SOLUTION
===============================================================================
*/

public class _04_Detect_Cycle_in_A_Directed_Graph {

    /*
     * DFS Cycle Detection
     */
    private boolean dfs(int node,
                        List<List<Integer>> adj,
                        boolean[] visited,
                        boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {

            /*
             * Back Edge Found
             */
            if (pathVisited[neighbor]) {

                return true;
            }

            /*
             * Explore Unvisited Node
             */
            if (!visited[neighbor]) {

                if (dfs(neighbor,
                        adj,
                        visited,
                        pathVisited)) {

                    return true;
                }
            }
        }

        /*
         * Remove node from current path
         */
        pathVisited[node] = false;

        return false;
    }

    /*
     * DFS Based Cycle Detection
     */
    public boolean isCyclicDFS(int V,
                               List<List<Integer>> adj) {

        boolean[] visited =
                new boolean[V];

        boolean[] pathVisited =
                new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i,
                        adj,
                        visited,
                        pathVisited)) {

                    return true;
                }
            }
        }

        return false;
    }

    /*
    ===============================================================================
                      KAHN'S ALGORITHM (BFS APPROACH)
    ===============================================================================
    
    IMPORTANT OBSERVATION
    
    Topological Sort exists ONLY for DAG.
    
    If graph contains cycle,
    Topological Sort cannot include all vertices.
    
    Therefore:
    
    Processed Nodes < V
    =>
    Cycle Exists
    ===============================================================================
    */

    public boolean isCyclicBFS(int V,
                               List<List<Integer>> adj) {

        int[] inDegree = new int[V];

        /*
         * Calculate In-Degree
         */
        for (int node = 0; node < V; node++) {

            for (int neighbor : adj.get(node)) {

                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue =
                new LinkedList<>();

        /*
         * Push nodes having
         * In-Degree = 0
         */
        for (int i = 0; i < V; i++) {

            if (inDegree[i] == 0) {

                queue.offer(i);
            }
        }

        int processedNodes = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            processedNodes++;

            for (int neighbor : adj.get(node)) {

                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {

                    queue.offer(neighbor);
                }
            }
        }

        /*
         * If all nodes are processed
         * graph is DAG.
         */
        return processedNodes < V;
    }

    public static void main(String[] args) {

        int V = 6;

        List<List<Integer>> adj =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }

        /*
              0 → 1 → 2 → 3 → 4
                      ↑       ↓
                      └───────┘

              1 → 5
         */

        adj.get(0).add(1);

        adj.get(1).add(2);
        adj.get(1).add(5);

        adj.get(2).add(3);

        adj.get(3).add(4);

        adj.get(4).add(1);

        _04_Detect_Cycle_in_A_Directed_Graph obj =
                new _04_Detect_Cycle_in_A_Directed_Graph();

        System.out.println(
                "Cycle Using DFS : "
                        + obj.isCyclicDFS(V, adj)
        );

        System.out.println(
                "Cycle Using Kahn's Algorithm : "
                        + obj.isCyclicBFS(V, adj)
        );
    }
}

/*
===============================================================================
WHY DFS WORKS?
===============================================================================

Cycle in Directed Graph

means

there exists a BACK EDGE.

-------------------------------------------------------------------------------

Back Edge:

Current Node
      ↓
Ancestor Node

-------------------------------------------------------------------------------

pathVisited[] helps identify
whether ancestor exists in current path.

If yes,

Cycle Found.

===============================================================================
WHY KAHN'S ALGORITHM WORKS?
===============================================================================

Topological Sort exists only for DAG.

-------------------------------------------------------------------------------

If graph contains cycle:

Some nodes will always have
non-zero in-degree.

They never enter queue.

-------------------------------------------------------------------------------

Therefore:

Processed Nodes < Total Nodes

=> Cycle Exists

===============================================================================
TIME COMPLEXITY
===============================================================================

DFS APPROACH

Each Node Visited Once

Each Edge Traversed Once

Time:

O(V + E)

-------------------------------------------------------------------------------

KAHN'S ALGORITHM

In-Degree Calculation:

O(E)

BFS Traversal:

O(V + E)

Total:

O(V + E)

===============================================================================
SPACE COMPLEXITY
===============================================================================

DFS

visited[]      -> O(V)

pathVisited[]  -> O(V)

Recursion Stack-> O(V)

Total:

O(V)

-------------------------------------------------------------------------------

KAHN'S ALGORITHM

In-Degree Array -> O(V)

Queue           -> O(V)

Total:

O(V)

===============================================================================
INTERVIEW QUESTIONS
===============================================================================

Q1. Why parent logic doesn't work in Directed Graph?

Because edges have direction.

A visited node may be reached through
another valid path.

-------------------------------------------------------------------------------

Q2. What detects cycle in DFS?

pathVisited[] array.

-------------------------------------------------------------------------------

Q3. What is a Back Edge?

An edge pointing to an ancestor
present in current DFS path.

-------------------------------------------------------------------------------

Q4. How does Kahn's Algorithm detect cycle?

Processed Nodes < V

-------------------------------------------------------------------------------

Q5. Which approach is more commonly asked?

DFS with Recursion Stack.

-------------------------------------------------------------------------------

Q6. Which approach is easier for cycle detection?

Kahn's Algorithm.

===============================================================================
INTERVIEW ONE-LINER
===============================================================================

"In a directed graph, a cycle exists if DFS reaches a node that is
already present in the current recursion path, or equivalently,
if Kahn's Algorithm cannot process all vertices."

===============================================================================
*/