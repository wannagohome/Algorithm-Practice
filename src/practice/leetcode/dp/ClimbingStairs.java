package practice.leetcode.dp;

public class ClimbingStairs {
    /**
     * https://leetcode.com/problems/climbing-stairs/
     * LeetCode 70. Climbing Stairs
     *
     * My Solution :
     * 그냥 dp 그냥 피보나치
     * result : 0ms
     */
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n > 1) dp[1] = 2;
        for (int i = 2; i < n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n - 1];
    }
}
