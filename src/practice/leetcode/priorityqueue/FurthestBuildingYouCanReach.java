package practice.leetcode.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 1642. Furthest Building You Can Reach
 */
public class FurthestBuildingYouCanReach {

	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 1; i < heights.length; i++) {
			if (heights[i - 1] >= heights[i]) {
				continue;
			}
			queue.add(heights[i] - heights[i - 1]);
			if (ladders > 0) {
				ladders --;
				continue;
			}
			bricks -= queue.poll();
			if (bricks < 0) {
				return i - 1;
			}
		}
		return heights.length - 1;
	}
}
