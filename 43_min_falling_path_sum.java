// Problem: Minimum Falling Path Sum
// LeetCode: https://leetcode.com/problems/minimum-falling-path-sum/

public class MinFallingPathSum {

    // ----------- Bottom-Up DP -----------
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int bestBelow = matrix[row + 1][col];
                if (col > 0) bestBelow = Math.min(bestBelow, matrix[row + 1][col - 1]);
                if (col < n - 1) bestBelow = Math.min(bestBelow, matrix[row + 1][col + 1]);
                matrix[row][col] += bestBelow;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            result = Math.min(result, matrix[0][col]);
        }

        return result;
    }

    /*
       Time Complexity: O(n^2)
       Space Complexity: O(1) (in-place)
    */
}
