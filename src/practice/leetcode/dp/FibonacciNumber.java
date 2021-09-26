package practice.leetcode.dp;

public class FibonacciNumber {
    /**
     * https://leetcode.com/problems/fibonacci-number/submissions/
     * LeetCode 509. Fibonacci Number
     *
     * My Solution : dp
     * result : 0ms
     */
    public int fib(int n) {
        int[] dp = new int[Math.max(2, n + 1)];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i < n + 1; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
