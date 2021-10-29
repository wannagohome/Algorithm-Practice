package practice.leetcode.bfs;

import java.util.*;

public class RottingOranges {
    /**
     * https://leetcode.com/problems/rotting-oranges/
     * LeetCode 994. Rotting Oranges
     *
     * My Solution :
     * 단순 bfs
     *
     * Time Complexity : O(n)
     * result : 2ms 97%
     *
     */

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int freshCount = 0;
        int[][] dXdY = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) freshCount++;
                else if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            if (freshCount != 0) ans++;
            int size = queue.size();
            while (size > 0) {
                int[] position = queue.poll();
                size--;

                for (int[] xy : dXdY) {
                    int x = position[0] + xy[0];
                    int y = position[1] + xy[1];
                    if (x < 0 || y < 0) continue;
                    if (x >= grid.length || y >= grid[0].length) continue;
                    if (grid[x][y] == 1) {
                        freshCount--;
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return freshCount == 0 ? ans : -1;
    }
}
