package _19_Dynamic_Programming.Lession_11;

public class _01_Best_Time_To_Buy_Sell_Stock {

    // O(n) Time | O(1) Space
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] > buyPrice) {
                profit = Math.max(profit, prices[i] - buyPrice);
            } else {
                buyPrice = prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Maximum Profit: " + maxProfit(prices1)); // 5

        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println("Maximum Profit: " + maxProfit(prices2)); // 0

        int[] prices3 = { 2, 4, 1 };
        System.out.println("Maximum Profit: " + maxProfit(prices3)); // 2
    }
}
