// Problem: Decode Ways
// LeetCode: https://leetcode.com/problems/decode-ways/

public class DecodeWays {

    // ----------- Brute Force Recursion -----------
    public int numDecodingsBrute(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;

        int res = dfs(s, i + 1);

        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num <= 26) res += dfs(s, i + 2);
        }

        return res;
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n)
    */


    // ----------- DP Approach (Bottom-Up) -----------
    public int numDecodingsDP(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));

            if (one >= 1 && one <= 9)
                dp[i] += dp[i - 1];

            if (two >= 10 && two <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[n];
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */
}
