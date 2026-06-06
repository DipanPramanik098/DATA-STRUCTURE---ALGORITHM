package _018_Graphs._02_Traversals_Problems;

import java.util.*;

/*
===============================================================================
                 DISTANCE OF NEAREST CELL HAVING ONE
===============================================================================

PROBLEM STATEMENT
-------------------------------------------------------------------------------

Given a binary matrix grid[][] of size N x M containing only:

0 -> Empty Cell
1 -> Cell containing One

For every cell, find the distance to the nearest cell having value 1.

Distance Formula:

Distance = |r1 - r2| + |c1 - c2|

where:

(r1, c1) = Current Cell
(r2, c2) = Nearest Cell containing 1

Return a matrix where each cell contains the minimum distance
to the nearest 1.

-------------------------------------------------------------------------------
EXAMPLE 1
-------------------------------------------------------------------------------

Input:

[
 [0,1,1,0],
 [1,1,0,0],
 [0,0,1,1]
]

Output:

[
 [1,0,0,1],
 [0,0,1,1],
 [1,1,0,0]
]

Explanation:

Cell (0,0) → nearest 1 at (0,1)
Distance = 1

Cell (0,3) → nearest 1 at (0,2)
Distance = 1

Cell (1,2) → nearest 1 at (1,1)
Distance = 1

-------------------------------------------------------------------------------
EXAMPLE 2
-------------------------------------------------------------------------------

Input:

[
 [1,0,1],
 [1,1,0],
 [1,0,0]
]

Output:

[
 [0,1,0],
 [0,0,1],
 [0,1,2]
]

Explanation:

Cell (2,2)

Nearest 1 is at (1,1)

Distance = |2-1| + |2-1|
         = 1 + 1
         = 2

-------------------------------------------------------------------------------
PRACTICE QUESTION
-------------------------------------------------------------------------------

Input:

[
 [0,1],
 [1,0]
]

Output:

[
 [1,0],
 [0,1]
]

Correct Answer:
Option 3

===============================================================================
INTUITION
===============================================================================

Brute Force Idea:

For every cell containing 0:

Search the entire matrix to find the nearest 1.

Time Complexity:

O((N*M) * (N*M))

Very expensive.

-------------------------------------------------------------------------------

Better Observation:

Suppose all cells containing 1 start expanding simultaneously.

Like:

1 spreads distance 1
Then distance 2
Then distance 3

The first time a cell is reached,
that distance is guaranteed to be minimum.

This is exactly how BFS works.

===============================================================================
WHY BFS AND NOT DFS?
===============================================================================

BFS explores level by level.

Level 0 -> Cells containing 1
Level 1 -> Distance 1
Level 2 -> Distance 2
Level 3 -> Distance 3

The first time BFS reaches a cell,
it reaches through the shortest path.

DFS cannot guarantee shortest distance.

Therefore BFS is preferred.

===============================================================================
KEY OBSERVATION
===============================================================================

Instead of running BFS from every 0,

Run BFS from ALL 1s together.

This is called:

MULTI-SOURCE BFS

-------------------------------------------------------------------------------

Imagine:

0 0 1
0 0 0
1 0 0

Queue initially contains:

[(0,2), (2,0)]

Both sources start expanding simultaneously.

The nearest source automatically reaches
every cell first.

Thus distance becomes minimum.

===============================================================================
APPROACH
===============================================================================

Step 1:

Create:

visited[][] matrix
distance[][] matrix

-------------------------------------------------------------------------------

Step 2:

Traverse the entire grid.

For every cell having 1:

Mark visited

Push into queue as:

(row, col, distance=0)

-------------------------------------------------------------------------------

Step 3:

Perform Multi-Source BFS.

While queue is not empty:

Take current cell

Store its distance

Explore all 4 directions

-------------------------------------------------------------------------------

Step 4:

For every unvisited neighbour:

Mark visited

Push neighbour with:

distance + 1

-------------------------------------------------------------------------------

Step 5:

Continue until queue becomes empty.

Distance matrix now contains shortest distance
to nearest 1.

Return distance matrix.

===============================================================================
VISUAL UNDERSTANDING
===============================================================================

Input:

0 1
1 0

-------------------------------------------------------------------------------

Initially Queue:

[(0,1,0),
 (1,0,0)]

Distance Matrix:

0 0
0 0

-------------------------------------------------------------------------------

Process (0,1)

Visit:

(0,0) distance = 1
(1,1) distance = 1

-------------------------------------------------------------------------------

Process (1,0)

Already shortest distances found.

-------------------------------------------------------------------------------

Final Distance Matrix:

1 0
0 1

===============================================================================
DRY RUN
===============================================================================

Input:

[
 [0,1],
 [1,0]
]

-------------------------------------------------------------------------------

Queue Initially:

[(0,1,0),
 (1,0,0)]

Visited:

0 1
1 0

-------------------------------------------------------------------------------

Pop (0,1,0)

dist[0][1] = 0

Visit:

(0,0) -> distance 1
(1,1) -> distance 1

Queue:

[(1,0,0),
 (0,0,1),
 (1,1,1)]

-------------------------------------------------------------------------------

Pop (1,0,0)

dist[1][0] = 0

Neighbours already visited.

-------------------------------------------------------------------------------

Pop (0,0,1)

dist[0][0] = 1

-------------------------------------------------------------------------------

Pop (1,1,1)

dist[1][1] = 1

-------------------------------------------------------------------------------

Final Answer:

[
 [1,0],
 [0,1]
]

===============================================================================
WHY MULTI-SOURCE BFS WORKS?
===============================================================================

Suppose a cell can be reached from multiple 1's.

The first source that reaches the cell
will always be the closest source.

Because BFS explores in increasing order of distance.

Hence:

First arrival = Shortest Distance

This guarantees correctness.

===============================================================================
TIME COMPLEXITY
===============================================================================

N = Rows
M = Columns

Every cell enters queue only once.

For every cell,
4 neighbours are checked.

Time Complexity:

O(N × M)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Visited Matrix:
O(N × M)

Distance Matrix:
O(N × M)

Queue:
O(N × M)

Total Space Complexity:

O(N × M)

===============================================================================
INTERVIEW QUESTIONS
===============================================================================

Q1. Why use Multi-Source BFS?

Because multiple cells contain 1 and all can act as
starting points simultaneously.

-------------------------------------------------------------------------------

Q2. Why not BFS from every 0?

That would take:

O((N*M)^2)

which is very expensive.

-------------------------------------------------------------------------------

Q3. Why does BFS guarantee shortest distance?

Because BFS explores nodes level by level.

-------------------------------------------------------------------------------

Q4. What does each BFS level represent?

Cells at equal distance from the nearest 1.

-------------------------------------------------------------------------------

Q5. What is the first distance assigned to a cell?

Its shortest possible distance.

===============================================================================
*/

public class _06_Distance_Of_Nearest_Cell_Having_One {

    // Up, Right, Down, Left
    private final int[] delRow = {-1, 0, 1, 0};
    private final int[] delCol = {0, 1, 0, -1};

    /*
     * Check whether cell is inside matrix.
     */
    private boolean isValid(int row, int col, int n, int m) {

        return row >= 0 &&
               row < n &&
               col >= 0 &&
               col < m;
    }

    /*
     * Returns distance matrix.
     */
    public int[][] nearest(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];

        /*
         * Queue stores:
         * {row, col, steps}
         */
        Queue<int[]> queue = new LinkedList<>();

        /*
         * Multi-Source BFS Initialization
         */
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (grid[row][col] == 1) {

                    visited[row][col] = 1;

                    queue.offer(
                            new int[]{row, col, 0}
                    );
                }
            }
        }

        /*
         * BFS Traversal
         */
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int steps = current[2];

            distance[row][col] = steps;

            for (int i = 0; i < 4; i++) {

                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (isValid(newRow, newCol, n, m)
                        && visited[newRow][newCol] == 0) {

                    visited[newRow][newCol] = 1;

                    queue.offer(
                            new int[]{
                                    newRow,
                                    newCol,
                                    steps + 1
                            }
                    );
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1},
                {1, 0}
        };

        _06_Distance_Of_Nearest_Cell_Having_One obj =
                new _06_Distance_Of_Nearest_Cell_Having_One();

        int[][] answer = obj.nearest(grid);

        System.out.println(
                "Distance Matrix:"
        );

        for (int[] row : answer) {

            for (int value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}