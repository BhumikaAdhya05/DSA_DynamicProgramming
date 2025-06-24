// Problem: Matrix Chain Multiplication
// GFG: https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

public class MatrixChainMultiplication {

    // ----------- DP with Memoization -----------
    public int matrixChainOrder(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    /*
       Time Complexity: O(n^3)
       Space Complexity: O(n^2)
    */
}
