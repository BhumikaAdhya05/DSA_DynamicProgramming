// Problem: Scramble String
// LeetCode: https://leetcode.com/problems/scramble-string/

import java.util.*;

public class ScrambleString {

    // ----------- Top-Down DP with Memoization -----------
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        String key = s1 + "," + s2;
        if (memo.containsKey(key)) return memo.get(key);

        if (!isAnagram(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: No swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] count = new int[26];
        for (char c : a.toCharArray()) count[c - 'a']++;
        for (char c : b.toCharArray()) count[c - 'a']--;
        for (int n : count) if (n != 0) return false;
        return true;
    }

    /*
       Time Complexity: O(n^4)
       Space Complexity: O(n^3) for memoization
    */
}
