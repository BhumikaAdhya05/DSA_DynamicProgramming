// Problem: Fibonacci Number
// LeetCode: https://leetcode.com/problems/fibonacci-number/

public class FibonacciNumber {

    // ----------- Approach 1: Brute Force Recursion -----------
    /*
       Idea:
       Use basic recursion to compute the nth Fibonacci number.
       This approach is highly inefficient due to repeated calculations.
    */
    public int fibBrute(int n) {
        if (n <= 1) return n;
        return fibBrute(n - 1) + fibBrute(n - 2);
    }

    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n) - recursion call stack
    */


    // ----------- Approach 2: Top-Down DP (Memoization) -----------
    /*
       Idea:
       Use a memo array to store the result of subproblems to avoid recomputation.
    */
    public int fibMemo(int n) {
        int[] memo = new int[n + 1];
        return fibMemoHelper(n, memo);
    }

    private int fibMemoHelper(int n, int[] memo) {
        if (n <= 1) return n;

        if (memo[n] != 0) return memo[n];

        memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
        return memo[n];
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */


    // ----------- Approach 3: Bottom-Up DP (Tabulation) -----------
    /*
       Idea:
       Build the solution from the base cases up to n using an array.
    */
    public int fibDP(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(n)
    */


    // ----------- Approach 4: Space Optimized DP -----------
    /*
       Idea:
       Only store the last two Fibonacci numbers at any time to reduce space.
    */
    public int fibOptimized(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
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
