package practice.leetcode.dp;

public class UniqueBinarySearchTrees {
    /**
     * https://leetcode.com/problems/unique-binary-search-trees/
     * LeetCode 96. Unique Binary Search Trees
     *
     * My Solution : dp
     * R(n) = R(0)*R(n-1) + R(1)*R(n-2) + ...... + R(n-2)*R(1) + R(n-1)*R(0)
     * result : 0ms
     */

    public int numTrees(int n) {
        int[] dp = new int[Math.max(3, n + 1)];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
