package practice.leetcode.dfs;

public class SumOfLeftLeaves {
    /**
     * https://leetcode.com/problems/sum-of-left-leaves/
     * LeetCode 404. Sum of Left Leaves
     *
     * My Solution : dfs
     *
     * Time Complexity : O(n)
     * result : 0ms
     */

    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    public int sum(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return isLeft ? node.val : 0;

        return sum(node.left, true)
                + sum(node.right, false);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
