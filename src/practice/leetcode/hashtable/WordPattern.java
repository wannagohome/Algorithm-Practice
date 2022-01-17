package practice.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	/**
	 * https://leetcode.com/problems/word-pattern/
	 * LeetCode 290. Word Pattern
	 *
	 * result : 0ms
	 */

	public boolean wordPattern(String pattern, String s) {
		String[] split = s.split(" ");
		Map<Character, String> map = new HashMap<>();

		if (pattern.length() != split.length)
			return false;

		for (int i = 0; i < pattern.length(); i++) {
			char key = pattern.charAt(i);
			if (!map.containsKey(key)) {
				if (map.containsValue(split[i]))
					return false;
				map.put(key, split[i]);
				continue;
			}

			if (!map.get(key).equals(split[i]))
				return false;
		}
		return true;
	}
}
