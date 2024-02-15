package practice.leetcode.greedy;

import java.util.Arrays;

/**
 * LeetCode 2971. Find Polygon With the Largest Perimeter
 */

public class FindPolygonWithTheLargestPerimeter {
	public long largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		long result = 0;
		for (int i: nums) {
			result += i;
		}

		for (int i = nums.length - 1; i >= 0; i--) {
				if (result - nums[i] > nums[i]) {
					return result;
				}
				result -= nums[i];
		}
		return -1;
	}
}
