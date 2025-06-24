// Problem: Unique Paths
// LeetCode: https://leetcode.com/problems/unique-paths/

public class UniquePaths {

    // ----------- Brute Force Recursion -----------
    public int uniquePathsBrute(int m, int n) {
        return dfs(0, 0, m, n);
    }

    private int dfs(int i, int j, int m, int n) {
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;

        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

    /*
       Time Complexity: O(2^(m+n))
       Space Complexity: O(m + n)
    */


    // ----------- Bottom-Up DP -----------
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];

        // Base case: first row and first column = 1 path
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /*
       Time Complexity: O(m * n)
       Space Complexity: O(m * n)
    */


    // ----------- Space Optimized DP -----------
    public int uniquePathsOptimized(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    /*
       Time Complexity: O(m * n)
       Space Complexity: O(n)
    */
}
