package practice.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class JumpGameIV {
	/**
	 * https://leetcode.com/problems/jump-game-iv/
	 * LeetCode 1345. Jump Game IV
	 *
	 * My Solution :
	 * 처음엔 한 번 방문했던 value에 대해 재방문을 막지 않아서 시간제한에 걸렸었다.
	 * 시간편차가 크다
	 *
	 * result : 90-140ms
	 *
	 */

	public static void main(String[] args) {
		JumpGameIV jumpGameIV = new JumpGameIV();
		jumpGameIV.minJumps(new int[] {100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
	}

	public int minJumps(int[] arr) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new ArrayList<>());
			}
			map.get(arr[i]).add(i);
		}

		int[] steps = new int[arr.length];
		Queue<Integer> queue = new LinkedList<>();
		steps[0] = 1;
		queue.add(0);

		while (!queue.isEmpty()) {
			int index = queue.poll();

			List<Integer> list = map.get(arr[index]);
			list.add(index + 1);
			list.add(index - 1);
			for (int i : list) {
				if (i < 0 || i >= arr.length || steps[i] == 0) continue;
				if (i == steps.length - 1) return steps[index];
				queue.add(i);
				steps[i] = steps[index] + 1;
			}
			map.get(arr[index]).clear();
		}

		return steps[steps.length - 1] - 1;
	}
}
