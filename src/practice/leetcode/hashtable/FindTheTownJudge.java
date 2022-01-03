package practice.leetcode.hashtable;

public class FindTheTownJudge {
	/**
	 * https://leetcode.com/problems/find-the-town-judge/
	 * LeetCode 997. Find the Town Judge
	 *
	 * result : 3ms
	 */

	public int findJudge(int n, int[][] trust) {
		int[] trustedCount = new int[n];
		boolean[] isTrustSomebody = new boolean[n];

		for (int[] t : trust) {
			isTrustSomebody[t[0] - 1] = true;
			trustedCount[t[1] - 1]++;
		}

		for (int i = 0; i < n; i++) {
			if (trustedCount[i] == n - 1 && !isTrustSomebody[i]) {
				return i + 1;
			}
		}
		return -1;
	}
}
