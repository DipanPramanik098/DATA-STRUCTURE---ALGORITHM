package _018_Graphs._02_Traversals_Problems;

import java.util.*;

/*
=========================================================
                NUMBER OF PROVINCES
=========================================================

Problem Statement:
------------------
Given an undirected graph represented as an adjacency matrix adj[][],
find the total number of Provinces.

A Province is a group of directly or indirectly connected cities,
and there should not be any connection with cities outside the group.

adj[i][j] = 1 -> City i is connected to City j
adj[i][j] = 0 -> No connection

---------------------------------------------------------
Example 1:
---------------------------------------------------------
adj = [
       [1,0,0,1],
       [0,1,1,0],
       [0,1,1,0],
       [1,0,0,1]
      ]

Graph:

1 ----- 4

2 ----- 3

Output: 2

Explanation:
Province 1 = {1,4}
Province 2 = {2,3}

---------------------------------------------------------
Example 2:
---------------------------------------------------------
adj = [
       [1,0,1],
       [0,1,0],
       [1,0,1]
      ]

Graph:

1 ----- 3

2

Output: 2

Explanation:
Province 1 = {1,3}
Province 2 = {2}

---------------------------------------------------------
Example 3:
---------------------------------------------------------
adj = [
       [1,1],
       [1,1]
      ]

Graph:

1 ----- 2

Output: 1

Explanation:
Both cities are connected.
Hence only one province exists.

=========================================================
INTUITION
=========================================================

Think of each province as a connected component.

If two cities are connected directly or indirectly,
they belong to the same province.

Therefore:

1. Start traversing from an unvisited city.
2. Visit all cities reachable from it.
3. All those cities form one province.
4. Repeat for remaining unvisited cities.

Every time we start a new BFS/DFS from an unvisited node,
we discover a new province.

Thus:

Number of Provinces
=
Number of Connected Components

=========================================================
APPROACH
=========================================================

Step 1:
Convert adjacency matrix into adjacency list.

Why?

Matrix traversal during BFS/DFS is expensive.
Adjacency list makes traversal cleaner and efficient.

---------------------------------------------------------

Step 2:
Create a visited[] array.

visited[i] = true
means city i has already been explored.

---------------------------------------------------------

Step 3:
Traverse all vertices.

For every vertex:

if not visited:
    provinceCount++
    perform BFS/DFS

The traversal marks every city in that province as visited.

---------------------------------------------------------

Step 4:
Return provinceCount.

=========================================================
DRY RUN
=========================================================

Input:

adj = [
       [1,0,0,1],
       [0,1,1,0],
       [0,1,1,0],
       [1,0,0,1]
      ]

Adjacency List:

0 -> [3]
1 -> [2]
2 -> [1]
3 -> [0]

visited = [false,false,false,false]

count = 0

---------------------------------------------------------
Iteration i = 0
---------------------------------------------------------

Node 0 not visited

count = 1

BFS(0)

Visit:
0 -> 3

visited:
[T,F,F,T]

Province found:
{0,3}

---------------------------------------------------------
Iteration i = 1
---------------------------------------------------------

Node 1 not visited

count = 2

BFS(1)

Visit:
1 -> 2

visited:
[T,T,T,T]

Province found:
{1,2}

---------------------------------------------------------
Iteration i = 2
---------------------------------------------------------

Already visited

---------------------------------------------------------
Iteration i = 3
---------------------------------------------------------

Already visited

---------------------------------------------------------

Final Answer = 2

=========================================================
WHY BFS WORKS?
=========================================================

BFS explores level by level.

Starting from any city:

- Visit that city.
- Visit all its neighbors.
- Visit neighbors of neighbors.
- Continue until queue becomes empty.

Thus BFS visits every city belonging to the same connected
component (province).

When BFS finishes, the entire province is marked visited.

=========================================================
TIME COMPLEXITY ANALYSIS
=========================================================

1. Matrix → Adjacency List Conversion

Two nested loops:

for(i=0 to V-1)
    for(j=0 to V-1)

Time = O(V²)

---------------------------------------------------------

2. BFS Traversal

Every vertex is visited once.

Every edge is processed once.

Time = O(V + E)

---------------------------------------------------------

Overall:

O(V²) + O(V + E)

Since matrix conversion dominates,

Final Time Complexity:

O(V²)

=========================================================
SPACE COMPLEXITY ANALYSIS
=========================================================

Adjacency List:
O(V + E)

Visited Array:
O(V)

Queue (BFS):
O(V)

---------------------------------------------------------

Total:

O(V + E)

=========================================================
IMPORTANT INTERVIEW POINT
=========================================================

Since input is already an adjacency matrix,
we can avoid creating an adjacency list.

Directly run DFS/BFS on the matrix.

That also gives:

Time  : O(V²)
Space : O(V)

This is often considered the optimal interview solution.

=========================================================
*/

public class _01_Number_Of_Provinces {

    // BFS Traversal
    private void bfs(int node, List<Integer>[] adjList, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int neighbour : adjList[current]) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    // DFS Traversal (Alternative Approach)
    private void dfs(int node, List<Integer>[] adjList, boolean[] visited) {

        visited[node] = true;

        for (int neighbour : adjList[node]) {

            if (!visited[neighbour]) {
                dfs(neighbour, adjList, visited);
            }
        }
    }

    // Main Function
    public int numProvinces(int[][] adj) {

        int V = adj.length;

        // Adjacency List
        List<Integer>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Matrix -> List Conversion
        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                if (adj[i][j] == 1 && i != j) {

                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];

        int provinces = 0;

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                provinces++;

                bfs(i, adjList, visited);
                // dfs(i, adjList, visited);
            }
        }

        return provinces;
    }

    public static void main(String[] args) {

        int[][] adj = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        _01_Number_Of_Provinces obj = new _01_Number_Of_Provinces();

        System.out.println("Number of Provinces : "
                + obj.numProvinces(adj));
    }
}