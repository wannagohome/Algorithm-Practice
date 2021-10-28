package practice.programmers.level2.weekly;

import java.util.ArrayList;
import java.util.List;

public class Week12 {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/87946
     * Programmers 위클 챌린지 / 12 주차
     *
     * My Solution :
     * dfs가 bfs가 코드가 깔끔할 것 같아 dfs로 풀었다
     *
     */

    public static void main(String[] args) {
        Week12 instance = new Week12();
        instance.solution(80, new int[][]{{80, 20}, {50 ,40}, {30, 10}});
    }

    public int solution(int k, int[][] dungeons) {
        return maxDungeons(k, dungeons, new boolean[dungeons.length]);
    }

    public int maxDungeons(int k, int[][] dungeons, boolean[] visited) {
        List<Integer> toVisit = new ArrayList<>();
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) toVisit.add(i);
        }

        int res = 0;
        for (int idx : toVisit) {
            visited[idx] = true;
            res = Math.max(res, maxDungeons(k - dungeons[idx][1], dungeons, visited) + 1);
            visited[idx] = false;
        }
        return res;
    }
}
