// Problem: Longest Arithmetic Subsequence
// LeetCode: https://leetcode.com/problems/longest-arithmetic-subsequence/

import java.util.*;

public class LongestArithmeticSubsequence {

    // ----------- Optimal DP + HashMap of Differences -----------
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, maxLen = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, len);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(n^2) (worst case for all diffs)
    */
}
