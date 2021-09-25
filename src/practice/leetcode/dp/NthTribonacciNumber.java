package practice.leetcode.dp;

public class NthTribonacciNumber {
    /**
     * https://leetcode.com/problems/n-th-tribonacci-number/
     * LeetCode 1137. N-th Tribonacci Number
     *
     * My Solution : dp
     * result : 0ms
     */
    public int tribonacci(int n) {
        int[] dp = new int[Math.max(3, n)+1];
        dp[1] = 1; dp[2] = 1;
        for (int i = 3; i < n+1; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        return dp[n];
    }
}
