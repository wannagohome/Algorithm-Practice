package practice.leetcode.dp;

public class MaximumSubarray {
    /**
     * https://leetcode.com/problems/maximum-subarray/
     * LeetCode 53. Maximum Subarray
     *
     * My Solution : dp
     * result : 3ms
     */

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
