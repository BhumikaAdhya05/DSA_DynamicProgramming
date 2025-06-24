// Problem: Coin Change II
// LeetCode: https://leetcode.com/problems/coin-change-ii/

public class CoinChange2 {

    // ----------- Approach 1: Brute Force Recursion -----------
    public int changeBrute(int amount, int[] coins) {
        return dfs(coins, amount, 0);
    }

    private int dfs(int[] coins, int amount, int i) {
        if (amount == 0) return 1;
        if (i >= coins.length || amount < 0) return 0;

        // Include current coin + Exclude current coin
        return dfs(coins, amount - coins[i], i) + dfs(coins, amount, i + 1);
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n)
    */


    // ----------- Approach 2: Bottom-Up DP -----------
    public int changeDP(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    /*
       Time Complexity: O(n * amount)
       Space Complexity: O(amount)
    */
}
