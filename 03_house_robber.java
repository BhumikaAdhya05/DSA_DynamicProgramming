// Problem: House Robber
// LeetCode: https://leetcode.com/problems/house-robber/

public class HouseRobber {

    // ----------- Approach 1: Brute Force Recursion -----------
    /*
       Idea:
       At each house, we can either rob it and skip the next, or skip it.
       Try all such combinations recursively.
    */
    public int robBrute(int[] nums) {
        return robBruteHelper(nums, 0);
    }

    private int robBruteHelper(int[] nums, int i) {
        if (i >= nums.length) return 0;
        return Math.max(nums[i] + robBruteHelper(nums, i + 2), robBruteHelper(nums, i + 1));
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n) - recursion stack
    */


    // ----------- Approach 2: Top-Down DP (Memoization) -----------
    public int robMemo(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return robMemoHelper(nums, 0, memo);
    }

    private int robMemoHelper(int[] nums, int i, Integer[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] != null) return memo[i];

        memo[i] = Math.max(nums[i] + robMemoHelper(nums, i + 2, memo), robMemoHelper(nums, i + 1, memo));
        return memo[i];
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */


    // ----------- Approach 3: Bottom-Up DP -----------
    public int robDP(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        return dp[nums.length - 1];
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */


    // ----------- Approach 4: Space Optimized DP -----------
    public int robOptimized(int[] nums) {
        int prev1 = 0, prev2 = 0;

        for (int num : nums) {
            int temp = Math.max(num + prev2, prev1);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */
}
