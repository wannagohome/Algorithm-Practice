package practice.leetcode.bitmanipulation;

public class AddBinary {
	/**
	 * https://leetcode.com/problems/add-binary/
	 * LeetCode 67. Add Binary
	 *
	 * My Solution :
	 * result : 4-7ms
	 *
	 */

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (a.length() > index || b.length() > index) {
			int val = 0;
			if (a.length() > index) {
				val += a.charAt(a.length() - 1 - index) - '0';
			}
			if (b.length() > index) {
				val += b.charAt(b.length() - 1 - index) - '0';
			}
			if (sb.length() > index) {
				val += sb.charAt(index) - '0';
				sb.deleteCharAt(index);
			}

			if (val >= 2) {
				sb.append(val % 2);
				sb.append(1);
			} else {
				sb.append(val);
			}
			index++;
		}
		return sb.reverse().toString();
	}
}
