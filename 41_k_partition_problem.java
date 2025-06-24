// Problem: K-Partition Problem
// GFG Reference: https://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/

public class KPartition {

    // ----------- DP + Backtracking (Bitmask variant idea) -----------
    public boolean isKPartitionPossible(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (k == 0 || sum % k != 0) return false;
        int target = sum / k;

        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] used, int k, int start, int currSum, int target) {
        if (k == 1) return true;
        if (currSum > target) return false;
        if (currSum == target) return backtrack(nums, used, k - 1, 0, 0, target);

        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (backtrack(nums, used, k, i + 1, currSum + nums[i], target))
                    return true;
                used[i] = false;
            }
        }

        return false;
    }

    /*
       Time Complexity: O(k * 2^n)
       Space Complexity: O(n)
    */
}
