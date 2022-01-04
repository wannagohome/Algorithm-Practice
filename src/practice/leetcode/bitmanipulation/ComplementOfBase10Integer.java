package practice.leetcode.bitmanipulation;

public class ComplementOfBase10Integer {
	/**
	 * https://leetcode.com/problems/complement-of-base-10-integer/
	 * LeetCode 1009. Complement of Base 10 Integer
	 *
	 * My Solution :
	 * result : 0ms
	 *
	 */

	public int bitwiseComplement(int n) {
		int x = 1;
		while (n > x) {
			x = x * 2 + 1;
		}
		return x - n;
	}
}
