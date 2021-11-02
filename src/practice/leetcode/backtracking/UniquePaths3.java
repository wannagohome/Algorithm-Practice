package practice.leetcode.backtracking;

public class UniquePaths3 {
    /**
     * https://leetcode.com/problems/unique-paths-iii/
     * LeetCode 980. Unique Paths III
     *
     * My Solution :
     * dfs backtracking
     *
     * result : 0ms
     *
     */

    int emptyCount = 0;

    public static void main(String[] args) {
        UniquePaths3 uniquePaths3 = new UniquePaths3();
        uniquePaths3.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}});
    }

    public int uniquePathsIII(int[][] grid) {
        int sx = 0, sy = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) emptyCount++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return findPathCount(grid, sx + 1, sy)
                + findPathCount(grid, sx - 1, sy)
                + findPathCount(grid, sx, sy + 1)
                + findPathCount(grid, sx, sy - 1);
    }

    public int findPathCount(int[][] grid, int x, int y) {
        if (x == -1 || x == grid.length || y == -1 || y == grid[0].length) return 0;
        if (grid[x][y] == 2 && emptyCount == 0) return 1;
        if (grid[x][y] != 0) return 0;

        grid[x][y] = -2;
        emptyCount--;
        int result = findPathCount(grid, x + 1, y)
                + findPathCount(grid, x - 1, y)
                + findPathCount(grid, x, y + 1)
                + findPathCount(grid, x, y - 1);
        grid[x][y] = 0;
        emptyCount++;
        return result;
    }
}
