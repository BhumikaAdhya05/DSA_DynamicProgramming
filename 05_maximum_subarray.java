// Problem: Maximum Subarray (Kadane's Algorithm)
// LeetCode: https://leetcode.com/problems/maximum-subarray/

public class MaximumSubarray {

    // ----------- Approach 1: Brute Force (TLE for large input) -----------
    public int maxSubArrayBrute(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(1)
    */


    // ----------- Approach 2: Optimal - Kadane's Algorithm -----------
    public int maxSubArrayKadane(int[] nums) {
        int maxSoFar = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currSum);
        }

        return maxSoFar;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */
}
