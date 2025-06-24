// Problem: Minimum Number of Refueling Stops
// LeetCode: https://leetcode.com/problems/minimum-number-of-refueling-stops/

import java.util.*;

public class RefuelingStops {

    // ----------- Brute Force Recursion (TLE) -----------
    public int minRefuelStopsBrute(int target, int startFuel, int[][] stations) {
        return helper(0, startFuel, stations, target);
    }

    private int helper(int i, int fuel, int[][] stations, int target) {
        if (fuel >= target) return 0;
        if (i == stations.length) return -1;

        if (fuel < stations[i][0]) return -1;

        // Option 1: Refuel
        int take = helper(i + 1, fuel + stations[i][1], stations, target);
        if (take != -1) take += 1;

        // Option 2: Skip
        int skip = helper(i + 1, fuel, stations, target);

        if (take == -1) return skip;
        if (skip == -1) return take;
        return Math.min(take, skip);
    }

    /*
       Time Complexity: Exponential
       Space Complexity: O(n)
    */


    // ----------- Optimal: Greedy + Max Heap -----------
    public int minRefuelStops(int target, int fuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, stops = 0;

        while (fuel < target) {
            while (i < stations.length && stations[i][0] <= fuel) {
                pq.offer(stations[i++][1]);
            }

            if (pq.isEmpty()) return -1;

            fuel += pq.poll();
            stops++;
        }

        return stops;
    }

    /*
       Time Complexity: O(n log n)
       Space Complexity: O(n)
    */
}
