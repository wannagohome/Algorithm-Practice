package practice.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {
    /**
     * https://leetcode.com/problems/island-perimeter/
     * LeetCode 463. Island Perimeter
     *
     * My Solution :
     * bfs(queue)로 땅을 하나씩 찾으며 count
     * Time Complexity : O(4n)
     * result : 38ms
     *
     * Faster :
     * 땅의 갯수와 맛닿아 있는 면 갯수만 알면 되기 때문에
     * 굳이 queue를 쓸 것도 없이, 땅 사방에 방문할 만한 땅을 찾을 필요도 없이
     * 땅 하나하나 찾아 들어가면 끝
     * Time Complexity : O(n)
     * result : 5-9ms
     *
     */
    public int islandPerimeter(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dXdY = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            boolean needsToBreak = false;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)  {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    needsToBreak = true;
                    break;
                }
            }
            if (needsToBreak) break;
        }

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            for (int[] xy : dXdY) {
                int x = coordinate[0] + xy[0];
                int y = coordinate[1] + xy[1];
                if (x < 0 || x > grid.length - 1
                || y < 0 || y > grid[0].length - 1
                || grid[x][y] == 0) { perimeter++; continue; }

                if (!visited[x][y]) {
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

        return perimeter;
    }

    public int faster(int[][] grid) {
        int land = 0, connect = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    land++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) connect++;
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) connect++;
                }
            }
        }

        return land * 4 - connect * 2;
    }
}
