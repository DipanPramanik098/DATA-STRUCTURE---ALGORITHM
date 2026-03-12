package _006_Hashing._003_Contest;

import java.util.HashMap;

public class _03_Maximum_Point_On_A_Line {

    public int maximumPointsOnALine(int[][] nums) {

        // Number of points
        int n = nums.length;

        // If points are 0, 1, or 2,
        // answer is simply n
        if (n <= 2) {
            return n;
        }

        // Stores final maximum number of points
        int maxPoints = 1;

        // Fix one point at a time
        for (int i = 0; i < n; i++) {

            // HashMap stores:
            // key   -> normalized slope
            // value -> number of points having that slope
            HashMap<String, Integer> map = new HashMap<>();

            // Maximum number of points sharing same slope
            // with current point i
            int localMax = 0;

            // Compare current point with all next points
            for (int j = i + 1; j < n; j++) {

                // Difference in x-coordinates
                int dx = nums[j][0] - nums[i][0];

                // Difference in y-coordinates
                int dy = nums[j][1] - nums[i][1];

                // Reduce dy and dx by their gcd
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                // Normalize sign so equivalent slopes
                // always get same representation
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }
                // Vertical line case
                else if (dx == 0) {
                    dy = 1;
                }
                // Horizontal line case
                else if (dy == 0) {
                    dx = 1;
                }

                // Create unique slope key
                String key = dy + "/" + dx;

                // Update frequency of this slope
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                // Update local maximum
                localMax = Math.max(localMax, count);
            }

            // Add 1 for the point itself
            maxPoints = Math.max(maxPoints, localMax + 1);
        }

        return maxPoints;
    }

    // Function to find gcd of two numbers
    private int gcd(int a, int b) {

        // If one is zero, return absolute of other
        if (a == 0) return Math.abs(b);
        if (b == 0) return Math.abs(a);

        a = Math.abs(a);
        b = Math.abs(b);

        // Euclidean algorithm
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) {

        _03_Maximum_Point_On_A_Line obj =
                new _03_Maximum_Point_On_A_Line();

        int[][] nums = {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3}
        };

        int ans = obj.maximumPointsOnALine(nums);

        System.out.println("Maximum points on a line: " + ans);
    }
}