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

// Problem 2: Word Break II
// LeetCode 140: https://leetcode.com/problems/word-break-ii/

public class WordBreakII {

    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet);
    }

    private List<String> dfs(String s, Set<String> dict) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();

        if (dict.contains(s)) result.add(s);

        for (int i = 1; i < s.length(); i++) {
            String right = s.substring(i);
            if (!dict.contains(right)) continue;

            List<String> leftParts = dfs(s.substring(0, i), dict);
            for (String left : leftParts)
                result.add(left + " " + right);
        }

        memo.put(s, result);
        return result;
    }

    /*
       Time Complexity: Exponential in worst-case
       Space Complexity: O(n * k), where k = number of valid partitions
    */
}
