// Problem: Number of Ways to Stay in the Same Place After Some Steps
// LeetCode: https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/

public class WaysToStay {

    private static final int MOD = 1_000_000_007;

    // ----------- DP with 2D Array -----------
    public int numWays(int steps, int arrLen) {
        int maxCol = Math.min(steps, arrLen);
        int[][] dp = new int[steps + 1][maxCol + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxCol; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                if (j < maxCol) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
            }
        }

        return dp[steps][0];
    }

    /*
       Time Complexity: O(steps * min(steps, arrLen))
       Space Complexity: O(steps * min(steps, arrLen))
    */
}
