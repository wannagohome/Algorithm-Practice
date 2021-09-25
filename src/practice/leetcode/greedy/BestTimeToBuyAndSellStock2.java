package practice.leetcode.greedy;

public class BestTimeToBuyAndSellStock2 {

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * LeetCode 122. Best Time to Buy and Sell Stock II
     *
     * My Solution : 수익이 나는 구간만 더하면 끝
     * discuss에 올라온 DP등의 풀이가 이해되지 않는다. 굳이??
     * result : 1ms
     */


    public static int solution(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                ans += prices[i + 1] - prices[i];
        }
        return ans;
    }
}
