package practice.leetcode.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
     * LeetCode 121. Best Time to Buy and Sell Stock
     *
     * My Solution : dp
     * result : 3ms
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int j = prices[i] - prices[i - 1];
            if (dp[i - 1] >= 0) dp[i] += dp[i - 1] + j;
            else dp[i] = j;
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
