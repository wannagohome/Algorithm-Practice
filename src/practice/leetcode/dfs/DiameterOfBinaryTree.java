package practice.leetcode.dfs;

public class DiameterOfBinaryTree {
    /**
     * https://leetcode.com/problems/diameter-of-binary-tree/
     * LeetCode 543. Diameter of Binary Tree
     *
     * My Solution :
     * 단순한 dfs
     * root를 거치지 않는게 답인 경우를 생각하지 못해 몇차례 오답이 나왔다
     *
     * result : 0ms
     */

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        int left = 0, right = 0;
        if (root.left != null) left = diameterOfBinaryBranch(root.left) + 1;
        if (root.right != null) right = diameterOfBinaryBranch(root.right) + 1;
        return Math.max(left + right, max);
    }

    public int diameterOfBinaryBranch(TreeNode node) {
        int left = 0, right = 0;
        if (node.left != null) left = diameterOfBinaryBranch(node.left) + 1;
        if (node.right != null) right = diameterOfBinaryBranch(node.right) + 1;
        max = Math.max(left + right, max);
        return Math.max(left, right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
