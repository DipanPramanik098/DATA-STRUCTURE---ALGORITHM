package _018_Graphs._02_Traversals_Problems;

import java.util.*;

/*
=========================================================
                FLOOD FILL ALGORITHM
=========================================================

Problem Statement:
------------------
An image is represented as a 2D matrix where each
cell contains a color value.

Given:

1. image[][] -> Original image
2. sr, sc    -> Starting pixel
3. newColor  -> Color to be filled

Replace the color of the starting pixel and all
4-directionally connected pixels having the same
initial color with newColor.

---------------------------------------------------------
4 Directions:
---------------------------------------------------------

        UP
         |
LEFT ---CELL--- RIGHT
         |
       DOWN

Only these directions are allowed.

Diagonal movement is NOT allowed.

=========================================================
EXAMPLE 1
=========================================================

Input:

image = [
          [1,1,1],
          [1,1,0],
          [1,0,1]
        ]

sr = 1
sc = 1
newColor = 2

Output:

[
 [2,2,2],
 [2,2,0],
 [2,0,1]
]

Explanation:

Starting color = 1

All connected 1's reachable through
4 directions become 2.

Bottom-right 1 remains unchanged
because it is not connected.

=========================================================
EXAMPLE 2
=========================================================

Input:

image = [
          [0,1,0],
          [1,1,0],
          [0,0,1]
        ]

sr = 2
sc = 2
newColor = 3

Output:

[
 [0,1,0],
 [1,1,0],
 [0,0,3]
]

Explanation:

Only one pixel has color 1 at (2,2).

Hence only that pixel changes.

=========================================================
MCQ ANSWER
=========================================================

Input:

image = [
          [1,1,1],
          [1,1,0],
          [1,0,1]
        ]

sr = 1
sc = 1
newColor = 0

Output:

[
 [0,0,0],
 [0,0,0],
 [0,0,1]
]

✅ Correct Answer:

[ [0,0,0],
  [0,0,0],
  [0,0,1] ]

Reason:

All connected 1's become 0.

Bottom-right 1 is not connected
through 4 directions.

=========================================================
INTUITION
=========================================================

Think of every pixel as a graph node.

Each node can connect to:

1. Up
2. Right
3. Down
4. Left

If a neighboring pixel has the same color,
it belongs to the same region.

Starting from (sr, sc):

1. Visit the current pixel.
2. Change its color.
3. Visit all neighboring pixels having
   the same original color.
4. Continue recursively.

This is exactly DFS traversal on a graph.

=========================================================
WHY DFS?
=========================================================

DFS naturally explores all connected nodes
before returning.

Whenever we reach a pixel:

1. Color it with newColor.
2. Move in all 4 directions.
3. Repeat for valid pixels having
   the same initial color.

Eventually the whole connected component
gets colored.

=========================================================
APPROACH
=========================================================

Step 1:
Store the initial color.

initialColor = image[sr][sc]

---------------------------------------------------------

Step 2:
Create answer matrix.

Copy original image.

---------------------------------------------------------

Step 3:
Start DFS from (sr, sc).

---------------------------------------------------------

Step 4:
For every visited pixel:

Change color to newColor.

---------------------------------------------------------

Step 5:
Traverse 4 neighbors:

UP
RIGHT
DOWN
LEFT

---------------------------------------------------------

Step 6:
Visit neighbor only if:

1. Inside image boundary.
2. Same initial color.
3. Not already colored.

---------------------------------------------------------

Step 7:
Return modified image.

=========================================================
DRY RUN
=========================================================

Input:

1 1 1
1 1 0
1 0 1

Start = (1,1)

newColor = 2

---------------------------------------------------------

Visit (1,1)

2 1 1
1 2 0
1 0 1

---------------------------------------------------------

Visit connected cells:

(0,1)
(1,0)
(0,0)
(0,2)
(2,0)

---------------------------------------------------------

Final:

2 2 2
2 2 0
2 0 1

=========================================================
DIRECTION ARRAYS
=========================================================

To move efficiently:

delRow = {-1, 0, 1, 0}
delCol = { 0, 1, 0,-1}

Meaning:

(-1,0) -> UP
(0,1)  -> RIGHT
(1,0)  -> DOWN
(0,-1) -> LEFT

=========================================================
TIME COMPLEXITY ANALYSIS
=========================================================

Let:

N = rows
M = columns

---------------------------------------------------------

Every pixel is visited at most once.

DFS visits:

N * M pixels

For every pixel,
4 neighbors are checked.

Time:

O(4 * N * M)

Ignoring constants:

O(N * M)

=========================================================
SPACE COMPLEXITY ANALYSIS
=========================================================

Answer matrix:

O(N * M)

---------------------------------------------------------

Recursion Stack:

Worst case:
Entire image has same color.

DFS depth:

O(N * M)

---------------------------------------------------------

Total Space:

O(N * M)

=========================================================
INTERVIEW FOLLOW-UP
=========================================================

Can we avoid extra answer matrix?

Yes.

Modify image directly.

This reduces extra space.

Only recursion stack remains.

Space Complexity:

O(N * M)  (due to recursion)

=========================================================
*/

public class _03_Flood_Fill_Algorithm {

    // 4 Directions
    private final int[] delRow = {-1, 0, 1, 0};
    private final int[] delCol = {0, 1, 0, -1};

    // Boundary Check
    private boolean isValid(int row, int col,
                            int n, int m) {

        return row >= 0 && row < n
                && col >= 0 && col < m;
    }

    // DFS Traversal
    private void dfs(int row, int col,
                     int[][] ans,
                     int[][] image,
                     int newColor,
                     int initialColor) {

        ans[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {

            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (isValid(newRow, newCol, n, m)
                    && image[newRow][newCol] == initialColor
                    && ans[newRow][newCol] != newColor) {

                dfs(newRow, newCol,
                        ans, image,
                        newColor,
                        initialColor);
            }
        }
    }

    // Main Function
    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int newColor) {

        int initialColor = image[sr][sc];

        int[][] ans =
                new int[image.length][image[0].length];

        // Copy original image
        for (int i = 0; i < image.length; i++) {
            ans[i] = Arrays.copyOf(
                    image[i],
                    image[i].length
            );
        }

        // Start DFS
        dfs(sr, sc, ans,
                image,
                newColor,
                initialColor);

        return ans;
    }

    public static void main(String[] args) {

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        _03_Flood_Fill_Algorithm obj =
                new _03_Flood_Fill_Algorithm();

        int[][] ans =
                obj.floodFill(
                        image,
                        sr,
                        sc,
                        newColor
                );

        System.out.println(
                "Image After Flood Fill:\n"
        );

        for (int[] row : ans) {

            for (int val : row) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }
}