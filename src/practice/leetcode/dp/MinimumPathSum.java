package practice.leetcode.dp;

public class MinimumPathSum {
	/**
	 * https://leetcode.com/problems/minimum-path-sum/
	 * LeetCode 64. Minimum Path Sum
	 *
	 * My Solution : dp
	 * result : 2ms
	 */
	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];

		for (int i = 1; i < grid[0].length; i++) {
			dp[0][i] = grid[0][i] + dp[0][i - 1];
		}
		for (int i = 1; i < grid.length; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];
	}
}
