// Problem: Number of Dice Rolls With Target Sum
// LeetCode: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

public class DiceRollsWithTarget {

    private static final int MOD = 1_000_000_007;

    // ----------- DP 2D -----------
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            for (int t = 1; t <= target; t++) {
                for (int face = 1; face <= k; face++) {
                    if (t - face >= 0)
                        dp[dice][t] = (dp[dice][t] + dp[dice - 1][t - face]) % MOD;
                }
            }
        }

        return dp[n][target];
    }

    /*
       Time Complexity: O(n * k * target)
       Space Complexity: O(n * target)
    */
}
