// Problem 1: Word Break I
// LeetCode 139: https://leetcode.com/problems/word-break/

import java.util.*;

public class WordBreakI {

    // ----------- DP Bottom-Up -----------
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
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
