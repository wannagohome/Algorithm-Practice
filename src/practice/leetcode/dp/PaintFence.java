package practice.leetcode.dp;


/**
 * LeetCode 276. Paint Fence
 */
public class PaintFence {

	public int numWays(int n, int k) {
		int[] dp = new int[Math.max(n + 1, 4)];
		dp[1] = k;
		dp[2] = (int)Math.pow(k, 2);
		dp[3] = (int)(Math.pow(k, 3) - k);

		for (int i = 4; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[ i -2]) * (k - 1);
		}
		return dp[n];
	}
}
