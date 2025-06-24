// Problem: Count Palindromic Subsequences
// GFG: https://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/

public class PalindromicSubsequences {

    // ----------- Brute Force Recursion (Very slow) -----------
    public int countSubseqBrute(String s) {
        return dfs(s, 0, s.length() - 1);
    }

    private int dfs(String s, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (s.charAt(i) == s.charAt(j)) {
            return 1 + dfs(s, i + 1, j) + dfs(s, i, j - 1);
        } else {
            return dfs(s, i + 1, j) + dfs(s, i, j - 1) - dfs(s, i + 1, j - 1);
        }
    }

    /*
       Time Complexity: O(3^n)
       Space Complexity: O(n)
    */


    // ----------- DP Approach -----------
    public int countSubseqDP(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(n^2)
    */
}
