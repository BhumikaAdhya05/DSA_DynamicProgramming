// Problem 1: Cherry Pickup I (LeetCode 741)
// https://leetcode.com/problems/cherry-pickup/

public class CherryPickup {

    // ----------- Brute Force Recursion (TLE) -----------
    public int cherryPickupBrute(int[][] grid) {
        int n = grid.length;
        return Math.max(0, dfs(grid, 0, 0, 0, new int[n][n][n]));
    }

    private int dfs(int[][] grid, int r1, int c1, int r2, int[][][] memo) {
        int c2 = r1 + c1 - r2;

        if (r1 >= grid.length || c1 >= grid[0].length ||
            r2 >= grid.length || c2 >= grid[0].length ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == grid.length - 1 && c1 == grid[0].length - 1)
            return grid[r1][c1];

        if (memo[r1][c1][r2] != 0) return memo[r1][c1][r2];

        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2) cherries += grid[r2][c2];

        int best = Math.max(
            Math.max(dfs(grid, r1 + 1, c1, r2 + 1, memo),
                     dfs(grid, r1, c1 + 1, r2, memo)),
            Math.max(dfs(grid, r1 + 1, c1, r2, memo),
                     dfs(grid, r1, c1 + 1, r2 + 1, memo))
        );

        cherries += best;
        memo[r1][c1][r2] = cherries;
        return cherries;
    }

    /*
       Time Complexity: O(n^3)
       Space Complexity: O(n^3)
    */
}

// Problem 2: Cherry Pickup II (LeetCode 1463)
// https://leetcode.com/problems/cherry-pickup-ii/

public class CherryPickupII {

    // ----------- DP: 3D Memoization -----------
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];

        return helper(grid, 0, 0, n - 1, dp);
    }

    private int helper(int[][] grid, int row, int col1, int col2, Integer[][][] dp) {
        int m = grid.length, n = grid[0].length;

        if (col1 < 0 || col1 >= n || col2 < 0 || col2 >= n) return 0;
        if (dp[row][col1][col2] != null) return dp[row][col1][col2];

        int result = grid[row][col1];
        if (col1 != col2) result += grid[row][col2];

        if (row != m - 1) {
            int max = 0;
            for (int d1 = -1; d1 <= 1; d1++) {
                for (int d2 = -1; d2 <= 1; d2++) {
                    max = Math.max(max, helper(grid, row + 1, col1 + d1, col2 + d2, dp));
                }
            }
            result += max;
        }

        return dp[row][col1][col2] = result;
    }

    /*
       Time Complexity: O(m * n * n)
       Space Complexity: O(m * n * n)
    */
}
