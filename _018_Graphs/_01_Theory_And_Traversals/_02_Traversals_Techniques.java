package _018_Graphs._01_Theory_And_Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

===============================================================================
                        GRAPH TRAVERSAL TECHNIQUES
===============================================================================

Graph Traversal means:
----------------------
Visiting every node(vertex) of the graph exactly once in some systematic way.

Traversal is one of the MOST IMPORTANT topics in Graphs.

Almost every graph problem is based on:
---------------------------------------
1. BFS (Breadth First Search)
2. DFS (Depth First Search)

Applications:
-------------
1. Cycle Detection
2. Shortest Path
3. Topological Sort
4. Connected Components
5. Flood Fill
6. Bipartite Graph
7. Maze Problems
8. Social Networks
9. Web Crawlers
10. Network Routing


===============================================================================
                            PROBLEM STATEMENT
===============================================================================

Given:
------
1. An undirected connected graph
2. V vertices numbered from 0 to V-1
3. List of edges

Task:
-----
Perform:
1. DFS Traversal
2. BFS Traversal

Starting from node 0.


===============================================================================
                                EXAMPLE
===============================================================================

Input:
------

V = 5

Edges:
-------
0 - 1
0 - 2
0 - 3
2 - 4


Graph:
------

            1
            |
            |
      3 --- 0 --- 2
                    \
                     \
                      4


Possible DFS:
--------------
0 -> 2 -> 4 -> 3 -> 1

Possible BFS:
--------------
0 -> 1 -> 2 -> 3 -> 4


===============================================================================
                    DIFFERENCE BETWEEN BFS AND DFS
===============================================================================

------------------------------------------------------------------------------
1. BFS (Breadth First Search)
------------------------------------------------------------------------------

Meaning:
--------
Visits nodes level by level.

Traversal Style:
----------------
Nearest nodes are visited first.

Data Structure Used:
--------------------
Queue (FIFO)

Real Life Example:
------------------
Spreading fire or virus.


------------------------------------------------------------------------------
2. DFS (Depth First Search)
------------------------------------------------------------------------------

Meaning:
--------
Goes as deep as possible first.

Traversal Style:
----------------
Complete one branch fully before backtracking.

Data Structure Used:
--------------------
Stack / Recursion

Real Life Example:
------------------
Maze solving.


===============================================================================
                        BFS (BREADTH FIRST SEARCH)
===============================================================================

------------------------------------------------------------------------------
INTUITION OF BFS
------------------------------------------------------------------------------

Think of BFS like ripple effect in water.

Example:
--------

Drop a stone into water.

Water spreads:
---------------
Level by level.

Similarly:
-----------
BFS visits:
1st level neighbors
Then 2nd level neighbors
Then 3rd level neighbors

and so on.


===============================================================================
                            BFS APPROACH
===============================================================================

1. Create visited[] array
2. Create Queue
3. Push source node into queue
4. Mark source node visited
5. While queue is NOT empty:
    a) Remove front node
    b) Add node into answer
    c) Traverse neighbors
    d) If neighbor unvisited:
            mark visited
            push into queue


===============================================================================
                            BFS DRY RUN
===============================================================================

Graph:
------

            1
            |
            |
      3 --- 0 --- 2
                    \
                     \
                      4


Adjacency List:
---------------
0 -> [1,2,3]
1 -> [0]
2 -> [0,4]
3 -> [0]
4 -> [2]


Initial:
--------
Queue = [0]
Visited = [T,F,F,F,F]



STEP 1:
-------
Remove 0

Answer = [0]

Push neighbors:
---------------
1,2,3

Queue = [1,2,3]

Visited:
--------
[T,T,T,T,F]



STEP 2:
-------
Remove 1

Answer:
-------
[0,1]

Neighbor:
---------
0 already visited

Queue:
------
[2,3]



STEP 3:
-------
Remove 2

Answer:
-------
[0,1,2]

Neighbor:
---------
4 unvisited

Push 4

Queue:
------
[3,4]

Visited:
--------
[T,T,T,T,T]



STEP 4:
-------
Remove 3

Answer:
-------
[0,1,2,3]



STEP 5:
-------
Remove 4

Answer:
-------
[0,1,2,3,4]

Queue becomes empty.

BFS COMPLETED.


===============================================================================
                        DFS (DEPTH FIRST SEARCH)
===============================================================================

------------------------------------------------------------------------------
INTUITION OF DFS
------------------------------------------------------------------------------

DFS goes DEEP first.

Think:
------
Suppose you are exploring a maze.

You keep moving forward until:
------------------------------
1. Dead end occurs
2. No further path exists

Then:
-----
You BACKTRACK.

This is exactly how DFS works.


===============================================================================
                            DFS APPROACH
===============================================================================

1. Mark node visited
2. Add node into answer
3. Traverse all neighbors
4. For every unvisited neighbor:
        call DFS recursively


===============================================================================
                            DFS DRY RUN
===============================================================================

Graph:
------

            1
            |
            |
      3 --- 0 --- 2
                    \
                     \
                      4


Start DFS(0)

STEP 1:
-------
Visit 0

Answer:
-------
[0]


STEP 2:
-------
Go to neighbor 1

Answer:
-------
[0,1]

Backtrack to 0


STEP 3:
-------
Go to neighbor 2

Answer:
-------
[0,1,2]


STEP 4:
-------
From 2 go to 4

Answer:
-------
[0,1,2,4]

Backtrack to 2
Backtrack to 0


STEP 5:
-------
Go to 3

Answer:
-------
[0,1,2,4,3]


DFS COMPLETED.


===============================================================================
                            IMPORTANT POINTS
===============================================================================

------------------------------------------------------------------------------
WHY VISITED ARRAY IS NECESSARY?
------------------------------------------------------------------------------

Without visited array:
----------------------
Graph traversal may go into infinite loop due to cycles.

Example:
--------

0 ---- 1

If visited array absent:
------------------------
0 -> 1 -> 0 -> 1 -> 0 -> infinite


------------------------------------------------------------------------------
CONNECTED VS DISCONNECTED GRAPH
------------------------------------------------------------------------------

Connected Graph:
----------------
All nodes reachable.

Disconnected Graph:
-------------------
Some nodes isolated.

For disconnected graph:
-----------------------
Run traversal for every node.


===============================================================================
                                CODE
===============================================================================

*/

public class _02_Traversals_Techniques {

    public static void main(String[] args) {

        /*
        =======================================================================
                                GRAPH CREATION
        =======================================================================

        V = Number of vertices

        Nodes:
        ------
        0,1,2,3,4
        */

        int V = 5;

        /*
        -----------------------------------------------------------------------
        CREATING ADJACENCY LIST
        -----------------------------------------------------------------------
        */

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        /*
        Add empty list for every node
        */

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }


        /*
        -----------------------------------------------------------------------
        ADDING EDGES
        -----------------------------------------------------------------------

        Graph:
        ------

                    1
                    |
                    |
              3 --- 0 --- 2
                            \
                             \
                              4
        */

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 2, 4);



        /*
        =======================================================================
                                    BFS
        =======================================================================
        */

        System.out.println("BFS Traversal:");

        List<Integer> bfsAns = bfsOfGraph(V, adj);

        System.out.println(bfsAns);



        /*
        =======================================================================
                                    DFS
        =======================================================================
        */

        System.out.println("\nDFS Traversal:");

        List<Integer> dfsAns = dfsOfGraph(V, adj);

        System.out.println(dfsAns);
    }



    /*
    ===========================================================================
                            ADD EDGE METHOD
    ===========================================================================

    Since graph is undirected:
    --------------------------
    Add both directions.
    */

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,
                               int u,
                               int v) {

        adj.get(u).add(v);
        adj.get(v).add(u);
    }



    /*
    ===========================================================================
                            BFS FUNCTION
    ===========================================================================

    Returns:
    --------
    BFS traversal of graph.
    */

    public static List<Integer> bfsOfGraph(int V,
                                           ArrayList<ArrayList<Integer>> adj) {

        /*
        -----------------------------------------------------------------------
        RESULT LIST
        -----------------------------------------------------------------------
        */

        List<Integer> ans = new ArrayList<>();



        /*
        -----------------------------------------------------------------------
        VISITED ARRAY
        -----------------------------------------------------------------------

        visited[i] = true
        means node already visited.
        */

        boolean[] visited = new boolean[V];



        /*
        -----------------------------------------------------------------------
        QUEUE FOR BFS
        -----------------------------------------------------------------------

        FIFO:
        -----
        First In First Out
        */

        Queue<Integer> queue = new LinkedList<>();



        /*
        -----------------------------------------------------------------------
        START BFS FROM NODE 0
        -----------------------------------------------------------------------
        */

        queue.offer(0);

        visited[0] = true;



        /*
        -----------------------------------------------------------------------
        BFS LOOP
        -----------------------------------------------------------------------

        Continue until queue becomes empty.
        */

        while (!queue.isEmpty()) {

            /*
            Remove front node
            */

            int node = queue.poll();



            /*
            Add node into answer
            */

            ans.add(node);



            /*
            Traverse all neighbors
            */

            for (int neighbor : adj.get(node)) {

                /*
                If neighbor not visited
                */

                if (!visited[neighbor]) {

                    /*
                    Mark visited
                    */

                    visited[neighbor] = true;



                    /*
                    Push into queue
                    */

                    queue.offer(neighbor);
                }
            }
        }

        return ans;
    }



    /*
    ===========================================================================
                            DFS FUNCTION
    ===========================================================================

    Returns:
    --------
    DFS traversal of graph.
    */

    public static List<Integer> dfsOfGraph(int V,
                                           ArrayList<ArrayList<Integer>> adj) {

        /*
        Result list
        */

        List<Integer> ans = new ArrayList<>();



        /*
        Visited array
        */

        boolean[] visited = new boolean[V];



        /*
        Start DFS from node 0
        */

        dfs(0, adj, visited, ans);

        return ans;
    }



    /*
    ===========================================================================
                            RECURSIVE DFS
    ===========================================================================

    Steps:
    ------
    1. Mark visited
    2. Add into answer
    3. Visit neighbors recursively
    */

    public static void dfs(int node,
                           ArrayList<ArrayList<Integer>> adj,
                           boolean[] visited,
                           List<Integer> ans) {

        /*
        -----------------------------------------------------------------------
        MARK VISITED
        -----------------------------------------------------------------------
        */

        visited[node] = true;



        /*
        -----------------------------------------------------------------------
        ADD INTO ANSWER
        -----------------------------------------------------------------------
        */

        ans.add(node);



        /*
        -----------------------------------------------------------------------
        VISIT ALL NEIGHBORS
        -----------------------------------------------------------------------
        */

        for (int neighbor : adj.get(node)) {

            /*
            If neighbor not visited
            */

            if (!visited[neighbor]) {

                /*
                Recursive DFS call
                */

                dfs(neighbor, adj, visited, ans);
            }
        }
    }
}



/*

===============================================================================
                        TIME COMPLEXITY ANALYSIS
===============================================================================

------------------------------------------------------------------------------
BFS TIME COMPLEXITY
------------------------------------------------------------------------------

O(V + E)

Where:
------
V = Number of vertices
E = Number of edges

Reason:
-------
1. Every node visited once
2. Every edge processed once


------------------------------------------------------------------------------
DFS TIME COMPLEXITY
------------------------------------------------------------------------------

O(V + E)

Reason:
-------
1. Every node visited once
2. Every edge traversed once


===============================================================================
                        SPACE COMPLEXITY ANALYSIS
===============================================================================

------------------------------------------------------------------------------
BFS SPACE COMPLEXITY
------------------------------------------------------------------------------

O(V)

Reason:
-------
Queue may contain all nodes in worst case.


------------------------------------------------------------------------------
DFS SPACE COMPLEXITY
------------------------------------------------------------------------------

O(V)

Reason:
-------
Recursive stack may contain all nodes.


===============================================================================
                            WHEN TO USE BFS?
===============================================================================

Use BFS when:
-------------
1. Shortest path in unweighted graph
2. Level order traversal
3. Minimum moves/problems
4. Multi-source traversal


===============================================================================
                            WHEN TO USE DFS?
===============================================================================

Use DFS when:
-------------
1. Backtracking
2. Cycle detection
3. Topological sorting
4. Connected components
5. Maze/path exploration


===============================================================================
                        BFS VS DFS SUMMARY
===============================================================================

+-------------------+-------------------+-------------------+
| Feature           | BFS               | DFS               |
+-------------------+-------------------+-------------------+
| Traversal Style   | Level Wise        | Depth Wise        |
| Data Structure    | Queue             | Stack/Recursion   |
| Shortest Path     | Yes               | No                |
| Memory Usage      | More              | Less              |
| Backtracking      | No                | Yes               |
| Implementation    | Iterative         | Recursive         |
+-------------------+-------------------+-------------------+

===============================================================================

*/