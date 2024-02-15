package practice.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 1272. Remove Interval
 */

public class RemoveInterval {
	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		List<List<Integer>> result = new LinkedList<>();
		for (int[] interval: intervals) {
			if (interval[0] >= toBeRemoved[1] || interval[1] <= toBeRemoved[0]) {
				result.add(asList(interval));
			} else if (interval[0] >= toBeRemoved[0] && interval[1] <= toBeRemoved[1]) {
				continue;
			} else if (interval[0] < toBeRemoved[0] && interval[1] > toBeRemoved[1]) {
				result.add(Arrays.asList(interval[0], toBeRemoved[0]));
				result.add(Arrays.asList(toBeRemoved[1], interval[1]));
			} else {
				if (interval[0] < toBeRemoved[0]) {
					result.add(Arrays.asList(interval[0], toBeRemoved[0]));
				} else {
					result.add(Arrays.asList(toBeRemoved[1], interval[1]));
				}
			}
		}
		return result;
	}

	private List<Integer> asList(int[] array) {
		List<Integer> list = new ArrayList<>(array.length);
		for (int i : array) {
			list.add(i);
		}
		return list;
	}
}
