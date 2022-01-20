package practice.leetcode.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {
	/**
	 * https://leetcode.com/problems/koko-eating-bananas/
	 * LeetCode 875. Koko Eating Bananas
	 *
	 * result : 19-27ms
	 */

	public int minEatingSpeed(int[] piles, int H) {
		int lo = 1, hi = Arrays.stream(piles).max().getAsInt();

		while (lo <= hi) {
			int K = lo + ((hi - lo) >> 1);
			if (canEatAll(piles, K, H)) {
				hi = K - 1;
			} else {
				lo = K + 1;
			}
		}

		return lo;
	}

	private boolean canEatAll(int[] piles, int K, int H) {
		int countHour = 0;

		for (int pile : piles) {
			countHour += pile / K;
			if (pile % K != 0)
				countHour++;
		}
		return countHour <= H;
	}
}
