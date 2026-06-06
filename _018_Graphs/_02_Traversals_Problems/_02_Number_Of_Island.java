package _018_Graphs._02_Traversals_Problems;

import java.util.*;

/*
=========================================================
                NUMBER OF ISLANDS
=========================================================

Problem Statement:
------------------
Given a grid of size N x M consisting of:

'1' -> Land
'0' -> Water

Find the total number of islands.

An island is formed by connecting adjacent land cells
in all 8 directions:

1. Up
2. Down
3. Left
4. Right
5. Top-Left
6. Top-Right
7. Bottom-Left
8. Bottom-Right

=========================================================
EXAMPLE 1
=========================================================

Input:

grid = [
        ['1','1','1','0','1'],
        ['1','0','0','0','0'],
        ['1','1','1','0','1'],
        ['0','0','0','1','1']
       ]

Output:
2

Explanation:

Island 1:
1 1 1
1
1 1 1

Island 2:
1
1 1

Total Islands = 2

=========================================================
EXAMPLE 2
=========================================================

Input:

grid = [
        ['1','0','0','0','1'],
        ['0','1','0','1','0'],
        ['0','0','1','0','0'],
        ['0','1','0','1','0']
       ]

Output:
1

Explanation:

All land cells are connected diagonally.

Hence only one island exists.

=========================================================
MCQ ANSWER
=========================================================

Input:

grid = [
        ['1','1','1','1','0'],
        ['1','1','0','1','0'],
        ['1','1','0','0','0'],
        ['0','0','0','0','0']
       ]

Output = 1

Reason:
All land cells are connected directly or indirectly.

✅ Correct Answer: 1

=========================================================
INTUITION
=========================================================

Think of every cell as a graph node.

Land cells ('1') are vertices.

Each land cell can connect with its
8 neighboring land cells.

Whenever we find an unvisited land cell:

1. We have discovered a new island.
2. Start BFS/DFS from that cell.
3. Visit all connected land cells.
4. Mark them visited.

After traversal, the entire island gets covered.

The number of times we start a new BFS/DFS
equals the number of islands.

=========================================================
WHY 8 DIRECTIONS?
=========================================================

For a cell (row,col)

Possible neighbors:

(-1,-1)  (-1,0)  (-1,+1)

( 0,-1)  (cell)  ( 0,+1)

(+1,-1)  (+1,0)  (+1,+1)

Hence:

deltaRow = {-1,0,1}
deltaCol = {-1,0,1}

Using nested loops from -1 to 1
covers all 8 neighbors efficiently.

=========================================================
APPROACH
=========================================================

Step 1:
Create a visited[][] array.

Initially all cells are false.

---------------------------------------------------------

Step 2:
Traverse every cell of grid.

---------------------------------------------------------

Step 3:
Whenever an unvisited land cell ('1')
is encountered:

count++

because a new island is found.

---------------------------------------------------------

Step 4:
Perform BFS from that cell.

Visit all connected land cells in
all 8 directions.

Mark them visited.

---------------------------------------------------------

Step 5:
Continue scanning grid.

---------------------------------------------------------

Step 6:
Return count.

=========================================================
DRY RUN
=========================================================

Grid:

1 1 0
0 1 0
0 0 1

Visited:

F F F
F F F
F F F

---------------------------------------------------------

Cell (0,0)

Land + Unvisited

count = 1

Start BFS

Reach:

(0,0)
(0,1)
(1,1)
(2,2)

because diagonal connections are allowed.

Visited:

T T F
F T F
F F T

---------------------------------------------------------

Remaining cells either water
or already visited.

Final Count = 1

=========================================================
TIME COMPLEXITY ANALYSIS
=========================================================

Nested loop traverses entire grid:

O(N * M)

---------------------------------------------------------

BFS Traversal:

Every cell enters queue at most once.

Each cell checks 8 neighbors.

Total work:

O(8 * N * M)

Ignoring constants:

O(N * M)

---------------------------------------------------------

Final Time Complexity:

O(N * M)

=========================================================
SPACE COMPLEXITY ANALYSIS
=========================================================

Visited Array:

O(N * M)

---------------------------------------------------------

Queue:

In worst case entire grid is land.

Queue size:

O(N * M)

---------------------------------------------------------

Total Space Complexity:

O(N * M)

=========================================================
INTERVIEW FOLLOW-UP
=========================================================

Can we solve without visited array?

Yes.

Whenever a land cell is visited,
convert it into water ('0').

This eliminates the visited array and
reduces extra space.

However, it modifies the input grid.

=========================================================
*/

public class _02_Number_Of_Island {

    // Check whether cell is inside grid
    private boolean isValid(int row, int col, int n, int m) {

        return row >= 0 && row < n &&
               col >= 0 && col < m;
    }

    // BFS Traversal
    private void bfs(int row, int col,
                     boolean[][] visited,
                     char[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        visited[row][col] = true;
        queue.offer(new int[]{row, col});

        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int currRow = current[0];
            int currCol = current[1];

            // Traverse all 8 neighbors
            for (int delRow = -1; delRow <= 1; delRow++) {

                for (int delCol = -1; delCol <= 1; delCol++) {

                    int newRow = currRow + delRow;
                    int newCol = currCol + delCol;

                    if (isValid(newRow, newCol, n, m)
                            && grid[newRow][newCol] == '1'
                            && !visited[newRow][newCol]) {

                        visited[newRow][newCol] = true;

                        queue.offer(new int[]{
                                newRow,
                                newCol
                        });
                    }
                }
            }
        }
    }

    // DFS Version (Alternative)
    private void dfs(int row, int col,
                     boolean[][] visited,
                     char[][] grid) {

        visited[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;

        for (int delRow = -1; delRow <= 1; delRow++) {

            for (int delCol = -1; delCol <= 1; delCol++) {

                int newRow = row + delRow;
                int newCol = col + delCol;

                if (isValid(newRow, newCol, n, m)
                        && grid[newRow][newCol] == '1'
                        && !visited[newRow][newCol]) {

                    dfs(newRow, newCol, visited, grid);
                }
            }
        }
    }

    // Main Function
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int islands = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (!visited[i][j]
                        && grid[i][j] == '1') {

                    islands++;

                    bfs(i, j, visited, grid);
                    // dfs(i, j, visited, grid);
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '0', '0', '0', '0'},
                {'1', '1', '1', '0', '1'},
                {'0', '0', '0', '1', '1'}
        };

        _02_Number_Of_Island obj =
                new _02_Number_Of_Island();

        System.out.println(
                "Number of Islands = "
                        + obj.numIslands(grid)
        );
    }
}