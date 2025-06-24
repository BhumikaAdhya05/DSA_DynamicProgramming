// Problem: Longest Palindromic Substring
// LeetCode: https://leetcode.com/problems/longest-palindromic-substring/

public class LongestPalindrome {

    // ----------- Brute Force -----------
    public String longestPalindromeBrute(String s) {
        int maxLen = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > maxLen) {
                    maxLen = sub.length();
                    result = sub;
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    /*
       Time Complexity: O(n^3)
       Space Complexity: O(1)
    */


    // ----------- Optimal: DP -----------
    public String longestPalindromeDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0, maxLen = 1;

        for (int i = 0; i < n; i++) dp[i][i] = true;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxLen) {
                            start = i;
                            maxLen = len;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(n^2)
    */
}
