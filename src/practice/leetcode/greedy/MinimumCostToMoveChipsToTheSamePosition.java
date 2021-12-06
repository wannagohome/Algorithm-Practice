package practice.leetcode.greedy;

public class MinimumCostToMoveChipsToTheSamePosition {
    /**
     * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
     * LeetCode 1217. Minimum Cost to Move Chips to The Same Position
     *
     * My Solution : Greedy
     *
     * Time complexity : O(n)
     * result: 0ms
     */

    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;

        for (int p : position) {
            if (p % 2 == 0) even++;
            else odd++;
        }

        return Math.min(even, odd);
    }
}
