package practice.leetcode.bitmanipulation;

public class PowerOfTwo {
	/**
	 * https://leetcode.com/problems/power-of-two/
	 * LeetCode 231. Power of Two
	 *
	 * My Solution :
	 * result : 1ms
	 *
	 */
	public boolean isPowerOfTwo(int n) {
		if (n == 1)  return true;
		if (n == 0)  return false;
		if (n % 2 != 0)  return false;

		return isPowerOfTwo(n / 2);
	}
}
