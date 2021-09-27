package practice.leetcode.bfs;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    /**
     * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
     * LeetCode 1466. Reorder Routes to Make All Paths Lead to the City Zero
     *
     * My Solution :
     * dfs
     *
     * result : 26ms 82%
     *
     */

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> path = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            path.add(new ArrayList<>());
        for (var c : connections) {
            path.get(c[0]).add(c[1]);
            path.get(c[1]).add(-c[0]);
        }

        return getRotateCount(path, 0, new boolean[n]);
    }

    public int getRotateCount(List<List<Integer>> path, int node, boolean[] visited) {
        visited[node] = true;
        int res = 0;
        for (var to : path.get(node))
            if (!visited[Math.abs(to)])
                res += getRotateCount(path, Math.abs(to), visited) + (to > 0 ? 1 : 0);

        return res;
    }
}
