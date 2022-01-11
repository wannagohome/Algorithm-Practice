package practice.leetcode.dfs;

public class SumOfRootToLeafBinaryNumbers {
	/**
	 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
	 * LeetCode 1022. Sum of Root To Leaf Binary Numbers
	 *
	 * My Solution : dfs
	 * result : 0ms
	 */

	public int sumRootToLeaf(TreeNode root) {
		return sum(root, 0);
	}

	private int sum(TreeNode node, int num) {
		int res = 0;
		num = num * 2 + node.val;
		if (node.left == null && node.right == null) {
			return num;
		}

		if (node.left != null) {
			res += sum(node.left, num);
		}
		if (node.right != null) {
			res += sum(node.right, num);
		}
		return res;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}
