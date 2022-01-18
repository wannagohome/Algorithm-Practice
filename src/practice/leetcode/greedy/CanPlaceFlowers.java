package practice.leetcode.greedy;

public class CanPlaceFlowers {
	/**
	 * https://leetcode.com/problems/can-place-flowers/
	 * LeetCode 605. Can Place Flowers
	 *
	 * My Solution :
	 * result : 1ms
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed[0] == 0 && flowerbed.length >= 2 && flowerbed[1] == 0
		|| flowerbed[0] == 0 && flowerbed.length == 1) {
			flowerbed[0] = 1;
			n--;
		}
		if (flowerbed[flowerbed.length - 1] == 0 && flowerbed.length >= 2 && flowerbed[flowerbed.length - 2] == 0) {
			flowerbed[flowerbed.length - 1] = 0;
			flowerbed[flowerbed.length - 1] = 1;
			n--;
		}

		for (int i = 1; i < flowerbed.length - 1; i++) {
			if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
				flowerbed[i] = 1;
				n--;
			}
		}

		return n <= 0;
	}
}
