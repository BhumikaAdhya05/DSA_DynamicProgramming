// Problem: Subset Sum
// GFG: https://www.geeksforgeeks.org/subset-sum-problem/

public class SubsetSum {

    // ----------- Approach 1: Brute Force Recursion -----------
    public boolean isSubsetSumBrute(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    private boolean dfs(int[] nums, int i, int target) {
        if (target == 0) return true;
        if (i == nums.length || target < 0) return false;

        return dfs(nums, i + 1, target - nums[i]) || dfs(nums, i + 1, target);
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n) - recursion stack
    */


    // ----------- Approach 2: Top-Down DP (Memoization) -----------
    public boolean isSubsetSumMemo(int[] nums, int target) {
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return helper(nums, 0, target, memo);
    }

    private boolean helper(int[] nums, int i, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (i == nums.length || target < 0) return false;
        if (memo[i][target] != null) return memo[i][target];

        boolean include = helper(nums, i + 1, target - nums[i], memo);
        boolean exclude = helper(nums, i + 1, target, memo);

        return memo[i][target] = include || exclude;
    }

    /*
       Time Complexity: O(n * target)
       Space Complexity: O(n * target)
    */


    // ----------- Approach 3: Bottom-Up DP -----------
    public boolean isSubsetSumDP(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                if (sum >= nums[i - 1]) {
                    dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - nums[i - 1]];
                } else {
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }

        return dp[n][target];
    }

    /*
       Time Complexity: O(n * target)
       Space Complexity: O(n * target)
    */
}
