// Problem: Minimum Insertions to Make a Palindrome
// LeetCode: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

public class MinInsertPalindrome {

    // ----------- DP on Substrings -----------
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(n^2)
    */
}
