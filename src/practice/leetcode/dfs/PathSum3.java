package practice.leetcode.dfs;

import java.util.HashMap;

public class PathSum3 {
    /**
     * https://leetcode.com/problems/path-sum-iii/
     * LeetCode 437. Path Sum III
     *
     * My Solution :
     * 단순하게 제귀적으로 모든 case를 완전탐색해 더하려 했지만
     * 적절한 로직을 짜지 못했다
     *
     * Solution :
     * HashMap을 사용해 합의 count를 구하는데
     * 왜 count를 올렸다가 내리는지 아직 잘 이해하지 못했다
     * 나중에 다시 살펴 봐야 할 것 같다
     *
     * result : 2ms 100%
     */
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) return 0;

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
