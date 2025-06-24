// Problem: Climbing Stairs
// LeetCode: https://leetcode.com/problems/climbing-stairs/

// ----------- Approach 1: Brute Force (Recursive) -----------
/*
   Idea:
   At each step, we can either climb 1 or 2 stairs.
   Recursively explore all combinations.
*/

public class ClimbingStairs {

    // Brute Force Recursive
    public int climbStairsBrute(int n) {
        if (n <= 1) return 1;
        return climbStairsBrute(n - 1) + climbStairsBrute(n - 2);
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n) – recursion stack
    */


    // ----------- Approach 2: Optimal (Dynamic Programming - Bottom Up) -----------

    public int climbStairsDP(int n) {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */

    // ----------- Approach 3: Optimized DP with Constant Space -----------

    public int climbStairsOptimized(int n) {
        if (n <= 1) return 1;

        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */
}
