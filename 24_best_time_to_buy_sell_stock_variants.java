// Problem: Best Time to Buy and Sell Stock (I)
// LeetCode 121: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class StockProfitVariants {

    // ---------- LeetCode 121: One Transaction ----------
    public int maxProfit1(int[] prices) {
        int min = prices[0], maxProfit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */


    // ---------- LeetCode 122: Infinite Transactions ----------
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */


    // ---------- LeetCode 123: At Most Two Transactions ----------
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[] left = new int[n], right = new int[n];

        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, left[i] + right[i]);
        }
        return res;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */


    // ---------- LeetCode 188: At Most K Transactions ----------
    public int maxProfitKTransactions(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][n - 1];
    }

    /*
       Time Complexity: O(k * n)
       Space Complexity: O(k * n)
    */


    // ---------- LeetCode 309: With Cooldown ----------
    public int maxProfitWithCooldown(int[] prices) {
        int sold = 0, held = Integer.MIN_VALUE, rest = 0;

        for (int price : prices) {
            int prevSold = sold;
            sold = held + price;
            held = Math.max(held, rest - price);
            rest = Math.max(rest, prevSold);
        }

        return Math.max(sold, rest);
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */


    // ---------- LeetCode 714: With Transaction Fee ----------
    public int maxProfitWithFee(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */
}
