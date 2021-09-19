package practice.leetcode.dfs;

public class IncreasingOrderSearchTree {
    /**
     * https://leetcode.com/problems/increasing-order-search-tree/
     * LeetCdoe 897. Increasing Order Search Tree
     *
     * My Solution : 단순하게 left와 right를 재귀적으로 조립
     * result : 0ms
     */
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
