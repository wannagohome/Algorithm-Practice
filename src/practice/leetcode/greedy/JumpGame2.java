package practice.leetcode.greedy;

public class JumpGame2 {

    /**
     * https://leetcode.com/problems/jump-game-ii/
     * LeetCode 45. Jump Game II
     *
     * My Solution : 각 인덱스에서 도달 할 수 있는 인덱스를 기록(dp)
     * Time complexity : O(n*k)
     * result : 45ms 33%
     *
     * Better Solution :
     * Greedy 하게 가장 멀리 갈 수 있는 지점만 챙김
     * Time complexity : O(n)
     * result: 1-2ms
     */

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 1, 4};
        System.out.println(solution(array));
        System.out.println(betterSolution(array));
    }

    public static int solution(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j > nums.length - 1) break;
                if (i + j == nums.length - 1) return dp[i] + 1;
                if (dp[i + j] == 0)
                    dp[i + j] = dp[i] + 1;
            }
        }
        return dp[dp.length - 1];
    }

    public static int betterSolution(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
