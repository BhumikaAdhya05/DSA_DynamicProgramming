// Problem 1: Paint House I
// LeetCode 256: https://leetcode.com/problems/paint-house/

public class PaintHouse {

    // ----------- DP -----------
    public int minCost(int[][] costs) {
        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */
}

// Problem 2: Paint House II
// LeetCode 265: https://leetcode.com/problems/paint-house-ii/

public class PaintHouseII {

    // ----------- Optimized DP -----------
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int prevMin = 0, prevSecMin = 0, prevMinColor = -1;

        for (int i = 0; i < n; i++) {
            int currMin = Integer.MAX_VALUE, currSecMin = Integer.MAX_VALUE, currMinColor = -1;

            for (int c = 0; c < k; c++) {
                int cost = costs[i][c] + (c == prevMinColor ? prevSecMin : prevMin);

                if (cost < currMin) {
                    currSecMin = currMin;
                    currMin = cost;
                    currMinColor = c;
                } else if (cost < currSecMin) {
                    currSecMin = cost;
                }

                costs[i][c] = cost;
            }

            prevMin = currMin;
            prevSecMin = currSecMin;
            prevMinColor = currMinColor;
        }

        return prevMin;
    }

    /*
       Time Complexity: O(n * k)
       Space Complexity: O(1)
    */
}
