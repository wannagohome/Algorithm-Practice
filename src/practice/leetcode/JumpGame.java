package practice.leetcode;

import java.util.Arrays;

public class JumpGame {
    /**
     * https://leetcode.com/problems/jump-game/
     * LeetCdoe 55. Jump Game
     *
     * My Solution : 재귀적으로 모든 경우의 수 전체 조회 O(n^2)
     * Time complexity : O(n^2)
     * result : Time Limit
     *
     * Better Solution :
     * 인덱스 0부터 순회하며 가장 멀리 갈 수 있는 지점을 계산 및 저장
     * 가장 멀리 갈 수 있는 지점이 인덱스를 넘지 못할 경우 -> 마지막 인덱스로 도달하지 못하는 경우
     * 경우의 수를 따지는 것이 아니라 단순히 도달 할 수 있는 인덱스만을 생각하는 Greedy한 해법이 가장 나은 해결책이었다.
     *
     * Time complexity : O(n)
     * result: 2ms
     */

    public static boolean mySolution(int[] nums) {
        if (nums.length == 1) return true;
        if (Arrays.stream(nums).noneMatch(i -> i==0)) return true;

        for (int i = 1; i <= nums[0]; i++) {
            if (recur(nums, i))
                return true;
        }

        return false;
    }

    private static boolean recur(int[] nums, int index) {
        if (nums.length <= index + 1)  return true;
        if (nums[index] == 0) return false;

        for (int i = 1; i <= nums[index]; i++) {
            if (recur(nums, index+i))
                return true;
        }
        return false;
    }

    public static boolean solution(int[] nums) {
        int reachable = 0;
        for(int i=0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, nums[i]+ i);
        }
        return true;
    }
}
