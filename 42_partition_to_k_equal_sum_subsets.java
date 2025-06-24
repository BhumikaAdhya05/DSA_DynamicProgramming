// Problem: Partition to K Equal Sum Subsets
// LeetCode: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

import java.util.*;

public class PartitionKEqualSum {

    // ----------- Backtracking + Memoization -----------
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) return false;

        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int k, int start, int currSum, int target) {
        if (k == 1) return true;
        if (currSum == target)
            return backtrack(nums, visited, k - 1, 0, 0, target);

        for (int i = start; i < nums.length; i++) {
            if (visited[i] || currSum + nums[i] > target) continue;
            visited[i] = true;
            if (backtrack(nums, visited, k, i + 1, currSum + nums[i], target)) return true;
            visited[i] = false;
        }

        return false;
    }

    /*
       Time Complexity: O(k * 2^n)
       Space Complexity: O(n)
    */
}
