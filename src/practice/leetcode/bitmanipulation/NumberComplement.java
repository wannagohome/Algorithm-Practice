package practice.leetcode.bitmanipulation;

public class NumberComplement {
	/**
	 * https://leetcode.com/problems/number-complement/
	 * LeetCode 476. Number Complement
	 *
	 * My Solution :
	 * result : 0ms
	 */

	public int findComplement(int num) {
		int mask = (Integer.highestOneBit(num) << 1) - 1;
		num = ~num;
		return num & mask;
	}
}
