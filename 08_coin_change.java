// Problem: Coin Change
// LeetCode: https://leetcode.com/problems/coin-change/

public class CoinChange {

    // ----------- Approach 1: Brute Force Recursion -----------
    public int coinChangeBrute(int[] coins, int amount) {
        int result = dfs(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin);
            if (res != Integer.MAX_VALUE) min = Math.min(min, res + 1);
        }

        return min;
    }

    /*
       Time Complexity: O(S^C) exponential
       Space Complexity: O(amount)
    */


    // ----------- Approach 2: Bottom-Up DP -----------
    public int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /*
       Time Complexity: O(n * amount)
       Space Complexity: O(amount)
    */
}
