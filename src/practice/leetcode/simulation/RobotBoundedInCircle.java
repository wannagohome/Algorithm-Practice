package practice.leetcode.simulation;

public class RobotBoundedInCircle {
	/**
	 * https://leetcode.com/problems/robot-bounded-in-circle/
	 * LeetCode 1041. Robot Bounded In Circle
	 *
	 * My Solution :
	 *
	 * result : 0ms
	 *
	 */
	public boolean isRobotBounded(String instructions) {
		int x = 0, y = 0, i = 0;
		int[][]  dXdY = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};

		for (int j = 0; j < instructions.length(); ++j) {
			if (instructions.charAt(j) == 'R')
				i = (i + 1) % 4;
			else if (instructions.charAt(j) == 'L')
				i = (i + 3) % 4;
			else {
				x += dXdY[i][0];
				y += dXdY[i][1];
			}
		}

		return x == 0 && y == 0 || i > 0;
	}
}
