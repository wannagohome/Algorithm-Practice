package practice.leetcode.dp;

import java.util.Arrays;

public class MaximalSquare {
	/**
	 * https://leetcode.com/problems/maximal-square/
	 * LeetCode 221. Maximal Square
	 *
	 * Time Complexity : O(n)
	 * My Solution : dp
	 *
	 * result : 4ms
	 */

	public int maximalSquare(char[][] matrix) {
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int ans = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j])+ 1;
					ans = Math.max(dp[i + 1][j + 1], ans);
				}
			}
		}
		for (int[] ints : dp) {
			System.out.println(Arrays.toString(ints));
		}
		return ans * ans;
	}
}
