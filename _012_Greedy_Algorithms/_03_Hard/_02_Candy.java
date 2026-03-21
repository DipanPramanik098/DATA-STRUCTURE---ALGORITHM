package _012_Greedy_Algorithms._03_Hard;

public class _02_Candy {

    // Function to find minimum candies required
    public int candy(int[] ratings) {

        int n = ratings.length;

        // First child gets 1 candy
        int sum = 1;

        int i = 1;

        while (i < n) {

            // Case 1: Equal ratings
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Case 2: Increasing slope
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Case 3: Decreasing slope
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                i++;
                down++;
            }

            // If decreasing slope is longer than peak,
            // peak child needs one extra adjustment
            if (down > peak) {
                sum += (down - peak);
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        _02_Candy obj = new _02_Candy();

        int[] ratings1 = {1, 0, 5};
        int[] ratings2 = {1, 2, 2};
        int[] ratings3 = {1, 2, 1, 4, 5};

        System.out.println("Example 1: " + obj.candy(ratings1)); // 5
        System.out.println("Example 2: " + obj.candy(ratings2)); // 4
        System.out.println("Test Case: " + obj.candy(ratings3)); // 9
    }
}