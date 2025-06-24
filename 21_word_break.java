// Problem: Word Break
// LeetCode: https://leetcode.com/problems/word-break/

import java.util.*;

public class WordBreak {

    // ----------- Brute Force Recursion -----------
    public boolean wordBreakBrute(String s, List<String> wordDict) {
        return dfs(s, 0, new HashSet<>(wordDict));
    }

    private boolean dfs(String s, int start, Set<String> dict) {
        if (start == s.length()) return true;

        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && dfs(s, end, dict)) {
                return true;
            }
        }

        return false;
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n)
    */


    // ----------- Bottom-Up DP -----------
    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && dict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(n)
    */
}
