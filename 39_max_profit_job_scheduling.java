// Problem: Maximum Profit in Job Scheduling
// LeetCode: https://leetcode.com/problems/maximum-profit-in-job-scheduling/

import java.util.*;

public class JobScheduling {

    class Job {
        int start, end, profit;
        Job(int s, int e, int p) { start = s; end = e; profit = p; }
    }

    // ----------- DP + Binary Search -----------
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);

        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int incl = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1) incl += dp[l];
            dp[i] = Math.max(dp[i - 1], incl);
        }

        return dp[n - 1];
    }

    private int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start)
                    low = mid + 1;
                else return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
       Time Complexity: O(n log n)
       Space Complexity: O(n)
    */
}
