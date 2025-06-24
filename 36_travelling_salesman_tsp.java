// Problem: Travelling Salesman Problem (TSP)
// Category: Bitmask DP
// GFG Reference: https://www.geeksforgeeks.org/travelling-salesman-problem-set-1/

import java.util.*;

public class TSP {

    // ----------- Bitmask DP + Memoization -----------
    int[][] dist;
    int[][] memo;
    int VISITED_ALL;

    public int tsp(int[][] distance) {
        int n = distance.length;
        this.dist = distance;
        this.memo = new int[n][1 << n];
        this.VISITED_ALL = (1 << n) - 1;

        for (int[] row : memo) Arrays.fill(row, -1);

        return tspUtil(0, 1); // start from city 0, visited only city 0
    }

    private int tspUtil(int pos, int mask) {
        if (mask == VISITED_ALL) return dist[pos][0]; // return to origin

        if (memo[pos][mask] != -1) return memo[pos][mask];

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < dist.length; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tspUtil(city, mask | (1 << city));
                ans = Math.min(ans, newAns);
            }
        }

        return memo[pos][mask] = ans;
    }

    /*
       Time Complexity: O(n^2 * 2^n)
       Space Complexity: O(n * 2^n)
    */
}
