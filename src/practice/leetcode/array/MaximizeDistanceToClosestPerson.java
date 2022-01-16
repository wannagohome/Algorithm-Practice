package practice.leetcode.array;

public class MaximizeDistanceToClosestPerson {
	/**
	 * https://leetcode.com/problems/maximize-distance-to-closest-person/
	 * LeetCode 849. Maximize Distance to Closest Person
	 *
	 * result : 1-5ms
	 *
	 */

	public int maxDistToClosest(int[] seats) {
		boolean isFirstSeatFounded = false;
		int firstIndex = 0;
		int lastIndex = 0;
		int maxDistance = 0;

		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				if (!isFirstSeatFounded) {
					isFirstSeatFounded = true;
					lastIndex = i;
					firstIndex = i;
					continue;
				}

				maxDistance = Math.max(maxDistance, i - lastIndex);
				lastIndex = i;
			}
		}

		if (maxDistance == 0) {
			return Math.max(seats.length - lastIndex - 1, lastIndex);
		}
		return Math.max(Math.max(maxDistance / 2, firstIndex), seats.length - lastIndex - 1);
	}
}
