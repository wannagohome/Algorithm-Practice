package practice.leetcode.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    /**
     * https://leetcode.com/problems/keys-and-rooms/submissions/
     * LeetCode 841. Keys and Rooms
     *
     * My Solution :
     * stack이든 queue든 방문 안한 것만 방문하면 되는 아주 간단한 문제
     * visited를 int[] 에서 boolean으로 바꾸니 조금 빨라 졌다 (7ms -> 5ms)
     *
     * Time Complexity : O(n)
     * result : 5ms 16%
     *
     */
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.offer(0);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            visited[index] = true;
            rooms.get(index)
                    .stream()
                    .filter(i -> !visited[i])
                    .forEach(queue::offer);
        }

        for (boolean b : visited) if (!b) return false;
        return true;
    }
}
