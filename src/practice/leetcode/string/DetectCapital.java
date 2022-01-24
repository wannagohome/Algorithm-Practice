package practice.leetcode.string;

public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		/**
		 * https://leetcode.com/problems/detect-capital/
		 * LeetCode 520. Detect Capital
		 *
		 * result : 1ms
		 */
		if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
			if (word.length() < 2) return true;
			if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
				for (char c : word.substring(2).toCharArray()) {
					if (c < 'A' || c > 'Z') return false;
				}
			} else {
				for (char c : word.substring(2).toCharArray()) {
					if (c < 'a' || c > 'z') return false;
				}
			}
		} else {
			for (char c : word.substring(1).toCharArray()) {
				if (c < 'a' || c > 'z') return false;
			}
		}
		return true;
	}
}
