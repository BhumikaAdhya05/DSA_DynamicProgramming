// Problem: Partition Equal Subset Sum
// LeetCode: https://leetcode.com/problems/partition-equal-subset-sum/

public class PartitionEqualSubsetSum {

    // ----------- Brute Force Recursion -----------
    public boolean canPartitionBrute(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;

        return dfs(nums, 0, total / 2);
    }

    private boolean dfs(int[] nums, int i, int target) {
        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;

        return dfs(nums, i + 1, target - nums[i]) || dfs(nums, i + 1, target);
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n)
    */


    // ----------- Bottom-Up DP -----------
    public boolean canPartitionDP(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }

    /*
       Time Complexity: O(n * target)
       Space Complexity: O(target)
    */
}
