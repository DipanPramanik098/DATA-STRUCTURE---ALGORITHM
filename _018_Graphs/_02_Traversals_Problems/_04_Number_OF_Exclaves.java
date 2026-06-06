package _018_Graphs._02_Traversals_Problems;

import java.util.*;

/*
===============================================================================
                         NUMBER OF ENCLAVES (LeetCode 1020)
===============================================================================

PROBLEM STATEMENT
-----------------
You are given a binary matrix grid[][] where:

0 -> Sea Cell
1 -> Land Cell

A move can be made from one land cell to another land cell in
4 directions only:

↑ Up
→ Right
↓ Down
← Left

A land cell is called an ENCLAVE if it is impossible to walk
outside the boundary of the grid starting from that cell.

Return the total number of enclave land cells.

-------------------------------------------------------------------------------
EXAMPLE 1
-------------------------------------------------------------------------------

Input:
grid =
[
 [0,0,0,0],
 [1,0,1,0],
 [0,1,1,0],
 [0,0,0,0]
]

Output:
3

Explanation:

Grid:

0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0

The land cell at (1,0) touches boundary,
therefore it can escape.

The group:
(1,2), (2,1), (2,2)

cannot reach any boundary.

Answer = 3

-------------------------------------------------------------------------------
EXAMPLE 2
-------------------------------------------------------------------------------

Input:
grid =
[
 [0,0,0,1],
 [0,0,0,1],
 [0,1,1,0],
 [0,0,1,0],
 [0,0,0,0]
]

Output:
3

Explanation:

Boundary land cells:
(0,3), (1,3)

They are connected to boundary.

Cells:
(2,1), (2,2), (3,2)

cannot reach boundary.

Answer = 3

-------------------------------------------------------------------------------
PRACTICE QUESTION
-------------------------------------------------------------------------------

Input:
grid =
[
 [0,0,0,1],
 [0,1,1,0],
 [0,1,1,0],
 [0,0,0,0]
]

Output = 4

Reason:

The boundary land cell (0,3) is isolated.

The 2x2 block:

(1,1), (1,2),
(2,1), (2,2)

cannot reach any boundary.

Answer = 4

===============================================================================
INTUITION
===============================================================================

Instead of finding enclave cells directly, let's think in reverse.

Question:
Which land cells are NOT enclaves?

Answer:
Any land cell that can reach the boundary.

So:

Step 1:
Start BFS/DFS from every boundary land cell.

Step 2:
Mark every land cell connected to boundary.

Step 3:
After traversal, all marked cells can escape.

Step 4:
Remaining unvisited land cells are enclaves.

This is much easier than checking each land cell individually.

===============================================================================
APPROACH
===============================================================================

1. Create a visited[][] array.

2. Traverse all boundary cells:
   - First row
   - Last row
   - First column
   - Last column

3. Whenever a boundary cell contains land (1):
   - Mark visited
   - Push into queue

4. Run BFS from all boundary land cells.

5. BFS will mark all land cells connected to boundary.

6. Traverse entire grid again.

7. Count cells where:
      grid[i][j] == 1
      AND
      visited[i][j] == false

8. Return count.

===============================================================================
VISUAL UNDERSTANDING
===============================================================================

Grid:

0 0 0 1
0 1 1 0
0 1 1 0
0 0 0 0

Boundary Land:

0 0 0 X
0 1 1 0
0 1 1 0
0 0 0 0

X = boundary land

Start BFS from X

X has no adjacent land.

Only X gets visited.

Visited:

0 0 0 V
0 1 1 0
0 1 1 0
0 0 0 0

Remaining unvisited land cells:

0 0 0 V
0 E E 0
0 E E 0
0 0 0 0

E = enclave

Count = 4

===============================================================================
DRY RUN
===============================================================================

Input:

0 0 0 1
0 1 1 0
0 1 1 0
0 0 0 0

Step 1:
Find boundary lands

Queue:
[(0,3)]

visited[0][3] = true

---------------------------------

Step 2:
Pop (0,3)

Check neighbours:

(-1,3) invalid
(0,4) invalid
(1,3)=0
(0,2)=0

No new cell added.

Queue becomes empty.

---------------------------------

Step 3:
Count unvisited land cells

(1,1) -> count=1
(1,2) -> count=2
(2,1) -> count=3
(2,2) -> count=4

Answer = 4

===============================================================================
WHY BFS WORKS?
===============================================================================

Every land cell connected to boundary is reachable from some
boundary land cell.

By starting BFS from all boundary lands:

We mark exactly those cells that can escape.

Any land cell not visited after BFS can never reach boundary.

Hence it is an enclave.

===============================================================================
TIME COMPLEXITY
===============================================================================

Let:

N = number of rows
M = number of columns

1. Boundary Traversal
   O(N*M)

2. BFS Traversal
   Every cell visited once

   O(N*M)

3. Counting Enclaves
   O(N*M)

Total:

O(N*M)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Visited Array:
O(N*M)

Queue (Worst Case):
O(N*M)

Total:

O(N*M)

===============================================================================
*/

public class _04_Number_OF_Exclaves {

    private final int[] delRow = {-1, 0, 1, 0};
    private final int[] delCol = {0, 1, 0, -1};

    /*
     * Checks whether the given cell
     * lies inside the matrix.
     */
    private boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    /*
     * Multi-Source BFS
     *
     * Starts BFS from all boundary land cells
     * present inside the queue.
     */
    private void bfs(int[][] grid,
                     Queue<int[]> queue,
                     boolean[][] visited) {

        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int i = 0; i < 4; i++) {

                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (isValid(newRow, newCol, n, m)
                        && grid[newRow][newCol] == 1
                        && !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    /*
     * Returns total number of enclave cells.
     */
    public int numberOfEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();

        /*
         * Add all boundary land cells
         * into queue.
         */
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                boolean isBoundary =
                        row == 0 ||
                        row == n - 1 ||
                        col == 0 ||
                        col == m - 1;

                if (isBoundary
                        && grid[row][col] == 1
                        && !visited[row][col]) {

                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
        }

        /*
         * Mark all land cells connected
         * to boundary.
         */
        bfs(grid, queue, visited);

        int enclaveCount = 0;

        /*
         * Count unvisited land cells.
         */
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (grid[row][col] == 1
                        && !visited[row][col]) {

                    enclaveCount++;
                }
            }
        }

        return enclaveCount;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        _04_Number_OF_Exclaves obj =
                new _04_Number_OF_Exclaves();

        int answer = obj.numberOfEnclaves(grid);

        System.out.println("Number of Enclaves = " + answer);
    }
}