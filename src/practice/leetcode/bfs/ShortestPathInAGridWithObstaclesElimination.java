package practice.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
    /**
     * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/submissions/
     * LeetCode 1293. Shortest Path in a Grid with Obstacles Elimination
     *
     * My Solution :
     *
     * result : 7ms 93%
     */
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] seen = new int[m][n];
        q.offer(new int[]{0,0,0});
        int[][] dirs = {{1,0},{-1,0}, {0,1}, {0,-1}};
        int steps = 0;
        for(int i = 0; i < m; i++){
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int kTillNow = curr[2];
                if(x == m - 1 && y == n - 1) return steps;
                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    int nk = kTillNow + grid[nx][ny];
                    if(nk >= seen[nx][ny] || nk > k) continue;
                    seen[nx][ny] = nk;
                    q.offer(new int[]{nx, ny, nk});
                }
            }
            steps++;
        }
        return -1;
    }
}
