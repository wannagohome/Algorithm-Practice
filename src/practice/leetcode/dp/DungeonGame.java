package practice.leetcode.dp;

import java.util.Arrays;

public class DungeonGame {
    /**
     * https://leetcode.com/problems/dungeon-game/
     * LeetCode 174. Dungeon Game
     *
     * My Solution :
     * 끝에서 부터 dp / 문제 자체는 단순하다
     * 맨 아래, 오른쪽 변의 칸들은 path를 고려할 필요가 없으므로 먼저 구하고
     * 아래부터 한 줄씩 dp
     *
     * result : 2ms
     */

    public static void main(String[] args) {
        DungeonGame game = new DungeonGame();
        game.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int xLength = dungeon.length;
        int yLength = dungeon[0].length;
        dp[xLength - 1][yLength - 1]
                = Math.max(1 - dungeon[xLength - 1][yLength - 1], 1);

        if (yLength > 1)
        for (int i = yLength - 2; i >= 0; i--) {
            dp[xLength - 1][i]
                    = Math.max(dp[xLength - 1][i + 1] - dungeon[xLength - 1][i], 1);
        }

        if (xLength > 1)
        for (int i = xLength - 2; i >= 0; i--) {
            dp[i][yLength - 1]
                    = Math.max(dp[i + 1][yLength - 1] - dungeon[i][yLength - 1], 1);
        }

        if (xLength > 1 && yLength > 1)
        for (int i = xLength - 2; i >= 0; i--) {
            for (int j = yLength - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }

        return Math.max(dp[0][0], 1);
    }
}
