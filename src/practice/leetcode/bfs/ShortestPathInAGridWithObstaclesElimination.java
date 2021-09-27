package practice.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
    /**
     * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
     * LeetCode 1293. Shortest Path in a Grid with Obstacles Elimination
     *
     * My Solution :
     * 이동한 경로와 벽을 부순 횟수를 가지고 있는 객체를 만들어 풀어봤지만 시간 초과
     *
     * Better Solution :
     * 각 이동 경로의 좌표와 벽을 부순 횟수로 길이 3의 int array,
     * 방문 여부는 당시 방문 했을 때의 벽을 부순 횟수로 판단(sean)
     *
     * 내 풀이와 마찬가지로 n^2의 2중 반복문을 사용하지만
     * 모든 경로를 들고다니는 부분에서 가장 큰 차이가 있는것 같다.
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
