package _018_Graphs._01_Theory_And_Traversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

===============================================================================
                        CONNECTED COMPONENTS IN GRAPH
===============================================================================

------------------------------------------------------------------------------
WHAT IS A CONNECTED COMPONENT?
------------------------------------------------------------------------------

A Connected Component is a group of nodes such that:

1. Every node is reachable from every other node in the same group.
2. No node from the group is connected to outside nodes.

In simple words:
----------------
A connected component is a separate connected group inside a graph.


===============================================================================
                            PROBLEM STATEMENT
===============================================================================

Given:
------
1. An undirected graph
2. V vertices numbered from 0 to V-1
3. List of edges

Task:
-----
Find the total number of connected components in the graph.


===============================================================================
                                EXAMPLE 1
===============================================================================

Input:
------

V = 4

Edges:
-------
0 - 1
1 - 2


Graph:
------

        0 ----- 1 ----- 2


        3


Components:
-----------
1st Component = {0,1,2}
2nd Component = {3}

Answer:
-------
2


===============================================================================
                                EXAMPLE 2
===============================================================================

Input:
------

V = 7

Edges:
-------
0 - 1
1 - 2
2 - 3
4 - 5


Graph:
------

        0 ----- 1 ----- 2 ----- 3


        4 ----- 5


        6


Components:
-----------
1. {0,1,2,3}
2. {4,5}
3. {6}

Answer:
-------
3


===============================================================================
                            VISUAL UNDERSTANDING
===============================================================================

Imagine graph as islands.

Each island:
-------------
1. Connected internally
2. Separated externally

Each island = Connected Component


===============================================================================
                                INTUITION
===============================================================================

The idea is very simple.

If we start traversal (BFS/DFS) from one node:
----------------------------------------------
We can visit ALL nodes belonging to that component.

After traversal:
----------------
If any node still remains unvisited,
it means:
---------
A NEW connected component exists.

Thus:
-----
Every time we start a NEW traversal,
we discover a NEW connected component.


===============================================================================
                            MAIN IDEA
===============================================================================

1. Create visited array
2. Traverse all nodes
3. If node unvisited:
       a) Increase component count
       b) Start BFS/DFS from that node
4. Continue until all nodes visited


===============================================================================
                            APPROACH
===============================================================================

STEP 1:
-------
Convert edges into adjacency list.

STEP 2:
-------
Create visited[] array.

STEP 3:
-------
Initialize component counter = 0

STEP 4:
-------
Traverse all vertices.

STEP 5:
-------
If node is NOT visited:
    a) Increment component count
    b) Run BFS or DFS

STEP 6:
-------
Return component count.


===============================================================================
                            DRY RUN
===============================================================================

Input:
------

V = 5

Edges:
-------
0 - 1
1 - 2
3 - 4


Graph:
------

        0 ----- 1 ----- 2


        3 ----- 4


------------------------------------------------------------------------------
STEP 1:
------------------------------------------------------------------------------

Visited Array:
--------------
[F,F,F,F,F]

Component Count:
----------------
0


------------------------------------------------------------------------------
STEP 2:
------------------------------------------------------------------------------

Start from node 0

Node 0 unvisited:
-----------------
New component found.

Count = 1

Run BFS/DFS from 0

Traversal visits:
-----------------
0 -> 1 -> 2

Visited:
--------
[T,T,T,F,F]


------------------------------------------------------------------------------
STEP 3:
------------------------------------------------------------------------------

Node 1 already visited.

Skip.


------------------------------------------------------------------------------
STEP 4:
------------------------------------------------------------------------------

Node 2 already visited.

Skip.


------------------------------------------------------------------------------
STEP 5:
------------------------------------------------------------------------------

Node 3 unvisited.

New component found.

Count = 2

Run BFS/DFS from 3

Traversal visits:
-----------------
3 -> 4

Visited:
--------
[T,T,T,T,T]


------------------------------------------------------------------------------
STEP 6:
------------------------------------------------------------------------------

All nodes visited.

Final Answer:
-------------
2


===============================================================================
                    WHY BFS/DFS WORKS HERE?
===============================================================================

Because:
--------
Traversal from one node reaches ALL nodes connected to it.

That means:
-----------
One traversal = One connected component


===============================================================================
                            IMPORTANT NOTE
===============================================================================

This problem works ONLY for:
----------------------------
Undirected Graphs

In directed graphs:
-------------------
Connected component concepts change:
1. Strongly Connected Components
2. Weakly Connected Components


===============================================================================
                            CODE
===============================================================================

*/

public class _03_Connected_Components {

    public static void main(String[] args) {

        /*
        =======================================================================
                                INPUT
        =======================================================================

        Graph:
        ------

                0 ----- 1 ----- 2


                3 ----- 4
        */

        int V = 5;

        List<List<Integer>> edges = Arrays.asList(

                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );



        /*
        =======================================================================
                            CREATE SOLUTION OBJECT
        =======================================================================
        */

        Solution sol = new Solution();



        /*
        =======================================================================
                        FIND CONNECTED COMPONENTS
        =======================================================================
        */

        int ans = sol.findNumberOfComponents(V, edges);



        /*
        =======================================================================
                                OUTPUT
        =======================================================================
        */

        System.out.println("Number Of Connected Components: " + ans);
    }
}



/*
===============================================================================
                                SOLUTION CLASS
===============================================================================
*/

class Solution {

    /*
    ===========================================================================
                        MAIN FUNCTION
    ===========================================================================

    This function returns total connected components.
    */

    public int findNumberOfComponents(int V,
                                      List<List<Integer>> edges) {

        /*
        =======================================================================
                        CREATE ADJACENCY LIST
        =======================================================================

        Adjacency List stores neighbors of every node.

        Example:
        --------
        0 -> [1]
        1 -> [0,2]
        2 -> [1]
        */

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();



        /*
        Create empty list for every vertex.
        */

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }



        /*
        =======================================================================
                            ADD EDGES
        =======================================================================

        Since graph is undirected:
        --------------------------
        Add both directions.
        */

        for (List<Integer> edge : edges) {

            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }



        /*
        =======================================================================
                            VISITED ARRAY
        =======================================================================

        visited[i] = true
        means node already explored.
        */

        boolean[] visited = new boolean[V];



        /*
        =======================================================================
                        COMPONENT COUNTER
        =======================================================================
        */

        int count = 0;



        /*
        =======================================================================
                            TRAVERSE ALL NODES
        =======================================================================

        Every unvisited node indicates:
        --------------------------------
        A NEW connected component.
        */

        for (int i = 0; i < V; i++) {

            /*
            If node unvisited
            */

            if (!visited[i]) {

                /*
                New component found
                */

                count++;



                /*
                Start traversal

                Can use:
                --------
                1. BFS
                2. DFS
                */

                bfs(i, adj, visited);

                // dfs(i, adj, visited);
            }
        }



        /*
        Return total components
        */

        return count;
    }



    /*
    ===========================================================================
                                BFS
    ===========================================================================

    Breadth First Search Traversal

    Uses:
    -----
    Queue Data Structure

    Traversal Style:
    ----------------
    Level by level
    */

    private void bfs(int start,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited) {

        /*
        =======================================================================
                                QUEUE
        =======================================================================
        */

        Queue<Integer> queue = new LinkedList<>();



        /*
        =======================================================================
                        START BFS
        =======================================================================
        */

        queue.offer(start);

        visited[start] = true;



        /*
        =======================================================================
                            BFS LOOP
        =======================================================================
        */

        while (!queue.isEmpty()) {

            /*
            Remove front node
            */

            int node = queue.poll();



            /*
            Traverse neighbors
            */

            for (int neighbor : adj.get(node)) {

                /*
                If neighbor unvisited
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
    }



    /*
    ===========================================================================
                                DFS
    ===========================================================================

    Depth First Search Traversal

    Uses:
    -----
    Recursion / Stack

    Traversal Style:
    ----------------
    Goes deep first
    */

    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited) {

        /*
        =======================================================================
                            MARK VISITED
        =======================================================================
        */

        visited[node] = true;



        /*
        =======================================================================
                        VISIT ALL NEIGHBORS
        =======================================================================
        */

        for (int neighbor : adj.get(node)) {

            /*
            If neighbor not visited
            */

            if (!visited[neighbor]) {

                /*
                Recursive DFS call
                */

                dfs(neighbor, adj, visited);
            }
        }
    }
}



/*

===============================================================================
                        COMPLEXITY ANALYSIS
===============================================================================

------------------------------------------------------------------------------
TIME COMPLEXITY
------------------------------------------------------------------------------

O(V + E)

Where:
------
V = Number of vertices
E = Number of edges

Reason:
-------
1. Every vertex visited once
2. Every edge processed once


------------------------------------------------------------------------------
SPACE COMPLEXITY
------------------------------------------------------------------------------

O(V + E)

Reason:
-------

1. Adjacency List:
   ---------------
   O(E)

2. Visited Array:
   ---------------
   O(V)

3. Queue/Recursion Stack:
   -----------------------
   O(V)


===============================================================================
                        WHY ADJACENCY LIST?
===============================================================================

Adjacency List is preferred because:
------------------------------------

1. Memory Efficient
2. Faster traversal
3. Best for sparse graphs


===============================================================================
                    EDGE CASES TO REMEMBER
===============================================================================

------------------------------------------------------------------------------
1. ALL ISOLATED NODES
------------------------------------------------------------------------------

Example:
--------
0   1   2   3

Components:
-----------
4


------------------------------------------------------------------------------
2. FULLY CONNECTED GRAPH
------------------------------------------------------------------------------

Example:
--------
0 - 1 - 2 - 3

Components:
-----------
1


------------------------------------------------------------------------------
3. EMPTY GRAPH
------------------------------------------------------------------------------

No edges.

Every node becomes separate component.


===============================================================================
                        BFS VS DFS FOR THIS PROBLEM
===============================================================================

Both BFS and DFS work perfectly.

------------------------------------------------------------------------------
USING BFS
------------------------------------------------------------------------------

Pros:
-----
1. Iterative
2. No recursion stack overflow

Uses Queue.


------------------------------------------------------------------------------
USING DFS
------------------------------------------------------------------------------

Pros:
-----
1. Short code
2. Easy recursive implementation

Uses Recursion/Stack.


===============================================================================
                            INTERVIEW POINTS
===============================================================================

Important Observation:
----------------------
Every time traversal starts from an unvisited node,
a NEW connected component is found.

This concept is extremely important and used in:
------------------------------------------------
1. Number of Provinces
2. Number of Islands
3. Connected Components
4. Network Connectivity
5. Social Network Groups


===============================================================================

*/