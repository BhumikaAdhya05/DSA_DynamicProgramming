// Problem: Longest Increasing Subsequence
// LeetCode: https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.*;

public class LIS {

    // ----------- Approach 1: Brute Force Recursion -----------
    public int lengthOfLISBrute(int[] nums) {
        return dfs(nums, -1, 0);
    }

    private int dfs(int[] nums, int prevIndex, int currIndex) {
        if (currIndex == nums.length) return 0;

        int take = 0;
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            take = 1 + dfs(nums, currIndex, currIndex + 1);
        }

        int notTake = dfs(nums, prevIndex, currIndex + 1);
        return Math.max(take, notTake);
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n)
    */


    // ----------- Approach 2: DP (O(n^2)) -----------
    public int lengthOfLISDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(n)
    */


    // ----------- Approach 3: Binary Search (O(n log n)) -----------
    public int lengthOfLISBinarySearch(int[] nums) {
        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);
            if (i < 0) i = -(i + 1);

            if (i < sub.size()) sub.set(i, num);
            else sub.add(num);
        }

        return sub.size();
    }

    /*
       Time Complexity: O(n log n)
       Space Complexity: O(n)
    */
}
