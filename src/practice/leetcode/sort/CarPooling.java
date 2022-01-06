package practice.leetcode.sort;

public class CarPooling {
	/**
	 * https://leetcode.com/problems/car-pooling/
	 * LeetCode 1094. Car Pooling
	 *
	 * My Solution :
	 * sorting을 해서 풀어보았지만 오히려 느렸다
	 * result : 1-2ms
	 */

	public boolean carPooling(int[][] trips, int capacity) {
		int stops[] = new int[1001];
		for (int t[] : trips) {
			stops[t[1]] += t[0];
			stops[t[2]] -= t[0];
		}
		for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
		return capacity >= 0;
	}
}
