package _018_Graphs._02_Traversals_Problems;

import java.util.*;

/*
===============================================================================
                            SURROUNDED REGIONS
===============================================================================

PROBLEM STATEMENT
-------------------------------------------------------------------------------

You are given a matrix mat[][] of size N x M containing:

'X' -> Blocked Cell
'O' -> Open Cell

Replace all 'O' cells that are COMPLETELY SURROUNDED by 'X'
with 'X'.

RULES
-------------------------------------------------------------------------------

1. Two 'O' cells are connected if they share a side
   (Up, Down, Left, Right).

2. Diagonal connections are NOT allowed.

3. Any 'O' connected directly or indirectly to a BORDER 'O'
   cannot be replaced.

4. Only those 'O' regions that are fully enclosed by 'X'
   should be converted into 'X'.

-------------------------------------------------------------------------------
EXAMPLE 1
-------------------------------------------------------------------------------

Input:

X X X X
X O O X
X X O X
X O X X

Output:

X X X X
X X X X
X X X X
X O X X

Explanation:

Region:

O O
  O

is completely surrounded by X.

Hence converted to X.

Cell (3,1) is on boundary.

Therefore it remains O.

-------------------------------------------------------------------------------
EXAMPLE 2
-------------------------------------------------------------------------------

Input:

X X X
X O X
X X X

Output:

X X X
X X X
X X X

Explanation:

The only O is completely surrounded.

Convert it into X.

-------------------------------------------------------------------------------
PRACTICE QUESTION
-------------------------------------------------------------------------------

Input:

X X X O
X X X X
O X X X
X X X X

Output:

X X X O
X X X X
O X X X
X X X X

Correct Answer:
Option 2

Reason:

Both O's are boundary O's.

Boundary regions can never be surrounded.

===============================================================================
INTUITION
===============================================================================

Direct Thinking:

Find every O region and check whether it touches boundary.

This becomes complicated.

-------------------------------------------------------------------------------

Reverse Thinking:

Instead of finding SURROUNDED O's,

Find O's that CANNOT be surrounded.

Who cannot be surrounded?

Answer:

Boundary O's and all O's connected to them.

-------------------------------------------------------------------------------

So the idea is:

1. Start DFS/BFS from boundary O's.
2. Mark every reachable O.
3. These O's are SAFE.
4. Remaining unvisited O's are surrounded.
5. Convert them into X.

===============================================================================
KEY OBSERVATION
===============================================================================

Boundary O
      |
Connected O
      |
Connected O
      |
Connected O

None of them can be converted.

Why?

Because there exists a path to boundary.

-------------------------------------------------------------------------------

Only O's having NO path to boundary
are surrounded regions.

===============================================================================
APPROACH
===============================================================================

STEP 1
-------------------------------------------------------------------------------

Create a visited[][] array.

visited[i][j] = true

means this O is connected to boundary.

-------------------------------------------------------------------------------

STEP 2
-------------------------------------------------------------------------------

Traverse all boundary cells.

Boundary includes:

First Row
Last Row
First Column
Last Column

-------------------------------------------------------------------------------

STEP 3
-------------------------------------------------------------------------------

Whenever a boundary O is found:

Run DFS from it.

Mark all connected O's as visited.

-------------------------------------------------------------------------------

STEP 4
-------------------------------------------------------------------------------

After DFS completes:

All safe O's are visited.

-------------------------------------------------------------------------------

STEP 5
-------------------------------------------------------------------------------

Traverse entire matrix.

If:

mat[i][j] == 'O'
AND
visited[i][j] == false

Convert it to X.

-------------------------------------------------------------------------------

STEP 6
-------------------------------------------------------------------------------

Return modified matrix.

===============================================================================
VISUAL UNDERSTANDING
===============================================================================

Input:

X X X X
X O O X
X X O X
X O X X

-------------------------------------------------------------------------------

Boundary O:

X X X X
X O O X
X X O X
X B X X

B = Boundary O

-------------------------------------------------------------------------------

Start DFS from B

Only B gets visited.

Visited:

X X X X
X O O X
X X O X
X V X X

-------------------------------------------------------------------------------

Remaining O's are not visited.

Therefore:

Convert them into X.

-------------------------------------------------------------------------------

Final:

X X X X
X X X X
X X X X
X O X X

===============================================================================
DRY RUN
===============================================================================

Input:

X X X X
X O O X
X X O X
X O X X

-------------------------------------------------------------------------------

Step 1:

visited[][] = false

-------------------------------------------------------------------------------

Step 2:

Check boundaries.

Found:

(3,1) = O

Run DFS.

-------------------------------------------------------------------------------

DFS:

Visit (3,1)

No connected O's.

-------------------------------------------------------------------------------

Visited Matrix:

F F F F
F F F F
F F F F
F T F F

-------------------------------------------------------------------------------

Step 3:

Traverse matrix.

(1,1) = O and unvisited
→ Convert to X

(1,2) = O and unvisited
→ Convert to X

(2,2) = O and unvisited
→ Convert to X

-------------------------------------------------------------------------------

Result:

X X X X
X X X X
X X X X
X O X X

===============================================================================
WHY DFS WORKS?
===============================================================================

DFS explores every O connected to a boundary O.

Hence:

Visited O
=
Safe O

-------------------------------------------------------------------------------

Any unvisited O

means

No path exists to boundary.

Therefore it is completely surrounded.

Hence it can be converted to X.

===============================================================================
TIME COMPLEXITY
===============================================================================

Let:

N = Number of Rows
M = Number of Columns

-------------------------------------------------------------------------------

Boundary Traversal:

O(N + M)

-------------------------------------------------------------------------------

DFS Traversal:

Each cell visited at most once.

O(N × M)

-------------------------------------------------------------------------------

Final Matrix Traversal:

O(N × M)

-------------------------------------------------------------------------------

Total Time Complexity:

O(N × M)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Visited Array:

O(N × M)

-------------------------------------------------------------------------------

Recursive DFS Stack:

Worst Case:

O(N × M)

(when entire matrix contains O)

-------------------------------------------------------------------------------

Total Space Complexity:

O(N × M)

===============================================================================
INTERVIEW QUESTIONS
===============================================================================

Q1. Why start from boundary O's?

Because boundary O's can never be surrounded.

-------------------------------------------------------------------------------

Q2. What does visited[][] represent?

O's connected to boundary.

-------------------------------------------------------------------------------

Q3. Which O's are converted into X?

Unvisited O's only.

-------------------------------------------------------------------------------

Q4. Can BFS be used instead of DFS?

Yes.

Both BFS and DFS work perfectly.

-------------------------------------------------------------------------------

Q5. Why not start DFS from every O?

That would lead to unnecessary traversals.

Starting from boundary O's is optimal.

===============================================================================
*/

public class _07_Surrounded_Regions {

    // Up, Right, Down, Left
    private final int[] delRow = { -1, 0, 1, 0 };
    private final int[] delCol = { 0, 1, 0, -1 };

    /*
     * Check whether cell lies inside matrix.
     */
    private boolean isValid(int row, int col, int n, int m) {

        return row >= 0 &&
                row < n &&
                col >= 0 &&
                col < m;
    }

    /*
     * DFS Traversal
     * Marks all O's connected to boundary.
     */
    private void dfs(int row,
            int col,
            boolean[][] visited,
            char[][] mat,
            int n,
            int m) {

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {

            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (isValid(newRow, newCol, n, m)
                    && mat[newRow][newCol] == 'O'
                    && !visited[newRow][newCol]) {

                dfs(newRow,
                        newCol,
                        visited,
                        mat,
                        n,
                        m);
            }
        }
    }

    /*
     * Replace surrounded O's with X.
     */
    public char[][] fill(char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];

        /*
         * Traverse first and last row.
         */
        for (int col = 0; col < m; col++) {

            if (mat[0][col] == 'O'
                    && !visited[0][col]) {

                dfs(0,
                        col,
                        visited,
                        mat,
                        n,
                        m);
            }

            if (mat[n - 1][col] == 'O'
                    && !visited[n - 1][col]) {

                dfs(n - 1,
                        col,
                        visited,
                        mat,
                        n,
                        m);
            }
        }

        /*
         * Traverse first and last column.
         */
        for (int row = 0; row < n; row++) {

            if (mat[row][0] == 'O'
                    && !visited[row][0]) {

                dfs(row,
                        0,
                        visited,
                        mat,
                        n,
                        m);
            }

            if (mat[row][m - 1] == 'O'
                    && !visited[row][m - 1]) {

                dfs(row,
                        m - 1,
                        visited,
                        mat,
                        n,
                        m);
            }
        }

        /*
         * Convert unvisited O into X.
         */
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (mat[row][col] == 'O'
                        && !visited[row][col]) {

                    mat[row][col] = 'X';
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {

        char[][] mat = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };

        _07_Surrounded_Regions obj = new _07_Surrounded_Regions();

        char[][] answer = obj.fill(mat);

        System.out.println("Updated Matrix:");

        for (char[] row : answer) {

            for (char cell : row) {

                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }
}