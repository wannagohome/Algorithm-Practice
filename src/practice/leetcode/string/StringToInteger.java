package practice.leetcode.string;

public class StringToInteger {
	/**
	 * https://leetcode.com/problems/string-to-integer-atoi/
	 * LeetCode 8. String to Integer (atoi)
	 *
	 * My Solution :
	 * 개똥같은 문제
	 *
	 * result : 7-8ms
	 */

	public int myAtoi(String s) {
		if (s.isBlank()) return 0;
		StringBuilder builder = new StringBuilder();
		String trimmed = s.trim();
		boolean isNegative = trimmed.charAt(0) == '-';
		if (trimmed.charAt(0) == '-' || trimmed.charAt(0) == '+') {
			trimmed = trimmed.substring(1);
		}

		for (char c : trimmed.toCharArray()) {
			if ((c >= '0' && c <= '9')) {
				builder.append(c);
			} else {
				break;
			}
		}

		try {
			if (builder.length() == 0)  return 0;
			if (isNegative) return -Integer.parseInt(builder.toString());
			return Integer.parseInt(builder.toString());
		} catch (NumberFormatException e) {
			return isNegative
				? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
	}
}
