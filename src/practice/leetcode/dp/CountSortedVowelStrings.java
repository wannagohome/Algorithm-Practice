package practice.leetcode.dp;

import java.util.Arrays;

public class CountSortedVowelStrings {
    /**
     * https://leetcode.com/problems/count-sorted-vowel-strings/
     * LeetCode 1641. Count Sorted Vowel Strings
     *
     * My Solution : dp
     * result : 0ms
     */

    public int countVowelStrings(int n) {
        int[][] dp = new int[n][6];
        Arrays.fill(dp[0], 1);
        dp[0][5] = 5;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
            dp[i][1] = dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
            dp[i][2] = dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
            dp[i][3] = dp[i-1][3] + dp[i-1][4];
            dp[i][4] = dp[i-1][4];
            dp[i][5] = dp[i][0] + dp[i][1] + dp[i][2] + dp[i][3] + dp[i][4];
        }

        return dp[n-1][5];
    }
}
