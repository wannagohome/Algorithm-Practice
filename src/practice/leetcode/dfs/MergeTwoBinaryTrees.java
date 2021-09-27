package practice.leetcode.dfs;

public class MergeTwoBinaryTrees {
    /**
     * https://leetcode.com/problems/merge-two-binary-trees/
     * LeetCode 617. Merge Two Binary Trees
     *
     * My Solution : left와 right를 재귀적으로 조립(?)
     * result : 1ms
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode mergedTreeNode = new TreeNode();
        mergedTreeNode.val += root1.val + root2.val;

        if (root1.left != null || root2.left != null)
            mergedTreeNode.left = mergeTrees(root1.left, root2.left);

        if (root1.right != null || root2.right != null)
            mergedTreeNode.right = mergeTrees(root1.right, root2.right);

        return mergedTreeNode;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
