package practice.leetcode.priorityqueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
	/**
	 * https://leetcode.com/problems/k-closest-points-to-origin/
	 * LeetCode 973. K Closest Points to Origin
	 *
	 * My Solution :
	 *
	 * Time Complexity : O(n)
	 * result : 3ms
	 *
	 */

	public int[][] kClosest(int[][] points, int K) {
		int len =  points.length, l = 0, r = len - 1;
		while (l <= r) {
			int mid = helper(points, l, r);
			if (mid == K) break;
			if (mid < K) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return Arrays.copyOfRange(points, 0, K);
	}

	private int helper(int[][] A, int l, int r) {
		int[] pivot = A[l];
		while (l < r) {
			while (l < r && compare(A[r], pivot) >= 0) r--;
			A[l] = A[r];
			while (l < r && compare(A[l], pivot) <= 0) l++;
			A[r] = A[l];
		}
		A[l] = pivot;
		return l;
	}

	private int compare(int[] p1, int[] p2) {
		return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
	}
}
