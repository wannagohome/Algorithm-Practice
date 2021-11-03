package practice.leetcode.dfs;

public class SumRootToLeafNumbers {
    /**
     * https://leetcode.com/problems/sum-root-to-leaf-numbers/
     * LeetCode 129. Sum Root to Leaf Numbers
     *
     * My Solution : dfs
     *
     * Time Complexity : O(n)
     * result : 0ms
     */
    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }

    public int getSum(TreeNode node, int currentSum) {
        if (node.left == null && node.right == null) return currentSum * 10 + node.val;
        int result = 0;
        if (node.left != null) result += getSum(node.left, currentSum * 10 + node.val);
        if (node.right != null) result += getSum(node.right, currentSum * 10 + node.val);
        return result;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}
