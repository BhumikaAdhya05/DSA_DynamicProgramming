// Problem: Edit Distance
// LeetCode: https://leetcode.com/problems/edit-distance/

public class EditDistance {

    // ----------- Brute Force Recursion -----------
    public int minDistanceBrute(String word1, String word2) {
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String a, String b, int i, int j) {
        if (i == a.length()) return b.length() - j;
        if (j == b.length()) return a.length() - i;

        if (a.charAt(i) == b.charAt(j))
            return dfs(a, b, i + 1, j + 1);

        int insert = dfs(a, b, i, j + 1);
        int delete = dfs(a, b, i + 1, j);
        int replace = dfs(a, b, i + 1, j + 1);

        return 1 + Math.min(insert, Math.min(delete, replace));
    }

    /*
       Time Complexity: O(3^n)
       Space Complexity: O(n)
    */


    // ----------- Bottom-Up DP -----------
    public int minDistanceDP(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],  // Replace
                                    Math.min(dp[i - 1][j],    // Delete
                                             dp[i][j - 1]));  // Insert
            }
        }

        return dp[m][n];
    }

    /*
       Time Complexity: O(m * n)
       Space Complexity: O(m * n)
    */
}
