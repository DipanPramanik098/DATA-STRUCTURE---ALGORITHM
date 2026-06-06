package _018_Graphs._02_Traversals_Problems;

import java.util.*;

/*
===============================================================================
                        NUMBER OF DISTINCT ISLANDS
===============================================================================

PROBLEM STATEMENT
-------------------------------------------------------------------------------

You are given a binary matrix grid[][] of size N x M.

0 -> Water
1 -> Land

A group of connected 1's (connected horizontally or vertically)
forms an island.

Your task is to count the number of DISTINCT islands.

-------------------------------------------------------------------------------

Two islands are considered SAME if:

Their shapes are exactly identical.

-------------------------------------------------------------------------------

Two islands are considered DIFFERENT if:

Their shapes differ.

-------------------------------------------------------------------------------

IMPORTANT:

Rotation is NOT allowed.
Reflection is NOT allowed.

Only exact shape matching is considered.

===============================================================================
EXAMPLE 1
===============================================================================

Input:

[
 [1,1,0,0,0],
 [1,1,0,0,0],
 [0,0,0,1,1],
 [0,0,0,1,1]
]

Visualization:

Island 1          Island 2

1 1               1 1
1 1               1 1

Both have identical shapes.

Output:

1

Explanation:

There are 2 islands,
but both have same shape.

Distinct Islands = 1

===============================================================================
EXAMPLE 2
===============================================================================

Input:

[
 [1,1,0,1,1],
 [1,0,0,0,0],
 [0,0,0,0,1],
 [1,1,0,1,1]
]

Output:

3

Explanation:

There are 4 islands.

Two islands have identical shape.

Hence:

Distinct Islands = 3

===============================================================================
PRACTICE QUESTION
===============================================================================

Input:

[
 [1,1,0,0,0],
 [1,1,0,0,0],
 [0,0,0,0,0],
 [0,0,0,1,1]
]

Visualization:

Island 1:

1 1
1 1

Island 2:

1 1

Shapes are different.

Output:

2

Correct Answer:
Option 1

===============================================================================
INTUITION
===============================================================================

The challenge is NOT finding islands.

The challenge is determining whether
two islands have the same shape.

-------------------------------------------------------------------------------

Suppose we store absolute coordinates.

Island A:

(0,0)
(0,1)
(1,0)

Island B:

(5,5)
(5,6)
(6,5)

Both islands have same shape.

But coordinates are different.

So absolute coordinates cannot be used.

===============================================================================
KEY IDEA
===============================================================================

Store RELATIVE coordinates.

-------------------------------------------------------------------------------

Suppose DFS starts from:

Base Cell = (rowBase, colBase)

For every cell in island store:

(row - rowBase,
 col - colBase)

-------------------------------------------------------------------------------

Island A:

(0,0)
(0,1)
(1,0)

Relative Coordinates:

(0,0)
(0,1)
(1,0)

-------------------------------------------------------------------------------

Island B:

(5,5)
(5,6)
(6,5)

Relative Coordinates:

(0,0)
(0,1)
(1,0)

-------------------------------------------------------------------------------

Both generate same signature.

Therefore:

Same Shape

===============================================================================
WHY HASHSET?
===============================================================================

HashSet stores only unique entries.

Example:

Shape1:
"0,0 0,1 1,0"

Shape2:
"0,0 0,1 1,0"

Only one copy stored.

-------------------------------------------------------------------------------

Shape3:
"0,0 0,1"

Stored separately.

-------------------------------------------------------------------------------

Number of Distinct Islands
=
HashSet Size

===============================================================================
APPROACH
===============================================================================

STEP 1
-------------------------------------------------------------------------------

Create a HashSet<String>

This will store unique island signatures.

-------------------------------------------------------------------------------

STEP 2
-------------------------------------------------------------------------------

Traverse the grid.

Whenever a land cell (1) is found:

Start DFS.

-------------------------------------------------------------------------------

STEP 3
-------------------------------------------------------------------------------

During DFS:

Mark current cell visited.

Store relative coordinates:

(row - baseRow,
 col - baseCol)

inside StringBuilder.

-------------------------------------------------------------------------------

STEP 4
-------------------------------------------------------------------------------

After DFS completes:

Convert StringBuilder into String.

Insert into HashSet.

-------------------------------------------------------------------------------

STEP 5
-------------------------------------------------------------------------------

Continue for all islands.

-------------------------------------------------------------------------------

STEP 6
-------------------------------------------------------------------------------

Return:

set.size()

===============================================================================
VISUAL UNDERSTANDING
===============================================================================

Grid:

1 1 0 0
1 0 0 0

0 0 1 1
0 0 1 0

-------------------------------------------------------------------------------

Island 1:

1 1
1

Base = (0,0)

Signature:

(0,0)
(0,1)
(1,0)

Stored as:

"0,0 0,1 1,0"

-------------------------------------------------------------------------------

Island 2:

1 1
1

Base = (2,2)

Relative Coordinates:

(0,0)
(0,1)
(1,0)

Stored as:

"0,0 0,1 1,0"

-------------------------------------------------------------------------------

HashSet contains:

{
 "0,0 0,1 1,0"
}

Answer = 1

===============================================================================
DRY RUN
===============================================================================

Input:

[
 [1,1,0,0],
 [1,0,0,0],
 [0,0,1,1],
 [0,0,1,0]
]

-------------------------------------------------------------------------------

Start DFS from (0,0)

Signature:

0,0
0,1
1,0

Shape:

"0,0 0,1 1,0"

Insert into set.

Set Size = 1

-------------------------------------------------------------------------------

Start DFS from (2,2)

Signature:

0,0
0,1
1,0

Shape:

"0,0 0,1 1,0"

Already exists.

Set Size = 1

-------------------------------------------------------------------------------

Return:

1

===============================================================================
WHY RELATIVE COORDINATES WORK?
===============================================================================

Translation (position change) does not matter.

Only shape matters.

-------------------------------------------------------------------------------

By subtracting base coordinates:

(row - baseRow,
 col - baseCol)

we normalize every island.

-------------------------------------------------------------------------------

Same shape
→ Same signature

Different shape
→ Different signature

===============================================================================
TIME COMPLEXITY
===============================================================================

N = Number of Rows
M = Number of Columns

-------------------------------------------------------------------------------

Grid Traversal:

O(N × M)

-------------------------------------------------------------------------------

DFS Traversal:

Each cell visited once.

O(N × M)

-------------------------------------------------------------------------------

HashSet Insertion:

Average O(1)

-------------------------------------------------------------------------------

Overall Time Complexity:

O(N × M)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Visited Island Storage
(HashSet + Signatures)

O(N × M)

-------------------------------------------------------------------------------

DFS Recursive Stack

Worst Case:

O(N × M)

-------------------------------------------------------------------------------

Overall Space Complexity:

O(N × M)

===============================================================================
INTERVIEW QUESTIONS
===============================================================================

Q1. Why can't we use absolute coordinates?

Because identical islands at different positions
would appear different.

-------------------------------------------------------------------------------

Q2. Why use relative coordinates?

To normalize island shape.

-------------------------------------------------------------------------------

Q3. Why use HashSet?

To automatically keep only unique shapes.

-------------------------------------------------------------------------------

Q4. Does rotation count as same island?

No.

Rotation is NOT allowed.

-------------------------------------------------------------------------------

Q5. Does reflection count as same island?

No.

Reflection is NOT allowed.

-------------------------------------------------------------------------------

Q6. What identifies an island uniquely?

Its relative coordinate signature.

===============================================================================
*/

public class _08_Number_Of_Distinct_island {

    // Up, Left, Down, Right
    private final int[] delRow = {-1, 0, 1, 0};
    private final int[] delCol = {0, -1, 0, 1};

    /*
     * Check whether cell lies inside grid.
     */
    private boolean isValid(int row,
                            int col,
                            int n,
                            int m) {

        return row >= 0 &&
               row < n &&
               col >= 0 &&
               col < m;
    }

    /*
     * DFS Traversal
     *
     * Generates shape signature using
     * relative coordinates.
     */
    private void dfs(int row,
                     int col,
                     int[][] grid,
                     int baseRow,
                     int baseCol,
                     StringBuilder shape) {

        int n = grid.length;
        int m = grid[0].length;

        // Mark visited
        grid[row][col] = 0;

        // Store relative coordinates
        shape.append(row - baseRow)
             .append(",")
             .append(col - baseCol)
             .append(" ");

        // Explore 4 directions
        for (int d = 0; d < 4; d++) {

            int newRow = row + delRow[d];
            int newCol = col + delCol[d];

            if (isValid(newRow, newCol, n, m)
                    && grid[newRow][newCol] == 1) {

                dfs(newRow,
                    newCol,
                    grid,
                    baseRow,
                    baseCol,
                    shape);
            }
        }
    }

    /*
     * Returns number of distinct islands.
     */
    public int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Set<String> uniqueShapes =
                new HashSet<>();

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (grid[row][col] == 1) {

                    StringBuilder shape =
                            new StringBuilder();

                    dfs(row,
                        col,
                        grid,
                        row,
                        col,
                        shape);

                    uniqueShapes.add(
                            shape.toString()
                    );
                }
            }
        }

        return uniqueShapes.size();
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };

        _08_Number_Of_Distinct_island obj =
                new _08_Number_Of_Distinct_island();

        int answer =
                obj.countDistinctIslands(grid);

        System.out.println(
                "Number of Distinct Islands = "
                        + answer
        );
    }
}