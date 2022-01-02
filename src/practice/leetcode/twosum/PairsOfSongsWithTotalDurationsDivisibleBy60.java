package practice.leetcode.twosum;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
	/**
	 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
	 * LeetCode 1010. Pairs of Songs With Total Durations Divisible by 60
	 *
	 * Solution :
	 * 단순하게 브루트 포스를 떠올렸지만 O(n)의 복잡도로 풀수 있는 방법을 찾았고 배웠다.
	 * 나머지 값을 기억해 둠으로서 아주 단순하게 O(n)의 시간복잡도를 만들 수 있다.
	 *
	 * result : 3-4ms
	 *
	 */

	public int numPairsDivisibleBy60(int[] time) {
		int ans = 0;
		int[] div = new int[60];

		for (int t : time) {
			ans += div[(600 - t) % 60];
			div[t % 60]++;
		}
		return ans;
	}
}
