package practice.programmers.level2.heap;

import java.util.PriorityQueue;

public class Spicy {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42626
     * Programmers 더 맵게
     *
     * My Solution :
     * PriorityQueue, Heap에 대해 배웠다.
     * PriorityQueue를 활용해 작은 값 부터 하나씩 섞는다.
     *
     * Time Complexity : O(NlogN)
     */

    public int solution(int[] scoville, int K) {
        if (scoville.length == 0) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) queue.offer(i);

        int answer = 0;
        while (queue.peek() < K) {
            if(queue.size() < 2) return -1;

            int mixed = queue.poll() + (queue.poll() * 2);
            queue.offer(mixed);
            answer++;
        }

        return answer;
    }
}
