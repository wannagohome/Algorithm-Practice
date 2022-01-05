package practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	/**
	 * https://leetcode.com/problems/palindrome-partitioning/
	 * LeetCode 131. Palindrome Partitioning
	 *
	 * My Solution :
	 * dfs backtracking
	 *
	 * result : 20-26ms
	 *
	 */

	public List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<>();
		dfs(0, ans, new ArrayList<>(), s);
		return ans;
	}

	private void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
		if (start >= s.length()) result.add(new ArrayList<>(currentList));
		for (int end = start; end < s.length(); end++) {
			if (isPalindrome(s.substring(start, end + 1))) {
				currentList.add(s.substring(start, end + 1));
				dfs(end + 1, result, currentList, s);
				currentList.remove(currentList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		int low = 0;
		int high = s.length() - 1;

		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--)) return false;
		}
		return true;
	}
}
