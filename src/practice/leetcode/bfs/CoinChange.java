package practice.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    /**
     * https://leetcode.com/problems/coin-change/submissions/
     * LeetCode 322. Coin Change
     *
     * My Solution :
     * bfs
     *
     * Time Complexity : O(n)
     * result : 26ms 38.59%
     *
     */

    public static void main(String[] args) {
        CoinChange change = new CoinChange();
        change.coinChange(new int[]{186, 419, 83, 408}, 6249);
    }

    public int coinChange(int[] coins, int amount) {
        Queue<Integer> queue = new LinkedList<>();
        if (amount == 0) return 0;
        if (Arrays.stream(coins).min().getAsInt() <= amount)
            Arrays.stream(coins).forEach(queue::offer);

        boolean[] visited = new boolean[amount + 1];
        int ans = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int num = queue.poll();
                size--;
                if (num == amount) return ans;
                for (int coin : coins) {
                    int next = num + coin;
                    if (next > 0 && visited.length > next && !visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }

                }
            }
            ans++;
        }
        return -1;
    }
}
