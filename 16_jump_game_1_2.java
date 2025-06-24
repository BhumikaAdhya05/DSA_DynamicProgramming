// Problem: Jump Game I & II
// LeetCode: https://leetcode.com/problems/jump-game/
// LeetCode: https://leetcode.com/problems/jump-game-ii/

public class JumpGame {

    // ----------- Jump Game I: Can Reach End (Greedy) -----------
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */


    // ----------- Jump Game II: Min Jumps to Reach End -----------
    public int jump(int[] nums) {
        int jumps = 0, currEnd = 0, farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }

    /*
       Time Complexity: O(n)
       Space Complexity: O(1)
    */
}
