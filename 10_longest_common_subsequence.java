// Problem: Longest Common Subsequence
// LeetCode: https://leetcode.com/problems/longest-common-subsequence/

public class LongestCommonSubsequence {

    // ----------- Approach 1: Brute Force Recursion -----------
    public int lcsBrute(String text1, String text2) {
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String a, String b, int i, int j) {
        if (i == a.length() || j == b.length()) return 0;

        if (a.charAt(i) == b.charAt(j))
            return 1 + dfs(a, b, i + 1, j + 1);
        else
            return Math.max(dfs(a, b, i + 1, j), dfs(a, b, i, j + 1));
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n)
    */


    // ----------- Approach 2: Top-Down DP (Memoization) -----------
    public int lcsMemo(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) java.util.Arrays.fill(row, -1);
        return lcsHelper(text1, text2, 0, 0, memo);
    }

    private int lcsHelper(String a, String b, int i, int j, int[][] memo) {
        if (i == a.length() || j == b.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        if (a.charAt(i) == b.charAt(j))
            memo[i][j] = 1 + lcsHelper(a, b, i + 1, j + 1, memo);
        else
            memo[i][j] = Math.max(lcsHelper(a, b, i + 1, j, memo), lcsHelper(a, b, i, j + 1, memo));

        return memo[i][j];
    }

    /*
       Time Complexity: O(m * n)
       Space Complexity: O(m * n)
    */


    // ----------- Approach 3: Bottom-Up DP -----------
    public int lcsDP(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    /*
       Time Complexity: O(m * n)
       Space Complexity: O(m * n)
    */
}
