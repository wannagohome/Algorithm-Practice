package practice.leetcode.dp;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    /**
     * https://leetcode.com/problems/perfect-squares/
     * LeetCode 279. Perfect Squares
     *
     * My Solution : 그냥 dp
     *
     * Time Complexity : O(n)
     * result : 7 -20ms 93-97%
     */

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i * i <= n; i++) {
            queue.offer(i * i);
            dp[i * i] = 1;
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 1; (i * i) + num <= n; i++) {
                int dx = (i * i) + num;
                if (dp[dx] != 0) continue;
                queue.offer(dx);
                dp[dx] = dp[num] + 1;
                if (dx == n) return dp[(i * i) + num];
            }
        }

        return dp[n];
    }
}
