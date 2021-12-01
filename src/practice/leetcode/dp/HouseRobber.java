package practice.leetcode.dp;

import java.util.Arrays;

public class HouseRobber {
	/**
	 * https://leetcode.com/problems/house-robber/
	 * LeetCode 198. House Robber
	 *
	 * My Solution : dp
	 * result : 0ms
	 */

	public int rob(int[] nums) {
		int[] dp = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				dp[i] = nums[i];
				continue;
			}
			if (i == 1) {
				dp[i] = Math.max(nums[i], dp[0]);
			}
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[dp.length - 1];
	}
}
