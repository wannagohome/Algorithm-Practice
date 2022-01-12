package practice.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertIntoABinarySearchTree {
	/**
	 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
	 * LeetCode 701. Insert into a Binary Search Tree
	 *
	 * My Solution :
	 * BST 삽입
	 *
	 * result : 0ms
	 *
	 */

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.val < val) {
				if (node.right != null) {
					queue.add(node.right);
					continue;
				}
				node.right = new TreeNode(val);
				return root;
			}
			if (node.val > val) {
				if (node.left != null) {
					queue.add(node.left);
					continue;
				}
				node.left = new TreeNode(val);
				return root;
			}
		}

		return root;
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
