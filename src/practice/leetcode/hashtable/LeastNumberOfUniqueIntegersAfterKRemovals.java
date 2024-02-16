package practice.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1481. Least Number of Unique Integers after K Removals
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {

	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		if (k == 0) { return map.size(); }

		Integer[] sortedValue = map.values()
			.stream()
			.sorted()
			.toArray(Integer[]::new);

		int sum = 0;
		for (int i = 0; i < sortedValue.length; i++) {
			sum += sortedValue[i];
			if (sum == k) {
				return sortedValue.length - i - 1;
			} else if (sum > k) {
				return sortedValue.length - i;
			}
		}
		return -1;
	}
}
