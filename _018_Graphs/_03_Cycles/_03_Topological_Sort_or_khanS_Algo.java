package _018_Graphs._03_Cycles;

import java.util.*;

/*
===============================================================================
                    TOPOLOGICAL SORT (KAHN'S ALGORITHM)
===============================================================================

PROBLEM STATEMENT
-------------------------------------------------------------------------------

Given a Directed Acyclic Graph (DAG) having V vertices
numbered from 0 to V-1.

Return any valid Topological Ordering of the graph.

-------------------------------------------------------------------------------

TOPOLOGICAL SORTING
-------------------------------------------------------------------------------

A linear ordering of vertices such that:

For every directed edge:

u → v

Node u appears BEFORE node v.

-------------------------------------------------------------------------------

Example:

0 → 1 → 2

Valid Order:

[0,1,2]

Invalid Order:

[1,0,2]

because 0 must come before 1.

===============================================================================
WHY TOPOLOGICAL SORT EXISTS ONLY FOR DAG?
===============================================================================

DAG = Directed Acyclic Graph

-------------------------------------------------------------------------------

CASE 1 : UNDIRECTED GRAPH

0 ---- 1

Means:

0 → 1
1 → 0

Now:

0 should come before 1
and

1 should come before 0

Impossible.

-------------------------------------------------------------------------------

CASE 2 : DIRECTED CYCLIC GRAPH

0 → 1 → 2 → 0

Requirements:

0 before 1
1 before 2
2 before 0

Impossible.

Therefore:

Topological Sort exists ONLY for DAG.

===============================================================================
INTUITION OF KAHN'S ALGORITHM
===============================================================================

Important Observation:

A node having In-Degree = 0

has no dependency.

Therefore it can safely appear first.

-------------------------------------------------------------------------------

Example:

0 → 2
1 → 2

In-Degree:

0 = 0
1 = 0
2 = 2

Nodes 0 and 1 have no dependencies.

They can appear before node 2.

-------------------------------------------------------------------------------

After processing 0 and 1:

Remove their edges.

2 becomes:

In-Degree = 0

Now 2 can be processed.

===============================================================================
WHAT IS IN-DEGREE?
===============================================================================

In-Degree of a node

=

Number of incoming edges.

-------------------------------------------------------------------------------

Example:

0 → 2
1 → 2
3 → 2

In-Degree(2) = 3

===============================================================================
KAHN'S ALGORITHM
===============================================================================

STEP 1
-------------------------------------------------------------------------------

Calculate In-Degree of every node.

-------------------------------------------------------------------------------

STEP 2
-------------------------------------------------------------------------------

Push all nodes having

In-Degree = 0

into Queue.

-------------------------------------------------------------------------------

STEP 3
-------------------------------------------------------------------------------

Until Queue becomes empty:

1. Remove node.
2. Add it to answer.
3. Remove all outgoing edges.
4. Decrease neighbors' in-degree.
5. If neighbor in-degree becomes 0,
   push it into queue.

-------------------------------------------------------------------------------

STEP 4

Answer array contains Topological Ordering.

===============================================================================
EXAMPLE 1
===============================================================================

Input:

V = 6

Adj:

0 -> []
1 -> []
2 -> [3]
3 -> [1]
4 -> [0,1]
5 -> [0,2]

-------------------------------------------------------------------------------

In-Degree Calculation

Node 0 = 2
Node 1 = 2
Node 2 = 1
Node 3 = 1
Node 4 = 0
Node 5 = 0

-------------------------------------------------------------------------------

Queue:

[4,5]

-------------------------------------------------------------------------------

Process 4

Answer:

[4]

Update:

0 = 1
1 = 1

-------------------------------------------------------------------------------

Process 5

Answer:

[4,5]

Update:

0 = 0
2 = 0

Queue:

[0,2]

-------------------------------------------------------------------------------

Process 0

Answer:

[4,5,0]

-------------------------------------------------------------------------------

Process 2

Answer:

[4,5,0,2]

Update:

3 = 0

Queue:

[3]

-------------------------------------------------------------------------------

Process 3

Answer:

[4,5,0,2,3]

Update:

1 = 0

Queue:

[1]

-------------------------------------------------------------------------------

Process 1

Answer:

[4,5,0,2,3,1]

Valid Topological Sort.

===============================================================================
PRACTICE QUESTION
===============================================================================

Input:

V = 3

Adj:

0 → 1
1 → 2
2 → []

-------------------------------------------------------------------------------

Conditions:

0 before 1
1 before 2

Only valid ordering:

[0,1,2]

Correct Answer:
Option 3

===============================================================================
DRY RUN
===============================================================================

Graph:

0 → 1 → 2

-------------------------------------------------------------------------------

In-Degree:

0 = 0
1 = 1
2 = 1

-------------------------------------------------------------------------------

Queue:

[0]

-------------------------------------------------------------------------------

Pop 0

Answer:

[0]

Update:

1 = 0

Queue:

[1]

-------------------------------------------------------------------------------

Pop 1

Answer:

[0,1]

Update:

2 = 0

Queue:

[2]

-------------------------------------------------------------------------------

Pop 2

Answer:

[0,1,2]

Done.

===============================================================================
BFS / KAHN'S ALGORITHM SOLUTION
===============================================================================
*/

public class _03_Topological_Sort_or_khanS_Algo {

    /*
     * Kahn's Algorithm
     * BFS Based Topological Sort
     */
    public int[] topoSortKahn(int V,
                              List<List<Integer>> adj) {

        int[] topo = new int[V];

        /*
         * Stores In-Degree of every node
         */
        int[] inDegree = new int[V];

        /*
         * Calculate In-Degree
         */
        for (int node = 0; node < V; node++) {

            for (int neighbor : adj.get(node)) {

                inDegree[neighbor]++;
            }
        }

        /*
         * Queue for BFS
         */
        Queue<Integer> queue =
                new LinkedList<>();

        /*
         * Push all nodes having
         * In-Degree = 0
         */
        for (int i = 0; i < V; i++) {

            if (inDegree[i] == 0) {

                queue.offer(i);
            }
        }

        int index = 0;

        /*
         * BFS Traversal
         */
        while (!queue.isEmpty()) {

            int node = queue.poll();

            topo[index++] = node;

            for (int neighbor : adj.get(node)) {

                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {

                    queue.offer(neighbor);
                }
            }
        }

        return topo;
    }

    /*
    ===============================================================================
                           DFS TOPOLOGICAL SORT
    ===============================================================================
    
    IDEA:
    
    Process all neighbors first.
    
    Then push current node into stack.
    
    After DFS completes,
    pop stack to obtain Topological Order.
    ===============================================================================
    */

    private void dfs(int node,
                     List<List<Integer>> adj,
                     boolean[] visited,
                     Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                dfs(neighbor,
                        adj,
                        visited,
                        stack);
            }
        }

        /*
         * Push after processing
         * all outgoing edges.
         */
        stack.push(node);
    }

    /*
     * DFS Based Topological Sort
     */
    public int[] topoSortDFS(int V,
                             List<List<Integer>> adj) {

        boolean[] visited =
                new boolean[V];

        Stack<Integer> stack =
                new Stack<>();

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                dfs(i,
                        adj,
                        visited,
                        stack);
            }
        }

        int[] topo = new int[V];

        int index = 0;

        while (!stack.isEmpty()) {

            topo[index++] = stack.pop();
        }

        return topo;
    }

    public static void main(String[] args) {

        int V = 6;

        List<List<Integer>> adj =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }

        /*
               5 → 2 → 3 → 1
               ↓
               0

               4 → 0
               ↓
               1
         */

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        _03_Topological_Sort_or_khanS_Algo obj =
                new _03_Topological_Sort_or_khanS_Algo();

        System.out.println("Kahn's Algorithm:");

        int[] bfsAns =
                obj.topoSortKahn(V, adj);

        System.out.println(
                Arrays.toString(bfsAns)
        );

        System.out.println();

        System.out.println("DFS Topological Sort:");

        int[] dfsAns =
                obj.topoSortDFS(V, adj);

        System.out.println(
                Arrays.toString(dfsAns)
        );
    }
}

/*
===============================================================================
WHY KAHN'S ALGORITHM WORKS?
===============================================================================

A node with In-Degree = 0

has no dependency.

So it can safely appear first.

-------------------------------------------------------------------------------

After removing that node,

other nodes may become independent.

Continue until graph finishes.

-------------------------------------------------------------------------------

This guarantees:

u always appears before v

for every edge:

u → v

===============================================================================
TOPOLOGICAL SORT USING DFS
===============================================================================

Rule:

Push node into stack AFTER
all neighbors are processed.

-------------------------------------------------------------------------------

This ensures:

Dependencies stay below

Dependent nodes stay above

-------------------------------------------------------------------------------

Popping stack gives valid order.

===============================================================================
TIME COMPLEXITY
===============================================================================

KAHN'S ALGORITHM

In-Degree Calculation:

O(E)

-------------------------------------------------------------------------------

BFS Traversal:

O(V + E)

-------------------------------------------------------------------------------

Total:

O(V + E)

===============================================================================
DFS TOPOLOGICAL SORT
===============================================================================

DFS Traversal:

O(V + E)

-------------------------------------------------------------------------------

Total:

O(V + E)

===============================================================================
SPACE COMPLEXITY
===============================================================================

KAHN'S ALGORITHM

In-Degree Array = O(V)

Queue = O(V)

Answer Array = O(V)

Total:

O(V)

===============================================================================

DFS APPROACH

Visited Array = O(V)

Stack = O(V)

Recursion Stack = O(V)

Total:

O(V)

===============================================================================
INTERVIEW QUESTIONS
===============================================================================

Q1. Topological Sort exists for which graph?

Only Directed Acyclic Graph (DAG).

-------------------------------------------------------------------------------

Q2. Why not for cyclic graph?

Because dependency ordering becomes impossible.

-------------------------------------------------------------------------------

Q3. What is In-Degree?

Number of incoming edges.

-------------------------------------------------------------------------------

Q4. What is Kahn's Algorithm?

BFS based Topological Sort using In-Degree.

-------------------------------------------------------------------------------

Q5. How to detect cycle using Kahn's Algorithm?

If number of processed nodes < V

then cycle exists.

-------------------------------------------------------------------------------

Q6. Which is easier for cycle detection?

Kahn's Algorithm.

===============================================================================
INTERVIEW ONE-LINER
===============================================================================

"Topological Sort is a linear ordering of vertices in a DAG such
that for every directed edge u → v, node u appears before node v.
Kahn's Algorithm uses in-degrees and BFS to generate this order."

===============================================================================
*/