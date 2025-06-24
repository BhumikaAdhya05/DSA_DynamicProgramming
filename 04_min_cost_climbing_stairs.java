// Problem: Min Cost Climbing Stairs
// LeetCode: https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinCostClimbingStairs {

    // ----------- Approach 1: Brute Force Recursion -----------
    public int minCostBrute(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        if (i >= cost.length) return 0;
        return cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n)
    */


    // ----------- Approach 2: Top-Down DP (Memoization) -----------
    public int minCostMemo(int[] cost) {
        int n = cost.length;
        Integer[] memo = new Integer[n];
        return Math.min(helper(cost, 0, memo), helper(cost, 1, memo));
    }

    private int helper(int[] cost, int i, Integer[] memo) {
        if (i >= cost.length) return 0;
        if (memo[i] != null) return memo[i];

        memo[i] = cost[i] + Math.min(helper(cost, i + 1, memo), helper(cost, i + 2, memo));
        return memo[i];
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */


    // ----------- Approach 3: Bottom-Up DP -----------
    public int minCostDP(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */


    // ----------- Approach 4: Space Optimized DP -----------
    public int minCostOptimized(int[] cost) {
        int n = cost.length;
        int prev1 = 0, prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int curr = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */
}
