package _19_Dynamic_Programming.Lession_11;

public class _02_Best_Time_To_Buy_Sell_Stock_2 {

    // O(n) Time | O(1) Space
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices1)); // 7

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Maximum Profit: " + maxProfit(prices2)); // 4

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit: " + maxProfit(prices3)); // 0
    }
}