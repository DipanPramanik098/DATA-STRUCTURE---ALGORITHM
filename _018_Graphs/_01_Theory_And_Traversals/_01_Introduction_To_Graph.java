package _018_Graphs._01_Theory_And_Traversals;

/*

===============================================================================
                            GRAPH THEORY NOTES
===============================================================================

------------------------------------------------------------------------------
1. WHAT IS A DATA STRUCTURE?
------------------------------------------------------------------------------

A Data Structure is a way to organize, store and manage data efficiently so
that operations like insertion, deletion, searching, traversal etc. can be
performed easily.

Data Structures are mainly divided into two types:

1) Linear Data Structure
2) Non-Linear Data Structure


------------------------------------------------------------------------------
2. LINEAR DATA STRUCTURE
------------------------------------------------------------------------------

In linear data structures, elements are stored sequentially one after another.

Examples:
---------
1. Array
2. Linked List
3. Stack
4. Queue

Visualization:
---------------
10 -> 20 -> 30 -> 40

Each element has a unique previous and next element.


------------------------------------------------------------------------------
3. NON-LINEAR DATA STRUCTURE
------------------------------------------------------------------------------

In non-linear data structures, elements are NOT stored sequentially.

Instead:
---------
1. Hierarchical relation may exist
2. Multiple connections may exist

Examples:
---------
1. Trees
2. Graphs

Visualization:
---------------

        A
      /   \
     B     C
    / \
   D   E

Graphs are one of the most important non-linear data structures.


===============================================================================
                            INTRODUCTION TO GRAPH
===============================================================================

------------------------------------------------------------------------------
4. WHAT IS A GRAPH?
------------------------------------------------------------------------------

A Graph is a non-linear data structure consisting of:

1. Nodes (Vertices)
2. Edges

A graph represents connections between different entities.

Mathematically:
---------------
Graph = (V, E)

Where:
-------
V = Set of Vertices (Nodes)
E = Set of Edges (Connections)


------------------------------------------------------------------------------
5. REAL LIFE APPLICATIONS OF GRAPH
------------------------------------------------------------------------------

Graphs are extremely important in Computer Science.

Applications:
--------------
1. Google Maps Navigation
2. Social Media Networks
3. Computer Networks
4. Recommendation Systems
5. Web Page Ranking
6. Flight Route Systems
7. Electrical Circuits
8. Dependency Graphs
9. AI and Machine Learning
10. Network Routing


------------------------------------------------------------------------------
6. COMPONENTS OF A GRAPH
------------------------------------------------------------------------------

A graph mainly contains:

1. Vertex (Node)
2. Edge (Connection)


------------------------------------------------------------------------------
7. VERTEX / NODE
------------------------------------------------------------------------------

A node stores the actual data.

Representation:
---------------
Usually represented using circles.

Example:
--------

    (1)   (2)   (3)

These are vertices/nodes.


------------------------------------------------------------------------------
8. EDGE
------------------------------------------------------------------------------

An edge represents a connection between two nodes.

Representation:
---------------
Line connecting two nodes.

Example:
--------

    1 ----- 2

Edge between node 1 and node 2.


===============================================================================
                            TYPES OF EDGES
===============================================================================

------------------------------------------------------------------------------
9. DIRECTED EDGE
------------------------------------------------------------------------------

A directed edge has direction.

Representation:
---------------

    1 -----> 2

Meaning:
--------
Connection exists from 1 to 2 ONLY.

Mathematical Representation:
----------------------------
(1, 2)

IMPORTANT:
----------
(1,2) != (2,1)

Both are different edges.


------------------------------------------------------------------------------
10. UNDIRECTED EDGE
------------------------------------------------------------------------------

An undirected edge has NO direction.

Representation:
---------------

    1 ------- 2

Meaning:
--------
1 can reach 2 and 2 can also reach 1.

Mathematical Representation:
----------------------------
{1,2}

IMPORTANT:
----------
(1,2) == (2,1)


===============================================================================
                            TYPES OF GRAPH
===============================================================================

------------------------------------------------------------------------------
11. DIRECTED GRAPH
------------------------------------------------------------------------------

A graph where all edges are directed.

Example:
--------

    1 -----> 2
    ^
    |
    3

Used in:
--------
1. Instagram follow system
2. Web links
3. Dependency graphs


------------------------------------------------------------------------------
12. UNDIRECTED GRAPH
------------------------------------------------------------------------------

A graph where all edges are bidirectional.

Example:
--------

    1 ------ 2
     \      /
       3

Used in:
--------
1. Facebook friendship
2. Road maps
3. Computer networks


------------------------------------------------------------------------------
13. CONVERSION OF UNDIRECTED TO DIRECTED GRAPH
------------------------------------------------------------------------------

An undirected edge:
-------------------

    u ----- v

Can be converted into:
----------------------

    u -----> v
    u <----- v

Meaning:
--------
Two directed edges.


===============================================================================
                            CYCLE IN GRAPH
===============================================================================

------------------------------------------------------------------------------
14. WHAT IS A CYCLE?
------------------------------------------------------------------------------

A graph contains a cycle if we can start from a node and again reach the same
node.

Example:
--------

    1 ----- 2
     \     /
       3

Cycle:
------
1 -> 2 -> 3 -> 1


------------------------------------------------------------------------------
15. CYCLIC GRAPH
------------------------------------------------------------------------------

A graph containing at least one cycle.

Example:
--------

    1 --- 2
     \   /
       3


------------------------------------------------------------------------------
16. ACYCLIC GRAPH
------------------------------------------------------------------------------

A graph containing NO cycle.

Example:
--------

    1 --- 2 --- 3


===============================================================================
                            COMPONENTS OF GRAPH
===============================================================================

------------------------------------------------------------------------------
17. CONNECTED COMPONENT
------------------------------------------------------------------------------

A component is a group of connected nodes.

Nodes inside a component:
-------------------------
Connected directly or indirectly.

Nodes belonging to different components:
----------------------------------------
NOT connected.


Example:
--------

    1 --- 2       5 --- 6

    3             7

Components:
-----------
1. {1,2}
2. {3}
3. {5,6}
4. {7}


===============================================================================
                            PATH IN GRAPH
===============================================================================

------------------------------------------------------------------------------
18. WHAT IS A PATH?
------------------------------------------------------------------------------

A path is a sequence of vertices where adjacent vertices are connected.

Example:
--------

    1 --- 2 --- 3 --- 5

Path:
-----
1 -> 2 -> 3 -> 5


------------------------------------------------------------------------------
19. SIMPLE PATH
------------------------------------------------------------------------------

A path where no node repeats.

Example:
--------
1 -> 2 -> 3 -> 5


------------------------------------------------------------------------------
20. INVALID PATH
------------------------------------------------------------------------------

1 -> 2 -> 3 -> 2 -> 1

INVALID because node 2 repeats.


------------------------------------------------------------------------------
21. CLOSED PATH / CYCLE
------------------------------------------------------------------------------

A path that starts and ends at the same node.

Example:
--------
1 -> 2 -> 3 -> 1


===============================================================================
                            DEGREE OF NODE
===============================================================================

------------------------------------------------------------------------------
22. DEGREE IN UNDIRECTED GRAPH
------------------------------------------------------------------------------

Degree of a node =
-----------------
Number of edges connected to that node.

Example:
--------

        2
       / \
      1   3
       \ /
        4

Degree(1) = 2
Degree(2) = 2
Degree(3) = 2
Degree(4) = 2


------------------------------------------------------------------------------
23. IMPORTANT PROPERTY
------------------------------------------------------------------------------

Sum of all node degrees =
-------------------------
2 × Number of edges

Reason:
-------
Every edge contributes to degree of two nodes.


===============================================================================
                        DEGREE IN DIRECTED GRAPH
===============================================================================

------------------------------------------------------------------------------
24. IN-DEGREE
------------------------------------------------------------------------------

Number of incoming edges.

Example:
--------

    1 -----> 2

InDegree(2) = 1


------------------------------------------------------------------------------
25. OUT-DEGREE
------------------------------------------------------------------------------

Number of outgoing edges.

Example:
--------

    1 -----> 2

OutDegree(1) = 1


===============================================================================
                            WEIGHTED GRAPH
===============================================================================

------------------------------------------------------------------------------
26. WHAT IS A WEIGHTED GRAPH?
------------------------------------------------------------------------------

A graph whose edges contain weights/costs.

Example:
--------

    1 --5-- 2
     \     /
      2   1
       \ /
        3

Weights may represent:
----------------------
1. Distance
2. Cost
3. Time
4. Energy
5. Network latency


------------------------------------------------------------------------------
27. UNWEIGHTED GRAPH
------------------------------------------------------------------------------

Graph where edges contain NO weights.


===============================================================================
                            GRAPH INPUT FORMAT
===============================================================================

------------------------------------------------------------------------------
28. STANDARD INPUT FORMAT
------------------------------------------------------------------------------

First line:
-----------
n m

Where:
------
n = Number of nodes
m = Number of edges

Next m lines:
-------------
u v

Meaning:
--------
Edge between u and v


Example:
--------

5 6
1 2
1 3
2 4
3 4
3 5
4 5


===============================================================================
                    GRAPH REPRESENTATION TECHNIQUES
===============================================================================

There are mainly two methods:

1. Adjacency Matrix
2. Adjacency List


===============================================================================
                        ADJACENCY MATRIX
===============================================================================

------------------------------------------------------------------------------
29. WHAT IS ADJACENCY MATRIX?
------------------------------------------------------------------------------

A 2D matrix where:

adj[i][j] = 1
--------------
If edge exists between i and j

adj[i][j] = 0
--------------
If edge does NOT exist


------------------------------------------------------------------------------
30. EXAMPLE GRAPH
------------------------------------------------------------------------------

    1 ----- 2
    |       |
    |       |
    3 ----- 4


------------------------------------------------------------------------------
31. ADJACENCY MATRIX
------------------------------------------------------------------------------

        1  2  3  4

1       0  1  1  0
2       1  0  0  1
3       1  0  0  1
4       0  1  1  0


------------------------------------------------------------------------------
32. JAVA CODE FOR ADJACENCY MATRIX
------------------------------------------------------------------------------

*/

import java.util.ArrayList;
import java.util.Scanner;

public class _01_Introduction_To_Graph {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        -----------------------------------------------------------------------
        INPUT:
        -----------------------------------------------------------------------

        First line:
        n = number of nodes
        m = number of edges

        Example:
        --------
        5 6

        Meaning:
        --------
        5 nodes
        6 edges
        */

        int n = sc.nextInt();
        int m = sc.nextInt();



        /*
        =======================================================================
                        ADJACENCY MATRIX REPRESENTATION
        =======================================================================

        Matrix Size:
        ------------
        (n+1) x (n+1)

        Why n+1?
        --------
        Because graph nodes are generally 1-based indexed.

        Example:
        --------
        Nodes = 1,2,3,4,5

        So index 0 remains unused.

        */

        int[][] adjMatrix = new int[n + 1][n + 1];



        /*
        -----------------------------------------------------------------------
        ADDING EDGES INTO MATRIX
        -----------------------------------------------------------------------
        */

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            /*
            For UNDIRECTED GRAPH:
            ---------------------

            u -> v
            v -> u

            Both are true.

            Therefore:
            */

            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }



        /*
        -----------------------------------------------------------------------
        PRINTING ADJACENCY MATRIX
        -----------------------------------------------------------------------
        */

        System.out.println("Adjacency Matrix:");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                System.out.print(adjMatrix[i][j] + " ");
            }

            System.out.println();
        }



        /*
        =======================================================================
                        SPACE COMPLEXITY OF MATRIX
        =======================================================================

        Space Complexity:
        -----------------
        O(N^2)

        Reason:
        -------
        We need a complete matrix.

        Best For:
        ---------
        Dense Graphs

        Dense Graph:
        ------------
        Number of edges are very high.

        Advantage:
        ----------
        Checking edge existence is O(1)

        Disadvantage:
        -------------
        Consumes huge memory.
        */



        /*
        =======================================================================
                        ADJACENCY LIST REPRESENTATION
        =======================================================================

        Most commonly used representation in competitive programming.

        Each node stores its neighbors.

        Example:
        --------

        1 -> [2,3]
        2 -> [1,4]
        3 -> [1,4,5]

        etc.
        */

        ArrayList<ArrayList<Integer>> adjList =
                new ArrayList<>();



        /*
        -----------------------------------------------------------------------
        INITIALIZATION
        -----------------------------------------------------------------------
        */

        for (int i = 0; i <= n; i++) {

            adjList.add(new ArrayList<>());
        }



        /*
        -----------------------------------------------------------------------
        NOTE:
        -----------------------------------------------------------------------

        Since scanner already consumed all input previously for matrix,
        to demonstrate adjacency list separately we manually add edges here.

        Example Graph:
        --------------
        1-2
        1-3
        2-4
        3-4
        3-5
        4-5
        */



        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 4);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 3, 5);
        addEdge(adjList, 4, 5);



        /*
        -----------------------------------------------------------------------
        PRINTING ADJACENCY LIST
        -----------------------------------------------------------------------
        */

        System.out.println("\nAdjacency List:");

        for (int i = 1; i <= n; i++) {

            System.out.print(i + " -> ");

            for (int neighbor : adjList.get(i)) {

                System.out.print(neighbor + " ");
            }

            System.out.println();
        }



        /*
        =======================================================================
                        SPACE COMPLEXITY OF LIST
        =======================================================================

        Space Complexity:
        -----------------
        O(2E)

        Because:
        --------
        Every edge appears twice in undirected graph.

        Best For:
        ---------
        Sparse Graphs

        Sparse Graph:
        -------------
        Graph having less edges.

        Advantage:
        ----------
        Saves memory.

        Disadvantage:
        -------------
        Edge lookup slower compared to matrix.
        */



        /*
        =======================================================================
                        WEIGHTED GRAPH REPRESENTATION
        =======================================================================

        In weighted graph:
        ------------------

        We store:
        ----------
        (neighbor, weight)

        Example:
        --------

        1 --5-- 2

        Here:
        -----
        Neighbor = 2
        Weight = 5

        Since Java has no built-in pair,
        we create custom Pair class.
        */


        sc.close();
    }



    /*
    ===========================================================================
                            ADD EDGE METHOD
    ===========================================================================
    */

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,
                               int u,
                               int v) {

        /*
        For undirected graph:
        ---------------------
        Add both directions.
        */

        adj.get(u).add(v);
        adj.get(v).add(u);
    }



    /*
    ===========================================================================
                            PAIR CLASS
    ===========================================================================

    Used in weighted graphs.

    Stores:
    --------
    1. Neighbor node
    2. Edge weight
    */

    static class Pair {

        int node;
        int weight;

        Pair(int node, int weight) {

            this.node = node;
            this.weight = weight;
        }
    }
}