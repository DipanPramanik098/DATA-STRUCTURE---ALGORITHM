package _018_Graphs._02_Traversals_Problems;

import java.util.*;

/*
===============================================================================
                            ROTTEN ORANGES (LeetCode 994)
===============================================================================

PROBLEM STATEMENT
-------------------------------------------------------------------------------

You are given a grid of size N x M where:

0 -> Empty Cell
1 -> Fresh Orange
2 -> Rotten Orange

Rule:
Every minute, a rotten orange can rot all adjacent fresh oranges
in 4 directions:

↑ Up
↓ Down
← Left
→ Right

Return the minimum number of minutes required to rot all oranges.

If it is impossible to rot all fresh oranges, return -1.

-------------------------------------------------------------------------------
EXAMPLE 1
-------------------------------------------------------------------------------

Input:

[
 [2,1,1],
 [0,1,1],
 [1,0,1]
]

Output:
-1

Explanation:

2 1 1
0 1 1
1 0 1

The orange at (2,0) is isolated.

No rotten orange can reach it.

Therefore all oranges can never become rotten.

Answer = -1

-------------------------------------------------------------------------------
EXAMPLE 2
-------------------------------------------------------------------------------

Input:

[
 [2,1,1],
 [1,1,0],
 [0,1,1]
]

Output:
4

Explanation:

Minute 0

2 1 1
1 1 0
0 1 1

Minute 1

2 2 1
2 1 0
0 1 1

Minute 2

2 2 2
2 2 0
0 1 1

Minute 3

2 2 2
2 2 0
0 2 1

Minute 4

2 2 2
2 2 0
0 2 2

All oranges become rotten.

Answer = 4

-------------------------------------------------------------------------------
PRACTICE QUESTION
-------------------------------------------------------------------------------

Input:

[
 [0,1,2],
 [0,1,2],
 [2,1,1]
]

Output:
2

Explanation:

Minute 0

0 1 2
0 1 2
2 1 1

Minute 1

0 1 2
0 2 2
2 2 2

Minute 2

0 2 2
0 2 2
2 2 2

All oranges become rotten.

Answer = 2

===============================================================================
INTUITION
===============================================================================

A rotten orange spreads rot to all adjacent fresh oranges
simultaneously every minute.

Important Observation:

All rotten oranges start spreading at the SAME TIME.

This is exactly a Multi-Source BFS problem.

Why BFS?

Because:

Level 0 -> Initial rotten oranges
Level 1 -> Oranges rotten after 1 minute
Level 2 -> Oranges rotten after 2 minutes
Level 3 -> Oranges rotten after 3 minutes

Each BFS level represents one minute.

Therefore:

Time Taken = Number of BFS Levels

===============================================================================
WHY MULTI-SOURCE BFS?
===============================================================================

Suppose:

2 0 2

There are two rotten oranges.

Both start spreading simultaneously.

So we push ALL rotten oranges into queue initially.

Queue:

[(0,0), (0,2)]

This is called Multi-Source BFS.

===============================================================================
APPROACH
===============================================================================

Step 1:
Traverse the entire grid.

Count total oranges:

Fresh + Rotten

Store in variable total.

-------------------------------------------------------------------------------

Step 2:
Push all rotten oranges into queue.

These are starting points for BFS.

-------------------------------------------------------------------------------

Step 3:
Perform BFS level by level.

Each level = 1 minute.

For every rotten orange:

Check 4 neighbours.

If neighbour is fresh:

Convert it into rotten.

Add into queue.

-------------------------------------------------------------------------------

Step 4:
After finishing one level:

If queue still contains oranges,

increment time.

-------------------------------------------------------------------------------

Step 5:
Count how many oranges became rotten.

If

count == total

all oranges are rotten.

Return time.

Else

some fresh oranges were unreachable.

Return -1.

===============================================================================
VISUAL UNDERSTANDING
===============================================================================

Initial Grid

2 1 1
1 1 0
0 1 1

-------------------------------------------------------------------------------

Minute 0

2 1 1
1 1 0
0 1 1

-------------------------------------------------------------------------------

Minute 1

2 2 1
2 1 0
0 1 1

-------------------------------------------------------------------------------

Minute 2

2 2 2
2 2 0
0 1 1

-------------------------------------------------------------------------------

Minute 3

2 2 2
2 2 0
0 2 1

-------------------------------------------------------------------------------

Minute 4

2 2 2
2 2 0
0 2 2

Answer = 4

===============================================================================
DRY RUN
===============================================================================

Input:

[
 [0,1,2],
 [0,1,2],
 [2,1,1]
]

-------------------------------------------------------------------------------

Step 1

Queue initially contains all rotten oranges:

[(0,2), (1,2), (2,0)]

Total oranges = 6

-------------------------------------------------------------------------------

Minute 0

Process:

(0,2)
(1,2)
(2,0)

New rotten:

(1,1)
(2,1)
(2,2)

Queue:

[(1,1), (2,1), (2,2)]

time = 1

-------------------------------------------------------------------------------

Minute 1

Process:

(1,1)
(2,1)
(2,2)

New rotten:

(0,1)

Queue:

[(0,1)]

time = 2

-------------------------------------------------------------------------------

Minute 2

Process:

(0,1)

No new fresh oranges.

Queue becomes empty.

-------------------------------------------------------------------------------

All oranges rotten.

Answer = 2

===============================================================================
WHY COUNT VARIABLE IS USED?
===============================================================================

Consider:

2 1 1
0 0 0
1 1 1

Bottom oranges are completely disconnected.

BFS cannot reach them.

If we simply return time,
we may get incorrect answer.

Therefore:

total = total oranges

count = oranges actually processed by BFS

If:

count != total

some oranges never became rotten.

Return -1.

===============================================================================
TIME COMPLEXITY
===============================================================================

Let:

N = Number of Rows
M = Number of Columns

Every orange enters queue at most once.

For every cell,
4 neighbours are checked.

Time Complexity:

O(N × M)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Queue may contain all oranges.

Space Complexity:

O(N × M)

===============================================================================
INTERVIEW QUESTIONS
===============================================================================

Q1. Why BFS and not DFS?

Because infection spreads level-by-level.
Each BFS level naturally represents one minute.

-------------------------------------------------------------------------------

Q2. Why Multi-Source BFS?

Because all rotten oranges start spreading
simultaneously from minute 0.

-------------------------------------------------------------------------------

Q3. What does one BFS level represent?

Exactly one minute.

-------------------------------------------------------------------------------

Q4. Why modify fresh orange to rotten immediately?

To avoid visiting the same orange multiple times.

-------------------------------------------------------------------------------

Q5. When do we return -1?

When some fresh oranges remain unreachable.

Condition:

count != total

===============================================================================
*/

public class _05_Rotten_Oranges {

    // Directions: Up, Right, Down, Left
    private final int[] delRow = {-1, 0, 1, 0};
    private final int[] delCol = {0, 1, 0, -1};

    /*
     * Check whether a cell is inside the grid.
     */
    private boolean isValid(int row, int col, int n, int m) {

        return row >= 0 &&
               row < n &&
               col >= 0 &&
               col < m;
    }

    /*
     * Returns minimum minutes required
     * to rot all oranges.
     */
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int total = 0; // Total oranges
        int count = 0; // Rotten oranges processed
        int time = 0;

        Queue<int[]> queue = new LinkedList<>();

        /*
         * Find total oranges and
         * push all rotten oranges
         * into queue.
         */
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (grid[row][col] != 0) {
                    total++;
                }

                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        /*
         * Multi-Source BFS
         */
        while (!queue.isEmpty()) {

            int size = queue.size();

            count += size;

            while (size-- > 0) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for (int i = 0; i < 4; i++) {

                    int newRow = row + delRow[i];
                    int newCol = col + delCol[i];

                    if (isValid(newRow, newCol, n, m)
                            && grid[newRow][newCol] == 1) {

                        // Make fresh orange rotten
                        grid[newRow][newCol] = 2;

                        queue.offer(
                                new int[]{newRow, newCol}
                        );
                    }
                }
            }

            /*
             * If queue still contains oranges,
             * one more minute has passed.
             */
            if (!queue.isEmpty()) {
                time++;
            }
        }

        /*
         * If all oranges became rotten.
         */
        if (count == total) {
            return time;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 2},
                {0, 1, 2},
                {2, 1, 1}
        };

        _05_Rotten_Oranges obj =
                new _05_Rotten_Oranges();

        int answer = obj.orangesRotting(grid);

        System.out.println(
                "Minimum Time Required = " + answer
        );
    }
}