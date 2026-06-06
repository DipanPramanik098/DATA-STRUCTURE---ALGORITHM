package _018_Graphs._03_Cycles;

import java.util.*;

/*
===============================================================================
                DETECT A CYCLE IN AN UNDIRECTED GRAPH (BFS + DFS)
===============================================================================

PROBLEM STATEMENT
-------------------------------------------------------------------------------

Given an undirected graph having V vertices numbered from:

0 to V - 1

and an adjacency list adj[].

Determine whether the graph contains a cycle.

Return:

true  -> Cycle Exists
false -> No Cycle Exists

-------------------------------------------------------------------------------

NOTE:

1. Graph is UNDIRECTED.
2. No self-loops are present.
3. Graph may be disconnected.

===============================================================================
EXAMPLE 1
===============================================================================

Input:

V = 6

0 ---- 1
|      | \
|      |  \
3 ---- 4 --5
       |
       |
       2

Adj:

[
 [1,3],
 [0,2,4],
 [1,5],
 [0,4],
 [1,3,5],
 [2,4]
]

Output:

true

Explanation:

Cycle exists:

1 → 2 → 5 → 4 → 1

===============================================================================
EXAMPLE 2
===============================================================================

Input:

V = 4

0
|\
| \
1  2
    \
     \
      3

Adj:

[
 [1,2],
 [0],
 [0,3],
 [2]
]

Output:

false

Explanation:

No cycle exists.

Graph is a tree.

===============================================================================
PRACTICE QUESTION
===============================================================================

Input:

V = 4

0 ----- 1
 \     /
  \   /
    2
    |
    |
    3

Adj:

[
 [1,2],
 [0,2],
 [0,1,3],
 [2]
]

Output:

true

Correct Answer:
Option 1

Explanation:

Cycle:

0 → 1 → 2 → 0

===============================================================================
WHAT IS A CYCLE?
===============================================================================

A cycle exists when:

Starting from a node,

we can come back to the same node

without reusing edges.

-------------------------------------------------------------------------------

Example:

0 ---- 1
|      |
|      |
3 ---- 2

Cycle:

0 → 1 → 2 → 3 → 0

===============================================================================
KEY OBSERVATION
===============================================================================

In an UNDIRECTED GRAPH:

Every edge appears twice.

Example:

0 ---- 1

Adjacency List:

0 -> 1
1 -> 0

-------------------------------------------------------------------------------

While traversing:

If we visit a previously visited node,

it does NOT always mean cycle.

Because:

Child → Parent edge exists naturally.

-------------------------------------------------------------------------------

Example:

0 ---- 1

From node 1,
neighbor 0 is already visited.

But that's not a cycle.

That's simply its parent.

===============================================================================
MAIN IDEA
===============================================================================

Cycle exists when:

Visited Neighbor
AND
Neighbor ≠ Parent

-------------------------------------------------------------------------------

Condition:

if(visited[neighbor] && neighbor != parent)

        cycle exists

===============================================================================
WHY PARENT IS IMPORTANT?
===============================================================================

Example:

0 ---- 1

Starting BFS:

Visit 0

Visit 1

Now from node 1:

Neighbor = 0

Already visited.

-------------------------------------------------------------------------------

Without parent check:

Cycle detected ❌

Wrong Answer.

-------------------------------------------------------------------------------

With parent check:

neighbor == parent

Ignore it.

Correct Answer ✅

===============================================================================
APPROACH 1 : BFS
===============================================================================

Store:

(node, parent)

inside queue.

-------------------------------------------------------------------------------

Step 1:

Start BFS from an unvisited node.

Queue:

(node, parent)

-------------------------------------------------------------------------------

Step 2:

Pop node.

Traverse neighbors.

-------------------------------------------------------------------------------

Case 1:

Neighbor not visited

→ Mark visited
→ Push into queue

-------------------------------------------------------------------------------

Case 2:

Neighbor visited
AND
Neighbor != parent

→ Cycle Found

Return true

-------------------------------------------------------------------------------

If all nodes processed

Return false

===============================================================================
DRY RUN (BFS)
===============================================================================

Graph:

0 ----- 1
 \     /
  \   /
    2

-------------------------------------------------------------------------------

Queue:

[(0,-1)]

Visited:

[true,false,false]

-------------------------------------------------------------------------------

Pop:

(0,-1)

Neighbors:

1,2

Queue:

[(1,0),(2,0)]

Visited:

[true,true,true]

-------------------------------------------------------------------------------

Pop:

(1,0)

Neighbor:

0 -> parent -> ignore

Neighbor:

2 -> visited

2 != parent

Cycle Found

Return true

===============================================================================
BFS CODE
===============================================================================
*/

public class _01_Detect_A_Cycle_In_An_Undirected_Gaph {

    /*
     * BFS Traversal
     */
    private boolean bfs(int start,
                        List<Integer>[] adj,
                        boolean[] visited) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{start, -1});

        visited[start] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int node = current[0];
            int parent = current[1];

            for (int neighbor : adj[node]) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.offer(
                            new int[]{neighbor, node}
                    );
                }

                else if (neighbor != parent) {

                    return true;
                }
            }
        }

        return false;
    }

    /*
     * BFS Cycle Detection
     */
    public boolean isCycleBFS(int V,
                              List<Integer>[] adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (bfs(i, adj, visited)) {

                    return true;
                }
            }
        }

        return false;
    }

    /*
    ===============================================================================
                              DFS APPROACH
    ===============================================================================
    
    INTUITION
    
    DFS goes deeper into graph.
    
    While traversing:
    
    If a visited neighbor is found
    and it is not parent,
    
    then cycle exists.
    
    -------------------------------------------------------------------------------
    
    Condition:
    
    visited[neighbor] == true
    &&
    neighbor != parent
    
    => Cycle
    ===============================================================================
    */

    private boolean dfs(int node,
                        int parent,
                        List<Integer>[] adj,
                        boolean[] visited) {

        visited[node] = true;

        for (int neighbor : adj[node]) {

            if (!visited[neighbor]) {

                if (dfs(neighbor,
                        node,
                        adj,
                        visited)) {

                    return true;
                }
            }

            else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    /*
     * DFS Cycle Detection
     */
    public boolean isCycleDFS(int V,
                              List<Integer>[] adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i,
                        -1,
                        adj,
                        visited)) {

                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        List<Integer>[] adj =
                new ArrayList[V];

        for (int i = 0; i < V; i++) {

            adj[i] = new ArrayList<>();
        }

        /*
              0
             / \
            1---2
                |
                3
         */

        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0, 2));
        adj[2].addAll(Arrays.asList(0, 1, 3));
        adj[3].add(2);

        _01_Detect_A_Cycle_In_An_Undirected_Gaph obj =
                new _01_Detect_A_Cycle_In_An_Undirected_Gaph();

        System.out.println(
                "Cycle Using BFS : "
                        + obj.isCycleBFS(V, adj)
        );

        System.out.println(
                "Cycle Using DFS : "
                        + obj.isCycleDFS(V, adj)
        );
    }
}

/*
===============================================================================
TIME COMPLEXITY
===============================================================================

BFS:

Every node visited once
Every edge visited once

Time:

O(V + E)

-------------------------------------------------------------------------------

DFS:

Every node visited once
Every edge visited once

Time:

O(V + E)

===============================================================================
SPACE COMPLEXITY
===============================================================================

BFS:

Visited Array = O(V)

Queue = O(V)

Total:

O(V)

-------------------------------------------------------------------------------

DFS:

Visited Array = O(V)

Recursion Stack = O(V)

Total:

O(V)

===============================================================================
INTERVIEW QUESTIONS
===============================================================================

Q1. Why parent is required?

Because in undirected graph every edge appears twice.

Parent prevents false cycle detection.

-------------------------------------------------------------------------------

Q2. Cycle Detection Condition?

visited[neighbor] == true
AND
neighbor != parent

-------------------------------------------------------------------------------

Q3. Why start from every node?

Graph can be disconnected.

-------------------------------------------------------------------------------

Q4. Can BFS and DFS both solve it?

Yes.

Both work in O(V + E).

-------------------------------------------------------------------------------

Q5. Which approach is more common?

DFS is most commonly asked in interviews.

===============================================================================
INTERVIEW ONE-LINER
===============================================================================

"During BFS/DFS, if we encounter a visited neighbor that is not
the parent of the current node, then an undirected graph cycle
exists."

===============================================================================
*/