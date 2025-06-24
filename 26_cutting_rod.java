// Problem: Rod Cutting
// GFG: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

public class CuttingRod {

    // ----------- DP Solution (Unbounded Knapsack) -----------
    public int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }

        return dp[n];
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(n)
    */
}
