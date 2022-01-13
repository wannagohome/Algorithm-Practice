package practice.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
	/**
	 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
	 * LeetCode 452. Minimum Number of Arrows to Burst Balloons
	 *
	 * My Solution : Greedy
	 * 끝점을 기준으로 정렬한 뒤 각 끝점에서 겹치는 풍선들을 제외시키는 식으로 count
	 * List의 element들을 remove 하는 알고리즘을 array의 조회로 바꾸니 10배 이상으로 빨라졌다.
	 *
	 * result: ~=55ms
	 */


	public int findMinArrowShots(int[][] points) {
		int count = 0;
		int index = 0;
		Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

		while (points.length > index) {
			int arrow = points[index][1];
			index++;
			while (points.length > index
				&& points[index][0] <= arrow
				&& points[index][1] >= arrow) {
				index++;
			}
			count++;
		}

		return count;
	}
}
