// Problem: Target Sum
// LeetCode: https://leetcode.com/problems/target-sum/

public class TargetSum {

    // ----------- Approach 1: Brute Force Recursion -----------
    public int findTargetSumWaysBrute(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int i, int sum, int target) {
        if (i == nums.length) return sum == target ? 1 : 0;
        return dfs(nums, i + 1, sum + nums[i], target) + dfs(nums, i + 1, sum - nums[i], target);
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n)
    */


    // ----------- Approach 2: Top-Down DP (Memoization) -----------
    public int findTargetSumWaysMemo(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) return 0;

        int newTarget = (sum + target) / 2;
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = newTarget; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[newTarget];
    }

    /*
       Time Complexity: O(n * sum)
       Space Complexity: O(sum)
       (Subset sum DP reinterpretation)
    */
}
