package practice.leetcode.bfs;

import java.util.*;

public class OpenTheLock {
    /**
     * https://leetcode.com/problems/open-the-lock/submissions/
     * LeetCode 752. Open the Lock
     *
     * My Solution :
     * dp와 재귀를 이용하려 했으나 콜 스택 초과로 실패
     * dfs로 해결
     *
     * result : 175ms 37%
     *
     */
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        int[] visited = new int[10000];
        q.offer("0000");
        visited[0] = 1;
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                String s = q.poll();
                if(deads.contains(s)) {
                    size --;
                    continue;
                }
                if(s.equals(target)) return level;
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    int i1 = Integer.parseInt(s1);
                    int i2 = Integer.parseInt(s2);
                    if(!(visited[i1] == 1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited[i1] = 1;
                    }
                    if(!(visited[i2] == 1) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited[i2] = 1;
                    }
                }
                size --;
            }
            level ++;
        }
        return -1;
    }

    /**
     * 실패
     */
    int[] dp = new int[10000];
    public int dp(String[] deadends, String target) {
        Arrays.fill(dp, -2);
        dp[0] = 0;
        for (String s : deadends)  dp[Integer.parseInt(s)] = Integer.MAX_VALUE;
        return getCount(target);
    }

    public Integer getCount(String target) {
        System.out.println(target);
        if (dp[Integer.parseInt(target)] == -1) return null;
        if (dp[Integer.parseInt(target)] >= 0) return dp[Integer.parseInt(target)];
        int min = Integer.MAX_VALUE;
        dp[Integer.parseInt(target)] = -1;

        for(int i = 0; i < 4; i ++) {
            char c = target.charAt(i);
            String s1 = target.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + target.substring(i + 1);
            String s2 = target.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + target.substring(i + 1);
            Integer n1 = getCount(s1);
            Integer n2 = getCount(s2);
            if (n1 != null)  min = Math.min(n1, min);
            if (n2 != null) min = Math.min(n2, min);
        }
        return min;
    }
}
